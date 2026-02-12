package com.connectdb;
import java.sql.*;
import java.util.*;

public class AllOperationsInEmployees {
	
	public static void addEmployee(String ins, PreparedStatement ps) throws SQLException{
		Scanner sc = new Scanner(System.in);
		int id = sc.nextInt();
		ps.setInt(1, id);
		sc.nextLine();
		String name = sc.nextLine();
		ps.setString(2, name);
		int sal = sc.nextInt();
		ps.setInt(3, sal);
		
		ps.execute();
		System.out.println("inserted");
	}
	
	public static void deleteEmployeeById(String del, PreparedStatement ps) throws SQLException{
		Scanner sc = new Scanner(System.in);
		int id = 1;
		ps.setInt(1, id);
		int rows = ps.executeUpdate();
		if(rows > 0)
			System.out.println("deleted");
		else
			System.out.println("not deleted");
		
	}
	
	public static void updateEmployeeSalById(String upd, PreparedStatement ps) throws SQLException{
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Enter employee id: ");
	    int id = sc.nextInt();

	    System.out.print("Enter new salary: ");
	    int sal = sc.nextInt();

	    ps.setInt(1, sal); 
	    ps.setInt(2, id);  

	    int rows = ps.executeUpdate();
	    
	    if(rows > 0) {
		    	System.out.println("updated");	    		
	    }else {
	    		System.out.println("not updated");
	    }
		
		
	}
	
	public static void findEmployeeById(String find, PreparedStatement ps) throws SQLException{
		Scanner sc = new Scanner(System.in);
		int id = sc.nextInt();
		ps.setInt(1, id);
		
		ResultSet res = ps.executeQuery();
		while(res.next()) {
			System.out.println(res.getInt(1) + " " + res.getString(2));
		}
	}
	
	public static void main(String[] args) {
		String url = "jdbc:postgresql://localhost:5433/collage";
		String username = "postgres";
		String pwd = "612900";
		
		try {
			
			Class.forName("org.postgresql.Driver");
			
			Connection connect = DriverManager.getConnection(url, username, pwd);
			
//			Statement stmt = connect.createStatement();
			
//			String ins = "insert into employee values(?, ?, ?)";
//			PreparedStatement ps = connect.prepareStatement(ins);
//			addEmployee(ins, ps);
//			
			String del = "delete from employee where id = ?";
			PreparedStatement ps = connect.prepareStatement(del);
			deleteEmployeeById(del, ps);
//			
//			String upd = "update employee set salary = ? where id = ?";
//			PreparedStatement ps = connect.prepareStatement(upd);
//			updateEmployeeSalById(upd, ps);
			
//			String find = "select * from employee where id = ?";
//			PreparedStatement ps = connect.prepareStatement(find);
			
//			findEmployeeById(find, ps);
			
			
			
		}catch(ClassNotFoundException cnfe) {
			cnfe.printStackTrace();
		}catch(SQLException s) {
			s.printStackTrace();
		}
	}
}
