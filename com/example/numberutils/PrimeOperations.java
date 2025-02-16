package com.example.numberutils;

import java.util.ArrayList;

public class PrimeOperations {
    public static ArrayList<Integer> findPrimeNumbers(int start, int end) {
        ArrayList<Integer> primeNumbers = new ArrayList<>();
        if (start <= 1) start = 2;
        
        for (int i = start; i <= end; i++) {
            boolean isPrime = true;
            for (int j = 2; j * j <= i; j++) {
                if (i % j == 0) {
                    isPrime = false;
                    break;
                }
            }
            if (isPrime) {
                primeNumbers.add(i);
            }
        }
        return primeNumbers;
    }
    
    public static int sumOfPrimeNumbers(int start, int end) {
        int sum = 0;
        for (int num : findPrimeNumbers(start, end)) {
            sum += num;
        }
        return sum;
    }
}
