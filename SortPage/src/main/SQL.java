package main;

import java.security.cert.PKIXRevocationChecker.Option;
import java.util.Random;

public class SQL {
	public static int [] cmd;
	public static int [] cmd1;
	public static int length;
	public static double [] ans;
	public void init()
	{
		cmd = new int[30000];
		cmd1 = new int[30000];
		ans = new double[10];
		length = 0;
		creatcmd();
		ans[1]=OPT();
		ans[2]=FIFO();
		ans[3]=LRU();
		ans[4]=LFU();
		ans[5]=NRU();
		display();
	}
	public static void display()
	{
		System.out.println("OPT: "+ans[1]);
		System.out.println("FIFO: "+ans[2]);
		System.out.println("LRU: "+ans[3]);
		System.out.println("LFU: "+ans[4]);
		System.out.println("NRU: "+ans[5]);
	}
	public static void creatcmd()
	{
		int[] vis = new int[320];
		for(int i=0;i<320;i++)vis[i]=0;
		Random random = new Random();
		int m = random.nextInt(320);
		cmd[length++]=m;vis[m]=1;
		if(m<319) {cmd[length++]=m+1;vis[m+1]=1;}
		int flag1=0;
		while(true)
		{
			int flag=0;
			for(int i=0;i<320;i++) {
				if(vis[i]==0) {
					flag=1;break;
				}
			}
			if(flag==0)break;
			if(flag1==0) {
				if(m>0) {
					m = random.nextInt(m);
					cmd[length++]=m;
					vis[m]=1;
					cmd[length++]=m+1;
					vis[m+1]=1;
					m++;
				}
				flag1=1;
			}
			else {
				if(m<319) {
					m = m+1+random.nextInt(319-m);
					cmd[length++]=m;
					vis[m]=1;
					if(m<319) {cmd[length++]=m+1;vis[m+1]=1;}
				}
				flag1=0;
			}
		}
		for(int i=0;i<length;i++) {cmd1[i]=cmd[i];cmd[i]=cmd[i]/10;}
		System.out.println(length);
	}
	public static double OPT()
	{
		double ans=0.0;
		int[] vis = new int[4];
		for(int i=0;i<4;i++) vis[i]=-1;
		for(int i=0;i<length;i++) {
			int flag=0;
			for(int j=0;j<4;j++)if(vis[j]==cmd[i])flag=1;
			if(flag==1)continue;
			for(int j=0;j<4;j++) {
				if(vis[j]==-1) {
					vis[j]=cmd[i];
					ans+=1.0;
					flag=1;
					break;
				}
			}
			if(flag==1)continue;
			int ip=-1,mx=-1;
			for(int j=0;j<4;j++) {
				int id = vis[j],flag2=0;
				for(int r=i+1;r<length;r++) {
					if(cmd[r]==id) {
						flag2=1;
						if(mx<r) {
							ip=j;
							mx=r;
						}	
						break;
					}
				}
				if(flag2==0) {
					mx=length+1;
					ip=j;
					break;
				}
			}
			vis[ip]=cmd[i];
			ans+=1.0;
		}
		return ans/Double.parseDouble(Integer.toString(length));
	}
	
	
	public static double FIFO()
	{
		double ans=0.0;
		int[] vis = new int[4];
		for(int i=0;i<4;i++)vis[i]=-1;
		int[] time = new int[4];
		for(int i=0;i<length;i++) {
			int flag=0;
			for(int j=0;j<4;j++) {
				if(vis[j]==cmd[i]) {
					flag=1;
				}
			}
			if(flag == 1)continue;
			for(int j=0;j<4;j++) {
				if(vis[j]==-1) {
					vis[j]=cmd[i];
					time[j]=i;
					flag=1;
					ans+=1.0;
					break;
				}
			}
			if(flag==1)continue;
			int id=-1,mn=length+1;
			for(int j=0;j<4;j++) {
				if(time[j]<mn) {
					mn=time[j];
					id=j;
				}
			}
			vis[id]=cmd[i];
			time[id]=i;
			ans+=1.0;
		}
		return ans/Double.parseDouble(Integer.toString(length));
	}
	public static double LRU()
	{
		double ans=0.0;
		int[] vis = new int[4];
		for(int i=0;i<4;i++)vis[i]=-1;
		int[] time = new int[4];
		for(int i=0;i<length;i++) {
			int flag=0;
			for(int j=0;j<4;j++) {
				if(vis[j]==cmd[i]) {
					time[j]=i;
					flag=1;
				}
			}
			if(flag == 1)continue;
			for(int j=0;j<4;j++) {
				if(vis[j]==-1) {
					vis[j]=cmd[i];
					time[j]=i;
					flag=1;
					ans+=1.0;
					break;
				}
			}
			if(flag==1)continue;
			int id=-1,mn=length+1;
			for(int j=0;j<4;j++) {
				if(time[j]<mn) {
					mn=time[j];
					id=j;
				}
			}
			vis[id]=cmd[i];
			time[id]=i;
			ans+=1.0;
		}
		return ans/Double.parseDouble(Integer.toString(length));
	}

	public static double LFU()
	{
		double ans=0.0;
		int[] vis = new int[4];
		for(int i=0;i<4;i++)vis[i]=-1;
		int[] count = new int[4];
		for(int i=0;i<length;i++) {
			int flag=0;
			for(int j=0;j<4;j++) {
				if(vis[j]==cmd[i]) {
					count[j]++;
					flag=1;
				}
			}
			if(flag == 1)continue;
			for(int j=0;j<4;j++) {
				if(vis[j]==-1) {
					vis[j]=cmd[i];
					count[j]=1;
					flag=1;
					ans+=1.0;
					break;
				}
			}
			if(flag==1)continue;
			int id=-1,mn=length+1;
			for(int j=0;j<4;j++) {
				if(count[j]<mn) {
					mn=count[j];
					id=j;
				}
			}
			vis[id]=cmd[i];
			count[id]=i;
			ans+=1.0;
		}
		return ans/Double.parseDouble(Integer.toString(length));
	}

	public static double NRU()
	{
		double ans=0.0;
		int[] vis = new int[4];
		for(int i=0;i<4;i++)vis[i]=-1;
		int[] temp = new int[4];
		int ip = 0;
		for(int i=0;i<4;i++) temp[i] = 0;
		for(int i=0;i<length;i++) {
			int flag=0;
			for(int j=0;j<4;j++) {
				if(vis[j]==cmd[i]) {
					flag=1;
				}
			}
			if(flag == 1)continue;
			while(true)
			{
				if(temp[ip]==0) {
					vis[ip]=cmd[i];
					temp[ip]=1;
					ans+=1.0;
					ip=(ip+1)%4;
					flag=1;
					break;
				}else {
					temp[ip]=0;
					ip=(ip+1)%4;
				}
			}
		}
		return ans/Double.parseDouble(Integer.toString(length));
	}
}
