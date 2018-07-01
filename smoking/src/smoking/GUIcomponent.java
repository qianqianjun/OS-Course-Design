package smoking;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class GUIcomponent {
	
	private static boolean ok = false;
	private static int smoker_lqd = 0;
	private static int smoker_gq = 0;
	private static int smoker_yzr = 0;
	private static int Boss = 0;
	private static int tobacco = 0;
	private static int paper = 0;
	private static int matches = 0;
	
	
	private static JPanel panel = new JPanel();
	public static void start(){
		JFrame frame = new JFrame("Smoking");
		frame.setSize(800, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		frame.add(panel);
		placeComponents(panel);
		
		frame.setVisible(true);
	}
	private static void placeComponents(JPanel panel) {
		panel.setLayout(null);
		
		JLabel label = new JLabel("by: bingyu");
		label.setBounds(20, 500, 100, 50);
		panel.add(label);
		
		
		
		JLabel images_lqd = new JLabel();
		ImageIcon image_lqd = new ImageIcon("images/nosmoke.jpg");
		if(smoker_lqd == 0) image_lqd = new ImageIcon("images/nosmoke.jpg");
		else image_lqd = new ImageIcon("images/smoke.jpg");
		images_lqd.setIcon(image_lqd);
		images_lqd.setBounds(150, 100, 70, 70);
		panel.add(images_lqd);
		JLabel label_lqd = new JLabel("ÁõÈ¨´ï(ÑÌ²Ý)");
		label_lqd.setBounds(150, 160, 100, 50);
		panel.add(label_lqd);
		
		
		JLabel images_gq = new JLabel();
		ImageIcon image_gq = new ImageIcon("images/nosmoke.jpg");
		if(smoker_gq == 0) image_gq = new ImageIcon("images/nosmoke.jpg");
		else image_gq = new ImageIcon("images/smoke.jpg");
		images_gq.setIcon(image_gq);
		images_gq.setBounds(150, 230, 70, 70);
		panel.add(images_gq);
		JLabel label_gq = new JLabel("¸ßÇ«(Ö½)");
		label_gq.setBounds(150, 290, 100, 50);
		panel.add(label_gq);
		
		JLabel images_yzr = new JLabel();
		ImageIcon image_yzr = new ImageIcon("images/nosmoke.jpg");
		if(smoker_yzr == 0) image_yzr = new ImageIcon("images/nosmoke.jpg");
		else image_yzr = new ImageIcon("images/smoke.jpg");
		images_yzr.setIcon(image_yzr);
		images_yzr.setBounds(150, 350, 70, 70);
		panel.add(images_yzr);
		JLabel label_yzr = new JLabel("ÓàÖÐÈð(»ð²ñ)");
		label_yzr.setBounds(150, 410, 100, 50);
		panel.add(label_yzr);
		
		JLabel images_boss = new JLabel();
		ImageIcon image_boss = new ImageIcon("images/boss.jpg");
		images_boss.setIcon(image_boss);
		images_boss.setBounds(550, 200, 130, 130);
		panel.add(images_boss);
		JLabel label_boss = new JLabel("");
		if(tobacco + paper + matches == 0){
			label_boss = new JLabel("Nothing!");
		}else{
			if(tobacco == 1 && paper == 1)
				label_boss = new JLabel("ÑÌ²Ýx1  Ö½x1");
			if(tobacco == 1 && matches == 1)
				label_boss = new JLabel("ÑÌ²Ýx1  »ð²ñx1");
			if(paper == 1 && matches == 1)
				label_boss = new JLabel("Ö½x1   »ð²ñx1");
		}
		label_boss.setBounds(580, 330, 100, 50);
		panel.add(label_boss);
		
		
		
		
		
		JButton loginButton = new JButton("µãÒ»µã");
		loginButton.setBounds(650, 515, 80, 25);
		loginButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(ok == false) ok = true;
				else ok = false;
				System.out.println(ok);
			}
		});
		panel.add(loginButton);
	}
	public synchronized boolean ifStart(){

		if(ok == true){
			return true;
		}else{
			return false;
		}
	}

	public synchronized void change(int lqd,int gq,int yzr,int boss,int Tobacco,int Paper,int Matches){
		smoker_lqd = lqd;
		smoker_gq = gq;
		smoker_yzr = yzr;
		Boss = boss;
		tobacco = Tobacco;
		paper = Paper;
		matches = Matches;
		
		panel.removeAll();
		placeComponents(panel);
		panel.repaint();
		
	}
	
}
