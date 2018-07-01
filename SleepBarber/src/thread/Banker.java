package thread;
class customer implements Runnable
{
	private Banker b=new Banker();
	public void run()
	{
		for(int i=0;i<3;i++)
		{
			b.add(100);
		}
	}
}
public class Banker {
	public int number;
	public Object obj=new Object();
	public synchronized void add(int num)
	{
//		synchronized(obj) 
//		{
//			this.number+=num;
//			System.out.println(number);
//		}
		this.number+=num;
		System.out.println(number);
		
	}
	public static void main(String[] args) {
		customer c1=new customer();
		Thread th1=new Thread(c1);
		Thread th2=new Thread(c1);
		th1.start();
		th2.start();
	}

}
