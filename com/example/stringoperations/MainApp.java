package com.example.stringoperations;

import java.util.*;

public class MainApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Demonstrating String Operations
        System.out.print("Enter a string: ");
        String str = scanner.nextLine();

        System.out.println("\nString Methods:");
        System.out.println("Length: " + str.length());
        System.out.println("Character at index 2: " + str.charAt(2));
        System.out.println("Substring (0,3): " + str.substring(0, 3));
        System.out.println("Index of 'a': " + str.indexOf('a'));
        System.out.println("Last index of 'a': " + str.lastIndexOf('a'));
        System.out.println("Uppercase: " + str.toUpperCase());
        System.out.println("Lowercase: " + str.toLowerCase());
        System.out.println("Trimmed: " + str.trim());
        System.out.println("Starts with 'A': " + str.startsWith("A"));
        System.out.println("Ends with 'z': " + str.endsWith("z"));
        System.out.println("Replaced 'a' with 'A': " + str.replace('a', 'A'));
        System.out.println("Equals 'hello': " + str.equals("hello"));
        System.out.println("Equals Ignore Case 'hello': " + str.equalsIgnoreCase("hello"));
        System.out.println("Contains 'world': " + str.contains("world"));
        System.out.println("Split by space: " + Arrays.toString(str.split(" ")));

        // Demonstrating StringBuffer Methods
        System.out.println("\nStringBuffer Methods:");
        StringBuffer stringBuffer = new StringBuffer(str);
        System.out.println("Original: " + stringBuffer);
        System.out.println("Append ' Java': " + stringBuffer.append(" Java"));
        System.out.println("Insert 'Awesome ' at index 5: " + stringBuffer.insert(5, "Awesome "));
        System.out.println("Reverse: " + stringBuffer.reverse());
        stringBuffer.reverse(); // Reverting to original
        System.out.println("Replace 0-5 with 'Hello': " + stringBuffer.replace(0, 5, "Hello"));
        System.out.println("Delete 0-5: " + stringBuffer.delete(0, 5));
        System.out.println("Capacity: " + stringBuffer.capacity());

        // Demonstrating StringBuilder Methods
        System.out.println("\nStringBuilder Methods:");
        StringBuilder stringBuilder = new StringBuilder(str);
        System.out.println("Original: " + stringBuilder);
        System.out.println("Append ' Java': " + stringBuilder.append(" Java"));
        System.out.println("Insert 'Awesome ' at index 5: " + stringBuilder.insert(5, "Awesome "));
        System.out.println("Reverse: " + stringBuilder.reverse());
        stringBuilder.reverse(); // Reverting to original
        System.out.println("Replace 0-5 with 'Hello': " + stringBuilder.replace(0, 5, "Hello"));
        System.out.println("Delete 0-5: " + stringBuilder.delete(0, 5));
        System.out.println("Capacity: " + stringBuilder.capacity());

        // Demonstrating Utility Methods
        System.out.println("\nUtility Methods:");
        System.out.print("Enter a string to check palindrome: ");
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
        scanner.nextLine(); // Consume newline
        System.out.println("Binary string: " + StringOperationsUtil.decimalToBinary(decimalInput));

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