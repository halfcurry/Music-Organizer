


import java.sql.*;
import java.util.ArrayList;  
class SQLConnector{ 
	
	static ArrayList<ArrayList<String>> retrievedData= new ArrayList<ArrayList<String>> ();
	
	public ArrayList<ArrayList<String>> ConnectToServer(String queryString){  
	
		ArrayList<String> retrievedRow= new ArrayList<String>();
	try{  
			
		Class.forName("com.mysql.jdbc.Driver");  
		Connection con=DriverManager.getConnection(	"jdbc:mysql://localhost:3306/musicorganizer","root","notroot");  
		//here sonoo is database name, root is username and password  
		Statement stmt=con.createStatement();  
		ResultSet rs=stmt.executeQuery(queryString);  
		while(rs.next())  
		{
			retrievedRow.add(rs.getString(1));
			retrievedRow.add(rs.getString(2));
			retrievedRow.add(rs.getString(3));
			
			retrievedData.add(retrievedRow);
			retrievedRow=new ArrayList<String>();
		
		}
		
		con.close();  
	}
	
	catch(Exception e){ System.out.println(e);}  
	
	
	return retrievedData;
	}  
	
//	public static void main(String args[]){  
//		
//		
//		SQLConnector s1= new SQLConnector();
//		ArrayList<String> retrievedRow =s1.ConnectToServer();
//		System.out.println(retrievedData);
//	
//	}
}  