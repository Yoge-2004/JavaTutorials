package com.example.netflix;

import java.util.Objects;

public class NetflixApp {
	public static void main(String[] args) {
		User yogeshwaran = User.getInstance("Yogeshwaran", "Yoge@2004", "12345678", "yogeshwaranmuthuraman56@gmail.com");
		Movie mandaiya = Movie.getInstance("Mandaiya", "This is the sample description", "2020");
		System.out.println(yogeshwaran);
		System.out.println(mandaiya);
		
		User tamilanbanNitish = User.getInstance(null, null, null, null);
		System.out.println(Objects.hashCode(tamilanbanNitish));
		
		System.out.println(tamilanbanNitish.name);
	}
}
