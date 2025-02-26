package com.example.numberutils;

public class NumberSwapper {
    public static int swapAdjacentDigits(int number) {
        int temp = number;
        int swappedNumber = 0;
        int length = (int) Math.log10(number) + 1;

        if ((length & 1) == 1) { // Check if length is odd
            throw new IllegalArgumentException("Error: Length of the number must be even");
        }

        while (temp > 0) {
            int firstDigit = temp / (int) Math.pow(10, --length); // Extract first digit
            temp %= (int) Math.pow(10, length); // Remove first digit
            
            int secondDigit = temp / (int) Math.pow(10, --length); // Extract second digit
            temp %= (int) Math.pow(10, length); // Remove second digit

            swappedNumber = swappedNumber * 100 + secondDigit * 10 + firstDigit;
        }
        
        return swappedNumber;
    }
}
