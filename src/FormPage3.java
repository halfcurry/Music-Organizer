
import java.awt.BasicStroke;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Vector;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class FormPage3 {

	JPanel TablePanel;
	JPanel ButtonsPanel;
	JPanel FormPanel;
	JPanel TitlePanel;
	JPanel ParamPanel;
	JFrame FormFrame;
	JPanel AggregatePanel;
	JTable formTable;
	JTextField paramField1;
	JTextField paramField2;
	int queryNumber;
	String queryString;
	Connection con;
	DataFetch d;
	DefaultTableModel resultTable;

	public FormPage3(int qNo, Connection con) {
		// System.out.println( "Hello");
		FormPanel = new JPanel();
		// resultTable = new DefaultTableModel();
		// resultTable.setRowCount(0);
		AggregatePanel = new JPanel();
		FormPanel.setLayout(new GridBagLayout());
		FormPanel.setBackground(Color.DARK_GRAY);
		this.con = con;

		FormFrame = new JFrame("  SongKeeper - mDBMS ");
		FormFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		FormFrame.setSize(new Dimension(1920, 1080));
		FormFrame.setPreferredSize(new Dimension(1920, 1080));
		FormFrame.add(AggregatePanel);

		FormFrame.setVisible(true);

		this.queryNumber = qNo;
		// this.queryString = queryString;
	}

	void MakeParamPanel() {
		ParamPanel = new JPanel();
		ParamPanel.setLayout(new GridBagLayout());

		JButton goButton = new JButton("Go");
		goButton.setBackground(Color.DARK_GRAY);
		goButton.setForeground(Color.CYAN);
		goButton.setFont(new Font("Century Gothic", Font.PLAIN, 12));

		goButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub

				int topn = Integer.parseInt(paramField1.getText());
				String name = paramField2.getText();
				
				String[][] dataMatrix = RetrieveData( topn, name );

				String[] columnNames = dataMatrix[dataMatrix.length - 1];
				dataMatrix[dataMatrix.length - 1] = null;
				
				resultTable = new DefaultTableModel(columnNames, 0);
				resultTable.setRowCount(0);

				for (String[] row : dataMatrix) {
					resultTable.addRow(row);
				}

				dataMatrix = null;						
				formTable.setModel(resultTable);


			}

		});

		paramField1 = new JTextField();
		paramField2 = new JTextField();
		
		JLabel paramLabel1 = new JLabel("Enter n:", SwingConstants.LEFT);
		JLabel paramLabel2 = new JLabel("Enter Artist name:", SwingConstants.LEFT);

		paramLabel1.setFont(new Font("Century Gothic", Font.PLAIN, 12));
		paramLabel1.setForeground(Color.cyan);
		
		paramLabel2.setFont(new Font("Century Gothic", Font.PLAIN, 12));
		paramLabel2.setForeground(Color.cyan);

		paramLabel1.setPreferredSize(new Dimension(80, 20));
		paramLabel2.setPreferredSize(new Dimension(80, 20));

		GridBagConstraints gbc = new GridBagConstraints();
		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.anchor = GridBagConstraints.CENTER;

		gbc.gridx = 0;

		gbc.gridy++;
		gbc.insets = new Insets(10, 60, 10, 40);
		ParamPanel.add(paramLabel1, gbc);

		gbc.gridy++;
		gbc.insets = new Insets(10, 60, 10, 40);

		ParamPanel.add(paramField1, gbc);

		gbc.gridy++;
		gbc.insets = new Insets(10, 60, 10, 40);
		ParamPanel.add(goButton, gbc);
		
		gbc.gridy++;
		gbc.insets = new Insets(10, 60, 10, 40);
		ParamPanel.add(paramLabel2, gbc);

		gbc.gridy++;
		gbc.insets = new Insets(10, 60, 10, 40);
		ParamPanel.add(paramField2, gbc);
		

		ParamPanel.setBorder(BorderFactory.createStrokeBorder(new BasicStroke(5.0f)));
		ParamPanel.setBackground(Color.DARK_GRAY);


	}

	public String[][] RetrieveData( Integer n, String name ) {
		DataFetch d = new DataFetch();
		System.out.println("Fetching data");
		String s1 = "SELECT song.SongID ,song.SongName , artist.ArtistName FROM performs join song ";
		String s2 = "join artist on performs.ArtistID = artist.ArtistID and ";
		String s3 = "performs.SongID = song.SongID";
		String s4 = " and artist.ArtistName = \"" + name + "\"";
		String s5 = " order by SongScore desc limit " + n + ";";
		queryString = s1 + s2 + s3 + s4 + s5;
		System.out.println(queryString);
		try {
			PreparedStatement statement = con.prepareStatement(queryString);
			statement.setString(1, "Cliff Richard");
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		System.out.println(queryString);
		ArrayList<ArrayList<String>> dataArrayList = d.ReturnData(queryString, con);
		String[][] dataMatrix = new String[dataArrayList.size()][];
		for (int i = 0; i < dataArrayList.size(); i++) {
			ArrayList<String> row = dataArrayList.get(i);
			dataMatrix[i] = row.toArray(new String[row.size()]);
		}
	
		return dataMatrix;

	}

	void MakeTable() {
		
		TablePanel = new JPanel();
		TablePanel.setLayout(new BorderLayout());

		
		String[][] dataMatrix = null;
		String[] columnNames = {"2","2","2"};
	

		formTable = new JTable();
		formTable.setVisible(true);
		JScrollPane tableContainer = new JScrollPane(formTable);
		formTable.setFillsViewportHeight(true);
		TablePanel.add(tableContainer, BorderLayout.CENTER);
		TablePanel.setBackground(Color.DARK_GRAY);

	}

	JPanel MakeDescription() {
		JPanel DescPanel = new JPanel();
		JLabel songLabel = new JLabel("Current Query : " + this.queryNumber, SwingConstants.CENTER);
		songLabel.setFont(new Font("Century Gothic", Font.PLAIN, 12));
		songLabel.setForeground(Color.cyan);
		songLabel.setBackground((Color.DARK_GRAY));
		DescPanel.add(songLabel);
		DescPanel.setBackground((Color.DARK_GRAY));
		return DescPanel;

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

	void MakeButtons() {
		ButtonsPanel = new JPanel();
		ButtonsPanel.setLayout(new GridBagLayout());

		JButton backButton = new JButton("Back");
		backButton.setBackground(Color.DARK_GRAY);
		backButton.setForeground(Color.CYAN);
		backButton.setFont(new Font("Century Gothic", Font.PLAIN, 12));

		JButton exitButton = new JButton("Exit");
		exitButton.setBackground(Color.DARK_GRAY);
		exitButton.setForeground(Color.CYAN);
		exitButton.setFont(new Font("Century Gothic", Font.PLAIN, 12));

		JButton prevButton = new JButton("Prev");
		prevButton.setBackground(Color.DARK_GRAY);
		prevButton.setForeground(Color.CYAN);
		prevButton.setFont(new Font("Century Gothic", Font.PLAIN, 12));

		JButton nextButton = new JButton("Next");
		nextButton.setBackground(Color.DARK_GRAY);
		nextButton.setForeground(Color.CYAN);
		nextButton.setFont(new Font("Century Gothic", Font.PLAIN, 12));

		ButtonsPanel.add(backButton);
		ButtonsPanel.add(exitButton);

		GridBagConstraints gbc = new GridBagConstraints();
		gbc.gridx = 0;
		gbc.gridy = 0;

		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.anchor = GridBagConstraints.CENTER;
		gbc.insets = new Insets(0, 0, 0, 250);
		ButtonsPanel.add(exitButton, gbc);

		gbc.gridx = 20;
		gbc.insets = new Insets(10, 0, 10, 0);
		ButtonsPanel.add(prevButton, gbc);

		gbc.gridx = 30;
		gbc.insets = new Insets(10, 20, 10, 0);
		ButtonsPanel.add(nextButton, gbc);

		gbc.gridx = 40;
		gbc.insets = new Insets(0, 250, 0, 0);
		ButtonsPanel.add(backButton, gbc);

		ButtonsPanel.setBackground(Color.DARK_GRAY);
		ButtonsPanel.setBorder(BorderFactory.createStrokeBorder(new BasicStroke(5.0f)));

		backButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				HomeScreen homeScr = new HomeScreen(con);
				JFrame currentFrame = homeScr.MakeHomeScreen();
				FormFrame.dispose();

				currentFrame.setVisible(true);

				DefaultTableModel model = (DefaultTableModel) formTable.getModel();
				model.setRowCount(0);

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

	JFrame MakeForm() {
		MakeTable();
		MakeButtons();
		MakeLabels();
		MakeParamPanel();
		JPanel descPanel = MakeDescription();

		GridBagConstraints gbc = new GridBagConstraints();
		gbc.gridx = 0;
		gbc.gridy = 0;

		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.anchor = GridBagConstraints.CENTER;

		gbc.insets = new Insets(0, 0, 0, 0);
		FormPanel.add(TitlePanel, gbc);

		gbc.gridx = 0;
		gbc.gridy++;

		FormPanel.add(descPanel, gbc);

		gbc.insets = new Insets(50, 0, 0, 0);
		gbc.gridy = 3;
		FormPanel.add(TablePanel, gbc);

		gbc.insets = new Insets(50, 0, 0, 0);
		gbc.gridy = 5;

		FormPanel.add(ButtonsPanel, gbc);

		FormPanel.setBackground(Color.DARK_GRAY);
		FormPanel.setBorder(BorderFactory.createStrokeBorder(new BasicStroke(5.0f)));

		AggregatePanel.setLayout(new BorderLayout());

		AggregatePanel.add(FormPanel, BorderLayout.CENTER);
		AggregatePanel.add(ParamPanel, BorderLayout.WEST);

		return FormFrame;
	}

}
