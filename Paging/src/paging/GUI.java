package paging;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

import paging.SQL;
public class GUI {
	
	private static SQL mySql;
	private static JPanel panel = new JPanel();
	public static void start(SQL Sql){
		mySql = Sql;
		
		JFrame frame = new JFrame("paging");
		frame.setSize(1200, 800);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		frame.add(panel);
		placeComponents(panel);
		
		frame.setVisible(true);
	}
	private static void placeComponents(JPanel panel) {
		panel.setLayout(null);
		
		JLabel label = new JLabel("by: bingyu");
		label.setBounds(20, 700, 100, 50);
		panel.add(label);
		
		JLabel label_name = new JLabel("剩余块： ");
		label_name.setBounds(1100, 550, 70, 20);
		panel.add(label_name);
		
		JLabel label_count = new JLabel("作业名： ");
		label_count.setText(Integer.valueOf(mySql.Count).toString());
		label_count.setBounds(1150, 550, 70, 20);
		panel.add(label_count);
		
		JLabel label_addname = new JLabel("作业名： ");
		label_addname.setBounds(1000, 580, 70, 20);
		panel.add(label_addname);
		
		JLabel label_addsize = new JLabel("页数： ");
		label_addsize.setBounds(1013, 610, 70, 20);
		panel.add(label_addsize);
		
		JTextField text_addname = new JTextField();
        text_addname.setBounds(1050,580,120,20);
        panel.add(text_addname);
        
        JTextField text_addsize = new JTextField();
        text_addsize.setBounds(1050,610,120,20);
        panel.add(text_addsize);
        
        JButton  button_add = new JButton("加入作业");
		button_add.setBounds(1080, 640, 90, 20);
		button_add.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String name = "";String size = "";
				name = text_addname.getText();
				size = text_addsize.getText();
				if(!name.equals("") && !size.equals(""))
					add(name,Integer.valueOf(size));
			}
		});
		panel.add(button_add);
		
		JLabel label_deletname = new JLabel("作业名： ");
		label_deletname.setBounds(1000, 670, 70, 20);
		panel.add(label_deletname);
		
		JTextField text_deletname = new JTextField();
        text_deletname.setBounds(1050,670,120,20);
        panel.add(text_deletname);
        
        JButton  button_delet = new JButton("回收作业");
		button_delet.setBounds(1080, 700, 90, 20);
		button_delet.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String name = "";
				name = text_deletname.getText();
				if(!name.equals(""))
					delet(name);
			}
		});
		panel.add(button_delet);
		
		
		JLabel label_find = new JLabel("作业名： ");
		label_find.setBounds(1000, 480, 70, 20);
		panel.add(label_find);
		
		JTextField text_find = new JTextField();
        text_find.setBounds(1050,480,120,20);
        panel.add(text_find);
		
        JButton  button_find = new JButton("查找作业");
		button_find.setBounds(1080, 510, 90, 20);
		button_find.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String name = "";
				name = text_find.getText();
				if(!name.equals(""))
					find(name);
			}
		});
		panel.add(button_find);
		

		JLabel label_find1 = new JLabel("");
		label_find1.setBounds(870, 65, 100, 20);
		label_find1.setText(mySql.find_name);
		panel.add(label_find1);
		
		

		Object[][] addData = new Object[mySql.N][mySql.N+1];
		for(int i = 0; i<mySql.N;i++) {
			for(int j = 0 ;j<mySql.N+1;j++) {
				if(j != 0) addData[i][j] = Integer.valueOf(mySql.arr[i][j-1]);
				else addData[i][j] = Integer.valueOf(i);
			}
		}
		String[] Names = new String[mySql.N + 1];
		Names[0] = "字节号/位数";
		for(int i = 0 ;i < mySql.N ;i++)
			Names[i+1] = Integer.valueOf(i).toString();
		JTable table_add = new JTable(addData, Names);
		JScrollPane scrollPane_add = new JScrollPane(table_add);
		table_add.setRowHeight(45);
		scrollPane_add.setBounds(100, 100, 600, 385);
		panel.add(scrollPane_add);
		
		
		Vector<Integer> arr = mySql.mp.get(mySql.find_name);
		Object[][] findData = new Object[(arr == null ? 0 : arr.size())+1][2];
		if(arr != null) {
			for(int i = 0; i<arr.size();i++) {
				findData[i][0] = Integer.valueOf(i);
				findData[i][1] = arr.get(i);
			}
		}
		String[] find_Names = {"页号","块号"};
		JTable table_find = new JTable(findData,find_Names);
		JScrollPane scrollPane_find = new JScrollPane(table_find);
		scrollPane_find.setBounds(800, 100, 200, 385);
		panel.add(scrollPane_find);
	}
	public static void add(String name,int size) {
		mySql.add(name,size);
		panel.removeAll();
		placeComponents(panel);
		System.out.println("add succeed!");
		panel.repaint();
		mySql.display();
	}
	public static void delet(String name) {
		mySql.delet(name);
		panel.removeAll();
		placeComponents(panel);
		System.out.println("delet succeed!");
		panel.repaint();
		mySql.display();
	}
	public static void find(String name) {
		mySql.find(name);
		panel.removeAll();
		placeComponents(panel);
		System.out.println("find succeed!");
		panel.repaint();
		mySql.display();
	}
}
