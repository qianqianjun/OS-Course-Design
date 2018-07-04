package main;
public class Process {
	public Integer ID; //进程标识
	public int PRIORITY; //进程优先数
	public int CHIP;//时间片数
	public int CPUTIME;//已经是用的CPU时间;
	public int ALLTIME;//进程剩余运行时间
	public String STATUS; //运行状态 "R E"
	public Process(int id,int priority,int alltime)
	{
		this.ID=id;
		this.PRIORITY=priority;
		this.CHIP=0;
		this.ALLTIME=alltime;
		this.STATUS="R";
		this.CPUTIME=0;
	}
	public int getPriority()
	{
		return this.PRIORITY;
	}
}
