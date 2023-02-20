package com.cogent.JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
 
public class DBConnector {
	static final String DB_URL = "jdbc:mysql://localhost/batch65";
	static final String USER = "root";
	static final String PASS = "12345";
	static Connection conn = null;
	static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";

	public static Connection DBConn() {
		try {
			Class.forName(JDBC_DRIVER);
			
			Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);			
			return conn;
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return conn;
	}
	
	
}
