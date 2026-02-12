package com.connectdb;

import java.sql.*;

public class FetchStudentData {
	public static void main(String[] args) {
		
		String url = "jdbc:postgresql://localhost:5433/school";
		String username = "postgres";
		String pwd = "612900";
		
		try {
			Class.forName("org.postgresql.Driver");
			
			Connection connect = DriverManager.getConnection(url, username, pwd);
			
			String sel = "select * from student";
			Statement stmt = connect.createStatement();
			ResultSet res = stmt.executeQuery(sel);
			
			while(res.next()) {
				System.out.println(res.getInt(1) + " " + res.getString(2));
			}
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
	}
}
