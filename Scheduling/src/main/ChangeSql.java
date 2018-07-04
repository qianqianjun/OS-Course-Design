package main;


public class ChangeSql extends Thread{
	public static SQL mysql;
	public ChangeSql(SQL sql) {
		// TODO Auto-generated constructor stub
		mysql = sql;
	}
	@Override
	public void run() {
		mysql.RunProcess();
	}
}
