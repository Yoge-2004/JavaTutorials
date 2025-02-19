package com.example.analyzer;

import java.util.Scanner;

public class NumberAnalyzer {
    public static void findSmallestAndLargestDigit() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int number = scanner.nextInt();

        int smallest = Integer.MAX_VALUE;
        int largest = Integer.MIN_VALUE;
        int temp = number;

        while (temp > 0) {
            int remainder = temp % 10;
            smallest = Math.min(smallest, remainder);
            largest = Math.max(largest, remainder);
            temp /= 10;
        }

        System.out.println("Smallest Digit: " + smallest);
        System.out.println("Largest Digit: " + largest);
    }
}
