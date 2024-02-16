package jony;

import java.sql.*;
import java.util.Arrays;

public class BatchUpdates {

	public static void main(String[] args) {
		Connection connection=null;
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/jony?user=root&password=jony1234");
			System.out.println("Connection done");
			
			Statement statement = connection.createStatement();
			
			
			statement.addBatch("update emp set salary=salary+1000 where id=104");
			System.out.println("query 1 executed...deposit");
			
			statement.addBatch("update emp set salary=salary-5000 where id=103");
			System.out.println("query 2 executed...withdraw");
			
			statement.addBatch("update emp set salary=salary+5000");
			System.out.println("query 3 executed...deposit"); 
			
			int[] batch = statement.executeBatch();
			System.out.println(Arrays.toString(batch));
					
		} catch (ClassNotFoundException e) {
			
			e.printStackTrace();
		} catch (SQLException e) {
		}

}
}
