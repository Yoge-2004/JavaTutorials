package com.example.numberutils;

public class NumberOrderChecker {
    
    public static boolean isNonDecreasing(int number) {
        while (number >= 10) {
            int lastDigit = number % 10;
            int secondLastDigit = (number / 10) % 10;
            
            if (lastDigit < secondLastDigit) {
                return false;
            }
            number /= 10;
        }
        return true;
    }
    
    public static boolean isNonIncreasing(int number) {
        while (number >= 10) {
            int lastDigit = number % 10;
            int secondLastDigit = (number / 10) % 10;
            
            if (lastDigit > secondLastDigit) {
                return false;
            }
            number /= 10;
        }
        return true;
    }
}
