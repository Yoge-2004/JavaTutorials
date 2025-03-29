package com.example.listdemo;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.ListIterator;
import java.util.stream.Collectors;

public class ListOperationsDemo {
    private List<Integer> numbers;
    private List<String> words;
    private List<String> sentences;

    public ListOperationsDemo(List<Integer> numbers, List<String> words, List<String> sentences) {
        this.numbers = numbers;
        this.words = words;
        this.sentences = sentences;
    }

    public void performOperations() {
        processNumbers();
        processWords();
        processSentences();
    }

    private void processNumbers() {
        System.out.println("\nOriginal numbers: " + numbers);

        // Reverse digits of each number
        List<Integer> reversedNumbers = numbers.stream()
            .map(String::valueOf)
            .map(StringBuilder::new)
            .map(StringBuilder::reverse)
            .map(String::valueOf)
            .map(Integer::parseInt)
            .collect(Collectors.toList());
        System.out.println("Numbers with reversed digits: " + reversedNumbers);

        // Sort numbers by sum of digits
        List<Integer> sortedByDigitSum = numbers.stream()
            .sorted(new DigitSumComparator())
            .collect(Collectors.toList());
        System.out.println("Numbers sorted by digit sum: " + sortedByDigitSum);

        // Filter non-negative numbers
        List<Integer> nonNegativeNumbers = numbers.stream()
            .filter(n -> n >= 0)
            .collect(Collectors.toList());
        System.out.println("Non-negative numbers (using stream): " + nonNegativeNumbers);

        // Remove negative numbers using ListIterator
        List<Integer> filteredNumbers = new ArrayList<>(numbers);
        ListIterator<Integer> iterator = filteredNumbers.listIterator();
        while (iterator.hasNext()) {
            if (iterator.next() < 0) {
                iterator.remove();
            }
        }
        System.out.println("Numbers after removing negatives (using ListIterator): " + filteredNumbers);
    }

    private void processWords() {
        System.out.println("\nOriginal words: " + words);

        // Sort words in descending lexicographical order
        List<String> sortedWordsDescending = words.stream()
            .sorted((a, b) -> -a.compareTo(b))
            .collect(Collectors.toList());
        System.out.println("Words in descending order: " + sortedWordsDescending);

        // Count words starting with 'A'
        long countWordsStartingWithA = words.stream()
            .filter(word -> word.startsWith("A"))
            .count();
        System.out.println("Words starting with 'A': " + countWordsStartingWithA);

        // Find the longest word
        String longestWord = words.stream()
            .sorted(Comparator.comparingInt(String::length))
            .skip(words.size() - 1)
            .findFirst()
            .orElse("");
        System.out.println("Longest word: " + longestWord);
    }

    private void processSentences() {
        System.out.println("\nOriginal sentences: " + sentences);

        // Sort sentences by word count
        List<String> sortedSentences = sentences.stream()
            .sorted(new WordCountComparator())
            .collect(Collectors.toList());
        System.out.println("Sentences sorted by word count: " + sortedSentences);
    }
}