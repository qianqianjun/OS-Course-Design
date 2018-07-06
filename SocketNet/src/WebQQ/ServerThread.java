package WebQQ;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class ServerThread extends Thread {
    int id;
    DataOutputStream dos;
    DataInputStream din;
    public ServerThread(int id,Socket socket) throws IOException{
        this.id = id;
        this.dos = new DataOutputStream(socket.getOutputStream()); 
        this.din = new DataInputStream(socket.getInputStream());;
    }
    public void run(){
        while(true)
        {
            try 
            {
                String message = "客户" + id + ":" + din.readUTF();
                for(int i=0; i<Server.clientnum; i++)
                {
                    if(i!=id)
                    {
                        Server.allclient.get(i).dos.writeUTF(message);
                    }
                    else
                    {
                        String remessage =message.replace("客户"+id, "自己");
                        Server.allclient.get(id).dos.writeUTF(remessage);
                    }
                }
            } 
            catch (IOException e) {}
        }
    }
}
