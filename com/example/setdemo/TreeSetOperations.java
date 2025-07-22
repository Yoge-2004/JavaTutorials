package com.example.setdemo;
import java.util.*;

public class TreeSetOperations {
    public static void main(String[] args) {
        runTreeSetExample();
    }

    public static void runTreeSetExample() {
        // TreeSet in descending order
        TreeSet<Integer> set = new TreeSet<>(Comparator.reverseOrder());

        // Adding elements
        Collections.addAll(set, -1, 1, 3, 5, 7);

        System.out.println("TreeSet (Descending Order):");
        System.out.println(set);

        int target = 2;
        System.out.println("\n--- Navigation Methods ---");
        System.out.println("Ceiling (" + target + "): " + set.ceiling(target));
        System.out.println("Floor (" + target + "): " + set.floor(target));
        System.out.println("Lower (" + target + "): " + set.lower(target));
        System.out.println("Higher (" + target + "): " + set.higher(target));

        System.out.println("\n--- Basic Element Access ---");
        System.out.println("First: " + set.first());
        System.out.println("Last: " + set.last());

        System.out.println("\n--- Polling Elements (removal) ---");
        System.out.println("Poll First: " + set.pollFirst());
        System.out.println("Poll Last: " + set.pollLast());
        System.out.println("Set after polling: " + set);

        System.out.println("\n--- Subsets ---");
        System.out.println("HeadSet(5): " + set.headSet(5));       // elements > 5 (since descending)
        System.out.println("TailSet(3): " + set.tailSet(3));       // elements <= 3
        System.out.println("SubSet(5, 1): " + set.subSet(5, 1));   // range [5, 1) in descending order

        System.out.println("\n--- Descending View ---");
        NavigableSet<Integer> ascendingView = set.descendingSet();
        System.out.println("Ascending order view: " + ascendingView);
    }
}
