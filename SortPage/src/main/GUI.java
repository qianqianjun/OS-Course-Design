package main;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import main.SQL;
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
		
		JButton  button = new JButton("加入作业");
		button.setBounds(500, 640, 90, 20);
		button.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				mySql.init();
				change();
			}
		});
		panel.add(button);
		
		
		Object[][] arr = new Object[mySql.length][3];
		for(int i = 0; i<mySql.length;i++) {
			arr[i][0]=Integer.toString(i);
			arr[i][1]=Integer.toString(mySql.cmd1[i]);
			arr[i][2]=Integer.toString(mySql.cmd[i]);
		}
		String[] Names = {"标号","指令","页号"};
		
		JTable table = new JTable(arr, Names);
		JScrollPane scrollPane = new JScrollPane(table);
		table.setRowHeight(45);
		scrollPane.setBounds(100, 100, 600, 385);
		panel.add(scrollPane);
		
		JLabel label = new JLabel("111");
		label.setBounds(800, 200, 300, 50);
		label.setFont(new Font("宋体", Font.BOLD, 30));
		label.setText("OPT:  "+mySql.ans[1]);
		panel.add(label);
		
		JLabel label_FIFO = new JLabel("111");
		label_FIFO.setBounds(800, 250, 300, 50);
		label_FIFO.setFont(new Font("宋体", Font.BOLD, 30));
		label_FIFO.setText("FIFO: "+mySql.ans[2]);
		panel.add(label_FIFO);
		
		JLabel label_LRU = new JLabel("111");
		label_LRU.setBounds(800, 300, 300, 50);
		label_LRU.setFont(new Font("宋体", Font.BOLD, 30));
		label_LRU.setText("LRU:  "+mySql.ans[3]);
		panel.add(label_LRU);
		
		JLabel label_LFU = new JLabel("111");
		label_LFU.setBounds(800, 350, 300, 50);
		label_LFU.setFont(new Font("宋体", Font.BOLD, 30));
		label_LFU.setText("LFU:  "+mySql.ans[4]);
		panel.add(label_LFU);
		
		JLabel label_NRU = new JLabel("111");
		label_NRU.setBounds(800, 400, 300, 50);
		label_NRU.setFont(new Font("宋体", Font.BOLD, 30));
		label_NRU.setText("NRU:  "+mySql.ans[5]);
		panel.add(label_NRU);
	}
	public static void change() {
		panel.removeAll();
		placeComponents(panel);
		panel.repaint();
	}
	
}
