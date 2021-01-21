package com.revature.project2.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.revature.project2.entities.Location;


public interface LocationDAO extends JpaRepository<Location, Integer> {

}
