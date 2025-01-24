package com.example.model;


import org.antlr.v4.runtime.misc.NotNull;

import jakarta.persistence.Entity;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
//@Setter
//@Getter
@NoArgsConstructor
@AllArgsConstructor
public class user {
	public long getUser_id() {
		return user_id;
	}

	public void setUser_id(long user_id) {
		this.user_id = user_id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public long getPhoneno() {
		return phoneno;
	}

	public void setPhoneno(long phoneno) {
		this.phoneno = phoneno;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long user_id;
	
	@SuppressWarnings("deprecation")
	@NotNull
	private String userName;
	
	
	@SuppressWarnings("deprecation")
	@NotNull
	private String password;
	
	@SuppressWarnings("deprecation")
	@NotNull
	private long phoneno;
	
	@SuppressWarnings("deprecation")
	@NotNull
	private String email;
	
	
	
	
}
