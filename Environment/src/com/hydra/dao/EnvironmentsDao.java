package com.hydra.dao;

import java.sql.Connection;

import com.hydra.util.Database;

public class EnvironmentsDao {
	private Connection connection;

	public EnvironmentsDao(){
		connection=Database.getConnection();
	}
	
	//public void addEnvironments

}
