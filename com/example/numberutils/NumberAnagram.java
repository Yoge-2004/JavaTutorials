package com.example.numberutils;
public class NumberAnagram {
    public static boolean isAnagram(int number1, int number2) {
        // Convert numbers to positive values (ignore negative signs)
        number1 = Math.abs(number1);
        number2 = Math.abs(number2);

        // If numbers are identical, they are trivially anagrams
        if (number1 == number2) {
            return true;
        }

        // Frequency array for digits (0-9)
        int[] digitsFrequency = new int[10];

        // Count frequency of digits in number1
        while (number1 > 0) {
            digitsFrequency[number1 % 10]++;
            number1 /= 10;
        }

        // Reduce frequency for digits in number2
        while (number2 > 0) {
            digitsFrequency[number2 % 10]--;
            number2 /= 10;
        }

        // Check if all frequencies are zero
        for (int eachElement : digitsFrequency) {
            if (eachElement != 0) {
                return false;
            }
        }
        return true;
    }
}
