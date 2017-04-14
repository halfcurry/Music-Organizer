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
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/musicorganizer", "root", "notroot");
			System.out.println("Connection made!");
			// got connection, now create a new HomeScreen Object
			HomeScreen gui = new HomeScreen(con);
			gui.MakeHomeScreen();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// try {
		// con.close();
		// System.out.println("Connection closed!");
		// } catch (SQLException e) {
		// // TODO Auto-generated catch block
		// e.printStackTrace();
		// }
	}

}
