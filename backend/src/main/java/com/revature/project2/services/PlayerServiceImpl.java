package com.revature.project2.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.project2.entities.Player;
import com.revature.project2.repositories.PlayerDAO;

import java.util.List;

@Service
public class PlayerServiceImpl implements PlayerService {
	
	private PlayerDAO pd;
	
	@Autowired
	public PlayerServiceImpl(PlayerDAO pd) {
		this.pd = pd;
	}

	@Override
	public List<Player> findAllPlayers() {

		return pd.findAll();
	}

	@Override
	public Player findPlayerById(int id) {

		return pd.getOne(id);
	}

	@Override
	public Player savePlayer(Player player) {

		return pd.saveAndFlush(player);
	}

	@Override
	public Player findPlayerByEmail(String email) {

		return pd.findByEmail(email);
	}
}
