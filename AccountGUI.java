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

class AccountGUI extends JFrame
{
	public AccountGUI(String n, String pw)
	{
		super();
		//setLayout(new BorderLayout());
		String title = "Grokhowsky Bank";
		setTitle(title);
		setExtendedState(JFrame.MAXIMIZED_BOTH);
		setResizable(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);


		ImageIcon pic = new ImageIcon("image/" + n + ".JPG");
		Image picImage = pic.getImage();
		Image newImage = picImage.getScaledInstance(120, 120, Image.SCALE_SMOOTH);
		ImageIcon picTwo = new ImageIcon(newImage);

		Font f = new Font("Helvetica", Font.BOLD, 30);
		Font f2 = new Font("Helvetica", Font.BOLD, 45);

		Account openAccount = new Account(n, pw);

		JPanel imagePanel = new JPanel();
		imagePanel.setBackground(Color.GRAY);
		imagePanel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		add(imagePanel, BorderLayout.WEST);

		JLabel image = new JLabel(picTwo);
		imagePanel.add(image);

		JPanel mainPanel = new JPanel();
		mainPanel.setBackground(Color.GRAY);
		add(mainPanel);

		if(!openAccount.getPW())
		{
			JPanel panel = new JPanel(new GridLayout(7,1));
			panel.setBackground(Color.WHITE);
			mainPanel.add(panel, BorderLayout.CENTER);
		

			JPanel blank = new JPanel();
			blank.setBackground(Color.GRAY);
			panel.add(blank);


			JPanel welcomePanel = new JPanel();
			welcomePanel.setBackground(Color.WHITE);
			panel.add(welcomePanel);

			JLabel welcomeLabel = new JLabel("Welcome to your account ");
			welcomeLabel.setFont(f);
			welcomePanel.add(welcomeLabel);

			JPanel namePanel = new JPanel();
			panel.add(namePanel);

			JLabel name = new JLabel(openAccount.getName());
			name.setFont(f2);
			namePanel.add(name);

			JPanel blank1 = new JPanel();
			blank1.setBackground(Color.GRAY);
			panel.add(blank1);

			JPanel balancePanel = new JPanel();
			balancePanel.setBackground(Color.WHITE);
			panel.add(balancePanel);

			JLabel balanceLabel = new JLabel("Your balance is: ");
			balanceLabel.setFont(f);
			balancePanel.add(balanceLabel);

			JPanel balancePanelTwo = new JPanel();
			panel.add(balancePanelTwo);

			JLabel balance = new JLabel();
			balance.setText("$" + Double.toString(openAccount.getBalance()));
			balance.setFont(f2);
			balancePanelTwo.add(balance);

			panel.add(blank);

			JPanel closePanel = new JPanel();
			closePanel.setBackground(Color.GRAY);
			panel.add(closePanel);

			JPanel cPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
			JButton close = new JButton("CLOSE");
			cPanel.add(close);
			closePanel.add(cPanel, BorderLayout.SOUTH);

			close(close);	

		}
	
		else
		{
			JPanel panelTwo = new JPanel(new GridLayout(9,1));
			panelTwo.setBackground(Color.WHITE);
			mainPanel.add(panelTwo, BorderLayout.CENTER);		

			JPanel blank = new JPanel();
			blank.setBackground(Color.GRAY);
			panelTwo.add(blank);

			JPanel welcomePanel = new JPanel();
			welcomePanel.setBackground(Color.WHITE);
			panelTwo.add(welcomePanel);

			JLabel welcomeLabel = new JLabel("Welcome to your account ");
			welcomeLabel.setFont(f);
			welcomePanel.add(welcomeLabel);

			JPanel namePanel = new JPanel();
			panelTwo.add(namePanel);

			JLabel name = new JLabel(openAccount.getName());
			name.setFont(f2);
			namePanel.add(name);

			JPanel blank1 = new JPanel();
			blank1.setBackground(Color.GRAY);
			panelTwo.add(blank1);

			JPanel balancePanel = new JPanel();
			balancePanel.setBackground(Color.WHITE);
			panelTwo.add(balancePanel);

			JLabel balanceLabel = new JLabel("Your balance is: ");
			balanceLabel.setFont(f);
			balancePanel.add(balanceLabel);

			JPanel balancePanelTwo = new JPanel();
			panelTwo.add(balancePanelTwo);

			JLabel balance = new JLabel();
			balance.setText("$" + Double.toString(openAccount.getBalance()));
			balance.setFont(f2);
			balancePanelTwo.add(balance);

			panelTwo.add(blank1);

			JTextField tf = new JTextField();
			tf.setFont(f);
			panelTwo.add(tf);

			JPanel buttonPanel = new JPanel(new GridLayout(1,2));
			buttonPanel.setBackground(Color.GRAY);
			panelTwo.add(buttonPanel);

			JButton deposit = new JButton("DEPOSIT");
			buttonPanel.add(deposit);

			JButton withdraw = new JButton("WITHDRAW");
			buttonPanel.add(withdraw);

			respond(deposit, openAccount, tf, balance);
			respond(withdraw, openAccount, tf, balance);

			panelTwo.add(blank);

			JPanel closePanel = new JPanel();
			closePanel.setBackground(Color.GRAY);
			panelTwo.add(closePanel);

			JPanel cPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
			JButton close = new JButton("CLOSE");
			cPanel.add(close);
			closePanel.add(cPanel, BorderLayout.SOUTH);

			close(close);
		}
	}


	public void respond(JButton b, Account a, JTextField tf, JLabel balance)
	{
		b.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e)
			{
				String s = e.getActionCommand();

				switch(s)
				{
					case("DEPOSIT"):		
											a.deposit(Double.parseDouble(tf.getText()));
											a.writeBalance();
											balance.setText("$" + Double.toString(a.getBalance()));
					break;

					case("WITHDRAW"):										
											a.withdraw(Double.parseDouble(tf.getText()));
											a.writeBalance();
											balance.setText("$" + Double.toString(a.getBalance()));
					break;

				}

			}
		});
	}

	public void close(JButton b)
	{
		b.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e)
			{
				String s = e.getActionCommand();

				switch(s)
				{
					case("CLOSE"):			
											System.exit(0);
					break;
				}



			}
		});
	}

}