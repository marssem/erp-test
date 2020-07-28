package com.erp.test.common;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Conn {
	private static String URI = "jdbc:oracle:thin:@localhost:1521/xe";
	private static String ID = "c##test";
	private static String PWD = "test";
	private static String DRIVER_NAME = "oracle.jdbc.driver.OracleDriver";
	
	static {
		try {
			Class.forName(DRIVER_NAME);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	public static Connection open() {
		try {
			Connection con;
			con = DriverManager.getConnection(URI,ID,PWD);
			con.setAutoCommit(false);
			return con;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public static void main(String[] args) {
		Connection con = Conn.open();
		System.out.println("ㅇㅇ");
	}
	}


