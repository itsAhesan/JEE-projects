package jony;

import java.sql.*;

public class SavePoint {

	public static void main(String[] args) {
		Connection connection=null;
		Savepoint sp=null;
	
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/jony?user=root&password=jony1234");
			System.out.println("Connection done");
			
			Statement statement = connection.createStatement();
			
			connection.setAutoCommit(false);   // disable auto-commit mode
			statement.execute("update emp set salary=salary+1000 where id=104");
			System.out.println("query 1 executed...deposit");
			
			statement.execute("update emp set salary=salary-5000 where id=104");
			System.out.println("query 2 executed...withdraw");
			sp=connection.setSavepoint();           // set savpoint
			statement.execute("update emp set salary=salary+5000 where id=aa");
			System.out.println("query 3 executed...deposit"); 
			
			connection.commit();   // after executed all the queries
			System.out.println("data commit");
					
		} catch (ClassNotFoundException e) {
			
			e.printStackTrace();
		} catch (SQLException e) {
			try {
				connection.rollback(sp);      
				System.out.println("data rollback after save point");  // if any exception occurs
				connection.commit();
				System.out.println("data commited before save point");
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		
		
		
		

	}

}
