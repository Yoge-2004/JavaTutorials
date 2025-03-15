package com.example.streamprocessing;

import java.util.*;
import java.util.function.Function;
import java.util.regex.*;
import java.util.stream.*;

public class StringStreamProcessor {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Basic analysis using streams
        System.out.println("Enter a string for basic analysis (using streams):");
        String input = scanner.nextLine();
        long digitCount = input.chars().filter(Character::isDigit).count();
        long letterCount = input.chars().filter(Character::isLetter).count();
        long upperCount = input.chars().filter(Character::isUpperCase).count();
        long lowerCount = input.chars().filter(Character::isLowerCase).count();
        System.out.println("Digits: " + digitCount);
        System.out.println("Letters: " + letterCount);
        System.out.println("Uppercase: " + upperCount);
        System.out.println("Lowercase: " + lowerCount);
        System.out.println();

        // Palindrome detection using streams
        System.out.println("Enter words (separated by spaces) for palindrome detection:");
        String wordsInput = scanner.nextLine();
        String[] words = wordsInput.split("\\s+");
        int maxPalLength = Arrays.stream(words)
            .map(String::toLowerCase)
            .filter(StringStreamProcessor::isPalindrome)
            .mapToInt(String::length)
            .max()
            .orElse(0);
        List<String> longestPalindromes = Arrays.stream(words)
            .map(String::toLowerCase)
            .filter(s -> s.length() == maxPalLength && isPalindrome(s))
            .collect(Collectors.toList());
        System.out.println("Longest palindrome(s) with length " + maxPalLength + ": " + longestPalindromes);
        System.out.println();

        // Random uppercase string generation using streams
        System.out.println("Random uppercase string (30 characters):");
        String randomUpper = IntStream.generate(() -> new Random().nextInt(26) + 'A')
            .limit(30)
            .mapToObj(c -> String.valueOf((char)c))
            .collect(Collectors.joining());
        System.out.println(randomUpper);
        long distinctCount = randomUpper.chars()
            .map(Character::toLowerCase)
            .filter(Character::isLetter)
            .distinct()
            .count();
        System.out.println("Contains all 26 letters? " + (distinctCount == 26));
        System.out.println();

        // Frequency analysis using streams
        System.out.println("Enter a string for frequency analysis (using streams):");
        String freqInput = scanner.nextLine();
        System.out.println("Enter a character to remove:");
        char remChar = scanner.nextLine().charAt(0);
        String modified = freqInput.chars()
            .mapToObj(c -> (char)c)
            .filter(ch -> ch != remChar)
            .map(String::valueOf)
            .collect(Collectors.joining());
        System.out.println("Modified string after removing '" + remChar + "': " + modified);
        Map<Character, Long> freqMap = modified.chars()
            .mapToObj(c -> (char)c)
            .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        freqMap.forEach((k, v) -> System.out.println("Character: " + k + ", Count: " + v));
        System.out.println();

        // Decompress a compressed sequence using streams
        System.out.println("Enter a compressed sequence (e.g., A2B3C4D1):");
        String compSeq = scanner.nextLine();
        String decompressed = IntStream.range(0, compSeq.length() / 2)
            .mapToObj(i -> String.valueOf(compSeq.charAt(2 * i))
                    .repeat(Character.getNumericValue(compSeq.charAt(2 * i + 1))))
            .collect(Collectors.joining());
        System.out.println("Decompressed sequence: " + decompressed);
        System.out.println();

        // Word analysis (longest and shortest) using streams
        System.out.println("Enter a sentence for word analysis:");
        String sentence = scanner.nextLine();
        String[] sentWords = sentence.split("\\s+");
        String longestWord = Arrays.stream(sentWords)
            .max(Comparator.comparingInt(String::length))
            .orElse("");
        String shortestWord = Arrays.stream(sentWords)
            .min(Comparator.comparingInt(String::length))
            .orElse("");
        System.out.println("Longest word: " + longestWord);
        System.out.println("Shortest word: " + shortestWord);
        System.out.println();

        // Title formatting using streams
        System.out.println("Enter a title for formatting:");
        String title = scanner.nextLine();
        String formattedTitle = Arrays.stream(title.split("\\s+"))
            .map(word -> word.substring(0, 1).toUpperCase() + word.substring(1).toLowerCase())
            .collect(Collectors.joining(" "));
        System.out.println("Formatted Title: " + formattedTitle);
        System.out.println();

        // Unique and duplicate characters using streams
        System.out.println("Enter a string for unique/duplicate analysis:");
        String uniqueDup = scanner.nextLine();
        Map<Character, Long> charFreq = uniqueDup.chars()
            .mapToObj(c -> (char)c)
            .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        String uniqueChars = charFreq.entrySet().stream()
            .filter(e -> e.getValue() == 1)
            .map(e -> e.getKey().toString())
            .collect(Collectors.joining());
        String duplicateChars = charFreq.entrySet().stream()
            .filter(e -> e.getValue() > 1)
            .map(e -> e.getKey().toString())
            .collect(Collectors.joining());
        System.out.println("Unique characters: " + uniqueChars);
        System.out.println("Duplicate characters: " + duplicateChars);
        System.out.println();

