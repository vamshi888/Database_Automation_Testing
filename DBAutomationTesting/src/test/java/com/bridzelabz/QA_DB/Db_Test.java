package com.bridzelabz.QA_DB;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import org.testng.annotations.Test;

public class Db_Test extends Base {
	
	@Test (priority=1)
	
	public void getTableData() throws SQLException {
		con=this.setUp();
		Statement stmt = con.createStatement();
		ResultSet rs = stmt.executeQuery("select * from emp" );
		while (rs.next()) {
			int id = rs.getInt(1);
			String name = rs.getString(2);
			String email = rs.getString(3);
			System.out.println(id+ " "+name+ " " +email);			
		}
	}
	   @Test (priority=2)
	   public void insertData() throws SQLException {		   
		   con=this.setUp();
		   PreparedStatement stmt = con.prepareStatement ("insert into emp(id,name,email)values (?,?,?)");
		   stmt.setInt(1,4);
			stmt.setString(2, "vamshi");
			stmt.setString(3, "vamshi@gmail");
			stmt.executeUpdate();
			getTableData();
			
	   }
	   @Test (priority=4)
	   public void deleteData() throws SQLException {		   
		   con=this.setUp();
		   PreparedStatement stmt = con.prepareStatement ("delete from emp where id= ?");		 
			stmt.setInt(1, 1);			
			stmt.executeUpdate();
			getTableData();
			
	   }
	   @Test (priority=3)
	   public void updateData() throws SQLException {		   
		   con=this.setUp();
		   PreparedStatement stmt = con.prepareStatement ("update emp set name = 'krishna' where id = 3");		 
			//stmt.setString(1, "krishna");	
			//stmt.setInt(2, 3);
			stmt.executeUpdate();
			getTableData();
			
	   }
} 
