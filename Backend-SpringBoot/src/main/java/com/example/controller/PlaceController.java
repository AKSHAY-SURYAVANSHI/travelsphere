package com.example.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.model.Place;
import com.example.repo.PlaceRepo;

@RestController
@RequestMapping("/place")
@CrossOrigin(origins="*") 
public class PlaceController {
	
	@Autowired
	private PlaceRepo pr;
	
	@GetMapping("/read")
	public List<Place> read(){ 
		return pr.findAll();
	}
	
	@GetMapping("read/{id}")
	public Optional<Place> readOne(@PathVariable Integer id){
		return pr.findById(id);
	}
	

	@PostMapping("/add")
	public Place add(@RequestBody Place m) {
		return pr.save(m);
		
	}
	
	
	
	
	
	
	

}
