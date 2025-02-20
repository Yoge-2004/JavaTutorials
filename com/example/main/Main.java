package com.example.main;

import com.example.utils.ArrayUtility;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input the array size
        System.out.print("Enter the number of elements: ");
        int size = scanner.nextInt();
        int[] array = new int[size];

        // Input array elements
        System.out.println("Enter the elements of the array:");
        for (int i = 0; i < size; i++) {
            array[i] = scanner.nextInt();
        }

        // Calling utility methods and printing results
        System.out.println("Sum of elements: " + ArrayUtility.sum(array));
        System.out.println("Average of elements: " + ArrayUtility.average(array));
        System.out.println("Sum of elements at even indices: " + ArrayUtility.sumOfEvenElements(array));
        System.out.println("Sum of elements at odd indices: " + ArrayUtility.sumOfOddElements(array));
        System.out.println("Average of elements at even indices: " + ArrayUtility.averageOfEvenElements(array));
        System.out.println("Average of elements at odd indices: " + ArrayUtility.averageOfOddElements(array));
        System.out.println("Sum of first half elements: " + ArrayUtility.sumOfFirstHalfElements(array));
        System.out.println("Sum of second half elements: " + ArrayUtility.sumOfSecondHalfElements(array));
        System.out.println("Average of first half elements: " + ArrayUtility.averageOfFirstHalfElements(array));
        System.out.println("Average of second half elements: " + ArrayUtility.averageOfSecondHalfElements(array));
    }
}
