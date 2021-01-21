package com.revature.project2.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import com.revature.project2.entities.Player;

public interface PlayerDAO extends JpaRepository<Player, Integer> {

	public Player findByEmail(String email);

	public List<Player> findAllByCurrentLocationId(int id);

}
