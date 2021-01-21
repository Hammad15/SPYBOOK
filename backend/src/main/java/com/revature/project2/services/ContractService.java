package com.revature.project2.services;

import java.util.List;

import com.revature.project2.entities.Contract;

public interface ContractService {

	public List<Contract> findAllContracts();

	public Contract findContractById(int id);

	public Contract saveContract(Contract contract);

	public List<Contract> findAllContractsByUserId(int id);
}
