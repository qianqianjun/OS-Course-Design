package paging;

import paging.GUI;
import paging.SQL;


public class Main {
	public static void main(String args[]) {
		GUI myGui = new GUI();
		SQL mySql = new SQL();
		
		mySql.init(8);
		myGui.start(mySql);
	}
}
