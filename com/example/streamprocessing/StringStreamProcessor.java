package com.example.streamprocessing;

import java.util.*;
import java.util.regex.*;
import java.util.stream.*;

public class StringStreamProcessor {
    public static void main(String[] args) {
        // Original string to be processed.
        String originalString = "Hello to Java Programming ___1234";

        // Convert the original string into a stream of characters and reassemble it.
        String reassembledString = originalString.chars()
                .mapToObj(ch -> String.valueOf((char) ch))
                .collect(Collectors.joining());

        // Count the number of digit characters in the reassembled string.
        long numDigits = reassembledString.chars()
                .mapToObj(ch -> (char) ch)
                .filter(Character::isDigit)
                .count();
        System.out.println("Digit Count = " + numDigits);

        // Count the number of alphabetic characters (letters) in the reassembled string.
        long numLetters = reassembledString.chars()
                .mapToObj(ch -> (char) ch)
                .filter(Character::isLetter)
                .count();
        System.out.println("Letters Count = " + numLetters);

        // Count the number of uppercase letters in the reassembled string.
        long numUppercaseLetters = reassembledString.chars()
                .mapToObj(ch -> (char) ch)
                .filter(Character::isUpperCase)
                .count();
        System.out.println("Uppercase Letters Count = " + numUppercaseLetters);

        // Count the number of lowercase letters in the reassembled string.
        long numLowercaseLetters = reassembledString.chars()
                .mapToObj(ch -> (char) ch)
                .filter(Character::isLowerCase)
                .count();
        System.out.println("Lowercase Letters Count = " + numLowercaseLetters);

        // Create a Scanner for reading user input.
        Scanner inputScanner = new Scanner(System.in);
        System.out.println("Enter the string separated by spaces: ");
        // Split the user input into words.
        String[] inputWords = Arrays.stream(inputScanner.nextLine().split("\\s+"))
                .toArray(String[]::new);
        System.out.println();

        // Determine the maximum length among palindromic words (case-insensitive).
        int maxPalindromeLength = Arrays.stream(inputWords)
                .map(String::toLowerCase)
                .filter(StringStreamProcessor::isPalindrome)
                .mapToInt(String::length)
                .max()
                .orElse(0);

        // Find all palindromic words having the maximum length.
        List<String> palindromesWithMaxLength = Arrays.stream(inputWords)
                .parallel()
                .peek(System.out::println) // Debug: print each word.
                .map(String::toLowerCase)
                .filter(StringStreamProcessor::isPalindrome)
                .sorted((a, b) -> b.length() - a.length()) // Sort in descending order.
                .filter(word -> word.length() == maxPalindromeLength)
                .toList();
        System.out.println("Longest Palindrome(s) = " + palindromesWithMaxLength);

        // Generate a random string of 30 uppercase letters.
        Random randomGenerator = new Random();
        String randomUppercaseString = IntStream.generate(() -> randomGenerator.nextInt(26) + 'A')
                .limit(30)
                .mapToObj(ch -> (char) ch)
                .map(String::valueOf)
                .collect(Collectors.joining());

        // Print the generated random string.
        randomUppercaseString.chars()
                .mapToObj(ch -> (char) ch)
                .forEach(System.out::print);
        System.out.println();

        // Check if the generated string contains all 26 letters (case-insensitive).
        long distinctLettersCount = randomUppercaseString.chars()
                .mapToObj(ch -> (char) ch)
                .map(Character::toLowerCase)
                .filter(Character::isLetter)
                .distinct()
                .count();
        System.out.println(distinctLettersCount == 26);

        // Remove all occurrences of the character 'a' from "Hello Java".
        String helloJavaString = "Hello Java";
        char charToRemove = 'a';
        helloJavaString = helloJavaString.chars()
                .mapToObj(ch -> (char) ch)
                .filter(ch -> ch != charToRemove)
                .map(String::valueOf)
                .collect(Collectors.joining());
        System.out.println(helloJavaString);

        // Build a frequency map for each character in helloJavaString.
        Map<Character, Integer> charFrequencyMap = new LinkedHashMap<>();
        for (Character ch : helloJavaString.toCharArray()) {
            charFrequencyMap.put(ch, charFrequencyMap.getOrDefault(ch, 0) + 1);
        }

        // Find and print the most frequent character.
        Optional<Character> mostFreqChar = 
                charFrequencyMap.entrySet().stream()
                .max(Map.Entry.comparingByValue())
                .map(Map.Entry::getKey);
        mostFreqChar.ifPresent(System.out::println);

        // Find and print the least frequent character.
        Optional<Character> leastFreqChar =
                charFrequencyMap.entrySet().stream()
                .min(Map.Entry.comparingByValue())
                .map(Map.Entry::getKey);
        leastFreqChar.ifPresent(System.out::println);

        // Decompress a string in the format "A2B3C4D1" into "AABBBCCCCD".
        String compressedSequence = "A2B3C4D1";
        String expandedSequence = IntStream.range(0, compressedSequence.length() / 2)
                .mapToObj(i -> String.valueOf(compressedSequence.charAt(2 * i))
                        .repeat(Character.getNumericValue(compressedSequence.charAt(2 * i + 1))))
                .collect(Collectors.joining());
        System.out.println(expandedSequence);

        // Split a sample sentence into words and identify the longest and shortest words.
        String sampleSentence = "Hello to Java Programming";
        String[] sentenceWords = sampleSentence.split("\\s+");
        String longestWordInSentence = Arrays.stream(sentenceWords)
                .max(Comparator.comparingInt(String::length))
                .orElse("");
        String shortestWordInSentence = Arrays.stream(sentenceWords)
                .min(Comparator.comparingInt(String::length))
                .orElse("");
        System.out.println(longestWordInSentence);
        System.out.println(shortestWordInSentence);

        // Capitalize the first letter of each word in a title.
        String rawTitle = "oracle java";
        String formattedTitle = Arrays.stream(rawTitle.split("\\s+"))
                .map(word -> word.substring(0, 1).toUpperCase() + word.substring(1))
                .collect(Collectors.joining(" "));
        System.out.println(formattedTitle);

        // Print characters from helloJavaString that occur exactly once.
        charFrequencyMap.entrySet().stream()
                .filter(entry -> entry.getValue() == 1)
                .map(Map.Entry::getKey)
                .forEach(System.out::print);
        System.out.println();

        // Print distinct characters from the formatted title.
        formattedTitle.chars()
                .mapToObj(ch -> (char) ch)
                .distinct()
                .forEach(System.out::print);
        System.out.println();

        // Print duplicate characters from helloJavaString.
        charFrequencyMap.entrySet().stream()
                .filter(entry -> entry.getValue() > 1)
                .map(Map.Entry::getKey)
                .forEach(System.out::print);
        System.out.println();

        // Print the character with the minimum frequency.
        charFrequencyMap.entrySet().stream()
                .min(Comparator.comparingInt(Map.Entry::getValue))
                .map(Map.Entry::getKey)
                .ifPresent(System.out::println);

        // Identify and print the first unique character.
        char firstUniqueChar = charFrequencyMap.entrySet().stream()
                .filter(entry -> entry.getValue() == 1)
                .limit(1)
                .map(Map.Entry::getKey)
                .findFirst()
                .orElse('\0');
        // Identify and print the first duplicate character.
        char firstDuplicateChar = charFrequencyMap.entrySet().stream()
                .filter(entry -> entry.getValue() > 1)
                .limit(1)
                .map(Map.Entry::getKey)
                .findFirst()
                .orElse('\0');
        System.out.println(firstUniqueChar);
        System.out.println(firstDuplicateChar);

        // Reverse the order of words in the sample sentence.
        List<String> sentenceWordsList = new ArrayList<>(Arrays.asList(sentenceWords));
        Collections.reverse(sentenceWordsList);
        String reversedSentenceOrder = String.join(" ", sentenceWordsList);
        System.out.println(reversedSentenceOrder);

        // Reverse each individual word using StringBuffer.
        Collections.reverse(sentenceWordsList); // Restore original order.
        sentenceWordsList.stream()
                .map(StringBuffer::new)
                .map(StringBuffer::reverse)
                .forEach(System.out::print);
        System.out.println();

        // Decompress a complex string with segments like "2{ABC} 3{XYZ}, 5{DEF}".
        String compressedWordSegments = "2{ABC} 3{XYZ}, 5{DEF}";
        Pattern segmentPattern = Pattern.compile("(\\d+)\\{(.*?)\\}");
        Matcher segmentMatcher = segmentPattern.matcher(compressedWordSegments);
        while (segmentMatcher.find()) {
            for (int i = 1; i <= Integer.parseInt(segmentMatcher.group(1)); i++) {
                System.out.print(segmentMatcher.group(2) + " ");
            }
            System.out.println();
        }

        // Normalize a number string with leading zeros.
        String numberStringWithLeadingZeros = "00001234";
        String normalizedNumberString = String.valueOf(Integer.valueOf(numberStringWithLeadingZeros));
        System.out.println(normalizedNumberString);

        // Print words with an even number of characters.
        sentenceWordsList.stream()
                .filter(wordStr -> wordStr.length() % 2 == 0)
                .forEach(System.out::println);

        // Print words with an odd number of characters.
        sentenceWordsList.stream()
                .filter(wordStr -> wordStr.length() % 2 == 1)
                .forEach(System.out::println);

        // Swap adjacent characters in the word "Java".
        String swappableWord = "Java";
        char[] swappableWordChars = swappableWord.toCharArray();
        for (int i = 0; i < swappableWordChars.length - 1; i += 2) {
            char temp = swappableWordChars[i];
            swappableWordChars[i] = swappableWordChars[i + 1];
            swappableWordChars[i + 1] = temp;
        }
        swappableWord = new String(swappableWordChars);
        System.out.println(swappableWord);

        // Partition the string "aaaabbbbcccc" into 3 equal parts.
        String partitionString = "aaaabbbbcccc";
        int numParts = 3;
        int partLength = partitionString.length() / numParts;
        IntStream.range(0, numParts)
                .mapToObj(i -> partitionString.substring(i * partLength, partLength * (i + 1)))
                .forEach(System.out::println);

        // Compute a result based on differences between counts of '0', '1', and '2' in a number pattern.
        String numberPatternString = "102100211";
        HashMap<String, Integer> patternCountMap = new HashMap<>();
        patternCountMap.put("0,0", 1);
        int zeroCount = 0, oneCount = 0, twoCount = 0, patternResult = 0;
        for (char ch : numberPatternString.toCharArray()) {
            if (ch == '0') {
                zeroCount++;
            } else if (ch == '1') {
                oneCount++;
            } else if (ch == '2') {
                twoCount++;
            }
            String key = (zeroCount - oneCount) + "," + (zeroCount - twoCount);
            patternResult += patternCountMap.getOrDefault(key, 0);
            patternCountMap.put(key, patternCountMap.getOrDefault(key, 0) + 1);
        }
        System.out.println(patternResult);

        // Close the scanner.
        inputScanner.close();
    }

    // Helper method to determine if a given string is a palindrome.
    public static boolean isPalindrome(String word) {
        return word.equals(new StringBuilder(word).reverse().toString());
    }
}