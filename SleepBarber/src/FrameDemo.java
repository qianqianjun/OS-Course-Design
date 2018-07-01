import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.Button;
import java.awt.FlowLayout;
public class FrameDemo {

	public static void main(String[] args) {
		Frame f=new Frame("对话框");
		f.setBounds(400, 200, 500,400);
		f.setVisible(true);
		f.setLayout(new FlowLayout());
		Button button =new Button("点击关闭");
		button.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				System.exit(0);
			}
			
		});
		f.add(button);
		f.addWindowListener(new WindowAdapter() {

			@Override
			public void windowClosing(WindowEvent arg0) {
				super.windowClosing(arg0);
				System.exit(0);
			}
			
		});
		System.out.println("over");
	}

}
