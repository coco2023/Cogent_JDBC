package com.cogent.JDBC;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class BusinessLogic {
	Connection conn = null;
	
	void createTable() throws SQLException {
		conn = DBConnector.DBConn();
		Statement stmt = conn.createStatement();
		String DEOP_QUERY = "DROP TABLE IF EXISTS employee;";
		stmt.executeUpdate(DEOP_QUERY);
		String QUERY = "CREATE TABLE employee (\r\n"
				+ "	empId INTEGER,\r\n"
				+ "    empName VARCHAR(10),\r\n"
				+ "    salary FLOAT);";
		stmt.executeUpdate(QUERY);
		
		System.out.println("Table Creation Success~!");
	}
	
	void insert(int empId, String empName, float salary) throws SQLException {
		conn = DBConnector.DBConn();
		String QUETY = "INSERT INTO employee VALUES (?, ?, ?)";
		PreparedStatement pstmt = conn.prepareStatement(QUETY);
		
		pstmt.setInt(1, empId);
		pstmt.setString(2, empName);
		pstmt.setFloat(3, salary);
		pstmt.executeUpdate();	
		
		System.out.println("insert Success!");
	}
	
	void delete(int empId) throws SQLException {
		conn = DBConnector.DBConn();
		String QUETY = "DELETE FROM employee WHERE empId = ?";
		PreparedStatement pstmt = conn.prepareStatement(QUETY);
		
		pstmt.setInt(1, empId);
		pstmt.executeUpdate();	

		System.out.println("delete Success!");
	}
	
	void search(float salary) throws SQLException {
		conn = DBConnector.DBConn();
		String QUETY = "SELECT * FROM employee WHERE salary > ?";
		PreparedStatement pstmt = conn.prepareStatement(QUETY);
		
		pstmt.setFloat(1, salary);
		
		ResultSet rs = pstmt.executeQuery();	
		
		// display values
		while (rs.next()) {
			System.out.print("empId: " + rs.getInt("empId"));
			System.out.print(", empName: " + rs.getString("empName"));
			System.out.println(", salary: " + rs.getFloat("salary"));
		}

				
		System.out.println("search Success!");

	}
	
	void update(int empId, float salary) throws SQLException {
		conn = DBConnector.DBConn();
		String QUETY = "UPDATE employee SET salary = ? WHERE empId = ?";
		PreparedStatement pstmt = conn.prepareStatement(QUETY);
		
		pstmt.setInt(2, empId);
		pstmt.setFloat(1, salary);
		pstmt.executeUpdate();	
		
		System.out.println("update Success!");

	}
	
	
}
