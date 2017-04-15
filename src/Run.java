import java.sql.*;

public class Run {
	public static Connection con;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/musicorganizer", "root", "gubi");
			System.out.println("Connection made!");
			
			LoginPage Logger = new  LoginPage(con);
			Logger.MakeLoginScreen();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
