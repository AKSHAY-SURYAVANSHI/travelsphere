package com.example.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.model.Hotel;
import com.example.repo.HotelRepo;


@RestController
@RequestMapping("/hotel")
@CrossOrigin(origins="*")
public class HotelController {
	
	@Autowired
	private HotelRepo hr;
	
	@GetMapping("/read")
	public List<Hotel> read(){ 
		return hr.findAll();
	}
	
	@GetMapping("read/{id}")
	public Optional<Hotel> readOne(@PathVariable Integer id){
		return hr.findById(id);
	}

}
