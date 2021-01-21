package com.revature.project2.controllers;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.revature.project2.entities.Contract;
import com.revature.project2.services.ContractService;

@RestController
@RequestMapping("/api/contracts")
public class ContractController {

	private ContractService cs;

	public ContractController(ContractService cs) {
		this.cs = cs;
	}

	@GetMapping
	public ResponseEntity<List<Contract>> findAllContracts() {

		return new ResponseEntity<List<Contract>>(cs.findAllContracts(), HttpStatus.OK);

	}

	@GetMapping("/{id}")
	public ResponseEntity<Contract> findContractById(@PathVariable int id) {

		Contract c = cs.findContractById(id);
		if (c == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}

		return new ResponseEntity<>(c, HttpStatus.OK);
	}

	@GetMapping("/user/{id}")
	public ResponseEntity<List<Contract>> findContractContractedTo(@PathVariable int id) {

		return new ResponseEntity<List<Contract>>(cs.findAllContractsByUserId(id), HttpStatus.OK);
	}

	@PostMapping
	public ResponseEntity<Contract> saveNewContract(@RequestBody Contract contract) {

		contract.setContractId(0);
		contract.setStatusId(1);
		cs.saveContract(contract);
		return new ResponseEntity<>(contract, HttpStatus.CREATED);

	}

	@PutMapping("/{id}")
	public ResponseEntity<Contract> updateContract(@PathVariable int id, @RequestBody Contract contract) {

		Contract c = cs.findContractById(id);
		if (c == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		c.setContractedTo(contract.getContractedTo());
		c.setDescription(contract.getDescription());
		// c.setTargetId(contract.getTargetId());
		c.setStatusId(contract.getStatusId());

		final Contract updateContract = cs.saveContract(c);
		return new ResponseEntity<>(updateContract, HttpStatus.OK);

	}

}
