package WebQQ;
import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.*;

public class Server{
    public static ArrayList<Clients> allclient = new ArrayList<Clients>();
    public static int clientnum = 0;
    public static void main(String args[]){
        try {
			ServerSocket s = new ServerSocket(5432);
            while(true){
                Socket s1 = s.accept();
                DataOutputStream dos = new DataOutputStream(s1.getOutputStream());
                DataInputStream din = new DataInputStream(s1.getInputStream());
                Clients x = new Clients(clientnum, dos, din);
                allclient.add(x);
                x.start();
                clientnum++;
            }
        } catch (IOException e) { }
    }
}
class Clients extends Thread {
    int id;
    DataOutputStream dos;
    DataInputStream din;
    public Clients(int id, DataOutputStream dos, DataInputStream din){
        this.id = id;
        this.dos = dos;
        this.din = din;
    }
    public void run(){
        while(true)
        {
            try 
            {
                String message = "客户" + id + ":" + din.readUTF();
                for(int i=0; i<Server.clientnum; i++){
                    if(i != id)
                    {
                        Server.allclient.get(i).dos.writeUTF(message);
                    }
                    else
                    {
                        String remessage = "";
                        remessage = message.replace("客户" + id, "自己");
                        int aa = 35 - remessage.length();
                        StringBuffer space= new StringBuffer();
                        for(int j= 0;j<(aa-1);j++)
                        {
                           space.append(" ");
                        }
                        Server.allclient.get(id).dos.writeUTF((space.toString()) + remessage);
                    }
                }
            } 
            catch (IOException e) 
            {
            	e.printStackTrace();
            }
        }
    }
}

