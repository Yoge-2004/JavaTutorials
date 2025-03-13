package com.example.stringoperations;

import java.util.*;

public final class StringOperationsUtil {

    private StringOperationsUtil() {}

    public static boolean isPalindrome(String input) {
        if (input == null) return false;
        String reversed = new StringBuilder(input).reverse().toString();
        return input.equalsIgnoreCase(reversed);
    }

    public static boolean areAnagrams(String str1, String str2) {
        if (str1 == null || str2 == null) return false;
        char[] arr1 = str1.replaceAll("\\s", "").toLowerCase().toCharArray();
        char[] arr2 = str2.replaceAll("\\s", "").toLowerCase().toCharArray();
        Arrays.sort(arr1);
        Arrays.sort(arr2);
        return Arrays.equals(arr1, arr2);
    }

    public static boolean isPangram(String input) {
        if (input == null) return false;
        boolean[] seen = new boolean[26];
        input = input.toLowerCase();
        for (char ch : input.toCharArray()) {
            if (ch >= 'a' && ch <= 'z') {
                seen[ch - 'a'] = true;
            }
        }
        for (boolean letterSeen : seen) {
            if (!letterSeen) return false;
        }
        return true;
    }

    public static int binaryToDecimal(String binaryStr) {
        if (binaryStr == null || !binaryStr.matches("[01]+")) {
            throw new IllegalArgumentException("Invalid binary string");
        }
        return Integer.parseInt(binaryStr, 2);
    }

    public static String decimalToBinary(int decimal) {
        return Integer.toBinaryString(decimal);
    }

    public static int countCharDeletionsForEquality(String s1, String s2) {
        int[] frequency = new int[26];
        for (char ch : s1.toCharArray()) {
            if (Character.isLetter(ch)) {
                frequency[Character.toLowerCase(ch) - 'a']++;
            }
        }
        for (char ch : s2.toCharArray()) {
            if (Character.isLetter(ch)) {
                frequency[Character.toLowerCase(ch) - 'a']--;
            }
        }
        int deletions = 0;
        for (int count : frequency) {
            deletions += Math.abs(count);
        }
        return deletions;
    }

    public static int validateXYPattern(String input) {
        if (input == null) return 0;
        char[] characters = input.toCharArray();
        int balance = 0;
        for (char ch : characters) {
            balance = (ch == 'x') ? balance + 1 : balance - 1;
        }
        if (balance != 0) return 0;
        int xCount = 0;
        for (int i = 0; i < input.length(); i++) {
            char ch = input.charAt(i);
            if (ch == 'x') {
                xCount++;
            } else if (ch == 'y') {
                xCount--;
                if ((i + 1) < input.length() && input.charAt(i + 1) == 'x' && xCount != 0) {
                    return 0;
                }
            }
        }
        return (xCount == 0) ? 1 : 0;
    }

    public static String compressUsingRLE(String input) {
        if (input == null || input.isEmpty()) return input;
        StringBuilder compressed = new StringBuilder();
        int count = 1;
        for (int i = 0; i < input.length(); i++) {
            if (i < input.length() - 1 && input.charAt(i) == input.charAt(i + 1)) {
                count++;
            } else {
                compressed.append(input.charAt(i)).append(count);
                count = 1;
            }
        }
        return compressed.toString();
    }

