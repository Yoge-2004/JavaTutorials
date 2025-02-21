package com.example.main;

import com.example.utils.ArrayUtility;
import java.util.Scanner;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input the array size and elements
        System.out.print("Enter the number of elements: ");
        int size = scanner.nextInt();
        int[] array = new int[size];

        System.out.println("Enter the elements of the array:");
        for (int i = 0; i < size; i++) {
            array[i] = scanner.nextInt();
        }
        System.out.println("Original array: " + Arrays.toString(array));
        System.out.println();

        // Non-destructive methods
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
        System.out.println("Minimum element: " + ArrayUtility.findMinimum(array));
        System.out.println("Maximum element: " + ArrayUtility.findMaximum(array));
        System.out.println();

        // nthMinimum and nthMaximum methods
        System.out.print("Enter n for nth minimum: ");
        int nMin = scanner.nextInt();
        System.out.println(nMin + "th minimum element: " + ArrayUtility.nthMinimum(array, nMin));

        System.out.print("Enter n for nth maximum: ");
        int nMax = scanner.nextInt();
        System.out.println(nMax + "th maximum element: " + ArrayUtility.nthMaximum(array, nMax));
        System.out.println();

        // Print array in reverse order (non-destructive printing)
        System.out.print("Array printed in reverse order: ");
        ArrayUtility.printArrayReverse(array);
        System.out.println("\n");

        // reverseArray method (creates an in-place reversal on a copy)
        int[] reversedArray = Arrays.copyOf(array, array.length);
        reversedArray = ArrayUtility.reverseArray(reversedArray);
        System.out.println("Reversed array: " + Arrays.toString(reversedArray));
        System.out.println();

        // search method: find first occurrence of a given element
        System.out.print("Enter an element to search for (first occurrence): ");
        int searchElement = scanner.nextInt();
        int index = ArrayUtility.search(array, searchElement);
        if (index != -1) {
            System.out.println("Element " + searchElement + " found at index " + index);
        } else {
            System.out.println("Element " + searchElement + " not found in the array.");
        }
        System.out.println();

        // searchAll method: find all occurrences of a given element
        System.out.print("Enter an element to search for all occurrences: ");
        int searchAllElement = scanner.nextInt();
        int[] indices = ArrayUtility.searchAll(array, searchAllElement);
        if (indices != null) {
            System.out.println("Element " + searchAllElement + " found at indices " + Arrays.toString(indices));
        } else {
            System.out.println("Element " + searchAllElement + " not found in the array.");
        }
        System.out.println();

        // delete method: remove the first occurrence of an element
        System.out.print("Enter an element to delete (first occurrence): ");
        int deleteElement = scanner.nextInt();
        int[] arrayAfterDelete = Arrays.copyOf(array, array.length);
        arrayAfterDelete = ArrayUtility.delete(arrayAfterDelete, deleteElement);
        System.out.println("Array after deleting first occurrence of " + deleteElement + ": " + Arrays.toString(arrayAfterDelete));
        System.out.println();

        // deleteAll method: remove all occurrences of an element
        System.out.print("Enter an element to delete all occurrences: ");
        int deleteAllElement = scanner.nextInt();
        int[] arrayAfterDeleteAll = Arrays.copyOf(array, array.length);
        arrayAfterDeleteAll = ArrayUtility.deleteAll(arrayAfterDeleteAll, deleteAllElement);
        System.out.println("Array after deleting all occurrences of " + deleteAllElement + ": " + Arrays.toString(arrayAfterDeleteAll));
        System.out.println();

        // shiftRight method: shift the array right by a given number of positions
        System.out.print("Enter the number of positions to shift the array to the right: ");
        int shift = scanner.nextInt();
        int[] shiftedArray = Arrays.copyOf(array, array.length);
        shiftedArray = ArrayUtility.shiftRight(shiftedArray, shift);
        System.out.println("Array after shifting right by " + shift + " positions: " + Arrays.toString(shiftedArray));
        
        scanner.close();
    }
}
