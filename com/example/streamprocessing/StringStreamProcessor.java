package com.example.streamprocessing;

import java.util.*;
import java.util.regex.*;
import java.util.stream.*;

public class StringStreamProcessor {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Basic String Analysis: Count digits, letters, uppercase and lowercase characters.
        System.out.println("Enter a string for basic analysis (digits, letters, case counts):");
        String basicInput = scanner.nextLine();
        long basicDigits = basicInput.chars().filter(Character::isDigit).count();
        long basicLetters = basicInput.chars().filter(Character::isLetter).count();
        long basicUppercase = basicInput.chars().filter(Character::isUpperCase).count();
        long basicLowercase = basicInput.chars().filter(Character::isLowerCase).count();
        System.out.println("Basic Analysis Results:");
        System.out.println("  Digits: " + basicDigits);
        System.out.println("  Letters: " + basicLetters);
        System.out.println("  Uppercase letters: " + basicUppercase);
        System.out.println("  Lowercase letters: " + basicLowercase);
        System.out.println();

        // Palindrome Detection: Get words and find the longest palindromic word(s).
        System.out.println("Enter words separated by spaces for palindrome detection:");
        String palindromeInput = scanner.nextLine();
        String[] palindromeWords = palindromeInput.split("\\s+");
        int maxPalindromeLength = Arrays.stream(palindromeWords)
                .map(String::toLowerCase)
                .filter(StringStreamProcessor::isPalindrome)
                .mapToInt(String::length)
                .max()
                .orElse(0);
        List<String> longestPalindromes = Arrays.stream(palindromeWords)
                .map(String::toLowerCase)
                .filter(StringStreamProcessor::isPalindrome)
                .filter(word -> word.length() == maxPalindromeLength)
                .toList();
        System.out.println("Longest palindrome(s) of length " + maxPalindromeLength + ": " + longestPalindromes);
        System.out.println();

        // Random Uppercase String Generation: Generate a string of 30 random uppercase letters.
        Random random = new Random();
        String randomUppercase = IntStream.generate(() -> random.nextInt(26) + 'A')
                .limit(30)
                .mapToObj(ch -> String.valueOf((char) ch))
                .collect(Collectors.joining());
        System.out.println("Random uppercase string: " + randomUppercase);
        long distinctLetters = randomUppercase.chars()
                .map(Character::toLowerCase)
                .filter(Character::isLetter)
                .distinct()
                .count();
        System.out.println("Contains all 26 letters? " + (distinctLetters == 26));
        System.out.println();

        // Remove Character and Frequency Analysis: Remove a character from a string and analyze frequency.
        System.out.println("Enter a string for frequency analysis:");
        String freqInput = scanner.nextLine();
        System.out.println("Enter a character to remove from the string:");
        char removeChar = scanner.nextLine().charAt(0);
        String modifiedString = freqInput.chars()
                .mapToObj(ch -> String.valueOf((char) ch))
                .filter(s -> s.charAt(0) != removeChar)
                .collect(Collectors.joining());
        System.out.println("String after removing '" + removeChar + "': " + modifiedString);
        Map<Character, Integer> freqMap = new LinkedHashMap<>();
        for (char c : modifiedString.toCharArray()) {
            freqMap.put(c, freqMap.getOrDefault(c, 0) + 1);
        }
        Optional<Character> mostFreq = freqMap.entrySet().stream()
                .max(Map.Entry.comparingByValue())
                .map(Map.Entry::getKey);
        Optional<Character> leastFreq = freqMap.entrySet().stream()
                .min(Map.Entry.comparingByValue())
                .map(Map.Entry::getKey);
        System.out.println("Most frequent character: " + (mostFreq.isPresent() ? mostFreq.get() : "None"));
        System.out.println("Least frequent character: " + (leastFreq.isPresent() ? leastFreq.get() : "None"));
        System.out.println();

        // Decompress a Compressed Sequence: Expand a sequence like "A2B3C4D1" into its full form.
        System.out.println("Enter a compressed sequence (format like A2B3C4D1):");
        String compressedSequence = scanner.nextLine();
        String decompressedSequence = IntStream.range(0, compressedSequence.length() / 2)
                .mapToObj(i -> String.valueOf(compressedSequence.charAt(2 * i))
                        .repeat(Character.getNumericValue(compressedSequence.charAt(2 * i + 1))))
                .collect(Collectors.joining());
        System.out.println("Decompressed sequence: " + decompressedSequence);
        System.out.println();

