
import java.sql.*;
import java.util.ArrayList;

public class DataFetch {

	static ArrayList<ArrayList<String>> retrievedData = new ArrayList<ArrayList<String>>();

	public ArrayList<ArrayList<String>> ReturnData(String queryString, Connection con) {

		ArrayList<String> retrievedRow = new ArrayList<String>();
		ArrayList<String> columnNames = new ArrayList<String>();

		try {

			retrievedData = new ArrayList<ArrayList<String>>();
			Statement stmt = con.createStatement();
			System.out.println();
			ResultSet rs = stmt.executeQuery(queryString);
			ResultSetMetaData rsmd = rs.getMetaData();
			int columnCount = rsmd.getColumnCount();
			//System.out.println(columnCount);
			while (rs.next()) {
				for( int i = 1; i <= columnCount; i++ ){
					//System.out.println(rs.getString(i));
					retrievedRow.add(rs.getString(i));
				}
				
//				retrievedRow.add(rs.getString(2));
//				retrievedRow.add(rs.getString(3));

				retrievedData.add(retrievedRow);
				retrievedRow = new ArrayList<String>();

			}
			for( int i = 1; i <= columnCount; i++ ){
				columnNames.add(rsmd.getColumnName(i));
			}
			
			retrievedData.add(columnNames);
			
		}

		catch (Exception e) {
			System.out.println(e);
		}

		return retrievedData;
	}
}