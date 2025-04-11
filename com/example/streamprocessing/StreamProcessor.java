package com.example.streamprocessing;

import java.util.*;
import java.util.stream.*;

public class StreamProcessor {
    
    // -------------------- Entry Point --------------------
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // 1. Process a string to display its first non-repeated character
        displayFirstUniqueCharacter(scanner);

        // 2. Array processing: unique elements, intersection, and kth most frequent element
        List<Integer> primaryNumbers = readIntegerList(scanner, "first");
        displayUniqueNumbers(primaryNumbers);

        List<Integer> secondaryNumbers = readIntegerList(scanner, "second");
        displayListIntersection(new LinkedHashSet<>(primaryNumbers), secondaryNumbers);

        processKthFrequentNumbers(scanner, primaryNumbers);

        // 3. Process student data: entry and sorting using comparators
        System.out.print("Enter the number of student entries: ");
        int studentCount = scanner.nextInt();
        scanner.nextLine();  // Consume leftover newline
        List<Student> students = new ArrayList<>();

        System.out.println("----- Student Data Entry -----");
        for (int i = 0; i < studentCount; i++) {
            System.out.println("Enter details for Student " + (i + 1) + ": ");
            System.out.print("Enter student id: ");
            int id = scanner.nextInt();
            scanner.nextLine(); // Consume newline after integer input
            System.out.print("Enter student name: ");
            String name = scanner.nextLine();
            students.add(new Student(id, name));
        }

        System.out.println("\nBefore sorting (unsorted): ");
        printCollection(students);

        // Sort by id using the IdComparator
        Collections.sort(students, new IdComparator());
        System.out.println("\nAfter sorting by IdComparator: ");
        printCollection(students);

        // Sort by name using the NameComparator
        Collections.sort(students, new NameComparator());
        System.out.println("\nAfter sorting by NameComparator: ");
        printCollection(students);

        // 4. Frequency analysis on an integer array
        System.out.print("\nEnter the size of the array: ");
        int arraySize = scanner.nextInt();
        int[] numbersArray = new int[arraySize];

        System.out.print("Enter the array elements: ");
        for (int i = 0; i < arraySize; i++) {
            numbersArray[i] = scanner.nextInt();
        }

        SortedMap<Integer, Integer> frequencyMap = new TreeMap<>();
        Arrays.stream(numbersArray)
              .forEach(num -> frequencyMap.put(num, frequencyMap.getOrDefault(num, 0) + 1));

        System.out.println("\nElements occurred more than n/2 times:");
        frequencyMap.entrySet().stream()
                    .filter(entry -> entry.getValue() > (arraySize / 2))
                    .forEach(entry -> System.out.println("Element: " + entry.getKey()));

        System.out.println("\nElements occurred exactly twice:");
        frequencyMap.entrySet().stream()
                    .filter(entry -> entry.getValue() == 2)
                    .forEach(entry -> System.out.println("Element: " + entry.getKey()));

        // 5. Merge two predefined lists using Stream.concat
        List<Integer> listOne = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5));
        List<Integer> listTwo = new ArrayList<>(Arrays.asList(6, 7, 8, 9, 10));
        List<Integer> mergedList = Stream.concat(listOne.stream(), listTwo.stream())
                                         .collect(Collectors.toList());
        System.out.println("\nMerged List: ");
        System.out.println(mergedList);

        scanner.close();
    }

    // -------------------- String Processing --------------------
    // Reads a string and displays its first non-repeated character
    private static void displayFirstUniqueCharacter(Scanner scanner) {
        System.out.print("Enter the string: ");
        String input = scanner.nextLine();

        Map<Character, Integer> frequencyMap = new LinkedHashMap<>();
        input.chars()
             .mapToObj(ch -> (char) ch)
             .forEach(ch -> frequencyMap.put(ch, frequencyMap.getOrDefault(ch, 0) + 1));

        Character firstUnique = frequencyMap.entrySet().stream()
                                              .filter(entry -> entry.getValue() == 1)
                                              .map(Map.Entry::getKey)
                                              .findFirst()
                                              .orElse(null);

        System.out.println("First non-repeated character: " + (firstUnique != null ? firstUnique : "None"));
    }

    // -------------------- Array Processing --------------------
    // Reads a list of integers from the user
    private static List<Integer> readIntegerList(Scanner scanner, String label) {
        System.out.print("Enter the size of the " + label + " array: ");
        int size = scanner.nextInt();
        List<Integer> numbers = new ArrayList<>(size);
        System.out.println("Enter the elements for the " + label + " array:");
        for (int i = 0; i < size; i++) {
            numbers.add(scanner.nextInt());
        }
        return numbers;
    }

    // Displays unique numbers from the list
    private static void displayUniqueNumbers(List<Integer> numbers) {
        Set<Integer> uniqueNumbers = new LinkedHashSet<>(numbers);
        System.out.println("Unique Elements:");
        uniqueNumbers.forEach(System.out::println);
    }

    // Displays the intersection of a set and a list of integers
    private static void displayListIntersection(Set<Integer> uniqueSet, List<Integer> otherNumbers) {
        System.out.println("Intersection of the two lists:");
        uniqueSet.stream()
                 .filter(otherNumbers::contains)
                 .forEach(System.out::println);
    }

    // Processes and displays the kth most frequent number(s)
    private static void processKthFrequentNumbers(Scanner scanner, List<Integer> numbers) {
        System.out.print("Enter k for determining kth most frequent element: ");
        int k = scanner.nextInt();

        Map<Integer, Integer> numberFrequency = new HashMap<>();
        numbers.forEach(num -> numberFrequency.put(num, numberFrequency.getOrDefault(num, 0) + 1));

        List<Integer> frequencyRanks = numberFrequency.values().stream()
                                                      .distinct()
                                                      .sorted(Comparator.reverseOrder())
                                                      .collect(Collectors.toList());

        if (k <= 0 || k > frequencyRanks.size()) {
            System.out.println("Invalid value of k. There are only " + frequencyRanks.size() + " distinct frequency levels.");
            return;
        }
        int kthFrequency = frequencyRanks.get(k - 1);
        System.out.println("Elements with the " + k + "th most frequent count (" + kthFrequency + " occurrences):");
        numberFrequency.entrySet().stream()
                       .filter(entry -> entry.getValue() == kthFrequency)
                       .forEach(entry -> System.out.println(entry.getKey()));
    }

    // -------------------- Utility Method --------------------
    // A generic method to print any collection
    private static <T> void printCollection(Collection<T> collection) {
        collection.forEach(System.out::println);
    }
    
    // -------------------- Comparator Classes --------------------
    // Comparator for sorting students by their id
    static class IdComparator implements Comparator<Student> {
        @Override
        public int compare(Student s1, Student s2) {
            return s1.id - s2.id;
        }
    }

    // Comparator for sorting students by their name
    static class NameComparator implements Comparator<Student> {
        @Override
        public int compare(Student s1, Student s2) {
            return s1.name.compareTo(s2.name);
        }
    }
}

// -------------------- Student Class --------------------
class Student {
    int id;
    String name;
    
    public Student(int id, String name) {
        this.id = id;
        this.name = name;
    }
    
    @Override
    public String toString() {
        return String.format("Student { id = %d, name = %s }", id, name);
    }
}