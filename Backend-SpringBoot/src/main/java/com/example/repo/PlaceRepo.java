package com.example.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.model.Place;

@Repository
public interface PlaceRepo extends JpaRepository<Place, Integer> {
	
}
