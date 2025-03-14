package com.example.streamprocessing;

import java.util.*;
import java.util.stream.*;

public class StringStreamProcessor {
    public static void main(String[] args) {
        // Sample string
        String inputString = "Hello to Java Programming ___1234";

        // Convert characters to a stream and reassemble as a string
        String processedString = inputString.chars()
                .mapToObj(ch -> String.valueOf((char) ch))
                .collect(Collectors.joining());

        // Count digits in the string
        long digitCount = processedString.chars()
                .mapToObj(ch -> (char) ch)
                .filter(Character::isDigit)
                .count();
        System.out.println("Digit Count = " + digitCount);

        // Count alphabetic characters
        long alphabetCount = processedString.chars()
                .mapToObj(ch -> (char) ch)
                .filter(Character::isLetter)
                .count();
        System.out.println("Letters Count = " + alphabetCount);

        // Count uppercase letters
        long upperCaseCount = processedString.chars()
                .mapToObj(ch -> (char) ch)
                .filter(Character::isUpperCase)
                .count();
        System.out.println("Uppercase Letters Count = " + upperCaseCount);

        // Count lowercase letters
        long lowerCaseCount = processedString.chars()
                .mapToObj(ch -> (char) ch)
                .filter(Character::isLowerCase)
                .count();
        System.out.println("Lowercase Letters Count = " + lowerCaseCount);

        Scanner scanner = new Scanner(System.in);

        // Get user input for space-separated words
        System.out.println("Enter the string separated by spaces: ");
        String[] wordArray = Arrays.stream(scanner.nextLine().split("\\s+"))
                .toArray(String[]::new);

        System.out.println();

        // Find the maximum length of a palindrome in the input words
        int maxPalindromeLength = Arrays.stream(wordArray)
                .map(String::toLowerCase)
                .filter(StringStreamProcessor::isPalindrome)
                .mapToInt(String::length)
                .max()
                .orElse(0);

        // Find and list all longest palindromes
        List<String> longestPalindromes = Arrays.stream(wordArray)
                .parallel()
                .peek(System.out::println) // Debugging step to print words
                .map(String::toLowerCase)
                .filter(StringStreamProcessor::isPalindrome)
                .sorted((a, b) -> b.length() - a.length()) // Sort by length (desc)
                .filter(word -> word.length() == maxPalindromeLength)
                .toList();

        System.out.println("Longest Palindrome(s) = " + longestPalindromes);

        // Generate a random pangram-like string of 30 uppercase letters
        Random random = new Random();
        String pangramString = IntStream.generate(() -> random.nextInt(26) + 'A')
                .limit(30)
                .mapToObj(ch -> (char) ch)
                .map(String::valueOf)
                .collect(Collectors.joining());

        // Print the generated random string
        pangramString.chars()
                .mapToObj(ch -> (char) ch)
                .forEach(System.out::print);
        System.out.println();

        // Check if the generated string contains all 26 letters of the alphabet
        long distinctLetterCount = pangramString.chars()
                .mapToObj(ch -> (char) ch)
                .map(Character::toLowerCase)
                .filter(Character::isLetter)
                .distinct()
                .count();

        System.out.println(distinctLetterCount == 26);
    }

    // Method to check if a string is a palindrome
    public static boolean isPalindrome(String word) {
        return word.equals(new StringBuilder(word).reverse().toString());
    }
}