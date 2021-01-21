package com.revature.project2.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.revature.project2.entities.Alias;

public interface AliasDAO extends JpaRepository<Alias, Integer>{
	
	public List<Alias> findByUserID(int userID);
	
	public Alias findByUserIDAndIsActive(int userID, boolean isActive);

}