        // Sentence Word Analysis: Identify the longest and shortest words in a sentence.
        System.out.println("Enter a sentence for word analysis:");
        String sentenceInput = scanner.nextLine();
        String[] sentenceWords = sentenceInput.split("\\s+");
        String longestWord = Arrays.stream(sentenceWords)
                .max(Comparator.comparingInt(String::length))
                .orElse("");
        String shortestWord = Arrays.stream(sentenceWords)
                .min(Comparator.comparingInt(String::length))
                .orElse("");
        System.out.println("Longest word: " + longestWord);
        System.out.println("Shortest word: " + shortestWord);
        System.out.println();

        // Title Formatting: Capitalize the first letter of each word.
        System.out.println("Enter a title to format (each word's first letter will be capitalized):");
        String titleInput = scanner.nextLine();
        String formattedTitle = Arrays.stream(titleInput.split("\\s+"))
                .map(word -> word.substring(0, 1).toUpperCase() + word.substring(1))
                .collect(Collectors.joining(" "));
        System.out.println("Formatted Title: " + formattedTitle);
        System.out.println();

        // Unique and Duplicate Characters Analysis: Display characters occurring once and more than once.
        System.out.println("Enter a string to analyze unique and duplicate characters:");
        String uniqueDupInput = scanner.nextLine();
        Map<Character, Integer> uniqueDupMap = new LinkedHashMap<>();
        for (char c : uniqueDupInput.toCharArray()) {
            uniqueDupMap.put(c, uniqueDupMap.getOrDefault(c, 0) + 1);
        }
        String uniqueChars = uniqueDupMap.entrySet().stream()
                .filter(e -> e.getValue() == 1)
                .map(e -> String.valueOf(e.getKey()))
                .collect(Collectors.joining());
        String duplicateChars = uniqueDupMap.entrySet().stream()
                .filter(e -> e.getValue() > 1)
                .map(e -> String.valueOf(e.getKey()))
                .collect(Collectors.joining());
        System.out.println("Unique characters: " + uniqueChars);
        System.out.println("Duplicate characters: " + duplicateChars);
        uniqueDupMap.entrySet().stream()
                .min(Comparator.comparingInt(Map.Entry::getValue))
                .ifPresent(e -> System.out.println("Character with minimum frequency: " + e.getKey()));
        char firstUnique = uniqueDupMap.entrySet().stream()
                .filter(e -> e.getValue() == 1)
                .map(Map.Entry::getKey)
                .findFirst().orElse('\0');
        char firstDuplicate = uniqueDupMap.entrySet().stream()
                .filter(e -> e.getValue() > 1)
                .map(Map.Entry::getKey)
                .findFirst().orElse('\0');
        System.out.println("First unique character: " + firstUnique);
        System.out.println("First duplicate character: " + firstDuplicate);
        System.out.println();

        // Reverse Sentence Words Order and Reverse Each Word: Process a sentence in two ways.
        System.out.println("Enter a sentence to reverse its word order and to reverse each individual word:");
        String reverseSentenceInput = scanner.nextLine();
        String[] reverseWords = reverseSentenceInput.split("\\s+");
        List<String> reverseList = new ArrayList<>(Arrays.asList(reverseWords));
        Collections.reverse(reverseList);
        System.out.println("Sentence with reversed word order: " + String.join(" ", reverseList));
        String reversedEachWord = Arrays.stream(reverseWords)
                .map(word -> new StringBuilder(word).reverse().toString())
                .collect(Collectors.joining(" "));
        System.out.println("Sentence with each word reversed: " + reversedEachWord);
        System.out.println();

        // Decompress Complex Segments: Expand segments from a complex compressed string.
        System.out.println("Enter a compressed segment string (format like '2{ABC} 3{XYZ}, 5{DEF}'):");
        String complexCompressedInput = scanner.nextLine();
        Pattern pattern = Pattern.compile("(\\d+)\\{(.*?)\\}");
        Matcher matcher = pattern.matcher(complexCompressedInput);
        System.out.println("Decompressed segments:");
        while (matcher.find()) {
            String segment = matcher.group(2);
            int count = Integer.parseInt(matcher.group(1));
            for (int i = 0; i < count; i++) {
                System.out.print(segment + " ");
            }
            System.out.println();
        }
        System.out.println();

