import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;

import java.awt.*;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

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
		songLabel.setFont(new Font("Century Gothic", Font.PLAIN, 12));
		songLabel.setForeground(Color.cyan);
		songLabel.setBackground((Color.DARK_GRAY));
		DescPanel.add(songLabel);

		return DescPanel;

	}

	JFrame MakeHomeScreen() {
		MakeImage();
		//MakeParamPanel();
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

		gbc.insets = new Insets(50, 0, 0, 0);
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



	void GetForm(int currentQueryNumber) {
		// FormPage q = new FormPage(currentQueryNumber, currentQueryString,
		// con);
		// JFrame currentFrame = q.MakeForm();
		// HomeFrame.dispose();
		// currentFrame.setVisible(true);

		if (currentQueryNumber == 1) {
			FormPage1 q = new FormPage1(currentQueryNumber, con);
			JFrame currentFrame = q.MakeForm();
			HomeFrame.dispose();
			currentFrame.setVisible(true);

		} else if (currentQueryNumber == 2) {
			FormPage2 q = new FormPage2(currentQueryNumber, con);
			JFrame currentFrame = q.MakeForm();
			HomeFrame.dispose();
			currentFrame.setVisible(true);
		} else if (currentQueryNumber == 3) {
			FormPage3 q = new FormPage3(currentQueryNumber, con);
			JFrame currentFrame = q.MakeForm();
			HomeFrame.dispose();
			currentFrame.setVisible(true);
		} else if (currentQueryNumber == 4) {
			FormPage4 q = new FormPage4(currentQueryNumber, con);
			JFrame currentFrame = q.MakeForm();
			HomeFrame.dispose();
			currentFrame.setVisible(true);
		} else if (currentQueryNumber == 5) {
			FormPage5 q = new FormPage5(currentQueryNumber, con);
			JFrame currentFrame = q.MakeForm();
			HomeFrame.dispose();
			currentFrame.setVisible(true);
		} else if (currentQueryNumber == 6) {
			FormPage6 q = new FormPage6(currentQueryNumber, con);
			JFrame currentFrame = q.MakeForm();
			HomeFrame.dispose();
			currentFrame.setVisible(true);
		} else if (currentQueryNumber == 7) {
			FormPage7 q = new FormPage7(currentQueryNumber, con);
			JFrame currentFrame = q.MakeForm();
			HomeFrame.dispose();
			currentFrame.setVisible(true);
		} else if (currentQueryNumber == 8) {
			FormPage8 q = new FormPage8(currentQueryNumber, con);
			JFrame currentFrame = q.MakeForm();
			HomeFrame.dispose();
			currentFrame.setVisible(true);
		} else if (currentQueryNumber == 9) {
			FormPage9 q = new FormPage9(currentQueryNumber, con);
			JFrame currentFrame = q.MakeForm();
			HomeFrame.dispose();
			currentFrame.setVisible(true);
		}

		else if (currentQueryNumber == 10) {
			FormPage10 q = new FormPage10(currentQueryNumber, con);
			JFrame currentFrame = q.MakeForm();
			HomeFrame.dispose();
			currentFrame.setVisible(true);
		} else if (currentQueryNumber == 11) {
			FormPage11 q = new FormPage11(currentQueryNumber, con);
			JFrame currentFrame = q.MakeForm();
			HomeFrame.dispose();
			currentFrame.setVisible(true);
		} else if (currentQueryNumber == 12) {
			FormPage12 q = new FormPage12(currentQueryNumber, con);
			JFrame currentFrame = q.MakeForm();
			HomeFrame.dispose();
			currentFrame.setVisible(true);
		} else if (currentQueryNumber == 13) {
			FormPage13 q = new FormPage13(currentQueryNumber, con);
			JFrame currentFrame = q.MakeForm();
			HomeFrame.dispose();
			currentFrame.setVisible(true);
		} else if (currentQueryNumber == 14) {
			FormPage14 q = new FormPage14(currentQueryNumber, con);
			JFrame currentFrame = q.MakeForm();
			HomeFrame.dispose();
			currentFrame.setVisible(true);
		}

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
				if (currentQueryNumber == -1) {
					System.out.println("enter query proper");
				} else {
					GetForm(currentQueryNumber);
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

		JRadioButton query1 = new JRadioButton("1.Top n songs of all time.");
		JRadioButton query2 = new JRadioButton("2.Top n songs of a particular period of time.");
		JRadioButton query3 = new JRadioButton("3.Top n songs of a particular artist.");
		JRadioButton query4 = new JRadioButton("4.Top n songs in US/Eur.");
		JRadioButton query5 = new JRadioButton("5.Top n songs of a particular genre.");
		JRadioButton query6 = new JRadioButton("6.Artists with a particular merchandise from your Hometown.");
		JRadioButton query7 = new JRadioButton("7.Songs of a particular genre with size less than x mb.");
		JRadioButton query8 = new JRadioButton("8.Artists with atleast one songs in either of 2 formats. ");
		JRadioButton query9 = new JRadioButton("9.Genres with atleast x songs in it.");
		JRadioButton query10 = new JRadioButton("10.Find greatest Hits of each decade.");
		JRadioButton query11 = new JRadioButton("11.Genres having songs with rating more than x.");
		JRadioButton query12 = new JRadioButton("12.Songs with rating greater than avg rating of all albums.");
		JRadioButton query13 = new JRadioButton("13. Artists who have songs belonging to 2 genres.");
		JRadioButton query14 = new JRadioButton("14. Artists who are performing within some date.");

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
		queryGroup.add(query13);
		queryGroup.add(query14);

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
		query13.setBackground((Color.DARK_GRAY));
		query13.setForeground(Color.cyan);
		query14.setBackground((Color.DARK_GRAY));
		query14.setForeground(Color.cyan);

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
		query13.setFont(new Font("Century Gothic", Font.PLAIN, 12));
		query14.setFont(new Font("Century Gothic", Font.PLAIN, 12));

		GridBagConstraints gbc = new GridBagConstraints();
		gbc.gridx = 0;
		gbc.gridy = 0;

		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.anchor = GridBagConstraints.WEST;
		gbc.insets = new Insets(20, 0, 10, 120);
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

		gbc.gridy++;
		QueryPanel.add(query7, gbc);

		gbc.gridx = 20;
		gbc.gridy = 0;
		gbc.insets = new Insets(20, 30, 10, 10);
		QueryPanel.add(query8, gbc);

		gbc.gridy++;
		QueryPanel.add(query9, gbc);

		gbc.gridy++;
		QueryPanel.add(query10, gbc);

		gbc.gridy++;
		QueryPanel.add(query11, gbc);

		gbc.gridy++;
		QueryPanel.add(query12, gbc);

		gbc.gridy++;
		QueryPanel.add(query13, gbc);

		gbc.gridy++;
		QueryPanel.add(query14, gbc);

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
				}
			}

		});

		query2.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if (query2.isSelected()) {
					currentQueryNumber = 2;
				}
			}

		});

		query3.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if (query3.isSelected()) {
					currentQueryNumber = 3;
				}
			}

		});

		query4.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if (query4.isSelected()) {
					currentQueryNumber = 4;
				}
			}

		});

		query5.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if (query5.isSelected()) {
					currentQueryNumber = 5;
				}
			}

		});

		query6.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if (query6.isSelected()) {
					currentQueryNumber = 6;
				}
			}

		});

		query7.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if (query7.isSelected()) {
					currentQueryNumber = 7;
				}
			}

		});

		query8.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if (query8.isSelected()) {
					currentQueryNumber = 8;
				}
			}

		});

		query9.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if (query9.isSelected()) {
					currentQueryNumber = 9;
				}
			}

		});

		query10.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if (query10.isSelected()) {
					currentQueryNumber = 10;
				}
			}

		});

		query11.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if (query11.isSelected()) {
					currentQueryNumber = 11;
				}
			}

		});

		query12.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if (query12.isSelected()) {
					currentQueryNumber = 12;
				}
			}

		});

		query13.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if (query13.isSelected()) {
					currentQueryNumber = 13;
				}
			}

		});

		query14.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if (query14.isSelected()) {
					currentQueryNumber = 14;
				}
			}

		});

	}

}
