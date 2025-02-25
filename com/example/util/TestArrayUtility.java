package com.example.util;

import com.example.util.ArrayUtility;
public class TestArrayUtility {

    public static void main(String[] args) {
        int[] arr = {5, 2, 9, 2, 3, 10, 8};
        System.out.print("Original array: ");
        printArray(arr);

        // Check if ArrayOperations methods are static or need an object
        int[] rotated = ArrayOperations.rotateFirstHalfElements(arr.clone());
        System.out.print("After rotating first half: ");
        printArray(rotated);

        System.out.println("Minimum: " + ArrayOperations.findMinimum(arr));
        System.out.println("Maximum: " + ArrayOperations.findMaximum(arr));
        System.out.println("2nd Minimum: " + ArrayOperations.nthMinimum(arr, 2));
        System.out.println("2nd Maximum: " + ArrayOperations.nthMaximum(arr, 2));

        System.out.println("Search 9: " + ArrayOperations.search(arr, 9));
        System.out.print("Search all 2 (positions): ");
        printArray(ArrayOperations.searchAll(arr, 2));

        int[] arrDelete = arr.clone();
        ArrayOperations.delete(arrDelete, 2);
        System.out.print("After deleting first 2: ");
        printArray(arrDelete);

        int[] arrDeleteAll = arr.clone();
        ArrayOperations.deleteAll(arrDeleteAll, 2);
        System.out.print("After deleting all 2s: ");
        printArray(arrDeleteAll);

        int[] arrShiftRight = arr.clone();
        ArrayOperations.shiftRight(arrShiftRight, 2);
        System.out.print("After shifting right by 2: ");
        printArray(arrShiftRight);

        int[] arrLeftShift = arr.clone();
        arrLeftShift = ArrayOperations.leftShift(arrLeftShift, 2);
        System.out.print("After left shifting by 2: ");
        printArray(arrLeftShift);

        System.out.println("Sum: " + ArrayOperations.sum(arr));
        System.out.println("Average: " + ArrayOperations.average(arr));

        System.out.print("Print array in reverse order: ");
        ArrayOperations.printArrayReverse(arr);
        System.out.println();

        int[] arrReversed = arr.clone();
        ArrayOperations.reverseArray(arrReversed);
        System.out.print("Reversed array: ");
        printArray(arrReversed);

        System.out.println("Min of even-indexed elements: " + ArrayOperations.minOfEvenIndexedElements(arr));
        System.out.print("Even-indexed elements: ");
        ArrayOperations.printEvenIndexedElements(arr);
        System.out.println();
        System.out.print("Even-indexed elements reversed: ");
        ArrayOperations.printEvenIndexedElementsReverse(arr);
        System.out.println();
        System.out.println("Sum of even-indexed elements: " + ArrayOperations.sumOfEvenIndexedElements(arr));
        System.out.println("Average of even-indexed elements: " + ArrayOperations.averageOfEvenIndexedElements(arr));

        System.out.println("Min of odd-indexed elements: " + ArrayOperations.minOfOddIndexedElements(arr));
        System.out.print("Odd-indexed elements: ");
        ArrayOperations.printOddIndexedElements(arr);
        System.out.println();
        System.out.print("Odd-indexed elements reversed: ");
        ArrayOperations.printOddIndexedElementsReverse(arr);
        System.out.println();
        System.out.println("Sum of odd-indexed elements: " + ArrayOperations.sumOfOddIndexedElements(arr));
        System.out.println("Average of odd-indexed elements: " + ArrayOperations.averageOfOddIndexedElements(arr));

        System.out.println("Min of first half: " + ArrayOperations.minOfFirstHalfElements(arr));
        System.out.println("Max of first half: " + ArrayOperations.maxOfFirstHalfElements(arr));
        System.out.print("First half reversed (printed): ");
        ArrayOperations.printFirstHalfReverse(arr);
        System.out.println();
        int[] arrFirstHalfReversed = arr.clone();
        ArrayOperations.reverseFirstHalf(arrFirstHalfReversed);
        System.out.print("Array after reversing first half: ");
        printArray(arrFirstHalfReversed);
        System.out.println("Sum of first half: " + ArrayOperations.sumOfFirstHalfElements(arr));
        System.out.println("Average of first half: " + ArrayOperations.averageOfFirstHalfElements(arr));

        System.out.println("Min of second half: " + ArrayOperations.minOfSecondHalfElements(arr));
        System.out.println("Max of second half: " + ArrayOperations.maxOfSecondHalfElements(arr));
        System.out.print("Second half reversed (printed): ");
        ArrayOperations.printSecondHalfReverse(arr);
        System.out.println();
        int[] arrSecondHalfReversed = arr.clone();
        ArrayOperations.reverseSecondHalf(arrSecondHalfReversed);
        System.out.print("Array after reversing second half: ");
        printArray(arrSecondHalfReversed);
        System.out.println("Sum of second half: " + ArrayOperations.sumOfSecondHalfElements(arr));
        System.out.println("Average of second half: " + ArrayOperations.averageOfSecondHalfElements(arr));

        int[] arrSwap = arr.clone();
        ArrayOperations.swapElements(arrSwap, 9, 3);
        System.out.print("After swapping 9 and 3: ");
        printArray(arrSwap);

        int[] unique = ArrayOperations.findUniqueElements(arr);
        System.out.print("Unique elements: ");
        printArray(unique);
        int[] duplicates = ArrayOperations.findDuplicateElements(arr);
        System.out.print("Duplicate elements: ");
        printArray(duplicates);

        int[] removedOddIndexed = ArrayOperations.removeOddIndexedElements(arr);
        System.out.print("After removing odd-indexed elements: ");
        printArray(removedOddIndexed);
        int[] removedEvenIndexed = ArrayOperations.removeEvenIndexedElements(arr);
        System.out.print("After removing even-indexed elements: ");
        printArray(removedEvenIndexed);

        int[] removedDuplicates = ArrayOperations.removeDuplicates(arr);
        System.out.print("After removing duplicates: ");
        printArray(removedDuplicates);

        int[] arr2 = {3, 5, 7, 2, 11};
        System.out.print("Second array: ");
        printArray(arr2);
        int[] common = ArrayOperations.findCommonElements(arr, arr2);
        System.out.print("Common elements: ");
        printArray(common);
        int[] uncommon = ArrayOperations.findUncommonElements(arr, arr2);
        System.out.print("Uncommon elements: ");
        printArray(uncommon);

        int[] arrReverseOdd = arr.clone();
        ArrayOperations.reverseOddIndexedElements(arrReverseOdd);
        System.out.print("After reversing odd-indexed elements: ");
        printArray(arrReverseOdd);
        int[] arrReverseEven = arr.clone();
        ArrayOperations.reverseEvenIndexedElements(arrReverseEven);
        System.out.print("After reversing even-indexed elements: ");
        printArray(arrReverseEven);
        int[] arrSwapAdjacent = arr.clone();
        ArrayOperations.swapAdjacentOddEvenElements(arrSwapAdjacent);
        System.out.print("After swapping adjacent odd-even elements: ");
        printArray(arrSwapAdjacent);

        int[] missed = ArrayOperations.findMissedElements(arr);
        System.out.print("Missed elements between min and max: ");
        printArray(missed);

        int[] removedElements = ArrayOperations.removeElements(arr, arr2);
        System.out.print("After removing elements of second array from first: ");
        printArray(removedElements);

        int[] retainedElements = ArrayOperations.retainElements(arr, arr2);
        System.out.print("After retaining only elements of first that are in second: ");
        printArray(retainedElements);

        int[] merged = ArrayOperations.mergeArrays(arr, arr2);
        System.out.print("Merged array: ");
        printArray(merged);
    }

    public static void printArray(int[] arr) {
        for (int x : arr) {
            System.out.print(x + " ");
        }
        System.out.println();
    }
}
