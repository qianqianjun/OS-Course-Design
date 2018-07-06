package WebQQ;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
public class Server{
    public static ArrayList<ServerThread> allclient = new ArrayList<ServerThread>();
    public static int clientnum = 0;
    public static void main(String args[]){
    	System.out.println("我是服务器，正在提供服务");
        try {
			ServerSocket s = new ServerSocket(6666);
            while(true){
                Socket socket = s.accept();
                ServerThread newClientThread= new ServerThread(clientnum,socket);
                allclient.add(newClientThread);
                newClientThread.start();
                clientnum++;
            }
        } catch (IOException e) { }
    }
}


