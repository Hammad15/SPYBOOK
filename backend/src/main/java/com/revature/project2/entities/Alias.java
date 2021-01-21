package com.revature.project2.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name = "alias")
public class Alias {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "alias_id")
	private int aliasID;

	@Column(name = "user_id")
	private int userID;

	@Column(name = "alias_name")
	private String name;

	@Column(name = "current_level")
	private int aliasLevel;

	@Column(name = "photo")
	private String photo;

	@Column(name = "state_id")
	private int stateID;

	@Column(name = "is_active")
	private boolean isActive;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(referencedColumnName = "user_id", name = "user_id", insertable = false, updatable = false)
	@JsonBackReference(value = "user-alias")
	private Player owner;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(referencedColumnName = "status_id", name = "state_id", insertable = false, updatable = false)
	@JsonBackReference(value = "status-alias")
	private Status status;

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public Player getOwner() {
		return owner;
	}

	public void setOwner(Player owner) {
		this.owner = owner;
	}

	public Alias() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Alias(int aliasID, int userID, String name, int aliasLevel, String photo, int stateID, boolean isActive,
			Player owner, Status status) {
		super();
		this.aliasID = aliasID;
		this.userID = userID;
		this.name = name;
		this.aliasLevel = aliasLevel;
		this.photo = photo;
		this.stateID = stateID;
		this.isActive = isActive;
		this.owner = owner;
		this.status = status;
	}

	public Alias(int aliasID, int userID, String name, int aliasLevel, String photo, int stateID, boolean isActive) {
		super();
		this.aliasID = aliasID;
		this.userID = userID;
		this.name = name;
		this.aliasLevel = aliasLevel;
		this.photo = photo;
		this.stateID = stateID;
		this.isActive = isActive;

	}

	public int getAliasID() {
		return aliasID;
	}

	public void setAliasID(int aliasID) {
		this.aliasID = aliasID;
	}

	public int getUserID() {
		return userID;
	}

	public void setUserID(int userID) {
		this.userID = userID;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAliasLevel() {
		return aliasLevel;
	}

	public void setAliasLevel(int aliasLevel) {
		this.aliasLevel = aliasLevel;
	}

	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}

	public int getStateID() {
		return stateID;
	}

	public void setStateID(int stateID) {
		this.stateID = stateID;
	}

	public boolean isActive() {
		return isActive;
	}

	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}

	@Override
	public String toString() {
		return "Alias [aliasID=" + aliasID + ", userID=" + userID + ", name=" + name + ", aliasLevel=" + aliasLevel
				+ ", photo=" + photo + ", stateID=" + stateID + ", isActive=" + isActive + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + aliasID;
		result = prime * result + aliasLevel;
		result = prime * result + (isActive ? 1231 : 1237);
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((photo == null) ? 0 : photo.hashCode());
		result = prime * result + stateID;
		result = prime * result + userID;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Alias other = (Alias) obj;
		if (aliasID != other.aliasID)
			return false;
		if (aliasLevel != other.aliasLevel)
			return false;
		if (isActive != other.isActive)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (photo == null) {
			if (other.photo != null)
				return false;
		} else if (!photo.equals(other.photo))
			return false;
		if (stateID != other.stateID)
			return false;
		if (userID != other.userID)
			return false;
		return true;
	}

}
