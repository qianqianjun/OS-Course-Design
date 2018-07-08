package main;

import main.SQL;
import main.GUI;
public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SQL sql = new SQL();
		sql.init();
		sql.display();
		GUI gui = new GUI();
		gui.start(sql);		
	}
}
