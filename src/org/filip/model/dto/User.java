package org.filip.model.dto;

public class User {

	//Podatci o korisniku
	private int id;
	private String username;
	private String password;
	
	//No-args constructor
	public User() {

	}

	//Constructor
	public User(String username, String password) {
		this.username = username;
		this.password = password;
	}

	
	//auto-generated setters and getters
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	
}
