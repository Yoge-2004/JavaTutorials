package com.example.basic;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        checkAlphabet(scanner);
        calculateGrossSalary(scanner);
        calculateLibraryFine(scanner);
        convertSecondsToTime(scanner);
        calculateBillAmount(scanner);
        calculateTotalSalary(scanner);
        
        scanner.close();
    }
    
    // Checks whether the entered character is a vowel or a consonant.
    private static void checkAlphabet(Scanner scanner) {
        System.out.print("Enter an alphabet: ");
        char alphabet = scanner.next().charAt(0);
        
        boolean isVowel;
        switch (alphabet) {
            case 'A': 
            case 'E': 
            case 'I': 
            case 'O': 
            case 'U': 
            case 'a': 
            case 'e': 
            case 'i': 
            case 'o': 
            case 'u': 
                isVowel = true;
                break;
            default:
                isVowel = false;
        }
        System.out.println(isVowel ? "The given character is a vowel." : "The given character is a consonant.");
    }
    
    // Calculates and displays the gross salary based on the basic salary.
    private static void calculateGrossSalary(Scanner scanner) {
        System.out.print("Enter the basic salary: ");
        int basicSalary = scanner.nextInt();
        
        double hra, da;
        if (basicSalary < 1500) {
            hra = 10 / 100.0 * basicSalary;
            da = 90 / 100.0 * basicSalary;
        } else {
            hra = 500;
            da = 98 / 100.0 * basicSalary;
        }
        double grossSalary = basicSalary + hra + da;
        System.out.println("Gross Salary: " + grossSalary);
    }
    
    // Computes the library fine based on the number of days late.
    private static void calculateLibraryFine(Scanner scanner) {
        System.out.print("Enter the number of days late to return the book to library: ");
        int daysLate = scanner.nextInt();
        double fine = Double.MIN_VALUE;
        
        if (daysLate > 0 && daysLate <= 5) {
            fine = daysLate * 0.5;
        } else if (daysLate > 5 && daysLate <= 10) {
            fine = 5 * 0.5 + (daysLate - 5) * 1.0;
        } else if (daysLate > 10 && daysLate <= 30) {
            fine = 5 * 0.5 + 5 * 1.0 + (daysLate - 10) * 5.0;
        } else if (daysLate > 30) {
            System.out.println("Your membership is cancelled since you didn't return the book within 30 days.");
            return;
        } else {
            fine = 0;
        }
        
        if (fine != Double.MIN_VALUE) {
            System.out.println("Rs. " + fine + " has to be paid as fine.");
        }
    }
    
    // Converts seconds into a formatted hh:mm:ss string.
    private static void convertSecondsToTime(Scanner scanner) {
        System.out.print("Enter the time (in seconds): ");
        int secondsInput = scanner.nextInt();
        
        if (secondsInput < 0) {
            System.out.println("Invalid time given.");
            return;
        }
        
        int hoursVal = secondsInput / 3600;
        secondsInput %= 3600;
        int minutesVal = secondsInput / 60;
        int secondsVal = secondsInput % 60;
        
        // Format values to two digits
        String hours = (hoursVal < 10) ? "0" + hoursVal : String.valueOf(hoursVal);
        String minutes = (minutesVal < 10) ? "0" + minutesVal : String.valueOf(minutesVal);
        String seconds = (secondsVal < 10) ? "0" + secondsVal : String.valueOf(secondsVal);
        
        System.out.println(hours + ":" + minutes + ":" + seconds);
    }
    
    // Applies discount based on the bill amount and displays the final price.
    private static void calculateBillAmount(Scanner scanner) {
        System.out.print("Enter the total bill amount: ");
        double billAmount = scanner.nextDouble();
        
        if (billAmount > 3000 && billAmount < 5000) {
            billAmount -= (billAmount * (10 / 100.0));
        } else if (billAmount >= 5000) {
            billAmount -= (billAmount * (20 / 100.0));
        } else if (billAmount < 0) {
            System.out.println("Invalid Bill Amount.");
            return;
        }
        
        System.out.println("Final Price: Rs." + (int) billAmount);
    }
    
    // Calculates the total salary by adding base salary and incentive, then shows the rounded total.
    private static void calculateTotalSalary(Scanner scanner) {
        System.out.print("Enter base salary: ");
        double baseSalary = scanner.nextDouble();
        
        System.out.print("Enter incentive: ");
        double performanceIncentive = scanner.nextDouble();
        
        double total = baseSalary + performanceIncentive;
        int finalTotal = (int) total;
        
        System.out.println("Total Salary:\nBefore Rounding Off: " + total + "\nAfter Rounding Off: " + finalTotal);
    }
}
