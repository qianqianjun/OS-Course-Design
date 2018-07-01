package smoking;

import java.util.Random;
import smoking.GUIcomponent;

class Service{
	private int flag = 1;
	private int tobacco = 0;
	private int paper = 0;
	private int matches = 0;
	public synchronized void change(String item,String name,GUIcomponent myGUI){
		try{
			boolean vis = false;
			Thread.sleep(500);
			if(item == "ÑÌ²Ý"){
				if(tobacco == 0 && paper + matches == 2){
					vis = true;
					paper = matches = 0;
					flag = 1;
				}
			}else if(item == "Ö½"){
				if(paper == 0 && tobacco + matches == 2){
					vis = true;
					tobacco = matches = 0;
					flag = 1;
				}
			}else if(item == "»ð²ñ"){
				if(matches == 0 && tobacco + paper == 2){
					vis = true;
					tobacco = paper = 0;
					flag = 1;
				}
			}
			if(vis == true){
				System.out.println(name + " can smoking!");
				if(item == "ÑÌ²Ý") myGUI.change(1,0,0,0,tobacco,paper,matches);
				if(item == "Ö½") myGUI.change(0,1,0,0,tobacco,paper,matches);
				if(item == "»ð²ñ") myGUI.change(0,0,1,0,tobacco,paper,matches);
			}
			else
				System.out.println(name + " failed");
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	private static int ask(int num){
		int count = 0;
		while(num != 0){
			count ++;
			num = num & (num - 1);
		}
		return count;
	}
	public synchronized void add(GUIcomponent myGUI){
		try{
			Thread.sleep(500);
			if(flag == 1){
				Random rand = new Random();
				int num = 0;
				while(true){
					num = rand.nextInt(8);
					if(ask(num) == 2) break;
				}
				if((num & 1) != 0) tobacco = 1;
				if((num & (1<<1)) != 0) paper = 1;
				if((num & (1<<2)) != 0) matches = 1;
				flag = 0;
				System.out.println("Add succeed!");
				myGUI.change(0,0,0,1,tobacco,paper,matches);
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
}

class Mythread extends Thread{
	private Service service;
	private String item = "";
	private String name = "";
	private GUIcomponent  myGUI;
	public Mythread (String name,String item,Service service,GUIcomponent myGUI) {
		this.name = name;
		this.item = item;
		this.service = service;
		this.myGUI = myGUI;
	}
	
	public void run() {
		while(true){
			if(myGUI.ifStart() == true)
				service.change(this.item,this.name,this.myGUI);
			yield();
		}
	}
}

public class Main {
	public static void main(String args[]) {
		GUIcomponent myGUI = new GUIcomponent();
		myGUI.start();
		Service service = new Service();
		Mythread t1 = new Mythread("ÁõÈ¨´ï","ÑÌ²Ý",service,myGUI);
		Mythread t2 = new Mythread("¸ßÇ«","Ö½",service,myGUI);
		Mythread t3 = new Mythread("ÓàÖÐÈð","»ð²ñ",service,myGUI);
		t1.start();
		t2.start();
		t3.start();
		
		while(true){	
			if(myGUI.ifStart() == true)
				service.add(myGUI);
		}
	}
}
