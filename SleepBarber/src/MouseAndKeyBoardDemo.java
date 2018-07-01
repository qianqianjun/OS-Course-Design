import java.awt.*;
import java.awt.event.*;
public class MouseAndKeyBoardDemo {
	
	private Frame f;
	private TextField tf;
	private Button button;
	public MouseAndKeyBoardDemo()
	{
		init();
	}
	public void init()
	{
		//初始化组件
		f=new Frame("对话框");
		f.setLayout(new FlowLayout());
		f.setBounds(400, 200, 500, 400);
		tf=new TextField(15);
		button=new Button("按钮");
		//添加组件
		f.add(tf);
		f.add(button);
		//设置监听事件
		MyEventer();
		f.setVisible(true);
	}
	private void MyEventer() {
		
		f.addWindowListener(new WindowAdapter(){
			@Override
			public void windowClosing(WindowEvent arg0) {
				// TODO Auto-generated method stub
				System.exit(0);
			}
		});
		//设置button的相关事件监听
		button.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				//tf.setText("鼠标活动着呢");
			}
		});
		button.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseEntered(MouseEvent arg0) {
				super.mouseEntered(arg0);
				tf.setText("鼠标进入了");
			}

			@Override
			public void mouseClicked(MouseEvent e) {
				super.mouseClicked(e);
				if(e.getClickCount()==2)
					tf.setText("鼠标双击");
				else
					tf.setText("鼠标单击");
			}
		});
		//设置文本框的事件监听
		tf.addKeyListener(new KeyListener() {
			private StringBuffer s;
			@Override
			public void keyTyped(KeyEvent e) {
				// TODO Auto-generated method stub
				System.out.println(e.getKeyChar());
			}
			
			@Override
			public void keyReleased(KeyEvent e) {
				// TODO Auto-generated method stub
			}
			
			@Override
			public void keyPressed(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
	}
	public static void main(String [] args)
	{
		new MouseAndKeyBoardDemo();
	}
}
