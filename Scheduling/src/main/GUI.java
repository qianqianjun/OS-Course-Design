package main;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.rmi.server.UID;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableColumn;
class ProcessTable{
	public JScrollPane GetProcessTable(Object[][] Data,String[] Title,int width,int height)
	{
	    JTable table = new JTable(Data, Title);
	    table.setRowHeight(40);
	    table.getTableHeader().setPreferredSize(new Dimension(0, 40));
	    DefaultTableCellRenderer tcr = new DefaultTableCellRenderer();
	    tcr.setHorizontalAlignment(JLabel.CENTER);
	    table.setPreferredScrollableViewportSize(new Dimension(width, height));
	    JScrollPane scrollPane = new JScrollPane(table);
	    scrollPane.setSize(new Dimension(width, height));
	    return scrollPane;
	}
}
public class GUI {
	private static SQL sql = null;
	private static JFrame frame=new JFrame("进程调度");
	private static JPanel mainpanel=new JPanel();
	private static ProcessTable tables=new ProcessTable();
	public GUI(SQL mysql)
	{
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setBounds(100, 100, 1340, 748);
		frame.setVisible(true);
		frame.add(mainpanel);
		sql=mysql;
	}
	public void reset()
	{
		mainpanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		mainpanel.setLayout(null);
		JPanel runpanel = new JPanel();
		runpanel.setBackground(Color.CYAN);
		runpanel.setBounds(80, 134, 337, 251);
		runpanel.add(tables.GetProcessTable(sql.getRun(), sql.Title, 337, 251));
		mainpanel.add(runpanel);
		
		JLabel runlabel = new JLabel("运行状态");
		runlabel.setFont(new Font("宋体", Font.PLAIN, 19));
		runlabel.setBounds(205, 84, 102, 37);
		mainpanel.add(runlabel);
		
		JPanel readypanel = new JPanel();
	
		readypanel.setBounds(493, 138, 337, 247);
		//初始化ready
		readypanel.add(tables.GetProcessTable(sql.getData(), sql.Title, 337, 247));
		mainpanel.add(readypanel);
		
		JPanel finishpanel = new JPanel();
		finishpanel.setBackground(Color.ORANGE);
		finishpanel.setBounds(906, 138, 318, 247);
		finishpanel.add(tables.GetProcessTable(sql.getFinsh(), sql.Title, 318, 247));
		mainpanel.add(finishpanel);
		
		JLabel readylabel = new JLabel("就绪状态");
		readylabel.setFont(new Font("宋体", Font.PLAIN, 19));
		readylabel.setBounds(629, 88, 83, 29);
		mainpanel.add(readylabel);
		
		JLabel finishlabel = new JLabel("完成状态");
		finishlabel.setFont(new Font("宋体", Font.PLAIN, 19));
		finishlabel.setBounds(1013, 88, 83, 29);
		mainpanel.add(finishlabel);
		
		JPanel addpanel = new JPanel();
		addpanel.setBounds(245, 458, 386, 205);
		mainpanel.add(addpanel);
		addpanel.setLayout(null);
		
		JLabel idlabel = new JLabel("ID：");
		idlabel.setFont(new Font("宋体", Font.PLAIN, 19));
		idlabel.setBounds(54, 32, 72, 18);
		addpanel.add(idlabel);
		
		JLabel prioritylabel = new JLabel("PRIORITY：");
		prioritylabel.setFont(new Font("宋体", Font.PLAIN, 19));
		prioritylabel.setBounds(14, 74, 113, 31);
		addpanel.add(prioritylabel);
		
		JLabel alltimelabel = new JLabel("ALLTIME：");
		alltimelabel.setFont(new Font("宋体", Font.PLAIN, 19));
		alltimelabel.setBounds(24, 129, 96, 31);
		addpanel.add(alltimelabel);
		
		
		JTextField idtf = new JTextField();
		idtf.setBounds(127, 31, 190, 24);
		addpanel.add(idtf);
		idtf.setColumns(10);
		
		JTextField prtf = new JTextField();
		prtf.setBounds(127, 79, 190, 24);
		addpanel.add(prtf);
		prtf.setColumns(10);
		
		JTextField attf = new JTextField();
		attf.setBounds(127, 134, 190, 24);
		addpanel.add(attf);
		attf.setColumns(10);
		
		JButton addbutton = new JButton("添加进程");
		addbutton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String id=idtf.getText();
				String priority=prtf.getText();
				String alltime=attf.getText();
				attf.setText("");
				prtf.setText("");
				idtf.setText("");
				Process temp=new Process(Integer.parseInt(id), Integer.parseInt(priority),Integer.parseInt(alltime));
				sql.add(temp);
				sql.display();
				resetall();
			}
		});
		addbutton.setFont(new Font("宋体", Font.PLAIN, 19));
		addbutton.setBounds(267, 171, 119, 34);
		addpanel.add(addbutton);
		
		JPanel controlpanel = new JPanel();
		controlpanel.setBounds(961, 458, 329, 196);
		mainpanel.add(controlpanel);
		controlpanel.setLayout(null);
		
		JButton switchbutton = new JButton("切换算法");
		switchbutton.setFont(new Font("宋体", Font.PLAIN, 19));
		switchbutton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(sql.flag)
				{
					sql.flag=false;
					switchAlgorithm();
				}
				else
				{
					sql.flag=true;
					switchAlgorithm();
				}
			}
		});
		switchbutton.setBounds(191, 102, 124, 40);
		controlpanel.add(switchbutton);
		
		JLabel tips = new JLabel("当前算法");
		tips.setFont(new Font("宋体", Font.PLAIN, 19));
		tips.setBounds(95, 28, 95, 27);
		controlpanel.add(tips);
		
		JLabel algorithm = new JLabel("");
		if (sql.flag) 
		{
			algorithm.setText("时间片轮转");
		}
		else
		{
			algorithm.setText("优先级调度");
		}
		algorithm.setFont(new Font("宋体", Font.PLAIN, 19));
		algorithm.setBounds(202, 55, 113, 34);
		controlpanel.add(algorithm);
		
		JButton startbutton = new JButton("开始运行");
		startbutton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ChangeSql aaa=new ChangeSql(sql);
				aaa.start();
			}
		});
		startbutton.setFont(new Font("宋体", Font.PLAIN, 19));
		startbutton.setBounds(191, 155, 124, 41);
		controlpanel.add(startbutton);
		
		frame.repaint();
	}
	public void switchAlgorithm()
	{
		mainpanel.removeAll();
		sql.clearall();
		reset();
	}
	public void resetall()
	{
		mainpanel.removeAll();
		reset();
	}
}
