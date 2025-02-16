package com.example.numberutils;

public class FibonacciOperations {
    public static int[] findFibonacciNumbers(int n) {
        if (n <= 0) {
            return new int[0]; // Return an empty array for invalid input
        }
        
        int[] fibonacciNumbers = new int[n];
        fibonacciNumbers[0] = 0;
        
        if (n > 1) {
            fibonacciNumbers[1] = 1;
        }
        
        for (int i = 2; i < n; i++) {
            fibonacciNumbers[i] = fibonacciNumbers[i - 1] + fibonacciNumbers[i - 2];
        }
        
        return fibonacciNumbers;
    }
}
