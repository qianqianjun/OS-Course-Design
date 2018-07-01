
package thread;
/*class Demo extends Thread
{
	private String name;
	public Demo(String inputname) {
		this.name=inputname;
	}
	public void run()
	{
		for(int i=0;i<10;i++)
		{
			System.out.println(name+":"+i+"  Thread:"+this.getName());
		}
	}
	public void show()
	{
		run();
	}
}*/
class Demo implements Runnable
{
	private String name;
	public Demo(String name)
	{
		this.name=name;
	}
	public void run()
	{
		for(int i=0;i<10;i++)
			System.out.println("name:"+name+"x:"+i);
	}
}
public class ThreadDemo {
	public static void main(String[] args) {
		Demo d1=new Demo("込込込");
		Demo d2=new Demo("最最");
		Thread th1=new Thread(d1);
		Thread th2=new Thread(d2);
		th1.start();
		th2.start();
	}

}
