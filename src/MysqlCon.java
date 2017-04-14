import java.sql.*;
import java.util.Vector;  
class MysqlCon{  
	
	Vector data = new Vector();
	Vector row = new Vector();
//
//	
//	void sendData()
//	{
//		
//		while(rs.next())
//		{ 
//		    row = new Vector();
//		    for(int i =1;i<=c;i++)
//		    {
//
//		        row.add(rs.getString(i));
//		    }
//
//		    data.add(row);
//
//
//
//		}
//	}
//	
	
@SuppressWarnings({ "unchecked", "rawtypes" })
public Vector connectToSQL(){  

	
	
try{  
		Class.forName("com.mysql.jdbc.Driver"); 
		
		
		Connection con=DriverManager.getConnection(  
		"jdbc:mysql://localhost:3306/playground","root","notroot");  
		
		
		//here sonoo is database name, root is username and password  
		Statement stmt=con.createStatement();  	
		
		ResultSet rs=stmt.executeQuery("select * from equipment where equip_id = 1");  
		
		while(rs.next())
		{ 
		    row = new Vector();
		    for(int i =0;i<=2;i++)
		    {

		        row.add(rs.getString(i));
		    }

		    data.add(row);



		}
		
		
		
		
				con.close();  
				
				
		}
		catch(Exception e){ System.out.println(e);}


	return data;  
}  


}  



