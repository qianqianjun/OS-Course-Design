package main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;

public class ServerThread extends Thread{
	private Socket socket=null;
	public ServerThread(Socket socket)
	{
		this.socket=socket;
	}
	public void run()
	{
		InputStream is=null;
		InputStreamReader isr=null;
		BufferedReader br=null;
		OutputStream os=null;
		PrintWriter pw=null;
		try {
			is=socket.getInputStream();
			isr=new InputStreamReader(is);
			br=new BufferedReader(isr);
			String temp=null;
			String info=null;
			while((info=br.readLine())!=null)
			{
				temp=info;
				System.out.println("Client says "+info);
			}
			os=socket.getOutputStream();
			pw=new PrintWriter(os);
			String [] infoarr=temp.split(",");
			if(infoarr[0].equals("+"))
			{
				pw.write(""+(Integer.parseInt(infoarr[1])+Integer.parseInt(infoarr[2])));
			}
			else if(infoarr[0].equals("-"))
			{
				pw.write(""+(Integer.parseInt(infoarr[1])-Integer.parseInt(infoarr[2])));
			}
			else if(infoarr[0].equals("*"))
			{
				pw.write(""+(Integer.parseInt(infoarr[1])*Integer.parseInt(infoarr[2])));
			}
			else if(infoarr[0].equals("/"))
			{
				if(Integer.parseInt(infoarr[2])!=0)
					pw.write(""+(Integer.parseInt(infoarr[1])-Integer.parseInt(infoarr[2])));
				else
					pw.write("you can not get the result£¡");
			}
			else {
				pw.write("operator wrong");
			}
			pw.flush();
			socket.shutdownInput();
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			try {
				if(pw!=null)
				{
					if(pw!=null)
						pw.close();
					if(os!=null)
						os.close();
					if(br!=null)
						br.close();
					if(isr!=null)
						isr.close();
					if(is!=null)
						is.close();
					if(socket!=null)
						socket.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
