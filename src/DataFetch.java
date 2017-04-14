
import java.sql.*;
import java.util.ArrayList;

public class DataFetch {

	static ArrayList<ArrayList<String>> retrievedData = new ArrayList<ArrayList<String>>();

	public ArrayList<ArrayList<String>> ReturnData(String queryString, Connection con) {

		ArrayList<String> retrievedRow = new ArrayList<String>();

		try {

			retrievedData = new ArrayList<ArrayList<String>>();
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(queryString);
			while (rs.next()) {
				retrievedRow.add(rs.getString(1));
				retrievedRow.add(rs.getString(2));
				retrievedRow.add(rs.getString(3));

				retrievedData.add(retrievedRow);
				retrievedRow = new ArrayList<String>();

			}
		}

		catch (Exception e) {
			System.out.println(e);
		}

		return retrievedData;
	}
}