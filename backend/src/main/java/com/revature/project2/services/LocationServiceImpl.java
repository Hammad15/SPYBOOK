package com.revature.project2.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.project2.entities.Location;
import com.revature.project2.entities.Player;
import com.revature.project2.repositories.LocationDAO;
import com.revature.project2.repositories.PlayerDAO;

@Service
public class LocationServiceImpl implements LocationService {

	private LocationDAO ld;
	private PlayerDAO pd;
	
	@Autowired
	public LocationServiceImpl(LocationDAO ld, PlayerDAO pd) {
		this.ld = ld;
		this.pd = pd;
	}
	
	@Override
	public List<Location> findAllLocations() {
		return ld.findAll();
	}

	@Override
	public Location findLocationById(int id) {
		return ld.getOne(id);
	}

	@Override
	public Location saveLocation(Location location) {
		return ld.save(location);
	}


	@Override
	public List<Player> findAllUsersInLocation(int id) {
		return pd.findAllByCurrentLocationId(id);
	}

}
