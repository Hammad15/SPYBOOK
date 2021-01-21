package com.revature.project2.entities;

import java.sql.Timestamp;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
@Table(name = "user_table")
public class Player {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "user_id")
	private int userId;

	@Column(name = "firstname")
	private String firstName;

	@Column(name = "lastname")
	private String lastName;

	@Column(name = "username")
	private String userName;

	@Column(name = "user_password")
	private String userPassword;

	@Column(name = "email")
	private String email;

	@Column(name = "photo")
	private String photo;

	@Column(name = "salt")
	private String salt;

	@Column(name = "current_location")
	private int currentLocationId;

	@Column(name = "movement_cooldown")
	private Timestamp movementCooldown;

	@OneToMany(mappedBy = "player", fetch = FetchType.LAZY)
	@JsonBackReference(value = "user-target")
	private List<Contract> targets;

	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(referencedColumnName = "location_id", name = "current_location", insertable = false, updatable = false)
	private Location currentLocation;

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(referencedColumnName = "user_id", name = "user_id", insertable = false, updatable = false)
	private List<Alias> title;

	public List<Alias> getTitle() {
		return title;
	}

	public void setTitle(List<Alias> title) {
		this.title = title;
	}

	public Location getCurrentLocation() {
		return currentLocation;
	}

	public void setCurrentLocation(Location currentLocation) {
		this.currentLocation = currentLocation;
	}

	public Timestamp getMovementCooldown() {
		return movementCooldown;
	}

	public void setMovementCooldown(Timestamp movementCooldown) {
		this.movementCooldown = movementCooldown;
	}

	public List<Contract> getTargets() {
		return targets;
	}

	public void setTargets(List<Contract> targets) {
		this.targets = targets;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserPassword() {
		return userPassword;
	}

	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}

	public String getSalt() {
		return salt;
	}

	public void setSalt(String salt) {
		this.salt = salt;
	}

	public int getCurrentLocationId() {
		return currentLocationId;
	}

	public void setCurrentLocationId(int currentLocationId) {
		this.currentLocationId = currentLocationId;
	}

	public Player() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Player(int userId, String firstName, String lastName, String userName, String userPassword, String email,
			String photo, String salt, int currentLocationId, Timestamp movementCooldown, List<Contract> targets,
			Location currentLocation, List<Alias> title) {
		super();
		this.userId = userId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.userName = userName;
		this.userPassword = userPassword;
		this.email = email;
		this.photo = photo;
		this.salt = salt;
		this.currentLocationId = currentLocationId;
		this.movementCooldown = movementCooldown;
		this.targets = targets;
		this.currentLocation = currentLocation;
		this.title = title;
	}

}
