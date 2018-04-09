package client;


import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JPasswordField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.IOException;
import java.net.UnknownHostException;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;

public class LoginGUI extends JFrame implements Runnable {

	private JTextField user;
	private JLabel usernamel;
	private JLabel passwordl;
	private JLabel title;
	private JPasswordField pass;
	private JPanel userp;
	private JPanel passp;
	private JButton loginb;
	private Container c;
	Client client;
	LoginGUI login;

	/**
	 * Create the application.
	 * 
	 * @throws IOException
	 * @throws UnknownHostException
	 */
	public LoginGUI(Client client) {
		super("login");
		this.client = client;
		run();
	}

	private void initialize2() {
		c = getContentPane();
		c.setLayout(new BoxLayout(c, BoxLayout.PAGE_AXIS));
		title = new JLabel("Login");
		title.setFont(title.getFont().deriveFont(16.0f));
		usernamel = new JLabel("User Name");
		usernamel.setFont(usernamel.getFont().deriveFont(16.0f));
		user = new JTextField(15);
		userp = new JPanel();
		userp.setLayout(new BoxLayout(userp, BoxLayout.LINE_AXIS));
		userp.add(usernamel);
		userp.add(Box.createRigidArea(new Dimension(10, 0)));
		userp.add(user);
		
		passwordl = new JLabel("Password");
		passwordl.setFont(usernamel.getFont().deriveFont(16.0f));
		pass = new JPasswordField(15);
		pass.setEchoChar('*');
		passp = new JPanel();
		passp.setLayout(new BoxLayout(passp, BoxLayout.LINE_AXIS));
		passp.add(passwordl);
		passp.add(Box.createRigidArea(new Dimension(17, 0)));
		passp.add(pass);
		
		
		
		loginb = new JButton("Login");
		loginb.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					String username = user.getText();
					String password = new String(pass.getPassword());
					client.checkLogin(username, password);
					

				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		userp.setBorder(new EmptyBorder(15,15,0,15));
		passp.setBorder(new EmptyBorder(15,15,15,15));
		title.setAlignmentX( Component.CENTER_ALIGNMENT );
		loginb.setAlignmentX( Component.CENTER_ALIGNMENT );
		c.add(Box.createRigidArea(new Dimension(0,15)));
		c.add(title);
		c.add(userp);
		c.add(passp);
		c.add(loginb);
		c.add(Box.createRigidArea(new Dimension(0,15)));
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub

		initialize2();

	}
}