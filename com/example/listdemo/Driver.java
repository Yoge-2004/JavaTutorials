package com.example.listdemo;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Driver {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // User input for numbers
        System.out.print("Enter numbers separated by space: ");
        List<Integer> numbers = new ArrayList<>();
        for (String num : scanner.nextLine().split("\\s+")) {
            numbers.add(Integer.parseInt(num));
        }

        // User input for words (e.g., fruits or strings)
        System.out.print("Enter words separated by space: ");
        List<String> words = List.of(scanner.nextLine().split("\\s+"));

        // User input for sentences
        System.out.print("Enter sentences (each separated by a semicolon): ");
        List<String> sentences = List.of(scanner.nextLine().split(";"));

        scanner.close();

        // Running operations on user input
        ListOperationsDemo listOperations = new ListOperationsDemo(numbers, words, sentences);
        listOperations.performOperations();
    }
}