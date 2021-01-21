package com.revature.project2.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.project2.entities.Alias;
import com.revature.project2.repositories.AliasDAO;

@Service
public class AliasServiceImpl implements AliasService {
	
	AliasDAO ad;
	
	@Autowired
	public AliasServiceImpl(AliasDAO ad) {
		super();
		this.ad = ad;
	}

	@Override
	public List<Alias> findAllByUserID(int userID) {
		// TODO Auto-generated method stub
		return ad.findByUserID(userID);
	}

	@Override
	public Alias makeNewAlias(Alias a) {
		// TODO Auto-generated method stub
		return ad.saveAndFlush(a);
	}

	@Override
	public Alias findActiveAlias(int userID, boolean isActive) {
		// TODO Auto-generated method stub
		return ad.findByUserIDAndIsActive(userID, isActive);
	}

	@Override
	public Alias setActiveAlias(int userID) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Alias updateAlias(Alias a) {
		// TODO Auto-generated method stub
		return ad.saveAndFlush(a);
	}	

}
