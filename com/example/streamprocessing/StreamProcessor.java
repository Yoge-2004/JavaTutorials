package com.example.streamprocessing;

import java.util.*;
import java.util.stream.*;

public class StreamProcessor {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Process and display the first non-repeated character in a string
        processNonRepeatedCharacter(scanner);

        // Read the first array from the user and display its unique elements
        List<Integer> primaryList = readIntegerArray(scanner, "first");
        displayUniqueElements(primaryList);

        // Read the second array and display the intersection with the unique elements of the first array
        List<Integer> secondaryList = readIntegerArray(scanner, "second");
        displayIntersection(new LinkedHashSet<>(primaryList), secondaryList);

        // Process and display the kth most frequent element(s) from the first array
        processKthMostFrequent(scanner, primaryList);

        scanner.close();
    }

    // Reads a string from the user and displays the first non-repeated character
    private static void processNonRepeatedCharacter(Scanner scanner) {
        System.out.print("Enter the string: ");
        String inputString = scanner.nextLine();

        // Build a frequency map for each character, preserving insertion order
        Map<Character, Integer> charFrequencyMap = new LinkedHashMap<>();
        inputString.chars()
            .mapToObj(ch -> (char) ch)
            .forEach(ch -> charFrequencyMap.put(ch, charFrequencyMap.getOrDefault(ch, 0) + 1));

        // Find the first non-repeated character by filtering entries with frequency equal to 1
        Character nonRepeatedChar = charFrequencyMap.entrySet().stream()
            .sorted(Map.Entry.comparingByValue())
            .filter(entry -> entry.getValue() == 1)
            .map(Map.Entry::getKey)
            .findFirst()
            .orElse(null);

        System.out.println("First non-repeated character: " + (nonRepeatedChar != null ? nonRepeatedChar : "None"));
    }

    // Reads an array of integers from the user; 'arrayLabel' describes which array (e.g., "first", "second")
    private static List<Integer> readIntegerArray(Scanner scanner, String arrayLabel) {
        System.out.print("Enter the size of the " + arrayLabel + " array: ");
        int size = scanner.nextInt();

        List<Integer> integerList = new ArrayList<>(size);
        System.out.println("Enter the elements for the " + arrayLabel + " array:");
        IntStream.range(0, size)
            .forEach(index -> integerList.add(scanner.nextInt()));
        return integerList;
    }

    // Displays the unique elements from the given list
    private static void displayUniqueElements(List<Integer> integerList) {
        Set<Integer> uniqueElements = new LinkedHashSet<>(integerList);
        System.out.println("Unique Elements:");
        uniqueElements.forEach(System.out::println);
    }

    // Displays the intersection of a set and a list
    private static void displayIntersection(Set<Integer> uniqueSet, List<Integer> otherList) {
        System.out.println("Intersection of the two lists:");
        uniqueSet.stream()
            .filter(otherList::contains)
            .forEach(System.out::println);
    }

    // Processes and displays the kth most frequent element(s) from the provided list
    private static void processKthMostFrequent(Scanner scanner, List<Integer> integerList) {
        System.out.print("Enter k for determining kth most frequent element: ");
        int k = scanner.nextInt();

        // Build a frequency map for the elements
        Map<Integer, Integer> frequencyMap = new HashMap<>();
        integerList.forEach(num -> frequencyMap.put(num, frequencyMap.getOrDefault(num, 0) + 1));

        // Get distinct frequency values in descending order
        List<Integer> frequencyRankList = frequencyMap.values().stream()
            .distinct()
            .sorted(Comparator.reverseOrder())
            .collect(Collectors.toList());

        if (k <= 0 || k > frequencyRankList.size()) {
            System.out.println("Invalid value of k. There are only " + frequencyRankList.size() + " distinct frequency levels.");
            return;
        }

        int kthFrequency = frequencyRankList.get(k - 1);
        System.out.println("Elements with the " + k + "th most frequent count (" + kthFrequency + " occurrences):");

        // Display all elements that have the kth frequency
        frequencyMap.entrySet().stream()
            .filter(entry -> entry.getValue() == kthFrequency)
            .forEach(entry -> System.out.println(entry.getKey()));
    }
}
