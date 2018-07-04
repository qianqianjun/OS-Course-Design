package main;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Random;

import javax.swing.JFrame;
public class SQL {
	private LinkedList<Process> ReadyListRR=new LinkedList<Process>();
	public Process Run= null;
	private LinkedList<Process> FinishList=new LinkedList<Process>();
	public Boolean flag=true;//true RR;
	private GUI Ui ;
	private PriorityQueue<Process> priorityQueue=new PriorityQueue<Process>(1,ComparatorByPriority);
	public String[] Title= { "进程ID", "优先级别", "运行时间",  "时间片","剩余时间" };
	public static Object[][] runList= {};
	public static Object[][] readyList= {};
	public static Object[][] finishList= {};
	public static Comparator<Process> ComparatorByPriority = new Comparator<Process>(){
        @Override
        public int compare(Process c1, Process c2) {
            return (int) (c2.getPriority() - c1.getPriority());
        }
    };
    public static JFrame frame; 
    public void setUp(GUI myUI)
    {
    	Ui=myUI;
    }
    public void clearall()
    {
    	ReadyListRR.clear();
    	priorityQueue.clear();
    	FinishList.clear();
    	Run = null;
    }
	public Boolean add(Process process)
	{
		if(flag)
		{
			ReadyListRR.add(process);
		}
		else
		{
			priorityQueue.add(process);
		}
		return true;
	}
	public Object[][] getData()
	{
		Object[][] obj;
		if(flag) {
			obj=new Object[ReadyListRR.size()][5];
			for(int i=0;i<ReadyListRR.size();i++)
			{
				obj[i][0]=ReadyListRR.get(i).ID;
	    		obj[i][1]=ReadyListRR.get(i).PRIORITY;
	    		obj[i][2]=ReadyListRR.get(i).CPUTIME;
	    		obj[i][3]=ReadyListRR.get(i).CHIP;
	    		obj[i][4]=ReadyListRR.get(i).ALLTIME;
			}
			return obj;
		}
		else
		{
			obj=new Object[priorityQueue.size()][5];
			LinkedList<Process> temp=new LinkedList<Process>();
			while(!priorityQueue.isEmpty())
			{
				Process x = priorityQueue.poll();
				temp.add(x);
			}
			for(int i=0;i<temp.size();i++)
			{
				obj[i][0]=temp.get(i).ID;
	    		obj[i][1]=temp.get(i).PRIORITY;
	    		obj[i][2]=temp.get(i).CPUTIME;
	    		obj[i][3]=temp.get(i).CHIP;
	    		obj[i][4]=temp.get(i).ALLTIME;
	    		priorityQueue.add(temp.get(i));
			}
			return obj;
		}
	}
	public Object[][] getRun()
	{
		Object[][] obj= {};
		obj=new Object[1][5];
		if(Run==null)
			return obj;
		obj[0][0]=Run.ID;
		obj[0][1]=Run.PRIORITY;
		obj[0][2]=Run.CPUTIME;
		obj[0][3]=Run.CHIP;
		obj[0][4]=Run.ALLTIME;
		return obj;
	}
	public void RunProcess()
	{
		if(flag)
		{
			while(true)
			{
				
				if(ReadyListRR.size() == 0) break;
				Process temp = ReadyListRR.poll();
				Run = temp;
				Ui.resetall();
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				int num =0;
				Run.ALLTIME--;
				Run.CHIP++;
				Run.CPUTIME++;
				if(Run.ALLTIME == 0)
				{
					FinishList.add(Run);
				}
				else
				{
					ReadyListRR.add(Run);
				}
				Ui.resetall();
				display();
			}
			Run = null;
			Ui.resetall();
		}
		else 
		{
			while(true)
			{
				if(priorityQueue.isEmpty()) break;
				Process temp=priorityQueue.poll();
				Run=temp;
				Ui.resetall();
				Run.ALLTIME--;
				Run.CHIP++;
				Run.CPUTIME++;
				Run.PRIORITY--;
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				if(Run.ALLTIME<=0)
				{
					FinishList.add(Run);
				}
				else
				{
					priorityQueue.add(Run);
				}
				Ui.resetall();
				display();
			}
			Run = null;
			Ui.resetall();
		}
		
	}
	public Object[][] getFinsh()
	{
		Object[][] obj;
		obj=new Object[FinishList.size()][5];
		for(int i=0;i<FinishList.size();i++)
		{
			obj[i][0]=FinishList.get(i).ID;
    		obj[i][1]=FinishList.get(i).PRIORITY;
    		obj[i][2]=FinishList.get(i).CPUTIME;
    		obj[i][3]=FinishList.get(i).CHIP;
    		obj[i][4]=FinishList.get(i).ALLTIME;
		}
		return obj;

	}
	public void display()
	{
		/*for(int i=0;i<ReadyListRR.size();i++)
		{
			System.out.println(ReadyListRR.get(i).ID);
		}
		System.out.println("**************");
		LinkedList<Process> pro=new LinkedList<Process>();
		while(!priorityQueue.isEmpty())
		{
			Process temp=priorityQueue.poll();
			System.out.println(temp.ID);
			pro.add(temp);
		}
		for(int i=0;i<pro.size();i++)
		{
			priorityQueue.add(pro.get(i));
		}*/
	}
}