        // Reverse sentence: reverse word order and reverse each word using streams
        System.out.println("Enter a sentence to reverse its word order and to reverse each word:");
        String revSentence = scanner.nextLine();
        String[] revWords = revSentence.split("\\s+");
        List<String> reversedOrder = Arrays.asList(revWords);
        Collections.reverse(reversedOrder);
        System.out.println("Reversed word order: " + String.join(" ", reversedOrder));
        String eachWordReversed = Arrays.stream(revWords)
            .map(word -> new StringBuilder(word).reverse().toString())
            .collect(Collectors.joining(" "));
        System.out.println("Each word reversed: " + eachWordReversed);
        System.out.println();

        // Complex decompression using regex (stream not needed here)
        System.out.println("Enter a complex compressed segment (e.g., '2{ABC} 3{XYZ}, 5{DEF}'):");
        String complexComp = scanner.nextLine();
        Pattern pat = Pattern.compile("(\\d+)\\{(.*?)\\}");
        Matcher matcher = pat.matcher(complexComp);
        System.out.println("Decompressed segments:");
        while (matcher.find()) {
            int cnt = Integer.parseInt(matcher.group(1));
            String seg = matcher.group(2);
            String expandedSeg = IntStream.range(0, cnt)
                .mapToObj(i -> seg)
                .collect(Collectors.joining(" "));
            System.out.println(expandedSeg);
        }
        System.out.println();

        // Number normalization (using minimal built-in conversion)
        System.out.println("Enter a number string with leading zeros:");
        String numStr = scanner.nextLine();
        String normNum = String.valueOf(Integer.valueOf(numStr));
        System.out.println("Normalized number: " + normNum);
        System.out.println();

        // Even and odd length words using streams
        System.out.println("Enter a sentence to separate even and odd length words:");
        String evenOddSentence = scanner.nextLine();
        String[] evenOddWords = evenOddSentence.split("\\s+");
        List<String> evenWords = Arrays.stream(evenOddWords)
            .filter(w -> w.length() % 2 == 0)
            .collect(Collectors.toList());
        List<String> oddWords = Arrays.stream(evenOddWords)
            .filter(w -> w.length() % 2 == 1)
            .collect(Collectors.toList());
        System.out.println("Even length words: " + evenWords);
        System.out.println("Odd length words: " + oddWords);
        System.out.println();

        // Swap adjacent characters using streams
        System.out.println("Enter a word to swap adjacent characters:");
        String swapWord = scanner.nextLine();
        String swapped = IntStream.range(0, swapWord.length())
            .mapToObj(i -> {
                if (i % 2 == 0) {
                    return (i + 1 < swapWord.length()) ? swapWord.charAt(i + 1) : swapWord.charAt(i);
                } else {
                    return swapWord.charAt(i - 1);
                }
            })
            .collect(StringBuilder::new, StringBuilder::append, StringBuilder::append)
            .toString();
        System.out.println("Swapped word: " + swapped);
        System.out.println();

        // Partition a string using streams
        System.out.println("Enter a string to partition:");
        String partString = scanner.nextLine();
        System.out.println("Enter number of parts to partition into:");
        int parts = Integer.parseInt(scanner.nextLine());
        int partLen = partString.length() / parts;
        List<String> partitions = IntStream.range(0, parts)
            .mapToObj(i -> partString.substring(i * partLen, (i + 1) * partLen))
            .collect(Collectors.toList());
        System.out.println("Partitions: " + partitions);
        System.out.println();

        // Pattern computation (using a loop as stream conversion is nontrivial)
        System.out.println("Enter a number pattern string (digits 0, 1, 2) for computation:");
        String patternInput = scanner.nextLine();
        HashMap<String, Integer> patternMap = new HashMap<>();
        patternMap.put("0,0", 1);
        int count0 = 0, count1 = 0, count2 = 0, patternResult = 0;
        for (char c : patternInput.toCharArray()) {
            if (c == '0') count0++;
            else if (c == '1') count1++;
            else if (c == '2') count2++;
            String key = (count0 - count1) + "," + (count0 - count2);
            patternResult += patternMap.getOrDefault(key, 0);
            patternMap.put(key, patternMap.getOrDefault(key, 0) + 1);
        }
        System.out.println("Pattern computation result: " + patternResult);
        System.out.println();

        // Abbreviation extraction using streams
        System.out.println("Enter a string for abbreviation extraction (uppercase letters only):");
        String abbrevInput = scanner.nextLine();
        String abbreviation = abbrevInput.chars()
            .mapToObj(c -> (char)c)
            .filter(ch -> ch >= 'A' && ch <= 'Z')
            .map(String::valueOf)
            .collect(Collectors.joining());
        System.out.println("Abbreviation: " + abbreviation);
        System.out.println();

        // String rotation using substring operations
        System.out.println("Enter a string for rotation (e.g., ABCD):");
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

    // Helper method to check if a string is a palindrome.
    public static boolean isPalindrome(String s) {
        return s.equals(new StringBuilder(s).reverse().toString());
    }
}