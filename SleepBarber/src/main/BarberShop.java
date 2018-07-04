package main;

import java.util.concurrent.Semaphore;
class BarberTwo implements Runnable{
	private BarberShop object;
	private int index;
	public BarberTwo(BarberShop barbershop,int i)
	{
		this.object=barbershop;
		index=i;
	}
	public void run()
	{
		try {
			object.RunWork(index);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
public class BarberShop {
	static int CustomerCount=0;//顾客数
	static int Max=6;
	static int WorkStatus=0;
	static Semaphore mutex=new Semaphore(1);
	public BarberShopUi ui;
	public static Object fixCount=new Object();
	public static Object setui=new Object();
	public static int sleeptime=1000;
	public BarberShop()
	{
		ui=new BarberShopUi();
		ui.setVisible(true);
	}
	public static void main(String[] args) throws InterruptedException {
		BarberShop bar=new BarberShop();
		for(int i=1;i<20;i++)
		{
			new Thread(new BarberTwo(bar,i)).start();
			Thread.sleep(sleeptime);
		}
	}
	public synchronized boolean isEqual(int one,int two)
	{
		if(one==two)
		{
			return true;
		}
		return false;
	}
	public void RunWork(int index) throws InterruptedException
	{
		synchronized (setui) {
			synchronized (fixCount) 
			{
				System.out.println("顾客"+index+"来了");
				ui.setStatus("顾客"+index+"来了");
				CustomerCount++;
			}
		}
		if(isEqual(CustomerCount,Max))
		{
			synchronized (setui) {
				ui.setDoorCome();
				System.out.println("没有椅子坐，走了");
				ui.setDoorLeave();
				ui.setStatus("没有椅子坐，走了");
				synchronized (fixCount) {
					CustomerCount--;
				}
			}
		}
		else
		{
			if(isEqual(WorkStatus, 1))
			{
				synchronized (setui) {
					ui.getSeet(index);
					System.out.println("顾客"+index+"等待理发");
					ui.setStatus("顾客"+index+"等待理发");
				}
			}
			mutex.acquire();
			synchronized (this) {
				while(WorkStatus==1)
				{
					wait();
				}
				synchronized (setui) {
					synchronized(fixCount)
					{
						ui.freeSeet(index);
						CustomerCount--;
						WorkStatus=1;
					}
				}
			}
			synchronized (setui) {
				System.out.println("顾客"+index+"正在理发");
				ui.setBarber(index);
			}
			Thread.sleep(sleeptime*3);
			synchronized (setui) {
				System.out.println("顾客"+index+"离开了");
				ui.setStatus("顾客"+index+"理发完毕离开了");
			}
			synchronized (this) {
				WorkStatus=0;
				notify();
			}
			mutex.release();
			if(isEqual(CustomerCount,0))
			{
				synchronized (setui) {
					System.out.println("没有顾客，开始睡觉");
					ui.setStatus("没有顾客，开始睡觉");
					ui.Sleep();
				}
			}
		}
	}
}
