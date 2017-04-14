import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;

import java.awt.*;
import java.awt.event.*;
import java.sql.Connection;

public class HomeScreen {

	JFrame envelopePanel;
	JFrame HomeFrame;
	JPanel HomePanel;
	JPanel TitlePanel;
	JPanel QueryPanel;
	JPanel ButtonsPanel;
	JPanel AggregatePanel;
	JPanel ParamPanel;
	JPanel imgPanel;

	int currentQueryNumber;
	String currentQueryString;

	Connection con;

	HomeScreen(Connection con) {
		this.con = con;
		HomePanel = new JPanel();
		AggregatePanel = new JPanel();
		HomePanel.setLayout(new GridBagLayout());

		HomeFrame = new JFrame("  SongKeeper - mDBMS ");
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
		songLabel.setFont(new Font("Century Gothic", Font.PLAIN, 10));
		songLabel.setForeground(Color.cyan);
		songLabel.setBackground((Color.DARK_GRAY));
		DescPanel.add(songLabel);

		return DescPanel;

	}

	JFrame MakeHomeScreen() {
		MakeImage();
		MakeParamPanel();
		MakeLabels();
		MakeButtons();
		MakeQueryPanel();
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

		gbc.insets = new Insets(50, 0, 50, 0);
		gbc.gridx = 0;
		gbc.gridy += 3;

		HomePanel.add(QueryPanel, gbc);
		gbc.insets = new Insets(50, 0, 50, 0);
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

	void MakeParamPanel() {
		ParamPanel = new JPanel();
		ParamPanel.setLayout(new GridBagLayout());

		final JTextField paramField1 = new JTextField();
		final JTextField paramField2 = new JTextField();
		final JTextField paramField3 = new JTextField();

		JLabel paramLabel1 = new JLabel("Field 1:", SwingConstants.LEFT);
		JLabel paramLabel2 = new JLabel("Field 2:", SwingConstants.LEFT);
		JLabel paramLabel3 = new JLabel("Field 3:", SwingConstants.LEFT);

		paramLabel1.setPreferredSize(new Dimension(80, 20));
		paramLabel2.setPreferredSize(new Dimension(80, 20));
		paramLabel3.setPreferredSize(new Dimension(80, 20));

		GridBagConstraints gbc = new GridBagConstraints();
		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.anchor = GridBagConstraints.CENTER;

		gbc.gridx = 0;

		gbc.gridx = 0;
		gbc.gridy++;
		gbc.insets = new Insets(10, 0, 10, 40);
		ParamPanel.add(paramLabel1, gbc);

		gbc.gridy++;
		gbc.insets = new Insets(10, 0, 10, 40);

		ParamPanel.add(paramField1, gbc);

		gbc.gridy++;
		gbc.insets = new Insets(10, 0, 10, 40);
		ParamPanel.add(paramLabel2, gbc);

		gbc.gridy++;
		gbc.insets = new Insets(10, 0, 10, 40);
		ParamPanel.add(paramField2, gbc);

		gbc.gridy++;
		gbc.insets = new Insets(10, 0, 10, 40);
		ParamPanel.add(paramLabel3, gbc);

		gbc.gridy++;
		gbc.insets = new Insets(10, 0, 10, 40);
		ParamPanel.add(paramField3, gbc);

		ParamPanel.setBorder(BorderFactory.createStrokeBorder(new BasicStroke(5.0f)));
	}

	void MakeButtons() {

		ButtonsPanel = new JPanel();
		ButtonsPanel.setLayout(new GridBagLayout());

		JButton goButton = new JButton("Go!");
		goButton.setBackground(Color.DARK_GRAY);
		goButton.setForeground(Color.CYAN);
		goButton.setFont(new Font("Century Gothic", Font.PLAIN, 12));

		JButton exitButton = new JButton("Exit");
		exitButton.setBackground(Color.DARK_GRAY);
		exitButton.setForeground(Color.CYAN);
		exitButton.setFont(new Font("Century Gothic", Font.PLAIN, 12));

		// goButton.setPreferredSize(new Dimension(10,40));
		// exitButton.setPreferredSize(new Dimension(5,40));

		GridBagConstraints gbc = new GridBagConstraints();
		gbc.gridx = 0;
		gbc.gridy = 0;

		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.anchor = GridBagConstraints.CENTER;
		gbc.insets = new Insets(10, 0, 10, 200);
		ButtonsPanel.add(exitButton, gbc);

		gbc.gridx = 40;
		gbc.insets = new Insets(10, 0, 10, 0);
		ButtonsPanel.add(goButton, gbc);

		ButtonsPanel.setBackground(Color.DARK_GRAY);
		ButtonsPanel.setBorder(BorderFactory.createStrokeBorder(new BasicStroke(5.0f)));

		goButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				FormPage q = new FormPage(currentQueryNumber, currentQueryString, con);
				JFrame currentFrame = q.MakeForm();
				HomeFrame.dispose();
				currentFrame.setVisible(true);

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

	void MakeQueryPanel() {
		QueryPanel = new JPanel();
		QueryPanel.setLayout(new GridBagLayout());

		JRadioButton query1 = new JRadioButton("1.Top n songs of a particular year.");
		JRadioButton query2 = new JRadioButton("2.Top n songs of all time.");
		JRadioButton query3 = new JRadioButton("3.Top n songs of a particular period of time.");
		JRadioButton query4 = new JRadioButton("4.Top n songs in US/UK.");
		JRadioButton query5 = new JRadioButton("5.Top n songs of a particular genre.");
		JRadioButton query6 = new JRadioButton("6.Top n albums in US/UK.");
		JRadioButton query7 = new JRadioButton("7.Top n albums of an artist.");
		JRadioButton query8 = new JRadioButton("8.Top n artists of a particular year worldwide. ");
		JRadioButton query9 = new JRadioButton("9.Top n artists of a particular year in US/UK.");
		JRadioButton query10 = new JRadioButton("10.Top n songs grouped by genre.");
		JRadioButton query11 = new JRadioButton("11.This is query 1 xxxxxxxxxxxxxxxxxxxxx     ");
		JRadioButton query12 = new JRadioButton("12.This is query 1 xxxxxxxxxxxxxxxxxxxxx     ");

		ButtonGroup queryGroup = new ButtonGroup();

		queryGroup.add(query1);
		queryGroup.add(query2);
		queryGroup.add(query3);
		queryGroup.add(query4);
		queryGroup.add(query5);
		queryGroup.add(query6);
		queryGroup.add(query7);
		queryGroup.add(query8);
		queryGroup.add(query9);
		queryGroup.add(query10);
		queryGroup.add(query11);
		queryGroup.add(query12);

		query1.setBackground((Color.DARK_GRAY));
		query1.setForeground(Color.cyan);

		query2.setBackground((Color.DARK_GRAY));
		query2.setForeground(Color.cyan);
		query3.setBackground((Color.DARK_GRAY));
		query3.setForeground(Color.cyan);
		query4.setBackground((Color.DARK_GRAY));
		query4.setForeground(Color.cyan);
		query5.setBackground((Color.DARK_GRAY));
		query5.setForeground(Color.cyan);
		query6.setBackground((Color.DARK_GRAY));
		query6.setForeground(Color.cyan);
		query7.setBackground((Color.DARK_GRAY));
		query7.setForeground(Color.cyan);
		query8.setBackground((Color.DARK_GRAY));
		query8.setForeground(Color.cyan);
		query9.setBackground((Color.DARK_GRAY));
		query9.setForeground(Color.cyan);
		query10.setBackground((Color.DARK_GRAY));
		query10.setForeground(Color.cyan);
		query11.setBackground((Color.DARK_GRAY));
		query11.setForeground(Color.cyan);
		query12.setBackground((Color.DARK_GRAY));
		query12.setForeground(Color.cyan);

		query1.setFont(new Font("Century Gothic", Font.PLAIN, 12));
		query2.setFont(new Font("Century Gothic", Font.PLAIN, 12));
		query3.setFont(new Font("Century Gothic", Font.PLAIN, 12));
		query4.setFont(new Font("Century Gothic", Font.PLAIN, 12));
		query5.setFont(new Font("Century Gothic", Font.PLAIN, 12));
		query6.setFont(new Font("Century Gothic", Font.PLAIN, 12));
		query7.setFont(new Font("Century Gothic", Font.PLAIN, 12));
		query8.setFont(new Font("Century Gothic", Font.PLAIN, 12));
		query9.setFont(new Font("Century Gothic", Font.PLAIN, 12));
		query10.setFont(new Font("Century Gothic", Font.PLAIN, 12));
		query11.setFont(new Font("Century Gothic", Font.PLAIN, 12));
		query12.setFont(new Font("Century Gothic", Font.PLAIN, 12));

		GridBagConstraints gbc = new GridBagConstraints();
		gbc.gridx = 0;
		gbc.gridy = 0;

		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.anchor = GridBagConstraints.WEST;
		gbc.insets = new Insets(20, 10, 10, 120);
		QueryPanel.add(query1, gbc);

		gbc.gridy++;
		QueryPanel.add(query2, gbc);

		gbc.gridy++;
		QueryPanel.add(query3, gbc);

		gbc.gridy++;
		QueryPanel.add(query4, gbc);

		gbc.gridy++;
		QueryPanel.add(query5, gbc);

		gbc.gridy++;
		QueryPanel.add(query6, gbc);

		gbc.gridx = 20;
		gbc.gridy = 0;
		gbc.insets = new Insets(20, 100, 10, 10);
		QueryPanel.add(query7, gbc);

		gbc.gridy++;
		QueryPanel.add(query8, gbc);

		gbc.gridy++;
		QueryPanel.add(query9, gbc);

		gbc.gridy++;
		QueryPanel.add(query10, gbc);

		gbc.gridy++;
		QueryPanel.add(query11, gbc);

		gbc.gridy++;
		QueryPanel.add(query12, gbc);

		QueryPanel.setBackground(Color.DARK_GRAY);

		Border blackline = BorderFactory.createStrokeBorder(new BasicStroke(5.0f));
		TitledBorder queryBorder = BorderFactory.createTitledBorder(blackline, "Queries");
		queryBorder.setTitleJustification(TitledBorder.CENTER);
		QueryPanel.setBorder(queryBorder);
		// QueryPanel.setBorder(BorderFactory.createTitledBorder(null, "HOME",
		// TitledBorder.CENTER, TitledBorder.ABOVE_TOP, new Font("times new
		// roman",Font.PLAIN,12), Color.black));

		query1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if (query1.isSelected()) {
					currentQueryNumber = 1;
					currentQueryString = "SELECT * FROM musicorganizer.album where AlbumID=1;";

				}
			}

		});

