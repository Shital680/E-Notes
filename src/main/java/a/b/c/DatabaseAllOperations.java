package a.b.c;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DatabaseAllOperations {
	public static Connection getconnection() {
		Connection conn=null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			 conn=DriverManager.getConnection("jdbc:mysql://localhost/pro","root","root");
		}catch(Exception e) {
			e.printStackTrace();
		}
		return conn;
	}
	
	public static int save(UserDetails u) throws SQLException{
		int status=0;
		try {
			Connection conn=DatabaseAllOperations.getconnection();
			PreparedStatement ps=conn.prepareStatement("Insert into pro_table(name, email, password) values(?,?,?)");
			
			ps.setString(1, u.getName());
			ps.setString(2, u.getEmail());
			ps.setString(3, u.getPassword());
			status=ps.executeUpdate();
			conn.close();
		}catch(Exception e1) {
			e1.printStackTrace();
		}
		return status;
		
	}
	
	public static boolean validate(String email, String password) {
		boolean status =false;
		try {
			Connection conn=DatabaseAllOperations.getconnection();
			PreparedStatement ps=conn.prepareStatement("select * from pro_table where email=? and password=?");
			ps.setString(1, email);
			ps.setString(2, password);
			
			ResultSet rs=ps.executeQuery();
			status=rs.next();
		}catch(Exception e2) {
			e2.printStackTrace();
		}
		return status;
	}
	
	public static boolean Verification(String email) {
		boolean status =false;
		try {
			Connection conn=DatabaseAllOperations.getconnection();
			PreparedStatement ps=conn.prepareStatement("select * from pro_table where email=?");
			ps.setString(1, email);
			
			
			ResultSet rs=ps.executeQuery();
	        status=rs.next();
		}catch(Exception e2) {
			e2.printStackTrace();
		}
		return status;
	}
	
	public static int add(UserDetails u) throws SQLException{
		int status=0;
		try {
			Connection conn=DatabaseAllOperations.getconnection();
			PreparedStatement ps=conn.prepareStatement("Insert into pro_table1(title, note,email) values(?,?,?)");
			
			ps.setString(1, u.getTitle());
			ps.setString(2, u.getNote());
			ps.setString(2, u.getEmail());
			status=ps.executeUpdate();
			conn.close();
		}catch(Exception e1) {
			e1.printStackTrace();
		}
		return status;
}
	
	public static List<UserDetails> getNotesByUsername(String email) throws SQLException {
		
		List<UserDetails> li=new ArrayList<UserDetails>();
		try {
		Connection conn=DatabaseAllOperations.getconnection();
		PreparedStatement ps=conn.prepareStatement("Select * from pro_table1 where email=?");
		ps.setString(1, email);
		
		ResultSet rs=ps.executeQuery();
		while(rs.next()) {
			UserDetails s1=new UserDetails();
			
			s1.setId(rs.getInt(1));
			s1.setTitle(rs.getString(2));
			s1.setNote(rs.getString(3));
			s1.setEmail(rs.getString(4));
	
			
			li.add(s1);
		}conn.close();
		}catch(Exception e2) {
			e2.printStackTrace();
		}
		return li;
}
	
	public static UserDetails getUserById(int id) {
		UserDetails u=new UserDetails();
		try {
			Connection conn=DatabaseAllOperations.getconnection();
			PreparedStatement ps=conn.prepareStatement("Select * from pro_table1 where id=?");
			ps.setInt(1, id);
			
			ResultSet rs=ps.executeQuery();
			if(rs.next()) {
				u.setId(rs.getInt(1));
				u.setTitle(rs.getString(2));
				u.setNote(rs.getString(3));
				}conn.close();
			}catch(Exception e3) {
				e3.printStackTrace();
			}
		return u;
	}
	
	public static int update(UserDetails u) {
		int status=0;
		try {
			Connection con=DatabaseAllOperations.getconnection();
			PreparedStatement ps=con.prepareStatement("update pro_table1 set title=?, note=? where id=?");
			ps.setString(1, u.getTitle());
			ps.setString(2, u.getNote());
			ps.setInt(3, u.getId());
			
			status=ps.executeUpdate();
			con.close();
		}catch(Exception e4) {
			e4.printStackTrace();
		}
		return status;
	}
	
	public static int delete(int id) {
		int status=0;
		
		try {
			Connection con=DatabaseAllOperations.getconnection();
			PreparedStatement ps=con.prepareStatement("Delete from pro_table1 where id=?");
			ps.setInt(1, id);
			status=ps.executeUpdate();
			con.close();
		}catch(Exception e5) {
			e5.printStackTrace();
		}
		return status;
	}
}
