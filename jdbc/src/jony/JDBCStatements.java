package jony;

import java.sql.*;

public class JDBCStatements {

	public static void main(String[] args) {
		
		try {
			Class.forName("com.mysql.jdbc.Driver");    // 1st step
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/jony?user=root&password=jony1234");
			System.out.println("Connection done");
			
			CallableStatement callableStatement = connection.prepareCall("{call jony.jdbc(?,?,?,?)}"); // 3rd step  
			callableStatement.setInt(1, 103);
			callableStatement.setString(2, "JK");
			callableStatement.setString(3, "WB");
			callableStatement.setInt(4, 76899);
		
			callableStatement.execute();
			
			
			//statement.execute("create database jdbc");
			
			
			/*ResultSet resultSet = statement.executeQuery("select * from student");
			if(resultSet.next()){
				System.out.println(resultSet.getInt(1)+" "+resultSet.getString(2));
			}*/
			
			connection.close();
			
			
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

	}

}
