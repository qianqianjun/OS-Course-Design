package ui;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Font;

public class BarberShopUi extends JFrame {
	private int DeskCount=5;
	private JLabel[] labels=new JLabel[5] ;
	private JPanel MainDiv;
	private Boolean[] Desk=new Boolean[5];
	private JLabel status;
	private JLabel barber;
	private JLabel door;
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BarberShopUi frame = new BarberShopUi();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});	
	}
	public BarberShopUi() {
		for(int i=0;i<DeskCount;i++)
		{
			Desk[i]=true;
		}
		setBackground(Color.WHITE);
		setTitle("睡眠理发师问题演示powerby 高谦");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1135, 758);
		MainDiv = new JPanel();
		MainDiv.setBackground(Color.WHITE);
		MainDiv.setBorder(new EmptyBorder(5, 5, 5, 5));
		MainDiv.setLayout(new BorderLayout(0, 0));
		setContentPane(MainDiv);
		
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		MainDiv.add(panel, BorderLayout.NORTH);
		
		door = new JLabel("");
		door.setIcon(new ImageIcon("image/door.jpg"));
		MainDiv.add(door, BorderLayout.EAST);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.WHITE);
		MainDiv.add(panel_1, BorderLayout.CENTER);
		panel_1.setLayout(null);
		
		status = new JLabel("status");
		status.setFont(new Font("宋体", Font.PLAIN, 23));
		status.setBounds(100, 200, 400, 30);
		panel_1.add(status);
		
		JPanel panel_2 = new JPanel();
		MainDiv.add(panel_2, BorderLayout.WEST);
		panel_2.setLayout(new BorderLayout(0, 0));
		
		barber = new JLabel("睡觉中，理发请踢醒我！");
		barber.setFont(new Font("宋体", Font.PLAIN, 20));
		barber.setBackground(Color.WHITE);
		barber.setIcon((new ImageIcon("image/sleep.png")));
		panel_2.add(barber, BorderLayout.CENTER);
		ImageIcon img=new ImageIcon("image/desk.png");
		for(int i=0;i<5;i++)
		{
			labels[i]=new JLabel("");
			labels[i].setIcon(img);
			panel.add(labels[i]);
		}
	}
	public synchronized Boolean getSeet(int index)
	{
		for(int i=0;i<DeskCount;i++)
		{
			//System.out.println(i);
			if(Desk[i])
			{
				Desk[i]=false;
				labels[i].setIcon(new ImageIcon("image/full.png"));
				labels[i].setText(""+index);
				return true;
			}
		}
		return false;
	}
	public synchronized Boolean freeSeet(int index)
	{
		for(int i=0;i<DeskCount;i++)
		{
			if(labels[i].getText().equals((""+index)))
			{
				labels[i].setIcon(new ImageIcon("image/desk.png"));
				labels[i].setText("");
				Desk[i]=true;
				return true;
			}
		}
		return false;
	}
	public synchronized void setStatus(String s)
	{
		status.setText(s);
	}
	public synchronized void setBarber(int index)
	{
		barber.setText(""+index+"号顾客正在理发");
		barber.setFont(new Font("宋体", Font.PLAIN, 20));
		barber.setIcon(new ImageIcon("image/work.jpg"));
	}
	public synchronized void Sleep()
	{
		barber.setText("没有顾客，理发请踢醒我");
		barber.setFont(new Font("宋体", Font.PLAIN, 20));
		barber.setIcon(new ImageIcon("image/sleep.png"));
	}
	public synchronized void setDoorCome()
	{
		door.setIcon(new ImageIcon("image/come.jpg"));
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public synchronized void setDoorLeave()
	{
		door.setIcon(new ImageIcon("image/door.jpg"));
	}
}
