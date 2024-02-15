package Dao;

import java.sql.*;

import java.util.ArrayList;
import java.util.List;

import javax.print.attribute.standard.RequestingUserName;

import com.jony.Dto.Dto;


public class Dao {
	

	public void add(Dto dto){
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/jony?user=root&password=jony1234");
			PreparedStatement ps = connection.prepareStatement("Insert into Members values(?,?,?,?,?)");
			
			ps.setInt(1, dto.getId());
			ps.setString(2, dto.getName());
			ps.setString(3, dto.getPass());
			ps.setInt(4, dto.getSal());
			ps.setString(5, dto.getAdd());
			
			ps.execute();
			System.out.println("Data Store");
			
			connection.close();
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
	}

	public List<Dto> show() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/jony?user=root&password=jony1234");
			Statement statement = connection.createStatement();
			ResultSet rs = statement.executeQuery("Select * from Members");
			
			List<Dto> list= new ArrayList<>();
			
			while(rs.next()) {
					
			Dto dto= new Dto();
			dto.setId(rs.getInt(1));
			dto.setName(rs.getString(2));
			dto.setPass(rs.getString(3));
			dto.setSal(rs.getInt(4));
			dto.setAdd(rs.getString(5));
			list.add(dto);
			}
			return list;
			
			
			
			
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
		return null;
	}

	public Dto edit(int id) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/jony?user=root&password=jony1234");
			PreparedStatement ps = connection.prepareStatement("select * from members where id=?");
			
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			rs.next();
			Dto dto = new Dto();
			
			dto.setId(rs.getInt(1));
			dto.setName(rs.getString(2));
			dto.setPass(rs.getString(3));
			dto.setSal(rs.getInt(4));
			dto.setAdd(rs.getString(5));
			
			return dto;
			
			
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
		
	}

	public int update(Dto dto) {
		int update=0;
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/jony?user=root&password=jony1234");
			PreparedStatement ps = connection.prepareStatement("update members set name=?, pass=?, sal=?, address=? where id=?");
			
		
			ps.setString(1, dto.getName());
			ps.setString(2, dto.getPass());
			ps.setInt(3, dto.getSal());
			ps.setString(4, dto.getAdd());
			ps.setInt(5, dto.getId());
			
			update = ps.executeUpdate();
			
			
			connection.close();
			
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		}
		return update;
	}

	public static void delete(int id) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/jony?user=root&password=jony1234");
			PreparedStatement ps = connection.prepareStatement("delete from members where id=?");
			ps.setInt(1, id);
			ps.executeUpdate();
			
			connection.close();
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
		
	}

	

}
