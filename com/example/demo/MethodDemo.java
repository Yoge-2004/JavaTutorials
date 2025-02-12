package com.example.demo;

public class MethodDemo {
    // Addition method
    public static int add(int a, int b) {
        return a + b;
    }
    
    // Candy distribution: returns an array with evenly distributed candies and the remainder.
    public int[] distributeCandies(int totalCandies, int studentsCount) {
        int candiesEach = totalCandies / studentsCount;
        int remaining = totalCandies % studentsCount;
        return new int[] {candiesEach, remaining};
    }
    
    // Speed checking method
    public boolean isOverSpeeding(int carSpeed, int thresholdSpeed) {
        return (carSpeed > thresholdSpeed);
    }
    
    // Method overloading for displaying messages
    public static void displayMessage() {
        System.out.println("Welcome");
    }
    
    public static void displayMessage(String name) {
        System.out.println("Hi " + name);
    }
    
    public static void displayMessage(String greeting, String name) {
        System.out.println(greeting + ", " + name);
    }
}
