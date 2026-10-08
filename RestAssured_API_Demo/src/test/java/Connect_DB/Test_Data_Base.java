package Connect_DB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Test_Data_Base {
	
	Connection  con1= null;
	
	public Connection Connect_to_db(String dbname, String user, String pass) {
		
		
//		String url =null;
		try {
			Class.forName("org.postgresql.Driver");
			con1 = DriverManager.getConnection( "jdbc:postgresql://20.244.81.212:6014/" + dbname,user,pass);
			if(con1!=null) {
				System.out.println("connection established...");
			}else {
				System.out.println("Connection Failed...");
			}
			
			
		}catch(Exception e) {
			System.out.println(e);
		}
		return con1;
		
		
	}
	public void read_data(Connection con1, String tbl_name) {
		Statement statement;
		ResultSet rs;
		
		
		String query = String.format("select * from tbl_mobiles", "tbl_mobiles");
		try {
			statement = con1.createStatement();
			rs=statement.executeQuery(query);
			while(rs.next()) {
				System.out.println(rs.getString("mobile"));
				System.out.println(rs.getString("id"));

				
				
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
				
		
		
		
	}
	
	
	
	
}