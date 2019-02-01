// GUI to open login and if login isVerified opens appropriate account

import java.util.*;
import java.io.*;
import java.awt.*;
import javax.swing.*;
import javax.swing.border.*;
import java.awt.event.*; 
import javax.swing.event.*;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferByte;
import javax.imageio.ImageIO;

class BankGUI extends JFrame
{
	public BankGUI()
	{
		super();
		//setLayout(new BorderLayout());
		String title = "Grokhowsky Bank";
		setTitle(title);
		setExtendedState(JFrame.MAXIMIZED_BOTH);
		setResizable(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		boolean login = false;

		Login log = new Login();

		Font f = new Font("Helvetica", Font.BOLD, 30);
		Font f2 = new Font("Helvetica", Font.BOLD, 60);

		JPanel mainPanel = new JPanel();
		mainPanel.setBackground(Color.BLACK);
		add(mainPanel);

		JPanel panel = new JPanel(new GridLayout(6,1));
		mainPanel.add(panel, BorderLayout.CENTER);
		panel.setBackground(Color.BLACK);

		JPanel blank = new JPanel();
		blank.setBackground(Color.BLACK);
		panel.add(blank);

		JPanel blank1 = new JPanel();
		blank1.setBackground(Color.BLACK);
		panel.add(blank1);


		JPanel welcomePanel = new JPanel();
		welcomePanel.setBackground(Color.BLACK);
		panel.add(welcomePanel);

		JLabel welcomeLabel = new JLabel("Please log into your account");
		welcomeLabel.setFont(f);
		welcomeLabel.setBackground(Color.BLACK);
		welcomeLabel.setForeground(Color.WHITE);
		welcomePanel.add(welcomeLabel);


		JPanel user = new JPanel();
		user.setLayout(new BorderLayout());
		user.setBackground(Color.BLACK);
		panel.add(user);

		JLabel name = new JLabel("USER NAME:     ");
		name.setFont(f);
		name.setBackground(Color.BLACK);
		name.setForeground(Color.WHITE);
		name.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		
		JTextField nInput = new JTextField();
		nInput.setFont(f2);
		nInput.setBackground(Color.BLACK);
		nInput.setForeground(Color.WHITE);


		JPanel pass = new JPanel();
		pass.setLayout(new BorderLayout());
		pass.setBackground(Color.BLACK);
		panel.add(pass);


		JLabel password = new JLabel("PASSWORD:     ");
		password.setFont(f);
		password.setBackground(Color.BLACK);
		password.setForeground(Color.WHITE);
		password.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));


		JPasswordField pw = new JPasswordField(10);
		pw.setFont(f2);
		pw.setBackground(Color.BLACK);
		pw.setForeground(Color.WHITE);

		panel.add(blank);

		JButton submit = new JButton("SUBMIT");
		submit.setFont(f);
		submit.setBackground(Color.GRAY);
		submit.setForeground(Color.WHITE);
		
		user.add(name, BorderLayout.WEST);
		user.add(nInput, BorderLayout.CENTER);
		pass.add(password, BorderLayout.WEST);
		pass.add(pw, BorderLayout.CENTER);
		panel.add(submit);


		respond(submit, nInput, pw, log, login);


		

	}

	// respond function calls action listner if 'submit' button is pressed it test the user name and password in Login parameter log and if it is verified opens an account
	// takes 5 parameters - a JButton to access teh action listener, JTextField to access the user name, JPasswordField to acces the password, Login to test the user name and password, and boolean if login is succesful
	public void respond(JButton b, JTextField tf, JPasswordField pf, Login log, boolean login)
	{
		b.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e)
			{
				String s = e.getActionCommand();

				switch(s)
				{
					case("SUBMIT"):					log.setUser(tf.getText());
											char [] password = pf.getPassword();
											String pw = String.valueOf(password);
											log.setPassword(pw);
											if(log.getVerification()) 
											{
																						
												AccountGUI open = new AccountGUI(tf.getText(), pw);
												open.setVisible(true);
												login = true;
												dispose();														
											}
					break;
				}



			}
		});
	}

}
