package com.revature.project2.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.revature.project2.entities.Contract;

public interface ContractDAO extends JpaRepository<Contract, Integer> {

	public List<Contract> findByContractedTo(int userID);
}
