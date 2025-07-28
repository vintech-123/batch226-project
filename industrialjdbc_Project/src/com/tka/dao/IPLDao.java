package com.tka.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.tka.entity.Player;
import com.tka.utility.SQLUtility;

public class IPLDao {

	Connection connection = null;
	ResultSet resultSet = null;
	PreparedStatement preparedStatement = null;

	String path = "com.mysql.cj.jdbc.Driver";
	String url = "jdbc:mysql://localhost:3306/advjava226db";
	String username = "root";
	String password = "root";

	String query = "select * from player";
	List<Player> playerList = null;

//	public List<Player> getAllPlayers() {
//		System.out.println("In IPLDao.getAllPlayers() method");
//		
//		try {
//			//Step 1: Load the JDBC Driver
//			Class.forName(path);
//			System.out.println(1);
//			
//			//Step 2: Create a Connection
//			connection = DriverManager.getConnection(url, username, password);
//			System.out.println(2);
//			//Step 3: Create a PreparedStatement
//			preparedStatement = connection.prepareStatement(query);
//			System.out.println(3);
//			//Step 4: Execute the query
//			resultSet = preparedStatement.executeQuery();
//			System.out.println(4);
//			//Step 5: Process the ResultSet
//			playerList = new ArrayList<Player>();
//			while (resultSet.next()) {
//				
//				int pid = resultSet.getInt(1); // playerId
//				int jn = resultSet.getInt(2); // jerseyNumber
//				String pname = resultSet.getString(3); // playerName
//				int runs = resultSet.getInt(4); // runs
//				int wickets = resultSet.getInt(5); // wickets
//				String team = resultSet.getString(6); // teamName
//				
//				Player player = new Player(pid, jn, pname, runs, wickets, team);
//				
//				
//				
//				playerList.add(player);
//               
//            }
//		} catch (Exception e) {
//			e.printStackTrace();
//		} finally {
//			try {
//				if (resultSet != null) {
//					resultSet.close();
//				}
//				if (preparedStatement != null) {
//					preparedStatement.close();
//				}
//				if (connection != null) {
//					connection.close();
//				}
//			} catch (Exception e) {
//				e.printStackTrace();
//			}
//		}
//
//		return playerList;
//	}
	
	
	public List<Player> getAllPlayers() {
		System.out.println("In IPLDao.getAllPlayers() method");
		
		try {
			//get connection
			
			connection = SQLUtility.getConnection();
			
			
			//Step 3: Create a PreparedStatement
			preparedStatement = connection.prepareStatement(query);
			System.out.println(3);
			//Step 4: Execute the query
			resultSet = preparedStatement.executeQuery();
			System.out.println(4);
			//Step 5: Process the ResultSet
			playerList = new ArrayList<Player>();
			while (resultSet.next()) {
				
				int pid = resultSet.getInt(1); // playerId
				int jn = resultSet.getInt(2); // jerseyNumber
				String pname = resultSet.getString(3); // playerName
				int runs = resultSet.getInt(4); // runs
				int wickets = resultSet.getInt(5); // wickets
				String team = resultSet.getString(6); // teamName
				
				Player player = new Player(pid, jn, pname, runs, wickets, team);
				
				
				
				playerList.add(player);
               
            }
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (resultSet != null) {
					resultSet.close();
				}
				if (preparedStatement != null) {
					preparedStatement.close();
				}
				if (connection != null) {
					connection.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		return playerList;
	}

	public int insertPlayer(Player player) {
		
		try {
			// Step 1: Load the JDBC Driver
			Class.forName(path);
			System.out.println(1);

			// Step 2: Create a Connection
			connection = DriverManager.getConnection(url, username, password);
			System.out.println(2);

			// Step 3: Create a PreparedStatement
			String insertQuery = "insert into player values(?,?,?,?,?,?)";
			preparedStatement = connection.prepareStatement(insertQuery);
			System.out.println(3);

			// Step 4: Set the values in the PreparedStatement
			preparedStatement.setInt(1, player.getPid());
			preparedStatement.setInt(2, player.getJn());
			preparedStatement.setString(3, player.getPname());
			preparedStatement.setInt(4, player.getRuns());
			preparedStatement.setInt(5, player.getWickets());
			preparedStatement.setString(6, player.getTname());

			// Step 5: Execute the query
			int ack = preparedStatement.executeUpdate();
			System.out.println(4);

			return ack;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (preparedStatement != null) {
					preparedStatement.close();
				}
				if (connection != null) {
					connection.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		return 0;
	}

}
