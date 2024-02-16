package jony;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCSteps {

	public static void main(String[] args) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("Load successfully");
			
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/jony?user=root&password=jony1234");
			System.out.println("Connection done");
			
			Statement statement = connection.createStatement();
			//statement.execute("show databases");
			
			//statement.execute("create table student(id int(10),name varchar(255),address varchar(255),phone int(10))");
			//statement.execute("insert into student values(102,'Rahat','WB',67775)");
			ResultSet resultSet = statement.executeQuery("select * from student");
			while(resultSet.next()){
				System.out.println(resultSet.getInt(1)+" "+resultSet.getString(2)+" "+resultSet.getString(3)+" "+resultSet.getInt(4));
			}
			
			connection.close();
			System.out.println("Connection close");
			
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
