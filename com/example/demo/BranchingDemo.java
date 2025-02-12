package com.example.demo;

public class BranchingDemo {
    // Weather determination for outing
    public static void determineWeather(boolean isSunny, double outdoorTemperature) {
        if (isSunny && outdoorTemperature >= 30) {
            System.out.println("The weather is just perfect for an outing.");
        } else if (isSunny && outdoorTemperature < 30) {
            System.out.println("We can go for an outing but wear sweaters.");
        } else if (!isSunny) {
            System.out.println("The weather is not suitable for an outing.");
        }
    }
    
    // Check if a number is even
    public static boolean isEven(int number) {
        return number % 2 == 0;
    }
    
    // Check if a year is a leap year
    public static boolean isLeapYear(int year) {
        return (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);
    }
    
    // Gross Salary Calculation
    protected static double calculateGrossSalary(int basicSalary, int experience) {
        int bonus = 0;
        double hra = 0.0, da = 0.0;
        if (experience > 3)
            bonus = 2500;
        
        if (basicSalary > 0 && basicSalary <= 10000) {
            hra = (20 / 100.0) * basicSalary;
            da = (80 / 100.0) * basicSalary;
        } else if (basicSalary > 10000 && basicSalary <= 20000) {
            hra = (25 / 100.0) * basicSalary;
            da = (90 / 100.0) * basicSalary;
        } else if (basicSalary > 20000) {
            hra = (30 / 100.0) * basicSalary;
            da = (95 / 100.0) * basicSalary;
        }
        return basicSalary + hra + da + bonus;
    }
}
