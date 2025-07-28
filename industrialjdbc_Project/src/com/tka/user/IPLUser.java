package com.tka.user;
import java.util.List;
import com.tka.controller.IPLController;
import com.tka.entity.Player;

public class IPLUser {
	public static void main(String[] args) {

		System.out.println("Welcome to IPL User Management System");
		System.out.println("In IPLUser class");
		IPLController iplController = new IPLController();
		List<Player> allplayers_list = iplController.getAllPlayers();
		

		
//		List<Player> allplayers_list = iplController.getAllPlayers("csk");
		
		System.out.println("All Players List: \n" + allplayers_list);
		
		
//		List<Player> allplayers_list = iplController.getAllbatsman("teamName");
//		List<Player> allplayers_list = iplController.getAllballers("teamName");
		
		//insert one player

//		Player player = new Player(205, 33, "Ruturaj", 2300, 0, "CSK");
		
//		int ack = iplController.insertPlayer(player);
		
//		int ack2 =iplController.updatePlayer(player);
//		int ack3 =iplController.deletePlayer(201);
		
		
//		if (ack > 0) {
//			System.out.println("Player inserted successfully");
//		} else {
//			System.out.println("Player insertion failed");
//		}

		System.out.println("End of IPLUser class main method");
	}

}
