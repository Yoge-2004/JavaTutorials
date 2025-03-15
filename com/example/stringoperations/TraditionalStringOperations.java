package com.example.stringoperations;

import java.util.*;
import java.util.regex.*;

public class TraditionalStringOperations {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Basic analysis using traditional loops
        System.out.println("Enter a string for basic analysis (traditional):");
        String input = scanner.nextLine();
        int digitCount = 0, letterCount = 0, upperCount = 0, lowerCount = 0;
        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            if (Character.isDigit(c)) digitCount++;
            if (Character.isLetter(c)) letterCount++;
            if (Character.isUpperCase(c)) upperCount++;
            if (Character.isLowerCase(c)) lowerCount++;
        }
        System.out.println("Digits: " + digitCount);
        System.out.println("Letters: " + letterCount);
        System.out.println("Uppercase: " + upperCount);
        System.out.println("Lowercase: " + lowerCount);
        System.out.println();

        // Palindrome detection using traditional methods
        System.out.println("Enter words (separated by spaces) for palindrome detection (traditional):");
        String wordsInput = scanner.nextLine();
        String[] words = wordsInput.split("\\s+");
        int maxPalLength = 0;
        for (String w : words) {
            String lower = w.toLowerCase();
            if (isPalindrome(lower) && lower.length() > maxPalLength) {
                maxPalLength = lower.length();
            }
        }
        List<String> longestPalindromes = new ArrayList<>();
        for (String w : words) {
            String lower = w.toLowerCase();
            if (isPalindrome(lower) && lower.length() == maxPalLength) {
                longestPalindromes.add(lower);
            }
        }
        System.out.println("Longest palindrome(s) with length " + maxPalLength + ": " + longestPalindromes);
        System.out.println();

        // Random uppercase string generation using traditional methods
        System.out.println("Random uppercase string (30 characters, traditional):");
        Random rand = new Random();
        StringBuilder randomUpper = new StringBuilder();
        for (int i = 0; i < 30; i++) {
            char c = (char)(rand.nextInt(26) + 'A');
            randomUpper.append(c);
        }
        String randomUpperStr = randomUpper.toString();
        System.out.println(randomUpperStr);
        boolean[] seen = new boolean[26];
        for (int i = 0; i < randomUpperStr.length(); i++) {
            char c = randomUpperStr.charAt(i);
            if (Character.isLetter(c)) {
                seen[c - 'A'] = true;
            }
        }
        boolean allLetters = true;
        for (boolean b : seen) {
            if (!b) { allLetters = false; break; }
        }
        System.out.println("Contains all 26 letters? " + allLetters);
        System.out.println();

        // Frequency analysis using traditional methods
        System.out.println("Enter a string for frequency analysis (traditional):");
        String freqInput = scanner.nextLine();
        System.out.println("Enter a character to remove:");
        char remChar = scanner.nextLine().charAt(0);
        StringBuilder modified = new StringBuilder();
        for (int i = 0; i < freqInput.length(); i++) {
            char c = freqInput.charAt(i);
            if (c != remChar) {
                modified.append(c);
            }
        }
        String modifiedStr = modified.toString();
        System.out.println("Modified string after removing '" + remChar + "': " + modifiedStr);
        Map<Character, Integer> freqMap = new LinkedHashMap<>();
        for (int i = 0; i < modifiedStr.length(); i++) {
            char c = modifiedStr.charAt(i);
            freqMap.put(c, freqMap.getOrDefault(c, 0) + 1);
        }
        for (Map.Entry<Character, Integer> entry : freqMap.entrySet()) {
            System.out.println("Character: " + entry.getKey() + ", Count: " + entry.getValue());
        }
        System.out.println();

        // Decompress a compressed sequence using traditional methods
        System.out.println("Enter a compressed sequence (e.g., A2B3C4D1) (traditional):");
        String compSeq = scanner.nextLine();
        StringBuilder decompressed = new StringBuilder();
        for (int i = 0; i < compSeq.length(); i += 2) {
            char ch = compSeq.charAt(i);
            int count = Character.getNumericValue(compSeq.charAt(i + 1));
            for (int j = 0; j < count; j++) {
                decompressed.append(ch);
            }
        }
        System.out.println("Decompressed sequence: " + decompressed.toString());
        System.out.println();

        // Word analysis (longest and shortest) using traditional methods
        System.out.println("Enter a sentence for word analysis (traditional):");
        String sentence = scanner.nextLine();
        String[] sentWords = sentence.split("\\s+");
        String longestWord = "";
        String shortestWord = sentWords.length > 0 ? sentWords[0] : "";
        for (String w : sentWords) {
            if (w.length() > longestWord.length()) longestWord = w;
            if (w.length() < shortestWord.length()) shortestWord = w;
        }
        System.out.println("Longest word: " + longestWord);
        System.out.println("Shortest word: " + shortestWord);
        System.out.println();

        // Title formatting using traditional methods
        System.out.println("Enter a title to format (traditional):");
        String title = scanner.nextLine();
        String[] titleWords = title.split("\\s+");
        StringBuilder formattedTitle = new StringBuilder();
        for (String w : titleWords) {
            if (w.length() > 0) {
                formattedTitle.append(Character.toUpperCase(w.charAt(0)));
                if (w.length() > 1) {
                    formattedTitle.append(w.substring(1).toLowerCase());
                }
                formattedTitle.append(" ");
            }
        }
        System.out.println("Formatted Title: " + formattedTitle.toString().trim());
        System.out.println();

        // Unique and duplicate characters using traditional methods
        System.out.println("Enter a string for unique/duplicate analysis (traditional):");
        String uniqueDup = scanner.nextLine();
        Map<Character, Integer> charFreq = new LinkedHashMap<>();
        for (int i = 0; i < uniqueDup.length(); i++) {
            char c = uniqueDup.charAt(i);
            charFreq.put(c, charFreq.getOrDefault(c, 0) + 1);
        }
        StringBuilder uniqueChars = new StringBuilder();
        StringBuilder duplicateChars = new StringBuilder();
        for (Map.Entry<Character, Integer> entry : charFreq.entrySet()) {
            if (entry.getValue() == 1)
                uniqueChars.append(entry.getKey());
            else if (entry.getValue() > 1)
                duplicateChars.append(entry.getKey());
        }
        System.out.println("Unique characters: " + uniqueChars.toString());
        System.out.println("Duplicate characters: " + duplicateChars.toString());
        System.out.println();

        // Reverse sentence: reverse word order and reverse each word (traditional)
        System.out.println("Enter a sentence to reverse its word order and to reverse each word (traditional):");
        String revSentence = scanner.nextLine();
        String[] revWords = revSentence.split("\\s+");
        // Reverse word order
        for (int i = 0; i < revWords.length / 2; i++) {
            String temp = revWords[i];
            revWords[i] = revWords[revWords.length - 1 - i];
            revWords[revWords.length - 1 - i] = temp;
        }
        System.out.println("Reversed word order: " + String.join(" ", revWords));
        // Reverse each word
        StringBuilder eachWordReversed = new StringBuilder();
        for (String w : revSentence.split("\\s+")) {
            StringBuilder sb = new StringBuilder(w);
            eachWordReversed.append(sb.reverse().toString()).append(" ");
        }
        System.out.println("Each word reversed: " + eachWordReversed.toString().trim());
        System.out.println();

        // Complex decompression using regex (traditional)
        System.out.println("Enter a complex compressed segment (e.g., '2{ABC} 3{XYZ}, 5{DEF}') (traditional):");
        String complexComp = scanner.nextLine();
        Pattern pat = Pattern.compile("(\\d+)\\{(.*?)\\}");
        Matcher matcher = pat.matcher(complexComp);
        System.out.println("Decompressed segments:");
        while (matcher.find()) {
            int count = Integer.parseInt(matcher.group(1));
            String seg = matcher.group(2);
            StringBuilder expandedSeg = new StringBuilder();
            for (int i = 0; i < count; i++) {
                expandedSeg.append(seg).append(" ");
            }
            System.out.println(expandedSeg.toString().trim());
        }
        System.out.println();

        // Number normalization using traditional methods
        System.out.println("Enter a number string with leading zeros (traditional):");
        String numStr = scanner.nextLine();
        String normalizedNum = String.valueOf(Integer.parseInt(numStr));
        System.out.println("Normalized number: " + normalizedNum);
        System.out.println();

        // Even and odd length words using traditional methods
        System.out.println("Enter a sentence to separate even and odd length words (traditional):");
        String evenOddSentence = scanner.nextLine();
        String[] evenOddWords = evenOddSentence.split("\\s+");
        StringBuilder evenWords = new StringBuilder();
        StringBuilder oddWords = new StringBuilder();
        for (String w : evenOddWords) {
            if (w.length() % 2 == 0) {
                evenWords.append(w).append(" ");
            } else {
                oddWords.append(w).append(" ");
            }
        }
        System.out.println("Even length words: " + evenWords.toString().trim());
        System.out.println("Odd length words: " + oddWords.toString().trim());
        System.out.println();

        // Swap adjacent characters using traditional methods
        System.out.println("Enter a word to swap adjacent characters (traditional):");
        String swapWord = scanner.nextLine();
        char[] swapChars = swapWord.toCharArray();
        for (int i = 0; i < swapChars.length - 1; i += 2) {
            char temp = swapChars[i];
            swapChars[i] = swapChars[i + 1];
            swapChars[i + 1] = temp;
        }
        System.out.println("Swapped word: " + new String(swapChars));
        System.out.println();

        // Partition a string using traditional methods
        System.out.println("Enter a string to partition (traditional):");
        String partString = scanner.nextLine();
        System.out.println("Enter the number of equal parts to partition into:");
        int parts = Integer.parseInt(scanner.nextLine());
        int partLen = partString.length() / parts;
        for (int i = 0; i < parts; i++) {
            String part = partString.substring(i * partLen, (i + 1) * partLen);
            System.out.println("Part " + (i + 1) + ": " + part);
        }
        System.out.println();

        // Pattern computation using traditional methods
        System.out.println("Enter a number pattern string (digits 0, 1, 2) for computation (traditional):");
        String patternInput = scanner.nextLine();
        HashMap<String, Integer> patternMap = new HashMap<>();
        patternMap.put("0,0", 1);
        int count0 = 0, count1 = 0, count2 = 0, patternResult = 0;
        for (int i = 0; i < patternInput.length(); i++) {
            char c = patternInput.charAt(i);
            if (c == '0') count0++;
            else if (c == '1') count1++;
            else if (c == '2') count2++;
            String key = (count0 - count1) + "," + (count0 - count2);
            patternResult += patternMap.getOrDefault(key, 0);
            patternMap.put(key, patternMap.getOrDefault(key, 0) + 1);
        }
        System.out.println("Pattern computation result: " + patternResult);
        System.out.println();

        // Abbreviation extraction using traditional methods
        System.out.println("Enter a string for abbreviation extraction (traditional, uppercase letters only):");
        String abbrevInput = scanner.nextLine();
        StringBuilder abbreviation = new StringBuilder();
        for (int i = 0; i < abbrevInput.length(); i++) {
            char c = abbrevInput.charAt(i);
            if (c >= 'A' && c <= 'Z') {
                abbreviation.append(c);
            }
        }
        System.out.println("Abbreviation: " + abbreviation.toString());
        System.out.println();

        // String rotation using traditional methods
        System.out.println("Enter a string for rotation (e.g., ABCD) (traditional):");
        String rotInput = scanner.nextLine();
        System.out.println("Enter a rotation number:");
        int rotNum = Integer.parseInt(scanner.nextLine()) % rotInput.length();
        String rotString = rotInput + rotInput;
        String leftRot = rotString.substring(rotNum, rotNum + rotInput.length());
        String rightRot = rotString.substring(rotInput.length() - rotNum, 2 * rotInput.length() - rotNum);
        System.out.println("Left Rotation: " + leftRot);
        System.out.println("Right Rotation: " + rightRot);
        
        scanner.close();
    }

    // Helper method to check if a string is a palindrome (traditional).
    public static boolean isPalindrome(String s) {
        int left = 0, right = s.length() - 1;
        while (left < right) {
            if (s.charAt(left) != s.charAt(right))
                return false;
            left++;
            right--;
        }
        return true;
    }
}