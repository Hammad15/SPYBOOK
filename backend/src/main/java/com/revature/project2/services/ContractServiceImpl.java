package com.revature.project2.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.project2.entities.Contract;
import com.revature.project2.repositories.ContractDAO;

@Service
public class ContractServiceImpl implements ContractService {

	private ContractDAO cd;

	@Autowired
	public ContractServiceImpl(ContractDAO cd) {

		this.cd = cd;
	}

	@Override
	public List<Contract> findAllContracts() {

		return cd.findAll();
	}

	@Override
	public Contract findContractById(int id) {

		return cd.getOne(id);
	}

	@Override
	public Contract saveContract(Contract contract) {

		return cd.saveAndFlush(contract);
	}

	@Override
	public List<Contract> findAllContractsByUserId(int id) {
		// TODO Auto-generated method stub
		return cd.findByContractedTo(id);
	}

}