		query2.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if (query2.isSelected()) {
					currentQueryNumber = 2;
					currentQueryString = "SELECT * FROM musicorganizer.album where AlbumID=2;";
				}
			}

		});

		query3.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if (query3.isSelected()) {
					currentQueryNumber = 3;
					currentQueryString = "SELECT * FROM musicorganizer.album where AlbumID=3;";
				}
			}

		});

		query4.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if (query4.isSelected()) {
					currentQueryNumber = 4;
					currentQueryString = "SELECT * FROM musicorganizer.album where AlbumID=100;";
				}
			}

		});

		query5.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if (query5.isSelected()) {
					currentQueryNumber = 5;
					currentQueryString = "SELECT * FROM musicorganizer.album where AlbumID=100;";
				}
			}

		});

		query6.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if (query6.isSelected()) {
					currentQueryNumber = 6;
					currentQueryString = "SELECT * FROM musicorganizer.album where AlbumID=100;";
				}
			}

		});

		query7.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if (query7.isSelected()) {
					currentQueryNumber = 7;
					currentQueryString = "SELECT * FROM musicorganizer.album where AlbumID=100;";
				}
			}

		});

		query8.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if (query8.isSelected()) {
					currentQueryNumber = 8;
					currentQueryString = "SELECT * FROM musicorganizer.album where AlbumID=100;";
				}
			}

		});

		query9.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if (query9.isSelected()) {
					currentQueryNumber = 9;
					currentQueryString = "SELECT * FROM musicorganizer.album where AlbumID=100;";
				}
			}

		});

		query10.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if (query10.isSelected()) {
					currentQueryNumber = 10;
					currentQueryString = "SELECT * FROM musicorganizer.album where AlbumID=100;";
				}
			}

		});

		query11.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if (query11.isSelected()) {
					currentQueryNumber = 11;
					currentQueryString = "SELECT * FROM musicorganizer.album where AlbumID=100;";
				}
			}

		});

		query12.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if (query12.isSelected()) {
					currentQueryNumber = 12;
					currentQueryString = "SELECT * FROM musicorganizer.album where AlbumID=100;";
				}
			}

		});

	}

}
