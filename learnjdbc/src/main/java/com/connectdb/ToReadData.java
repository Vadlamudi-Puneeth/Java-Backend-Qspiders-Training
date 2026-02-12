package com.connectdb;

import java.sql.*;
import java.util.*;

public class ToReadData {
	
	public static void selectData(Statement stmt, String sel) throws SQLException{
		ResultSet res = stmt.executeQuery(sel);
		while(res.next()) {
			System.out.println(res.getInt(1) + " " + res.getString(2));
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		String url = "jdbc:postgresql://localhost:5433/school";
		String username = "postgres";
		String pwd = "612900";
		try {
			
			Class.forName("org.postgresql.Driver");
			
			Connection connect = DriverManager.getConnection(url, username, pwd);
			
			String ins = "insert into student values(?, ?, ?, ?)";
			String sel = "select * from student where id = ?";
			
//			Statement stmt = connect.createStatement();
//			insertData(stmt);
//			selectData(stmt, sel);
			
			PreparedStatement ps = connect.prepareStatement(ins); // dynamic query and for reusability
			
			int id = sc.nextInt();
			ps.setInt(1, id);
			sc.nextLine();
			String name = sc.nextLine();
			ps.setString(2, name);
			String email = sc.nextLine();
			ps.setString(3, email);
			String gender = sc.nextLine();
			ps.setString(4, gender);
			
			ps.execute();
			System.out.println("done");
			connect.close();
			
		}catch(ClassNotFoundException cnfe) {
			cnfe.printStackTrace();
		}catch(SQLException s) {
			s.printStackTrace();
		}
	}
}
