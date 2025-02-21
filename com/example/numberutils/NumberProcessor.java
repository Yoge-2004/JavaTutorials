package com.example.numberutils;

import java.util.Scanner;

public class NumberProcessor {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int number = scanner.nextInt();
        scanner.close();

        int result = processNumber(number);
        System.out.println(result);
    }

    private static int processNumber(int number) {
        int length = (int) (Math.log10(number) + 1);
        if (length % 2 != 0) {
            return number;
        }

        int firstHalf = (int) (number / Math.pow(10, length / 2));
        int secondHalf = (int) (number % Math.pow(10, length / 2));

        int temp = secondHalf; // int temp = firstHalf; for reversing first half of the number
        secondHalf = 0; // firstHalf = 0; for reversing first half of the number

        secondHalf = reverseDigits(temp); // Use firstHalf instead of secondHalf for reversing first half of the number

        return (int) (firstHalf * Math.pow(10, length / 2)) + secondHalf;
    }

    private static int reverseDigits(int num) {
        int reversed = 0;
        while (num > 0) {
            int remainder = num % 10;
            reversed = reversed * 10 + remainder;
            num /= 10;
        }
        return reversed;
    }
}
