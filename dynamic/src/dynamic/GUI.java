package dynamic;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.jws.soap.SOAPBinding.Use;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;


import dynamic.SQL;

public class GUI {
	
	private static int flag = 0;
	private static SQL mySql;
	
	private static JPanel panel = new JPanel();
	
	public static void start(SQL Sql){
		mySql = Sql;
		JFrame frame = new JFrame("dynamic");
		frame.setSize(1200, 800);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		frame.add(panel);
		placeComponents(panel);
		
		frame.setVisible(true);
	}
	public static void placeComponents(JPanel panel){
		panel.setLayout(null);
		
		JLabel label = new JLabel("by: bingyu");
		label.setBounds(20, 700, 100, 50);
		panel.add(label);
		
		JLabel label_addname = new JLabel("作业名： ");
		label_addname.setBounds(1000, 580, 70, 20);
		panel.add(label_addname);
		
		JLabel label_addsize = new JLabel("长度： ");
		label_addsize.setBounds(1013, 610, 70, 20);
		panel.add(label_addsize);
		
		JTextField text_addname = new JTextField();
        text_addname.setBounds(1050,580,120,20);
        panel.add(text_addname);
        
        JTextField text_addsize = new JTextField();
        text_addsize.setBounds(1050,610,120,20);
        panel.add(text_addsize);

        JTextField text_deletname = new JTextField();
        text_deletname.setBounds(1050,670,120,20);
        panel.add(text_deletname);
		
		JButton  button_add = new JButton("分配主存");
		button_add.setBounds(1080, 640, 90, 20);
		button_add.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String name = "";String size = "";
				name = text_addname.getText();
				size = text_addsize.getText();
				System.out.println(name + "  " + size);
				if(!name.equals("") && !size.equals(""))changeadd(name,Integer.valueOf(size));
			}
		});
		panel.add(button_add);
		
		JLabel label_deletname = new JLabel("作业名： ");
		label_deletname.setBounds(1000, 670, 70, 20);
		panel.add(label_deletname);
		
		JButton  button_delet = new JButton("回收主存");
		button_delet.setBounds(1080, 700, 90, 20);
		button_delet.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String name = "";
				name = text_deletname.getText();
				if(!name.equals(""))changedelet(name);
			}
		});
		panel.add(button_delet);	

        JButton  flag_0 = new JButton("首次适应");
		flag_0.setBounds(1080, 470, 90, 20);
		flag_0.addActionListener(new ActionListener() {		
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				flag = 0;
				changeflag(0);
			}
		});
		panel.add(flag_0);
		
		JLabel flag0state = new JLabel("？");
		if(flag == 0) flag0state = new JLabel("！");
		else flag0state = new JLabel("?");
		flag0state.setBounds(1050, 470, 20, 20);
		panel.add(flag0state);
		
		JButton  flag_1 = new JButton("最优适应");
		flag_1.setBounds(1080, 510, 90, 20);
		flag_1.addActionListener(new ActionListener() {	
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				flag = 1;
				changeflag(1);
			}
		});
		panel.add(flag_1);
		
		JLabel flag1state = new JLabel("？");
		if(flag == 0) flag1state = new JLabel("?");
		else flag1state = new JLabel("!");
		flag1state.setBounds(1050, 510, 20, 20);
		panel.add(flag1state);
		
		Object[][] addData = new Object[mySql.usedCount][3];
		for(int i = 0; i < mySql.usedCount; i++){
			addData[i][0]=mySql.used[i];
			addData[i][1]=new Integer(mySql.used_l[i]);
			addData[i][2]=new Integer(mySql.used_r[i]-mySql.used_l[i]);
		}
		String[] Names = {"作业名","起址","长度"};
		JTable table_add = new JTable(addData, Names);
		JScrollPane scrollPane_add = new JScrollPane(table_add);
		scrollPane_add.setBounds(100, 100, 300, 500);
		panel.add(scrollPane_add);
		
		String tmp1 = "未分配";
		Object[][] deletData = new Object[mySql.nousedCount+5][4];
		for(int i = 0; i < mySql.nousedCount; i++){
			deletData[i][0]=new Integer(i);
			deletData[i][1]=new Integer(mySql.noused_l[i]);
			deletData[i][2]=new Integer(mySql.noused_r[i]-mySql.noused_l[i]);
			deletData[i][3]="未分配";
		}
		for(int i = mySql.nousedCount; i < mySql.nousedCount + 5; i++){
			deletData[i][3]="空表目";
		}
		String[] Names1 = {"编号","起址","长度","状态栏"};
		JTable table_delet = new JTable(deletData, Names1);
		JScrollPane scrollPane_delet = new JScrollPane(table_delet);
		scrollPane_delet.setBounds(550, 100, 300, 500);
		panel.add(scrollPane_delet);
		
	}
	public static void changeflag(int num){
		mySql.changeflag(num);
		panel.removeAll();
		placeComponents(panel);
		System.out.println("change succeed!");
		panel.repaint();
		
	}
	public static void changeadd(String name,int size){
		mySql.add(name,size);
		panel.removeAll();
		placeComponents(panel);
		panel.repaint();
		System.out.println("Add succeed!");
		mySql.display();
	}
	public static void changedelet(String name){
		mySql.delet(name);
		panel.removeAll();
		placeComponents(panel);
		panel.repaint();
		System.out.println(name+" delet succeed!");
		mySql.display();
	}
}
