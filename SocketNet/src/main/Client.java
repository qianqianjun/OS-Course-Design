package main;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;
public class Client
{
	public static void main(String[] args)
	{
		try{
			Scanner s=new Scanner(System.in);
			System.out.println("请输入运算符，操作数1，操作数2，例如：* 2 3");
			while(s.hasNext())
			{
				String operator =s.next();
				if(operator.equals("exit"))
					break;
				int a=s.nextInt();
				int b=s.nextInt();
				Socket socket=new Socket("127.0.0.1",8888);
				OutputStream os=socket.getOutputStream();
				PrintWriter pw=new PrintWriter(os);
				pw.write(operator+","+a+","+b);
				pw.flush();
				socket.shutdownOutput();
				//get inputStream
				InputStream is =socket.getInputStream();
				BufferedReader br=new BufferedReader(new InputStreamReader(is));
				String info=null;
				while((info=br.readLine())!=null){
					System.out.println("server return: "+info);
				}
				System.out.println("请输入运算符，操作数1，操作数2，例如：* 2 3");
			}
			
			/*br.close();
			is.close();
			pw.close();
			os.close();
			socket.close();*/
		}
		catch(UnknownHostException e)
		{
			e.printStackTrace();
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}

	}
}