        // Number String Normalization: Remove leading zeros from a numeric string.
        System.out.println("Enter a number string with possible leading zeros:");
        String numStringInput = scanner.nextLine();
        String normalizedNumString = String.valueOf(Integer.valueOf(numStringInput));
        System.out.println("Normalized number string: " + normalizedNumString);
        System.out.println();

        // Even and Odd Length Words: Display words with even and odd character counts.
        System.out.println("Enter a sentence to display words with even and odd number of characters:");
        String evenOddSentence = scanner.nextLine();
        String[] evenOddWords = evenOddSentence.split("\\s+");
        System.out.println("Words with even number of characters:");
        Arrays.stream(evenOddWords).filter(word -> word.length() % 2 == 0).forEach(System.out::println);
        System.out.println("Words with odd number of characters:");
        Arrays.stream(evenOddWords).filter(word -> word.length() % 2 == 1).forEach(System.out::println);
        System.out.println();

        // Swap Adjacent Characters: Swap adjacent characters in a provided word.
        System.out.println("Enter a word to swap its adjacent characters:");
        String swapInput = scanner.nextLine();
        char[] swapChars = swapInput.toCharArray();
        for (int i = 0; i < swapChars.length - 1; i += 2) {
            char temp = swapChars[i];
            swapChars[i] = swapChars[i + 1];
            swapChars[i + 1] = temp;
        }
        String swappedResult = new String(swapChars);
        System.out.println("Result after swapping adjacent characters: " + swappedResult);
        System.out.println();

        // Partition a String: Partition a string into a specified number of equal parts.
        System.out.println("Enter a string to partition:");
        String partitionInput = scanner.nextLine();
        System.out.println("Enter the number of equal parts to partition the string into:");
        int partitionParts = Integer.parseInt(scanner.nextLine());
        int partitionLength = partitionInput.length() / partitionParts;
        System.out.println("Partitioned parts:");
        IntStream.range(0, partitionParts)
                .mapToObj(i -> partitionInput.substring(i * partitionLength, partitionLength * (i + 1)))
                .forEach(System.out::println);
        System.out.println();

        // Compute Pattern Result: Compute a result based on differences between counts of '0', '1', and '2'.
        System.out.println("Enter a number pattern string (consisting of digits 0, 1, 2) for pattern computation:");
        String patternInput = scanner.nextLine();
        HashMap<String, Integer> patternMap = new HashMap<>();
        patternMap.put("0,0", 1);
        int count0 = 0, count1 = 0, count2 = 0, patternRes = 0;
        for (char ch : patternInput.toCharArray()) {
            if (ch == '0') count0++;
            else if (ch == '1') count1++;
            else if (ch == '2') count2++;
            String key = (count0 - count1) + "," + (count0 - count2);
            patternRes += patternMap.getOrDefault(key, 0);
            patternMap.put(key, patternMap.getOrDefault(key, 0) + 1);
        }
        System.out.println("Pattern computation result: " + patternRes);
        System.out.println();

        // Abbreviation Extraction: Extract and display only uppercase letters from a string.
        System.out.println("Enter a string for abbreviation extraction (only uppercase letters will be kept):");
        String abbreviationInput = scanner.nextLine();
        String abbreviation = abbreviationInput.chars()
                .mapToObj(ch -> (char) ch)
                .filter(ch -> ch >= 'A' && ch <= 'Z')
                .map(String::valueOf)
                .collect(Collectors.joining());
        System.out.println("Abbreviation: " + abbreviation);
        System.out.println();

        // String Rotation: Rotate a string left and right based on a provided number.
        System.out.println("Enter a string for rotation (e.g., ABCD):");
        String rotationInput = scanner.nextLine();
        System.out.println("Enter a number for rotation:");
        int rotationNumber = Integer.parseInt(scanner.nextLine()) % rotationInput.length();
        // Duplicate the string to simulate rotation.
        String rotationString = rotationInput + rotationInput;
        String leftRotated = rotationString.substring(rotationNumber, rotationNumber + rotationInput.length());
        String rightRotated = rotationString.substring(rotationInput.length() - rotationNumber, 2 * rotationInput.length() - rotationNumber);
        System.out.println("Left Rotation: " + leftRotated);
        System.out.println("Right Rotation: " + rightRotated);

        scanner.close();
    }

    // Helper method to check if a string is a palindrome.
    public static boolean isPalindrome(String word) {
        return word.equals(new StringBuilder(word).reverse().toString());
    }
}