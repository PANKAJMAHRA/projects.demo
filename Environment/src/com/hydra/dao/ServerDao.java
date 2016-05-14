package com.hydra.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.hydra.model.Server;
import com.hydra.util.Database;

public class ServerDao {
	// private static final int Server_Id = 0;
	private Connection connection;
	ResultSet rs;
	public ServerDao() {
		connection = Database.getConnection();
	}

	public int addServer(Server server) {
		try {
			PreparedStatement preparedstatement = connection.prepareStatement("insert into server (Server_Id,Server_Name) values (?,?)");
			preparedstatement.setInt(1, server.getServerId());
			preparedstatement.setString(2, server.getServerName());
			int i=preparedstatement.executeUpdate();
			return i;
		} catch (SQLException e) {
			e.printStackTrace();
			return 0;
		}
	}

	public void deleteServer(Server sbean) {
		try {
			PreparedStatement preparedstatement = connection.prepareStatement("delete from Server where Server_Id=?");
			preparedstatement.setInt(1, sbean.getServerId());
			preparedstatement.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void updateserver(Server server){
		try{
			PreparedStatement preparedstatement = connection.prepareStatement("update Server set Server_Name=?" + "where Server_Id=?" );
			preparedstatement.setString(1,server.getServerName());		
			preparedstatement.setInt(2,server.getServerId());
		}
		 catch (SQLException e) {
				e.printStackTrace();
			}
	}
	
	public ArrayList<Server> findall() {
		ArrayList<Server> slist=new ArrayList<Server>();
			try {
				Statement statement = connection.createStatement();
			ResultSet rs=statement.executeQuery("select * from server");
			while(rs.next()){
				Server sbean=new Server();
				sbean.setServerId(rs.getInt("serverId"));
				sbean.setServerName(rs.getString("serverName"));
				slist.add(sbean);
			}
		} 
			catch (SQLException e) {
			e.printStackTrace();
		}
			
		return slist;
	}
}












