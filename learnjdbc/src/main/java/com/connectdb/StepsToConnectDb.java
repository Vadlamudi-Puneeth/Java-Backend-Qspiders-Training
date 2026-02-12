package com.connectdb;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
//import java.sql.Statement;

public class StepsToConnectDb {
	public static void main(String[] args) {
		String url = "jdbc:postgresql://localhost:5433/school";
		String username = "postgres";
		String pwd = "612900";
		// step:1 load the driver class

		try {
			Class.forName("org.postgresql.Driver");// this is used to load the 3rd party jar file present in maven
													

			// step2: to establish connection

			Connection connect = DriverManager.getConnection(url, username, pwd);

//			String ins = "insert into student values(3,'Don','don@gmail.com','female'), (4, 'mahesh', 'mahesh@gmail.com', 'male')";
//			String upd = "update student set studentName = 'priya' where id = 2";
//			String del = "delete from student where id = 1";
			
			// create statement api
//			Statement stmt = connect.createStatement();
			
//			stmt.execute(ins);
//			stmt.execute(upd);
//			stmt.execute(del);
			
			connect.close();
			
			System.out.println("data inserted");
//			System.out.println("data updated");
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} 
		// this is used to load the 3rd party jar file present in maven dependencies
		catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