    public static boolean areParenthesesBalanced(String input) {
        if (input == null) return true;
        Stack<Character> stack = new Stack<>();
        for (char ch : input.toCharArray()) {
            if (ch == '(' || ch == '[' || ch == '{' || ch == '<') {
                stack.push(ch);
            } else if (ch == ')' || ch == ']' || ch == '}' || ch == '>') {
                if (stack.isEmpty()) return false;
                char top = stack.peek();
                if ((top == '(' && ch == ')') ||
                    (top == '[' && ch == ']') ||
                    (top == '{' && ch == '}') ||
                    (top == '<' && ch == '>')) {
                    stack.pop();
                } else {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }

    public static List<String> getAllSubstrings(String input) {
        List<String> substrings = new ArrayList<>();
        if (input == null) return substrings;
        for (int i = 0; i < input.length(); i++) {
            for (int j = i + 1; j <= input.length(); j++) {
                substrings.add(input.substring(i, j));
            }
        }
        return substrings;
    }

    public static int romanNumeralToInteger(String roman) {
        if (roman == null || roman.isEmpty()) return 0;
        int result = 0, previousValue = 0;
        for (int i = 0; i < roman.length(); i++) {
            Numbers numeral = Numbers.valueOf(roman.substring(i, i + 1));
            int value = numeral.getValue();
            if (previousValue < value) {
                result = value - result;
            } else {
                result += value;
            }
            previousValue = value;
        }
        return result;
    }

    public static boolean areRotations(String s1, String s2) {
        if (s1 == null || s2 == null) return false;
        if (s1.length() != s2.length()) return false;
        return (s1 + s1).contains(s2);
    }

    public static Map<Character, Integer> getLetterFrequency(String input) {
        Map<Character, Integer> frequency = new HashMap<>();
        if (input == null) return frequency;
        for (char ch : input.toCharArray()) {
            frequency.put(ch, frequency.getOrDefault(ch, 0) + 1);
        }
        return frequency;
    }

    public static int getDuplicateCount(String input, Map<Character, Integer> countMap) {
        if (input == null) return 0;
        int duplicateCount = 0;
        for (char ch : input.toCharArray()) {
            if (!countMap.containsKey(ch)) {
                countMap.put(ch, 1);
            } else {
                duplicateCount++;
            }
        }
        return duplicateCount;
    }

    public static char getFirstDuplicateCharacter(String input, Map<Character, Integer> countMap) {
        if (input == null) return '\0';
        for (char ch : input.toCharArray()) {
            if (!countMap.containsKey(ch)) {
                countMap.put(ch, 1);
            } else {
                return ch;
            }
        }
        return '\0';
    }

    public static void countAlphabeticCharacters(String input, Map<Character, Integer> countMap) {
        if (input == null) return;
        for (char ch : input.toCharArray()) {
            if (Character.isLetter(ch)) {
                countMap.put(ch, countMap.getOrDefault(ch, 0) + 1);
            }
        }
    }

    public static void countAllCharacters(String input, Map<Character, Integer> countMap) {
        if (input == null) return;
        countAlphabeticCharacters(input, countMap);
        for (char ch : input.toCharArray()) {
            if (!Character.isLetter(ch)) {
                countMap.put(ch, countMap.getOrDefault(ch, 0) + 1);
            }
        }
    }

    public static String removeSpaces(String input) {
        if (input == null) return null;
        return input.trim().replace(" ", "");
    }

    public static String removeCharacter(String input, char charToRemove) {
        if (input == null) return null;
        char[] charArray = input.toCharArray();
        for (int i = 0; i < charArray.length; i++) {
            if (charArray[i] == charToRemove) {
                charArray[i] = '\0';
            }
        }
        return new String(charArray);
    }

    public static String replaceFirstOccurrence(String input, char oldChar, char newChar) {
        if (input == null) return null;
        char[] charArray = input.toCharArray();
        for (int i = 0; i < charArray.length; i++) {
            if (charArray[i] == oldChar) {
                charArray[i] = newChar;
                break;
            }
        }
        return new String(charArray);
    }

    public static String replaceAllOccurrences(String input, char oldChar, char newChar) {
        if (input == null) return null;
        char[] charArray = input.toCharArray();
        for (int i = 0; i < charArray.length; i++) {
            if (charArray[i] == oldChar) {
                charArray[i] = newChar;
            }
        }
        return new String(charArray);
    }
}

enum Numbers {
    I(1), V(5), X(10), L(50), C(100), D(500), M(1000),
    i(1), v(5), x(10), l(50), c(100), d(500), m(1000);

    private final int value;

    Numbers(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}