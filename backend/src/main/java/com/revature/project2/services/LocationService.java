package com.revature.project2.services;

import java.util.List;

import com.revature.project2.entities.Location;
import com.revature.project2.entities.Player;

public interface LocationService {

	public List<Location> findAllLocations();
	
	public Location findLocationById(int id);
	
	public Location saveLocation(Location location);

	public List<Player> findAllUsersInLocation(int id);
	
}
