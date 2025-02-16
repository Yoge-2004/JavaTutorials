package com.example.numberutils;

import java.util.Scanner;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter a number to find sum and product: ");
        int number = scanner.nextInt();
        System.out.println("Sum of all digits in the given number: " + DigitOperations.sumOfAllDigits(number));
        System.out.println("Product of all digits in the given number: " + DigitOperations.productOfAllDigits(number));
        
        System.out.print("Enter the starting range: ");
        int startRange = scanner.nextInt();
        
        System.out.print("Enter the ending range: ");
        int endRange = scanner.nextInt();
        
        System.out.println("Prime Numbers:");
        ArrayList<Integer> primes = PrimeOperations.findPrimeNumbers(startRange, endRange);
        for (int eachPrime : primes) {
            System.out.print(eachPrime + " ");
        }
        System.out.println("\nSum of all prime numbers: " + PrimeOperations.sumOfPrimeNumbers(startRange, endRange));
        
        System.out.println("Perfect Numbers:");
        ArrayList<Integer> perfects = PerfectNumberOperations.findPerfectNumbers(startRange, endRange);
        for (int eachPerfect : perfects) {
            System.out.print(eachPerfect + " ");
        }
        
        System.out.print("\nEnter the number of Fibonacci terms: ");
        int n = scanner.nextInt();
        int[] fibonacci = FibonacciOperations.findFibonacciNumbers(n);
        for (int term : fibonacci) {
            System.out.print(term + " ");
        }
        System.out.println();
        
        scanner.close();
    }
}
