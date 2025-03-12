package com.example.stringoperations;

import java.util.*;

enum Numbers {
    I(1), V(5), X(10), L(50), C(100), D(500), M(1000),
    i(1), v(5), x(10), l(50), c(100), d(500), m(1000);

    private final int number;

    Numbers(int number) {
        this.number = number;
    }

    public int getValue() {
        return number;
    }
}

public class StringOperationsUtility {
    
    // Function to compress a string using Run-Length Encoding (RLE)
    public static String compressString(String str) {
        StringBuilder compressedString = new StringBuilder();
        int count = 1;

        for (int i = 0; i < str.length(); i++) {
            if (i < str.length() - 1 && str.charAt(i) == str.charAt(i + 1)) {
                count++;
            } else {
                compressedString.append(str.charAt(i)).append(count);
                count = 1;
            }
        }
        return compressedString.toString();
    }

    // Function to check if parentheses in a string are balanced
    public static boolean isBalancedParenthesis(String str) {
        Stack<Character> stack = new Stack<>();

        for (char chr : str.toCharArray()) {
            if (chr == '(' || chr == '<' || chr == '[' || chr == '{') {
                stack.push(chr);
            } else {
                if (stack.isEmpty()) return false;
                char top = stack.peek();
                if ((top == '(' && chr == ')') || (top == '{' && chr == '}') ||
                    (top == '[' && chr == ']') || (top == '<' && chr == '>')) {
                    stack.pop();
                } else {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }

    // Function to find all substrings of a given string
    public static ArrayList<String> findSubStrings(String str) {
        ArrayList<String> substrings = new ArrayList<>();
        for (int i = 0; i < str.length(); i++) {
            for (int j = i + 1; j <= str.length(); j++) {
                substrings.add(str.substring(i, j));
            }
        }
        return substrings;
    }

    // Function to convert a Roman numeral string to an integer
    public static int romanToInteger(String str) {
        int number = 0, previousValue = 0;
        for (int i = 0; i < str.length(); i++) {
            Numbers numb = Numbers.valueOf(str.substring(i, i + 1));
            int romanValue = numb.getValue();

            if (previousValue < romanValue) {
                number = romanValue - number;
            } else {
                number += romanValue;
            }
            previousValue = romanValue;
        }
        return number;
    }

    // Function to check if two strings are rotations of each other
    public static boolean areRotations(String s1, String s2) {
        if (s1.length() != s2.length()) return false;
        return (s1 + s1).contains(s2);
    }

    // Function to calculate the frequency of each letter in a string
    public static Map<Character, Integer> letterFrequency(String str) {
        Map<Character, Integer> frequencyMap = new HashMap<>();
        for (char ch : str.toCharArray()) {
            frequencyMap.put(ch, frequencyMap.getOrDefault(ch, 0) + 1);
        }
        return frequencyMap;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // String compression
        System.out.print("Enter a string to compress: ");
        String inputString = scanner.nextLine();
        System.out.println("Compressed String: " + compressString(inputString));

        // Parenthesis balancing
        System.out.print("Enter a string with parentheses to check balance: ");
        String parenthesesString = scanner.nextLine();
        System.out.println("Is balanced? " + isBalancedParenthesis(parenthesesString));

        // Finding all substrings
        System.out.print("Enter a string to find substrings: ");
        String substringInput = scanner.nextLine();
        System.out.println("Substrings: " + findSubStrings(substringInput));

        // Roman numeral conversion
        System.out.print("Enter a Roman numeral string: ");
        String romanString = scanner.nextLine();
        System.out.println("Integer value: " + romanToInteger(romanString));

        // Check if two strings are rotations
        System.out.print("Enter first string: ");
        String str1 = scanner.nextLine();
        System.out.print("Enter second string: ");
        String str2 = scanner.nextLine();
        System.out.println("Are rotations? " + areRotations(str1, str2));

        // Letter frequency
        System.out.print("Enter a string to calculate letter frequency: ");
        String freqString = scanner.nextLine();
        System.out.println("Letter Frequency: " + letterFrequency(freqString));

        scanner.close();
    }
}
