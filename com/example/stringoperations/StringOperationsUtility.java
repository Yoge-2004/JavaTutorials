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
            } else if (chr == ')' || chr == '>' || chr == ']' || chr == '}') {
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

    // Counts duplicate characters in a string using a map
    public static int duplicateCount(String string, Map<Character, Integer> map) {
        int count = 0;
        for (Character ch : string.toCharArray()) {
            if (!map.containsKey(ch)) {
                map.put(ch, 1);
            } else {
                count++;
            }
        }
        return count;
    }

    // Returns the first duplicate character found in a string using a map
    public static char firstDuplicateCharacter(String string, Map<Character, Integer> map) {
        for (Character ch : string.toCharArray()) {
            if (!map.containsKey(ch)) {
                map.put(ch, 1);
            } else {
                return ch;
            }
        }
        return ' ';
    }

    // Counts alphabet characters (a-z, A-Z) in a string and stores counts in a map
    public static void countAlphabets(String string, Map<Character, Integer> map) {
        for (Character ch : string.toCharArray()) {
            if ((ch >= 'a' && ch <= 'z') || (ch >= 'A' && ch <= 'Z')) {
                map.put(ch, map.getOrDefault(ch, 0) + 1);
            }
        }
    }

    // Counts all characters in a string, separating alphabet and non-alphabet counts
    public static void countCharacters(String string, Map<Character, Integer> map) {
        countAlphabets(string, map);
        for (Character ch : string.toCharArray()) {
            // If the character is not an alphabet, count it separately
            if (!((ch >= 'a' && ch <= 'z') || (ch >= 'A' && ch <= 'Z'))) {
                map.put(ch, map.getOrDefault(ch, 0) + 1);
            }
        }
    }

    // Removes spaces from a string
    public static String removeSpaces(String string) {
        StringBuilder sb = new StringBuilder();
        // Optionally trim the string first
        string = string.trim();
        for (char ch : string.toCharArray()) {
            if (ch != ' ') {
                sb.append(ch);
            }
        }
        return sb.toString();
    }

    // Removes all occurrences of a specified character from the string by replacing them with the null character
    public static String removeChar(String string, char removeChar) {
        char[] charArray = string.toCharArray();
        for (int i = 0; i < charArray.length; i++) {
            if (charArray[i] == removeChar) {
                charArray[i] = '\0';
            }
        }
        return new String(charArray);
    }

    // Replaces the first occurrence of oldChar with newChar in the string
    public static String replaceChar(String string, char oldChar, char newChar) {
        char[] charArray = string.toCharArray();
        for (int i = 0; i < charArray.length; i++) {
            if (charArray[i] == oldChar) {
                charArray[i] = newChar;
                return new String(charArray);
            }
        }
        return string;
    }

    // Replaces all occurrences of oldChar with newChar in the string
    public static String replaceCharAll(String string, char oldChar, char newChar) {
        char[] charArray = string.toCharArray();
        for (int i = 0; i < charArray.length; i++) {
            if (charArray[i] == oldChar) {
                charArray[i] = newChar;
            }
        }
        return new String(charArray);
    }

    // ------------------------- Main Method -------------------------
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // ---- Demonstration of First Group of Operations ----
        System.out.println("---- First Group of Operations ----");

        // 1. String compression
        System.out.print("Enter a string to compress: ");
        String inputString = scanner.nextLine();
        System.out.println("Compressed String: " + compressString(inputString));

        // 2. Parenthesis balancing
        System.out.print("Enter a string with parentheses to check balance: ");
        String parenthesesString = scanner.nextLine();
        System.out.println("Is balanced? " + isBalancedParenthesis(parenthesesString));

        // 3. Finding all substrings
        System.out.print("Enter a string to find substrings: ");
        String substringInput = scanner.nextLine();
        System.out.println("Substrings: " + findSubStrings(substringInput));

        // 4. Roman numeral conversion
        System.out.print("Enter a Roman numeral string: ");
        String romanString = scanner.nextLine();
        System.out.println("Integer value: " + romanToInteger(romanString));

        // 5. Check if two strings are rotations
        System.out.print("Enter first string for rotation check: ");
        String str1 = scanner.nextLine();
        System.out.print("Enter second string for rotation check: ");
        String str2 = scanner.nextLine();
        System.out.println("Are rotations? " + areRotations(str1, str2));

        // 6. Letter frequency
        System.out.print("Enter a string to calculate letter frequency: ");
        String freqString = scanner.nextLine();
        System.out.println("Letter Frequency: " + letterFrequency(freqString));

        // ---- Demonstration of Second Group of Operations ----
        System.out.println("\n---- Second Group of Operations ----");

        // Use a fresh input string for these operations
        System.out.print("Enter a string for duplicate and character count operations: ");
        String stringForDup = scanner.nextLine();
        Map<Character, Integer> map = new HashMap<>(stringForDup.length());

        // 7. Duplicate count
        System.out.println("Duplicate Count: " + duplicateCount(stringForDup, map));
        map.clear();

        // 8. First duplicate character
        System.out.println("First Duplicate Character: " + firstDuplicateCharacter(stringForDup, map));
        map.clear();

        // 9. Count all characters (alphabets and others)
        countCharacters(stringForDup, map);
        System.out.println("Character counts:");
        map.forEach((key, value) -> System.out.println(key + " -> " + value));
        map.clear();

        // 10. Remove spaces from the string
        System.out.println("String without spaces: " + removeSpaces(stringForDup));

        // 11. Remove all occurrences of 'a' (for example)
        System.out.println("String after removing 'a': " + removeChar(stringForDup, 'a'));

        // Optionally, demonstrate replace functions
        System.out.print("Enter a string for replacement operations: ");
        String stringForReplace = scanner.nextLine();
        System.out.println("Replace first occurrence of 'a' with 'A': " + replaceChar(stringForReplace, 'a', 'A'));
        System.out.println("Replace all occurrences of 'a' with 'A': " + replaceCharAll(stringForReplace, 'a', 'A'));

        scanner.close();
    }
}