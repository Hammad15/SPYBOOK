package com.revature.project2.entities;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
@Table(name = "locations")
public class Location {

	@Id
	@Column(name = "location_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int locationId;

	@Column(name = "location_name")
	private String locationName;

	@Column(name = "description")
	private String description;

	@Column(name = "picture")
	private String picture;

	@Column(name = "adjacent_location_id1")
	private int adjacentLocation1;

	@Column(name = "adjacent_location_id2")
	private int adjacentLocation2;

	@OneToMany(mappedBy = "currentLocation", fetch = FetchType.LAZY)
	@JsonBackReference(value = "user-location")
	private List<Player> me;

	public List<Player> getMe() {
		return me;
	}

	public void setMe(List<Player> me) {
		this.me = me;
	}

	public Location() {
		super();
	}

	public Location(int locationId, String locationName, String description, String picture, int adjacentLocation1,
			int adjacentLocation2, List<Player> me) {
		super();
		this.locationId = locationId;
		this.locationName = locationName;
		this.description = description;
		this.picture = picture;
		this.adjacentLocation1 = adjacentLocation1;
		this.adjacentLocation2 = adjacentLocation2;
		this.me = me;
	}

	public int getLocationId() {
		return locationId;
	}

	public void setLocationId(int locationId) {
		this.locationId = locationId;
	}

	public String getLocationName() {
		return locationName;
	}

	public void setLocationName(String locationName) {
		this.locationName = locationName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getPicture() {
		return picture;
	}

	public void setPicture(String picture) {
		this.picture = picture;
	}

	public int getAdjacentLocation1() {
		return adjacentLocation1;
	}

	public void setAdjacentLocation1(int adjacentLocation1) {
		this.adjacentLocation1 = adjacentLocation1;
	}

	public int getAdjacentLocation2() {
		return adjacentLocation2;
	}

	public void setAdjacentLocation2(int adjacentLocation2) {
		this.adjacentLocation2 = adjacentLocation2;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + adjacentLocation1;
		result = prime * result + adjacentLocation2;
		result = prime * result + ((description == null) ? 0 : description.hashCode());
		result = prime * result + locationId;
		result = prime * result + ((locationName == null) ? 0 : locationName.hashCode());
		result = prime * result + ((picture == null) ? 0 : picture.hashCode());
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
		Location other = (Location) obj;
		if (adjacentLocation1 != other.adjacentLocation1)
			return false;
		if (adjacentLocation2 != other.adjacentLocation2)
			return false;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		if (locationId != other.locationId)
			return false;
		if (locationName == null) {
			if (other.locationName != null)
				return false;
		} else if (!locationName.equals(other.locationName))
			return false;
		if (picture == null) {
			if (other.picture != null)
				return false;
		} else if (!picture.equals(other.picture))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Location [locationId=" + locationId + ", locationName=" + locationName + ", description=" + description
				+ ", picture=" + picture + ", adjacentLocation1=" + adjacentLocation1 + ", adjacentLocation2="
				+ adjacentLocation2 + "]";
	}

}
