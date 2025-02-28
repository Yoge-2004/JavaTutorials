package com.example.netflix;

public class User {
	String name, password, phoneNumber, email;
	private static User user = null;
	
	private User() {}
	private User(String name, String password, String phoneNumber, String email) {
		this.name = name;
		this.password = password;
		this.phoneNumber = phoneNumber;
		this.email = email;
	}
	
	public static User getInstance(String name, String password, String phoneNumber, String email) {
		if (user == null) {
			user = new User(name, password, phoneNumber, email);
			return user;
		}
		return user;
	}
	
	@Override
	public String toString() {
		return "Object " + this.getClass().getName() + " is created sucessfully";
	}
}
