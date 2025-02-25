package com.example.util;

import com.example.util.ArrayUtility;

import java.util.ArrayList;
import java.util.Arrays;

public class TestArrayUtility {
    public static void main(String[] args) {
        // Test for rotateSecondHalfRight
        int[] array1 = {1, 2, 3, 4, 5, 6};
        System.out.println("Original Array: " + Arrays.toString(array1));
        ArrayUtility.rotateSecondHalfRight(array1);
        System.out.println("Array after rotating second half right: " + Arrays.toString(array1));

        // Test for updateArrayElement
        ArrayUtility.updateArrayElement(array1, 2, 99);
        System.out.println("Array after updating element at index 2 to 99: " + Arrays.toString(array1));

        // Test for findIndicesWithEqualNeighbors
        int[] array2 = {1, 2, 1, 3, 4, 5};
        ArrayList<Integer> indices = ArrayUtility.findIndicesWithEqualNeighbors(array2);
        System.out.println("Indices with equal neighbors: " + indices);

        // Test for removeRange
        int[] array3 = {10, 20, 30, 40, 50, 60};
        array3 = ArrayUtility.removeRange(array3, 2, 4);
        System.out.println("Array after removing elements from index 2 to 4: " + Arrays.toString(array3));

        // Test for mergeArraysWithReversedSecond
        int[] array4 = {1, 2, 3};
        int[] array5 = {4, 5, 6};
        int[] mergedArray = ArrayUtility.mergeArraysWithReversedSecond(array4, array5);
        System.out.println("Merged Array with second reversed: " + Arrays.toString(mergedArray));

        // Test for rotateFirstHalfRight
        int[] array6 = {1, 2, 3, 4, 5, 6};
        System.out.println("Original Array: " + Arrays.toString(array6));
        ArrayUtility.rotateFirstHalfRight(array6);
        System.out.println("Array after rotating first half right: " + Arrays.toString(array6));

        // Test for getMinimumElement
        int[] array7 = {5, 2, 9, 1, 7};
        int minElement = ArrayUtility.getMinimumElement(array7);
        System.out.println("Minimum element in the array: " + minElement);

        // Test for getMaximumElement
        int maxElement = ArrayUtility.getMaximumElement(array7);
        System.out.println("Maximum element in the array: " + maxElement);

        // Test for sumElements
        int sum = ArrayUtility.sumElements(array7);
        System.out.println("Sum of elements: " + sum);

        // Test for averageOfElements
        double average = ArrayUtility.averageOfElements(array7);
        System.out.println("Average of elements: " + average);

        // Test for reverseElements
        int[] array8 = {1, 2, 3, 4, 5};
        ArrayUtility.reverseElements(array8);
        System.out.println("Array after reverse: " + Arrays.toString(array8));

        // Test for getMinOfEvenIndices
        int minEvenIndices = ArrayUtility.getMinOfEvenIndices(array7);
        System.out.println("Minimum of elements at even indices: " + minEvenIndices);

        // Test for sumElementsAtEvenIndices
        int sumEvenIndices = ArrayUtility.sumElementsAtEvenIndices(array7);
        System.out.println("Sum of elements at even indices: " + sumEvenIndices);

        // Test for getMinOfOddIndices
        int minOddIndices = ArrayUtility.getMinOfOddIndices(array7);
        System.out.println("Minimum of elements at odd indices: " + minOddIndices);

        // Test for sumElementsAtOddIndices
        int sumOddIndices = ArrayUtility.sumElementsAtOddIndices(array7);
        System.out.println("Sum of elements at odd indices: " + sumOddIndices);

        // Test for getUniqueElements
        int[] array9 = {1, 2, 2, 3, 4, 4, 5};
        int[] uniqueElements = ArrayUtility.getUniqueElements(array9);
        System.out.println("Unique elements: " + Arrays.toString(uniqueElements));

        // Test for removeDuplicateElements
        int[] array10 = {1, 2, 2, 3, 3, 4};
        int[] noDuplicates = ArrayUtility.removeDuplicateElements(array10);
        System.out.println("Array after removing duplicates: " + Arrays.toString(noDuplicates));

        // Test for getCommonElements
        int[] array11 = {1, 2, 3, 4};
        int[] array12 = {3, 4, 5, 6};
        int[] commonElements = ArrayUtility.getCommonElements(array11, array12);
        System.out.println("Common elements: " + Arrays.toString(commonElements));

        // Test for getUncommonElements
        int[] uncommonElements = ArrayUtility.getUncommonElements(array11, array12);
        System.out.println("Uncommon elements: " + Arrays.toString(uncommonElements));
    }
}
