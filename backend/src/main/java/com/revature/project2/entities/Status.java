package com.revature.project2.entities;

import java.util.List;

import javax.persistence.CascadeType;
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
@Table(name = "status")
public class Status {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "status_id")
	private int cstatusId;

	@Column(name = "status_name")
	private String statusName;

	@OneToMany(mappedBy = "current", fetch = FetchType.LAZY)
	@JsonBackReference(value = "contract-status")
	private List<Contract> statuses;

	@OneToMany(mappedBy = "status", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	// @JoinColumn(referencedColumnName = "alias_id", name = "user_id", insertable =
	// false, updatable = false)
	private List<Alias> alias;

	public Status(int cstatusId, String statusName, List<Contract> statuses, List<Alias> alias) {
		super();
		this.cstatusId = cstatusId;
		this.statusName = statusName;
		this.statuses = statuses;
		this.alias = alias;
	}

	public List<Alias> getAlias() {
		return alias;
	}

	public void setAlias(List<Alias> alias) {
		this.alias = alias;
	}

	public int getCstatusId() {
		return cstatusId;
	}

	public void setCstatusId(int cstatusId) {
		this.cstatusId = cstatusId;
	}

	public String getStatusName() {
		return statusName;
	}

	public void setStatusName(String statusName) {
		this.statusName = statusName;
	}

	public List<Contract> getStatuses() {
		return statuses;
	}

	public void setStatuses(List<Contract> statuses) {
		this.statuses = statuses;
	}

	public Status() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + cstatusId;
		result = prime * result + ((statusName == null) ? 0 : statusName.hashCode());
		result = prime * result + ((statuses == null) ? 0 : statuses.hashCode());
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
		Status other = (Status) obj;
		if (cstatusId != other.cstatusId)
			return false;
		if (statusName == null) {
			if (other.statusName != null)
				return false;
		} else if (!statusName.equals(other.statusName))
			return false;
		if (statuses == null) {
			if (other.statuses != null)
				return false;
		} else if (!statuses.equals(other.statuses))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Status [cstatusId=" + cstatusId + ", statusName=" + statusName + ", statuses=" + statuses + "]";
	}

}
