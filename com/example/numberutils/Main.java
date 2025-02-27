package com.example.numberutils;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean exit = false;
        
        while (!exit) {
            System.out.println("\nSelect an option:");
            System.out.println("1. Digit Operations (Sum and Product of digits)");
            System.out.println("2. Prime and Perfect Numbers in a range");
            System.out.println("3. Fibonacci Sequence");
            System.out.println("4. Find nth Prime");
            System.out.println("5. Check if a number is Increasing or Decreasing");
            System.out.println("6. Swap Adjacent Digits");
            System.out.println("7. Check if two numbers are Anagrams");
            System.out.println("8. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            
            switch (choice) {
                case 1:
                    System.out.print("Enter a number to find sum and product: ");
                    int number = scanner.nextInt();
                    System.out.println("Sum of all digits: " + DigitOperations.sumOfAllDigits(number));
                    System.out.println("Product of all digits: " + DigitOperations.productOfAllDigits(number));
                    break;
                    
                case 2:
                    System.out.print("Enter the starting range: ");
                    int startRange = scanner.nextInt();
                    System.out.print("Enter the ending range: ");
                    int endRange = scanner.nextInt();
                    
                    System.out.println("\nPrime Numbers:");
                    ArrayList<Integer> primes = PrimeOperations.findPrimeNumbers(startRange, endRange);
                    for (int p : primes) {
                        System.out.print(p + " ");
                    }
                    System.out.println("\nSum of all prime numbers: " + PrimeOperations.sumOfPrimeNumbers(startRange, endRange));
                    
                    System.out.println("\nPerfect Numbers:");
                    ArrayList<Integer> perfects = PerfectNumberOperations.findPerfectNumbers(startRange, endRange);
                    for (int perfect : perfects) {
                        System.out.print(perfect + " ");
                    }
                    System.out.println();
                    break;
                    
                case 3:
                    System.out.print("Enter the number of Fibonacci terms: ");
                    int n = scanner.nextInt();
                    int[] fibonacci = FibonacciOperations.findFibonacciNumbers(n);
                    System.out.println("Fibonacci Sequence:");
                    for (int term : fibonacci) {
                        System.out.print(term + " ");
                    }
                    System.out.println();
                    break;
                    
                case 4:
                    System.out.print("Enter n to find nth prime: ");
                    int nth = scanner.nextInt();
                    System.out.println(nth + "th prime number is " + NthPrimeOperations.nthPrime(nth));
                    break;

                case 5:
                    System.out.print("Enter a number to check if it is increasing or decreasing: ");
                    int checkNumber = scanner.nextInt();
                    
                    boolean isIncreasing = NumberOrderChecker.isNonDecreasing(checkNumber);
                    boolean isDecreasing = NumberOrderChecker.isNonIncreasing(checkNumber);
                    
                    if (isIncreasing) {
                        System.out.println(checkNumber + " is an Increasing number.");
                    } else if (isDecreasing) {
                        System.out.println(checkNumber + " is a Decreasing number.");
                    } else {
                        System.out.println(checkNumber + " is neither Increasing nor Decreasing.");
                    }
                    break;

                case 6:
                    System.out.print("Enter a number to swap adjacent digits: ");
                    int swapNumber = scanner.nextInt();
                    try {
                        int swapped = NumberSwapper.swapAdjacentDigits(swapNumber);
                        System.out.println("Swapped Number: " + swapped);
                    } catch (IllegalArgumentException e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                    
                case 7:
                    System.out.print("Enter first number: ");
                    int num1 = scanner.nextInt();
                    System.out.print("Enter second number: ");
                    int num2 = scanner.nextInt();
                    
                    boolean anagramResult = NumberAnagram.isAnagram(num1, num2);
                    if (anagramResult) {
                        System.out.println(num1 + " and " + num2 + " are Anagrams.");
                    } else {
                        System.out.println(num1 + " and " + num2 + " are NOT Anagrams.");
                    }
                    break;

                case 8:
                    exit = true;
                    System.out.println("Exiting program.");
                    break;
                    
                default:
                    System.out.println("Invalid choice, please try again.");
                    break;
            }
        }
        
        scanner.close();
    }
}
