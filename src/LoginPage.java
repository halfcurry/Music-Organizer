import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;

import java.awt.*;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class LoginPage {

	JFrame envelopePanel;
	JFrame HomeFrame;
	JPanel HomePanel;
	JPanel TitlePanel;
	JPanel LoginPanel;
	JPanel ButtonsPanel;
	JPanel AggregatePanel;
	JPanel ParamPanel;
	JPanel imgPanel;
	String loginID;
	String loginPassword;
	 JTextField paramField1;
	 JPasswordField paramField2;

	int currentQueryNumber;
	String currentQueryString;

	Connection con;

	LoginPage(Connection con) {
		this.con = con;
		HomePanel = new JPanel();
		AggregatePanel = new JPanel();
		HomePanel.setLayout(new GridBagLayout());

		HomeFrame = new JFrame("  SongKeeper - Login ");
		HomeFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		HomeFrame.setSize(new Dimension(1920, 1080));
		HomePanel.setPreferredSize(new Dimension(1920, 1080));
		HomeFrame.add(AggregatePanel);

		HomeFrame.setVisible(true);

		currentQueryNumber = -1;

	}

	void MakeImage() {

		ImageIcon image = new ImageIcon("pic2.jpg");
		JLabel label = new JLabel("", image, JLabel.CENTER);
		imgPanel = new JPanel(new BorderLayout());
		imgPanel.add(label, BorderLayout.CENTER);

	}

	JPanel MakeDescription() {
		JPanel DescPanel = new JPanel();
		JLabel songLabel = new JLabel("a Database Management System for Music", SwingConstants.CENTER);
		songLabel.setFont(new Font("Century Gothic", Font.PLAIN, 11));
		songLabel.setForeground(Color.cyan);
		songLabel.setBackground((Color.DARK_GRAY));
		DescPanel.add(songLabel);

		return DescPanel;

	}

	JFrame MakeLoginScreen() {
		MakeImage();
		//MakeParamPanel();
		MakeLabels();
		MakeButtons();
		MakeLoginPanel();
		JPanel descPanel = MakeDescription();
		descPanel.setBackground(Color.DARK_GRAY);

		GridBagConstraints gbc = new GridBagConstraints();
		gbc.gridx = 0;
		gbc.gridy = 0;

		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.anchor = GridBagConstraints.CENTER;
		gbc.insets = new Insets(65, 0, 0, 0);
		HomePanel.add(TitlePanel, gbc);

		gbc.insets = new Insets(0, 0, 0, 0);
		gbc.gridx = 0;
		gbc.gridy += 3;

		HomePanel.add(descPanel, gbc);

		gbc.insets = new Insets(60, 0, 40, 0);
		gbc.gridx = 0;
		gbc.gridy += 3;

		HomePanel.add(LoginPanel, gbc);
		gbc.insets = new Insets(60, 0, 50, 0);
		gbc.gridx = 0;
		gbc.gridy++;

		HomePanel.add(ButtonsPanel, gbc);
		HomePanel.setBackground(Color.DARK_GRAY);
		HomePanel.setBorder(BorderFactory.createStrokeBorder(new BasicStroke(5.0f)));

		AggregatePanel.setLayout(new BorderLayout());

		AggregatePanel.add(HomePanel, BorderLayout.CENTER);
		AggregatePanel.add(imgPanel, BorderLayout.WEST);

		return HomeFrame;
	}



	void MakeButtons() {

		ButtonsPanel = new JPanel();
		ButtonsPanel.setLayout(new GridBagLayout());

		JButton LoginButton = new JButton("Login");
		LoginButton.setBackground(Color.DARK_GRAY);
		LoginButton.setForeground(Color.CYAN);
		LoginButton.setFont(new Font("Century Gothic", Font.PLAIN, 12));

		JButton exitButton = new JButton("Exit");
		exitButton.setBackground(Color.DARK_GRAY);
		exitButton.setForeground(Color.CYAN);
		exitButton.setFont(new Font("Century Gothic", Font.PLAIN, 12));

		GridBagConstraints gbc = new GridBagConstraints();
		gbc.gridx = 0;
		gbc.gridy = 0;

		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.anchor = GridBagConstraints.CENTER;
		gbc.insets = new Insets(10, 0, 10, 500);
		ButtonsPanel.add(exitButton, gbc);

		gbc.gridx = 40;
		gbc.insets = new Insets(10, 0, 10, 0);
		ButtonsPanel.add(LoginButton, gbc);

		ButtonsPanel.setBackground(Color.DARK_GRAY);
		ButtonsPanel.setBorder(BorderFactory.createStrokeBorder(new BasicStroke(5.0f)));

		LoginButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				loginID=paramField1.getText();		
				char [] tempPass = paramField2.getPassword();
				loginPassword = new String(tempPass);

				
				if (checkLogin(loginID,loginPassword) == false) {
					//System.out.println("enter query proper");
					Object infoMessage="Plij entre correcto fartssward/hojornaam";
					String titleBar="Errah";
					JOptionPane.showMessageDialog(null, infoMessage, "InfoBox: " + titleBar, JOptionPane.INFORMATION_MESSAGE);
					// dialog box
				} else {
					HomeScreen gui = new HomeScreen(con);
					JFrame currentFrame = gui.MakeHomeScreen();					
					currentFrame.setVisible(true);
					HomeFrame.dispose();		
					

				}
			}

		});

		exitButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				System.exit(0);

			}

		});
	}

	boolean checkLogin(String loginID, String loginPassword) {
		if (loginID.equals("admin") && loginPassword.equals("pigscanfly"))
			return true;
		else
			return false;

	}

	void MakeLabels() {

		TitlePanel = new JPanel();
		TitlePanel.setLayout(new GridBagLayout());

		JLabel songLabel = new JLabel(" \nsong", SwingConstants.CENTER);
		songLabel.setFont(new Font("Century Gothic", Font.ITALIC, 15));
		songLabel.setForeground(Color.cyan);
		songLabel.setBackground((Color.DARK_GRAY));
		TitlePanel.add(songLabel);

		JLabel keeperLabel = new JLabel("KEEPER", SwingConstants.CENTER);
		keeperLabel.setFont(new Font("Century Gothic", Font.PLAIN, 50));
		keeperLabel.setForeground(Color.cyan);
		keeperLabel.setBackground((Color.black));
		TitlePanel.add(keeperLabel);

		TitlePanel.setBackground((Color.DARK_GRAY));

		TitlePanel.setBorder(BorderFactory.createStrokeBorder(new BasicStroke(5.0f)));

	}

	void MakeLoginPanel() {
		LoginPanel = new JPanel();
		LoginPanel.setLayout(new GridBagLayout());

	 paramField1 = new JTextField();
		 paramField2 = new JPasswordField();
		 
	

		JLabel paramLabel1 = new JLabel("LOGIN    :", SwingConstants.LEFT);
		JLabel paramLabel2 = new JLabel("PASSWORD :", SwingConstants.LEFT);

		paramLabel1.setFont(new Font("Century Gothic", Font.PLAIN, 12));
		paramLabel1.setForeground(Color.cyan);
		paramLabel2.setFont(new Font("Century Gothic", Font.PLAIN, 12));
		paramLabel2.setForeground(Color.cyan);

		paramLabel1.setPreferredSize(new Dimension(100, 40));
		paramLabel2.setPreferredSize(new Dimension(100, 40));

		paramField1.setPreferredSize(new Dimension(100, 40));
		paramField2.setPreferredSize(new Dimension(100, 40));

		GridBagConstraints gbc = new GridBagConstraints();
		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.anchor = GridBagConstraints.CENTER;

		gbc.gridx = 0;

		gbc.gridx = 0;
		gbc.gridy++;
		gbc.insets = new Insets(10, 60, 10, 40);
		LoginPanel.add(paramLabel1, gbc);

		gbc.gridx++;
		gbc.insets = new Insets(10, 60, 10, 40);

		LoginPanel.add(paramField1, gbc);

		gbc.gridx = 0;
		gbc.gridy++;
		gbc.insets = new Insets(10, 60, 10, 40);
		LoginPanel.add(paramLabel2, gbc);

		gbc.gridx++;
		gbc.insets = new Insets(10, 60, 10, 40);
		LoginPanel.add(paramField2, gbc);

		LoginPanel.setBackground((Color.DARK_GRAY));

		LoginPanel.setBorder(BorderFactory.createStrokeBorder(new BasicStroke(5.0f)));

	}


}
