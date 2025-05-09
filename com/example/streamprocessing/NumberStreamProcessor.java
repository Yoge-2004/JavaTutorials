package com.example.streamprocessing;

import java.util.*;
import java.util.stream.*;
import java.math.BigInteger;

public class NumberStreamProcessor {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Get range input from the user
        System.out.print("Enter the range: ");
        int rangeLimit = scanner.nextInt();

        // Create an array of numbers from 1 to rangeLimit
        int[] numberArray = IntStream.rangeClosed(1, rangeLimit).toArray();

        // Display the generated array
        System.out.print("Numbers = ");
        Arrays.stream(numberArray).forEach(num -> System.out.print(num + " "));
        System.out.println();

        // Print odd numbers from the array
        System.out.print("Odd Numbers = ");
        Arrays.stream(numberArray).filter(num -> num % 2 != 0).forEach(num -> System.out.print(num + " "));
        System.out.println();

        // Print even numbers from the array
        System.out.print("Even Numbers = ");
        Arrays.stream(numberArray).filter(num -> num % 2 == 0).forEach(num -> System.out.print(num + " "));
        System.out.println();

        // Sort the numbers in descending order and display
        System.out.print("Sorted in Descending Order = ");
        Arrays.stream(numberArray).boxed().sorted(Comparator.reverseOrder()).forEach(num -> System.out.print(num + " "));
        System.out.println();

        // Print the first 5 numbers in ascending order
        System.out.print("Sorted in Ascending Order (First 5) = ");
        Arrays.stream(numberArray).sorted().limit(5).forEach(num -> System.out.print(num + " "));
        System.out.println();

        // Get input for nth largest number
        System.out.print("Enter n for nth Largest Number: ");
        int nthPosition = scanner.nextInt();

        // Find the nth largest number by sorting in reverse order
        int nthLargestNumber = Arrays.stream(numberArray).boxed()
                .sorted(Comparator.reverseOrder())
                .skip(nthPosition - 1)
                .findFirst()
                .orElse(-1);

        System.out.println("nth Largest Number: " + nthLargestNumber);

        // Generate first 'n' prime numbers
        int[] primeNumbers = IntStream.iterate(2, i -> i + 1)
                .filter(NumberStreamProcessor::isPrime)
                .limit(nthPosition)
                .toArray();

        // Count prime numbers greater than 10
        long primeCountAboveTen = Arrays.stream(primeNumbers).filter(num -> num > 10).count();

        // Print first 'n' prime numbers
        System.out.print("Prime Numbers: ");
        Arrays.stream(primeNumbers).forEach(num -> System.out.print(num + " "));
        System.out.println();

        // Print count of prime numbers greater than 10
        System.out.println("Count of Prime Numbers > 10 = " + primeCountAboveTen);

        // Calculate the average of all numbers in the array
        double averageValue = Arrays.stream(numberArray).average().orElse(0.0);
        System.out.println("Average = " + averageValue);

        // Calculate the product of all elements using BigInteger to avoid overflow
        BigInteger productOfAllNumbers = Arrays.stream(numberArray)
                .mapToObj(BigInteger::valueOf)
                .reduce(BigInteger.ONE, BigInteger::multiply);
        System.out.println("Product of all elements = " + productOfAllNumbers);

        // Calculate the product of squares of even numbers
        long productOfEvenSquares = Arrays.stream(numberArray)
                .filter(num -> num % 2 == 0) // Filter even numbers
                .map(num -> num * num) // Square each even number
                .asLongStream()
                .reduce(1L, (num1, num2) -> num1 * num2); // Multiply all squared numbers
        System.out.println("Product of even elements squared = " + productOfEvenSquares);
    }

    // Method to check if a number is prime
    public static boolean isPrime(int num) {
        if (num < 2) return false; // 0 and 1 are not prime numbers
        return IntStream.rangeClosed(2, (int) Math.sqrt(num))
                .noneMatch(divisor -> num % divisor == 0); // Check divisibility
    }
}
