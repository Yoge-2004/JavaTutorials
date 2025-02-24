package com.example.util;

public class TestArrayUtility {

    public static void main(String[] args) {
        int[] arr = {5, 2, 9, 2, 3, 10, 8};
        System.out.print("Original array: ");
        printArray(arr);
        
        int[] rotated = ArrayUtility.rotateFirstHalfElements(arr.clone());
        System.out.print("After rotating first half: ");
        printArray(rotated);

        System.out.println("Minimum: " + ArrayUtility.findMinimum(arr));
        System.out.println("Maximum: " + ArrayUtility.findMaximum(arr));
        System.out.println("2nd Minimum: " + ArrayUtility.nthMinimum(arr, 2));
        System.out.println("2nd Maximum: " + ArrayUtility.nthMaximum(arr, 2));

        System.out.println("Search 9: " + ArrayUtility.search(arr, 9));
        System.out.print("Search all 2 (positions): ");
        printArray(ArrayUtility.searchAll(arr, 2));

        int[] arrDelete = arr.clone();
        ArrayUtility.delete(arrDelete, 2);
        System.out.print("After deleting first 2: ");
        printArray(arrDelete);

        int[] arrDeleteAll = arr.clone();
        ArrayUtility.deleteAll(arrDeleteAll, 2);
        System.out.print("After deleting all 2s: ");
        printArray(arrDeleteAll);

        int[] arrShiftRight = arr.clone();
        ArrayUtility.shiftRight(arrShiftRight, 2);
        System.out.print("After shifting right by 2: ");
        printArray(arrShiftRight);

        int[] arrLeftShift = arr.clone();
        arrLeftShift = ArrayUtility.leftShift(arrLeftShift, 2);
        System.out.print("After left shifting by 2: ");
        printArray(arrLeftShift);

        System.out.println("Sum: " + ArrayUtility.sum(arr));
        System.out.println("Average: " + ArrayUtility.average(arr));

        System.out.print("Print array in reverse order: ");
        ArrayUtility.printArrayReverse(arr);
        System.out.println();

        int[] arrReversed = arr.clone();
        ArrayUtility.reverseArray(arrReversed);
        System.out.print("Reversed array: ");
        printArray(arrReversed);

        System.out.println("Min of even-indexed elements: " + ArrayUtility.minOfEvenIndexedElements(arr));
        System.out.print("Even-indexed elements: ");
        ArrayUtility.printEvenIndexedElements(arr);
        System.out.println();
        System.out.print("Even-indexed elements reversed: ");
        ArrayUtility.printEvenIndexedElementsReverse(arr);
        System.out.println();
        System.out.println("Sum of even-indexed elements: " + ArrayUtility.sumOfEvenIndexedElements(arr));
        System.out.println("Average of even-indexed elements: " + ArrayUtility.averageOfEvenIndexedElements(arr));

        System.out.println("Min of odd-indexed elements: " + ArrayUtility.minOfOddIndexedElements(arr));
        System.out.print("Odd-indexed elements: ");
        ArrayUtility.printOddIndexedElements(arr);
        System.out.println();
        System.out.print("Odd-indexed elements reversed: ");
        ArrayUtility.printOddIndexedElementsReverse(arr);
        System.out.println();
        System.out.println("Sum of odd-indexed elements: " + ArrayUtility.sumOfOddIndexedElements(arr));
        System.out.println("Average of odd-indexed elements: " + ArrayUtility.averageOfOddIndexedElements(arr));

        System.out.println("Min of first half: " + ArrayUtility.minOfFirstHalfElements(arr));
        System.out.println("Max of first half: " + ArrayUtility.maxOfFirstHalfElements(arr));
        System.out.print("First half reversed (printed): ");
        ArrayUtility.printFirstHalfReverse(arr);
        System.out.println();
        int[] arrFirstHalfReversed = arr.clone();
        ArrayUtility.reverseFirstHalf(arrFirstHalfReversed);
        System.out.print("Array after reversing first half: ");
        printArray(arrFirstHalfReversed);
        System.out.println("Sum of first half: " + ArrayUtility.sumOfFirstHalfElements(arr));
        System.out.println("Average of first half: " + ArrayUtility.averageOfFirstHalfElements(arr));

        System.out.println("Min of second half: " + ArrayUtility.minOfSecondHalfElements(arr));
        System.out.println("Max of second half: " + ArrayUtility.maxOfSecondHalfElements(arr));
        System.out.print("Second half reversed (printed): ");
        ArrayUtility.printSecondHalfReverse(arr);
        System.out.println();
        int[] arrSecondHalfReversed = arr.clone();
        ArrayUtility.reverseSecondHalf(arrSecondHalfReversed);
        System.out.print("Array after reversing second half: ");
        printArray(arrSecondHalfReversed);
        System.out.println("Sum of second half: " + ArrayUtility.sumOfSecondHalfElements(arr));
        System.out.println("Average of second half: " + ArrayUtility.averageOfSecondHalfElements(arr));

        int[] arrSwap = arr.clone();
        ArrayUtility.swapElements(arrSwap, 9, 3);
        System.out.print("After swapping 9 and 3: ");
        printArray(arrSwap);

        int[] unique = ArrayUtility.findUniqueElements(arr);
        System.out.print("Unique elements: ");
        printArray(unique);
        int[] duplicates = ArrayUtility.findDuplicateElements(arr);
        System.out.print("Duplicate elements: ");
        printArray(duplicates);

        int[] removedOddIndexed = ArrayUtility.removeOddIndexedElements(arr);
        System.out.print("After removing odd-indexed elements: ");
        printArray(removedOddIndexed);
        int[] removedEvenIndexed = ArrayUtility.removeEvenIndexedElements(arr);
        System.out.print("After removing even-indexed elements: ");
        printArray(removedEvenIndexed);

        int[] removedDuplicates = ArrayUtility.removeDuplicates(arr);
        System.out.print("After removing duplicates: ");
        printArray(removedDuplicates);

        int[] arr2 = {3, 5, 7, 2, 11};
        System.out.print("Second array: ");
        printArray(arr2);
        int[] common = ArrayUtility.findCommonElements(arr, arr2);
        System.out.print("Common elements: ");
        printArray(common);
        int[] uncommon = ArrayUtility.findUncommonElements(arr, arr2);
        System.out.print("Uncommon elements: ");
        printArray(uncommon);

        int[] arrReverseOdd = arr.clone();
        ArrayUtility.reverseOddIndexedElements(arrReverseOdd);
        System.out.print("After reversing odd-indexed elements: ");
        printArray(arrReverseOdd);
        int[] arrReverseEven = arr.clone();
        ArrayUtility.reverseEvenIndexedElements(arrReverseEven);
        System.out.print("After reversing even-indexed elements: ");
        printArray(arrReverseEven);
        int[] arrSwapAdjacent = arr.clone();
        ArrayUtility.swapAdjacentOddEvenElements(arrSwapAdjacent);
        System.out.print("After swapping adjacent odd-even elements: ");
        printArray(arrSwapAdjacent);

        int[] missed = ArrayUtility.findMissedElements(arr);
        System.out.print("Missed elements between min and max: ");
        printArray(missed);

        int[] removedElements = ArrayUtility.removeElements(arr, arr2);
        System.out.print("After removing elements of second array from first: ");
        printArray(removedElements);

        int[] retainedElements = ArrayUtility.retainElements(arr, arr2);
        System.out.print("After retaining only elements of first that are in second: ");
        printArray(retainedElements);

        int[] merged = ArrayUtility.mergeArrays(arr, arr2);
        System.out.print("Merged array: ");
        printArray(merged);

        int[] unsorted = {9, 4, 6, 2, 10, 1};
        System.out.print("Unsorted array: ");
        printArray(unsorted);
        int[] sorted = ArrayUtility.bubbleSort(unsorted.clone());
        System.out.print("Bubble sorted array: ");
        printArray(sorted);
    }

    public static void printArray(int[] arr) {
        for (int x : arr) {
            System.out.print(x + " ");
        }
        System.out.println();
    }
}
