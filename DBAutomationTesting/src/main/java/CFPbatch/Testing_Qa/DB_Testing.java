package CFPbatch.Testing_Qa;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DB_Testing {

		public static void main(String[] args) throws SQLException {	
				String dburl = "jdbc:mysql://localhost:3306/DB_automation";
				String username = "root";
				String password = "vamshi";
				Connection con = DriverManager.getConnection(dburl,username,password);
				Statement stmt = con.createStatement();
				ResultSet rs = stmt.executeQuery("select * from Emp");
				while (rs.next()) {
					int id = rs.getInt(1);
					String name = rs.getString(2);
	String email = rs.getString(3);
					System.out.println(id+" "+name+" "+email);
				}
				con.close();
		}

	}

