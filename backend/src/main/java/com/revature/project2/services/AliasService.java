package com.revature.project2.services;

import java.util.List;

import com.revature.project2.entities.Alias;

public interface AliasService {
	
	public List<Alias> findAllByUserID(int userID);

	public Alias makeNewAlias(Alias a);
	
	public Alias findActiveAlias(int userID, boolean isActive);
	
	public Alias updateAlias(Alias a);
	
	public Alias setActiveAlias(int userID);

}
