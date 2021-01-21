package com.revature.project2.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.revature.project2.entities.Location;
import com.revature.project2.entities.Player;
import com.revature.project2.services.LocationService;

@RestController
@RequestMapping("/api/locations/")
public class LocationController {

	private LocationService ls;
	
	@Autowired
	public LocationController(LocationService ls) {
		this.ls = ls;
	}
	
	
	@GetMapping
	public ResponseEntity<List<Location>> findAllLocations() {
		return new ResponseEntity<List<Location>>(ls.findAllLocations(), HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Location> findLocationById(@PathVariable int id) {
		return new ResponseEntity<Location>(ls.findLocationById(id), HttpStatus.OK);
	}
	
	@GetMapping("/{id}/users")
	public ResponseEntity<List<Player>> findAllUsersInLocation(@PathVariable int id) {
		return new ResponseEntity<List<Player>>(ls.findAllUsersInLocation(id), HttpStatus.OK);
	}
}
