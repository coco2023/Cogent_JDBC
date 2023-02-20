package com.cogent.JDBC;

import java.sql.SQLException;

public class ControllerMain {

	public static void main(String[] args) throws SQLException {
		// TODO Auto-generated method stub
		BusinessLogic bl = new BusinessLogic();
		bl.createTable();
		
		bl.insert(111, "Mary", 1.11f);
		bl.insert(112, "Zhao", 1.21f);
		bl.insert(113, "Qian", 1.31f);
		bl.insert(114, "Sun", 1.41f);
		bl.insert(115, "Li", 2.11f);
		
		bl.search(1.20f);
		
		bl.update(113, 2.25f);
		
		bl.delete(111);		
	}

}
