package com.example.netflix;

public class Movie {
	String title, description, releasedYear;
	private static Movie movie = null;
	
	private Movie() {}
	private Movie(String title, String description, String releasedYear) {
		this.title = title;
		this.description = description;
		this.releasedYear = releasedYear;
	}
	
	public static Movie getInstance(String title, String description, String releasedYear) {
		if (movie == null) {
			movie = new Movie(title, description, releasedYear);
			return movie;
		}
		return movie;
	}
	
	@Override
	public String toString() {
		return "Object " + this.getClass().getName() + " is created sucessfully";
	}
}
