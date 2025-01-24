package com.example.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.model.Booking;

@Repository
public interface BookingRepo extends JpaRepository<Booking, Integer> {
	

}
