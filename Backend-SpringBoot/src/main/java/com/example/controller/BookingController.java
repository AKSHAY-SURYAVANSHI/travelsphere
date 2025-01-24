package com.example.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.model.Booking;
import com.example.repo.BookingRepo;


@RestController
@RequestMapping("/booking")
@CrossOrigin(origins="*")
public class BookingController {
	
	@Autowired
	private BookingRepo br;
	
	@GetMapping("/read")
	public List<Booking> read(){ 
		return br.findAll();
	}
	
	@GetMapping("read/{id}")
	public Optional<Booking> readOne(@PathVariable Integer id){
		return br.findById(id);
	}
	
	@PutMapping("/update/{id}")
	public void update(@PathVariable Integer id, @RequestBody Booking m) {
		Optional<Booking> book = br.findById(id);
		book.get().setCheckInDate(m.getCheckInDate());
		book.get().setCheckOutDate(m.getCheckOutDate());
		book.get().setCheckInDate(m.getCheckInDate());
		
		br.save(book.get());
	}
	
	@DeleteMapping("/delete/{id}")
	public void delete(@PathVariable Integer id) {
//		Optional<Booking> book = br.findById(id);
		br.deleteById(id);
		
	}
	
	@PostMapping("/add")
	public Booking addBooking(@RequestBody Booking Bk) {
		return br.save(Bk);
	}

}
