package com.revature.project2.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.revature.project2.entities.Alias;
import com.revature.project2.entities.Credentials;
import com.revature.project2.entities.Player;
import com.revature.project2.services.AliasService;
import com.revature.project2.services.PlayerService;
import com.revature.project2.utils.PasswordUtils;

@RestController
@RequestMapping("/api/players")
public class PlayerController {

	private PlayerService ps;

	private AliasService as;

	@Autowired
	public PlayerController(PlayerService ps, AliasService as) {
		this.ps = ps;
		this.as = as;
	}

	@GetMapping
	public ResponseEntity<List<Player>> findAllPlayers() {

		return new ResponseEntity<List<Player>>(ps.findAllPlayers(), HttpStatus.OK);

	}

	@GetMapping("/{id}")
	public ResponseEntity<Player> findPlayerById(@PathVariable int id) {

		Player p = ps.findPlayerById(id);
		if (p == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}

		return new ResponseEntity<>(p, HttpStatus.OK);
	}

	@PutMapping()
	public ResponseEntity<Player> updatePlayer(@RequestBody Player player) {

		Player p = ps.findPlayerById(player.getUserId());
		if (p == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}

		p.setFirstName(player.getFirstName());
		p.setLastName(player.getLastName());
		p.setUserName(player.getUserName());
		p.setPhoto(player.getPhoto());
		p.setMovementCooldown(player.getMovementCooldown());
		p.setCurrentLocationId(player.getCurrentLocationId());

		final Player updatePlayer = ps.savePlayer(p);
		return new ResponseEntity<>(updatePlayer, HttpStatus.OK);

	}

	@PutMapping("/{cp}")
	public ResponseEntity<Player> updatePlayer(@PathVariable String cp, @RequestBody Player player) {

		if (cp == "true") {

			String securePassword = PasswordUtils.generateSecurePassword(player.getUserPassword(),
					player.getUserPassword());
			player.setUserPassword(securePassword);
		}

		ps.savePlayer(player);
		return new ResponseEntity<>(player, HttpStatus.OK);

	}

	@PostMapping("/signup")
	public ResponseEntity<Player> saveNewPlayer(@RequestBody Player player) {

		// encrypt password
		String salt = PasswordUtils.getSalt(25);
		String securePassword = PasswordUtils.generateSecurePassword(player.getUserPassword(), salt);
		player.setUserId(0);
		player.setUserPassword(securePassword);
		player.setSalt(salt);
		player.setCurrentLocationId(4);
		player.setPhoto(null);

		ps.savePlayer(player);
		return new ResponseEntity<>(player, HttpStatus.CREATED);

	}

	@PostMapping("/login")
	public ResponseEntity<Player> login(@RequestBody Credentials cred) {

		Player p = ps.findPlayerByEmail(cred.getEmail());
		if (p == null) {
			return new ResponseEntity<Player>(HttpStatus.NOT_FOUND);
		}

		boolean passwordMatch = PasswordUtils.verifyUserPassword(cred.getPassword(), p.getUserPassword(), p.getSalt());

		if (passwordMatch) {
			return new ResponseEntity<>(p, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}

	}

	@GetMapping("/{id}/alias/current")
	public ResponseEntity<Alias> findAliasById(@PathVariable int id) {

		Alias a = as.findActiveAlias(id, true);

		if (a == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}

		return new ResponseEntity<Alias>(a, HttpStatus.OK);
	}

	@GetMapping("/{id}/alias/all")
	public ResponseEntity<List<Alias>> findAllAlias(@PathVariable int id) {

		List<Alias> a = as.findAllByUserID(id);

		if (a == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}

		return new ResponseEntity<List<Alias>>(a, HttpStatus.OK);
	}

	@PostMapping("/{id}/alias")
	public ResponseEntity<Alias> makeAlias(@PathVariable int id, @RequestBody String name) {

		// Setting the state of existing aliases, if any, to inactive since the the new
		// one will be active by default
		List<Alias> allAlias = as.findAllByUserID(id);

		if (allAlias != null) {
			for (int i = 0; i < allAlias.size(); i++) {
				Alias a = allAlias.get(i);
				a.setActive(false);
				as.updateAlias(a);
			}
		}

		// creating the new alias
		Alias al = new Alias(0, id, name, 0, null, 1, true);

		Alias a = as.makeNewAlias(al);
		if (a == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}

		return new ResponseEntity<Alias>(a, HttpStatus.OK);
	}

	@PostMapping("/{id}/alias/set")
	public ResponseEntity<Alias> setCurrentAlias(@PathVariable int id, @RequestBody Alias alias) {

		// Setting the state of existing aliases, if any, to inactive
		Alias a = as.findActiveAlias(id, true);

		if (a != null) {
			a.setActive(false);
			as.updateAlias(a);
		}

		// setting the passed Alias as current Alias
		alias.setActive(true);
		Alias al = as.updateAlias(alias);
		if (al == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}

		return new ResponseEntity<Alias>(al, HttpStatus.OK);
	}

	@PutMapping("/alias")
	public ResponseEntity<Alias> updateAlias(@RequestBody Alias alias) {

		as.updateAlias(alias);
		return new ResponseEntity<>(alias, HttpStatus.OK);

	}

}
