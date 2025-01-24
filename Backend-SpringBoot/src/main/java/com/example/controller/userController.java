package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.model.user;
import com.example.repo.userRepo;

@RestController
@RequestMapping("/user")
@CrossOrigin(origins = "*")
public class userController {
	@Autowired
	userRepo ur;
	
	@GetMapping("/read")
	public List<user> read(){
		return ur.findAll();
	}
	
	@PostMapping("/add")
	public user add(@RequestBody user u) {
		return ur.save(u);
	}
	
	
	@PostMapping("/login")
	public List<user> login(@RequestBody user user ) {
		return ur.findByNameAndPassword(user.getUserName(), user.getPassword());
	}
	
}
