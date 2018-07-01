package main;

import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class Server{
	public static void main(String [] args)
	{
		try{
			@SuppressWarnings("resource")
			ServerSocket serverSocket=new ServerSocket(8888);
			Socket socket=null;
			int count=0;
			System.out.println("server is start");
			while(true)
			{
				socket=serverSocket.accept();
				ServerThread serverThread=new ServerThread(socket);
				serverThread.start();
				count++;
				System.out.println("客户端数量是："+count);
				InetAddress address=socket.getInetAddress();
				System.out.println(address.getHostAddress());
			}
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
		
	}
}