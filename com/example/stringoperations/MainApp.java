package com.example.stringoperations;

import java.util.Scanner;

public class MainApp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Palindrome Check
        System.out.print("Enter a string to check Palindrome: ");
        String palStr = sc.nextLine();
        System.out.println("Is Palindrome? " + StringOperations.isPalindrome(palStr));

        // Anagram Check
        System.out.print("\nEnter first string for Anagram check: ");
        String str1 = sc.next();
        System.out.print("Enter second string: ");
        String str2 = sc.next();
        System.out.println("Are Anagrams? " + StringOperations.isAnagram(str1, str2));

        // Pangram Check
        System.out.print("\nEnter a string to check Pangram: ");
        sc.nextLine();
        String pangramStr = sc.nextLine();
        System.out.println("Is Pangram? " + StringOperations.isPangram(pangramStr));

        // Binary to Decimal
        System.out.print("\nEnter a binary number: ");
        String binary = sc.next();
        System.out.println("Decimal Equivalent: " + StringOperations.binaryToDecimal(binary));

        // Decimal to Binary
        System.out.print("\nEnter a decimal number: ");
        int decimal = sc.nextInt();
        System.out.println("Binary Equivalent: " + StringOperations.decimalToBinary(decimal));

        // Count Characters to Make Strings Equal
        System.out.print("\nEnter first string: ");
        String s1 = sc.next();
        System.out.print("Enter second string: ");
        String s2 = sc.next();
        System.out.println("Characters to delete to make equal: " + StringOperations.countCharsToEqual(s1, s2));

        // Pattern Matching (isValidXYPattern function)
        System.out.print("\nEnter a pattern string (x and y): ");
        String pattern = sc.next();
        System.out.println("Pattern Matching Result: " + StringOperations.isValidXYPattern(pattern));

        // Demonstrate String, StringBuilder, StringBuffer methods
        StringOperations.demonstrateStringMethods();

        sc.close();
    }
}