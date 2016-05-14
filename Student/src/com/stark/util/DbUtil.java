package com.stark.util;

import java.sql.Connection;
import java.sql.DriverManager;

public class DbUtil {

	public static Connection conn;

	public static Connection getConnetion() {
		try {
			System.out.println("in database");
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "scott", "tiger");
			System.out.println("after connection");
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		return conn;
	}
}