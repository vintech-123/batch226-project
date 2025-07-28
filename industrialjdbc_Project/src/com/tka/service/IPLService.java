package com.tka.service;

import java.util.ArrayList;
import java.util.List;

import com.tka.dao.IPLDao;
import com.tka.entity.Player;

public class IPLService {
	private IPLDao iplDao = null;

	public List<Player> getAllPlayers() {
		System.out.println("In IPLService.getAllPlayers() method");
		iplDao = new IPLDao();
		List<Player> allPlayersList = iplDao.getAllPlayers();

		return allPlayersList;
	}
	
	//Bussiness Logic

	public List<Player> getAllPlayers(String tn) {

		List<Player> chotulist = new ArrayList<Player>();

		List<Player> allPlayers = this.getAllPlayers();
		
		for (Player player : allPlayers) {
			if (player.getTname().equalsIgnoreCase(tn)) {
				chotulist.add(player);
			}
		}

		return chotulist;
	}

	public int insertPlayer(Player player) {
		
		iplDao = new IPLDao();
		int ack = iplDao.insertPlayer(player);
		
		return ack;
	}

}
