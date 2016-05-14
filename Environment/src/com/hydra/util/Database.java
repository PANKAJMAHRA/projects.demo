package com.hydra.util;

import java.sql.Connection;
import java.sql.DriverManager;
public class Database {
	
	public static Connection conn;
	public static Connection getConnection(){
		try{
			System.out.println("in orcle connection");
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","system");
			System.out.println("After connection");
			}
		catch(Exception e){
			e.printStackTrace();
		}
		return conn;
	}

}
