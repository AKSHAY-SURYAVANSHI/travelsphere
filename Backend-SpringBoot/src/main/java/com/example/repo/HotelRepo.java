package com.example.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.model.Hotel;

@Repository
public interface HotelRepo extends JpaRepository<Hotel, Integer> {

}
