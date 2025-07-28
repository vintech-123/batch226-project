package com.tka.controller;

import java.util.List;
import com.tka.entity.Player;
import com.tka.service.IPLService;

public class IPLController {
	private IPLService iplService = null;
	public List<Player> getAllPlayers() {
		System.out.println("In IPLController.getAllPlayers() method");
		 iplService = new IPLService();
		 List<Player> allPlayersList = iplService.getAllPlayers();
		return allPlayersList;
	}
	
	public List<Player> getAllPlayers(String tn) {
		
		 iplService = new IPLService();
		 List<Player> allPlayersList = iplService.getAllPlayers(tn);


		return allPlayersList;
	}

	public int insertPlayer(Player player) {
		
		iplService = new IPLService();
		int ack = iplService.insertPlayer(player);
		
		return ack;
	}

}
