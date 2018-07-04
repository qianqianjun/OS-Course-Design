package main;
public class Dispacher {
	public static void main(String[] args) {
		SQL sql=new SQL();
		GUI uiGui=new GUI(sql);
		sql.setUp(uiGui);
		uiGui.reset();
	}
}
