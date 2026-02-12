package com.connectdb;
import java.sql.*;

public class Employee {
	
	public static void fetchData(Statement stmt) throws SQLException {
		String fet = "select * from employee";
		ResultSet res = stmt.executeQuery(fet);
		while(res.next()) {
			System.out.println(res.getInt(1) + " " + res.getString(2));
		}
	}
	
	public static void insertData(Statement stmt) throws SQLException {
		String ins = "insert into employee values (1, 'nani', 189892), (2, 'puneeth', 23454)";
		stmt.execute(ins);
	}
	
	public static void updateData(Statement stmt) throws SQLException{
		String upd = "update employee set name = 'hero' where id = 2";
		stmt.execute(upd);
	}
	
	public static void deleteData(Statement stmt) throws SQLException{
		String del = "delete from employee where id = 1";
		stmt.execute(del);
	}
	
	public static void main(String[] args) {
		
		String url = "jdbc:postgresql://localhost:5433/collage";
		String username = "postgres";
		String pass = "612900";
		try {
			
			Class.forName("org.postgresql.Driver");
			Connection connect = DriverManager.getConnection(url, username, pass);
			
			Statement stmt = connect.createStatement();
			fetchData(stmt);
//			insertData(stmt);
//			updateData(stmt);
//			deleteData(stmt);
			
			System.out.println("operation done");
		}catch(ClassNotFoundException e) {
			e.printStackTrace();
		}catch(SQLException s) {
			s.printStackTrace();
		}
		
	}
}
