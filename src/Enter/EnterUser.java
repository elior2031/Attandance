package Enter;

import java.awt.EventQueue;
import java.awt.Window;

import javax.swing.JFrame;

import Login.FrameClock;
import javax.swing.JButton;

public class EnterUser extends FrameClock{

	//private JFrame frameEnter;
	JButton btnExit;
	JButton btnEnter;
	JButton btnManage;
	JButton btnBack;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
				//	EnterUser window = new EnterUser();
					//window.frameEnter.setVisible(true);
					new EnterUser();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 * @wbp.parser.entryPoint
	 */
	public EnterUser() {
		super.getFrame().setVisible(true);
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		//frameEnter = new JFrame();
		/*frame.setBounds(270, 60, 1400, 900);
		frameEnter.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frameEnter.getContentPane().setLayout(null);*/
		
		btnExit = new JButton("יציאה");
		btnExit.setBounds(700, 100, 250, 100);
		frame.getContentPane().add(btnExit);
		
		btnEnter = new JButton("כניסה");
		btnEnter.setBounds(1050, 100, 250, 100);
		frame.getContentPane().add(btnEnter);
		
		btnManage = new JButton("ניהול נוכחות");
		btnManage.setBounds(700, 270, 600, 100);
		frame.getContentPane().add(btnManage);
		
		btnBack = new JButton("חזרה למסך ראשי");
		btnBack.setBounds(100, 700, 300, 100);
		frame.getContentPane().add(btnBack);
	}

	public JFrame getFrame() {
		// TODO Auto-generated method stub
		return frame;
		
	}
}
