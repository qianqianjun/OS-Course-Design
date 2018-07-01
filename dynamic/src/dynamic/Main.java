package dynamic;

import dynamic.GUI;
import dynamic.SQL;
public class Main {
	public static void main(String args[]) {
		GUI myGui = new GUI();
		SQL mySql = new SQL();
		
		mySql.init(1000000);
		myGui.start(mySql);
	}
}
