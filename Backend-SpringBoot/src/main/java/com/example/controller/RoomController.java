package com.example.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
//import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.model.Room;
import com.example.repo.RoomRepo;

@RestController
@RequestMapping("/room")
@CrossOrigin(origins="*") 
public class RoomController {
	
	@Autowired
	private RoomRepo rr;
	
	@GetMapping("/read")
	public List<Room> read(){ 
		return rr.findAll();
	}
	
	@GetMapping("read/{id}")
	public Optional<Room> readOne(@PathVariable Integer id){
		return rr.findById(id);
	}
	
	@PostMapping("/add")
	public Room add(@RequestBody Room m) {
		return rr.save(m);
	}
	
	@GetMapping("/hotel/{id}")
	public List<Room> readHotel(@PathVariable Integer id){
		return rr.findRoomsByHotelId(id);
	}
	
//	@PutMapping("/update/{id}")
//	public void update(@PathVariable Integer id, @RequestBody Room m) {
//		Optional<Room> room = rr.findById(id);
//		room.get().setAvailability(m());
//		rr.save(room.get());
//	}
	
//	@DeleteMapping("/delete/{id}")
//	public void delete(@PathVariable Integer id) {
//		Optional<Room> musician = rr.findById(id);
//		rr.deleteById(musician.get().getRoomId());
//		
//	}
	
	

}
