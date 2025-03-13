package com.example.stringoperations;

import java.util.*;

public class MainApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Demonstrating StringOperationsUtil methods.");

        System.out.print("Enter a string to test palindrome: ");
        String palindromeInput = scanner.nextLine();
        System.out.println("Is palindrome? " + StringOperationsUtil.isPalindrome(palindromeInput));

        System.out.print("Enter first string to test anagram: ");
        String anagramStr1 = scanner.nextLine();
        System.out.print("Enter second string to test anagram: ");
        String anagramStr2 = scanner.nextLine();
        System.out.println("Are anagrams? " + StringOperationsUtil.areAnagrams(anagramStr1, anagramStr2));

        System.out.print("Enter a string to test pangram: ");
        String pangramInput = scanner.nextLine();
        System.out.println("Is pangram? " + StringOperationsUtil.isPangram(pangramInput));

        System.out.print("Enter a binary string to convert to decimal: ");
        String binaryInput = scanner.nextLine();
        try {
            int decimalValue = StringOperationsUtil.binaryToDecimal(binaryInput);
            System.out.println("Decimal value: " + decimalValue);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

        System.out.print("Enter a decimal number to convert to binary: ");
        int decimalInput = scanner.nextInt();
        scanner.nextLine(); // consume newline
        System.out.println("Binary string: " + StringOperationsUtil.decimalToBinary(decimalInput));

        System.out.print("Enter first string for deletion count: ");
        String deletionStr1 = scanner.nextLine();
        System.out.print("Enter second string for deletion count: ");
        String deletionStr2 = scanner.nextLine();
        System.out.println("Deletions required: " +
            StringOperationsUtil.countCharDeletionsForEquality(deletionStr1, deletionStr2));

        System.out.print("Enter a string for XY pattern validation: ");
        String xyPattern = scanner.nextLine();
        System.out.println("XY pattern valid? " +
            (StringOperationsUtil.validateXYPattern(xyPattern) == 1));

        System.out.print("Enter a string to compress using RLE: ");
        String rleInput = scanner.nextLine();
        System.out.println("Compressed string: " +
            StringOperationsUtil.compressUsingRLE(rleInput));

        System.out.print("Enter a string to check parentheses balance: ");
        String parenthesesInput = scanner.nextLine();
        System.out.println("Parentheses balanced? " +
            StringOperationsUtil.areParenthesesBalanced(parenthesesInput));

        System.out.print("Enter a string to get all substrings: ");
        String substringInput = scanner.nextLine();
        List<String> substrings = StringOperationsUtil.getAllSubstrings(substringInput);
        System.out.println("Substrings: " + substrings);

        System.out.print("Enter a Roman numeral: ");
        String romanInput = scanner.nextLine();
        System.out.println("Integer value: " +
            StringOperationsUtil.romanNumeralToInteger(romanInput));

        System.out.print("Enter first string for rotation check: ");
        String rotationStr1 = scanner.nextLine();
        System.out.print("Enter second string for rotation check: ");
        String rotationStr2 = scanner.nextLine();
        System.out.println("Are rotations? " +
            StringOperationsUtil.areRotations(rotationStr1, rotationStr2));

        System.out.print("Enter a string to get letter frequency: ");
        String frequencyInput = scanner.nextLine();
        Map<Character, Integer> frequencyMap = StringOperationsUtil.getLetterFrequency(frequencyInput);
        System.out.println("Letter frequency: " + frequencyMap);

        System.out.print("Enter a string to check for duplicate characters: ");
        String duplicateInput = scanner.nextLine();
        Map<Character, Integer> duplicateMap = new HashMap<>();
        System.out.println("Duplicate count: " +
            StringOperationsUtil.getDuplicateCount(duplicateInput, duplicateMap));
        duplicateMap.clear();
        System.out.println("First duplicate character: " +
            StringOperationsUtil.getFirstDuplicateCharacter(duplicateInput, duplicateMap));

        System.out.print("Enter a string to count all characters: ");
        String countInput = scanner.nextLine();
        Map<Character, Integer> countMap = new HashMap<>();
        StringOperationsUtil.countAllCharacters(countInput, countMap);
        System.out.println("Character counts: " + countMap);

        System.out.print("Enter a string to remove spaces: ");
        String removeSpacesInput = scanner.nextLine();
        System.out.println("Without spaces: " +
            StringOperationsUtil.removeSpaces(removeSpacesInput));

        System.out.print("Enter a string to replace first occurrence of 'a' with 'A': ");
        String replaceInput = scanner.nextLine();
        System.out.println("After replacement: " +
            StringOperationsUtil.replaceFirstOccurrence(replaceInput, 'a', 'A'));
        System.out.println("After replacing all occurrences of 'a' with 'A': " +
            StringOperationsUtil.replaceAllOccurrences(replaceInput, 'a', 'A'));

        scanner.close();
    }
}