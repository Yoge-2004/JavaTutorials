package com.example.numberutils;

public class NthPrimeOperations {

    // Returns true if 'number' is prime; false otherwise.
    public static boolean checkPrime(int number) {
        if (number < 2) {  // 0 and 1 are not prime
            return false;
        }
        // Loop from 2 up to the square root of the number.
        for (int i = 2; i <= Math.sqrt(number); i++) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }
    
    // Returns the nth prime number.
    public static int nthPrime(int n) {
        int count = 0;
        int prime = 2;
        int nthPrime = 0;
        
        // Loop until we find n prime numbers.
        while (count != n) {
            if (checkPrime(prime)) {
                nthPrime = prime;
                count++;
            }
            prime++;
        }
        return nthPrime;
    }
}
