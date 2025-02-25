package com.example.operations;

import java.util.ArrayList;
import java.util.Arrays;

public class ArrayOperations {

    public static int[] rotateSecondHalfRight(int[] array) {
        int halfSize = array.length / 2;
        if (halfSize == 0) {
            return array;
        }
        int temp = array[array.length - 1];
        for (int i = array.length - 1; i > halfSize; i--) {
            array[i] = array[i - 1];
        }
        array[halfSize] = temp;
        return array;
    }

    public static int[] updateArrayElement(int[] array, int index, int element) {
        if (index < 0 || index >= array.length) {
            System.out.println("Index out of bounds.");
            return array;
        }
        array[index] = element;
        return array;
    }

    public static ArrayList<Integer> findIndicesWithEqualNeighbors(int[] array) {
        int size = array.length;
        ArrayList<Integer> indices = new ArrayList<>();
        for (int i = 1; i < size - 1; i++) {
            if (array[i - 1] == array[i + 1]) {
                indices.add(i);
            }
        }
        return indices;
    }

    public static int[] removeRange(int[] array, int start, int end) {
        if (start < 0 || end > array.length - 1) {
            return array;
        }
        int temp[] = new int[array.length - (end - start) - 1];
        int pos = 0;
        for (int i = 0; i < array.length; i++) {
            if (i < start) {
                temp[pos++] = array[i];
            } else if (i > end) {
                temp[pos++] = array[i];
            }
        }
        array = temp;
        return array;
    }

    public static int[] mergeArraysWithReversedSecond(int[] array1, int[] array2) {
        int size1 = array1.length;
        int size2 = array2.length;
        int temp[] = new int[size1 + size2];
        int pos = 0;
        for (int i = 0; i < size1; i++) {
            temp[pos++] = array1[i];
        }
        for (int i = size2 - 1; i >= 0; i--) {
            temp[pos++] = array2[i];
        }
        return temp;
    }

    public static int[] rotateFirstHalfRight(int[] array) {
        int halfSize = array.length / 2;
        if (halfSize == 0) {
            return array;
        }
        int temp = array[halfSize - 1];
        for (int i = halfSize - 1; i > 0; i--) {
            array[i] = array[i - 1];
        }
        array[0] = temp;
        return array;
    }

    public static int getMinimumElement(int[] array) {
        if (array.length == 1) {
            return array[0];
        } else if (array.length == 2) {
            return (array[0] < array[1]) ? array[0] : array[1];
        }
        int min = Integer.MAX_VALUE;
        for (int element : array) {
            if (element < min) {
                min = element;
            }
        }
        return min;
    }

    public static int getMaximumElement(int[] array) {
        if (array.length == 1) {
            return array[0];
        } else if (array.length == 2) {
            return (array[0] > array[1]) ? array[0] : array[1];
        }
        int max = Integer.MIN_VALUE;
        for (int element : array) {
            if (element > max) {
                max = element;
            }
        }
        return max;
    }

    public static int getNthMinimum(int[] array, int n) {
        int minimum = getMinimumElement(array);
        int nextMinimum = Integer.MAX_VALUE;
        while (n > 1) {
            for (int element : array) {
                if (element > minimum && element < nextMinimum) {
                    nextMinimum = element;
                }
            }
            minimum = nextMinimum;
            nextMinimum = Integer.MAX_VALUE;
            n--;
        }
        return minimum;
    }

    public static int getNthMaximum(int[] array, int n) {
        int maximum = getMaximumElement(array);
        int nextMaximum = Integer.MIN_VALUE;
        while (n > 1) {
            for (int element : array) {
                if (element < maximum && element > nextMaximum) {
                    nextMaximum = element;
                }
            }
            maximum = nextMaximum;
            nextMaximum = Integer.MIN_VALUE;
            n--;
        }
        return maximum;
    }

    public static int indexOf(int[] array, int element) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] == element) {
                return i;
            }
        }
        return -1;
    }

    public static int[] indicesOf(int[] array, int element) {
        int count = 0;
        for (int i : array) {
            if (i == element) {
                count++;
            }
        }
        if (count == 0) {
            return null;
        }
        int[] positions = new int[count];
        int index = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] == element) {
                positions[index++] = i;
            }
        }
        return positions;
    }

    public static int[] deleteElement(int[] array, int element) {
        int position = indexOf(array, element);
        if (position == -1) {
            return array;
        }
        for (int i = position; i < array.length - 1; i++) {
            array[i] = array[i + 1];
        }
        array[array.length - 1] = 0;
        return array;
    }

    public static int[] deleteAllOccurrences(int[] array, int element) {
        int[] positions = indicesOf(array, element);
        if (positions == null) {
            return array;
        }
        int shift = 0;
        for (int pos : positions) {
            int index = pos - shift;
            for (int j = index; j < array.length - 1; j++) {
                array[j] = array[j + 1];
            }
            array[array.length - 1] = 0;
            shift++;
        }
        return array;
    }

    public static int[] shiftElementsRight(int[] array, int shift) {
        if (array.length <= 1) {
            return array;
        }
        while (shift > 0) {
            int lastElement = array[array.length - 1];
            for (int i = array.length - 1; i >= 1; i--) {
                array[i] = array[i - 1];
            }
            array[0] = lastElement;
            shift--;
        }
        return array;
    }

    public static int[] leftShiftElements(int[] array, int n) {
        if (array.length == 0) {
            return array;
        }
        n = n % array.length;
        int[] result = new int[array.length];
        for (int i = 0; i < array.length - n; i++) {
            result[i] = array[i + n];
        }
        for (int i = array.length - n; i < array.length; i++) {
            result[i] = 0;
        }
        return result;
    }

    public static int sumElements(int[] array) {
        int sum = 0;
        for (int element : array) {
            sum += element;
        }
        return sum;
    }

    public static double averageOfElements(int[] array) {
        return array.length > 0 ? (double) sumElements(array) / array.length : 0;
    }

    public static void printElementsInReverse(int[] array) {
        for (int i = array.length - 1; i >= 0; i--) {
            System.out.print(array[i] + " ");
        }
    }

    public static int[] reverseElements(int[] array) {
        int end = array.length - 1;
        for (int i = 0; i < array.length / 2; i++) {
            int temp = array[i];
            array[i] = array[end];
            array[end] = temp;
            end--;
        }
        return array;
    }

    public static int getMinOfEvenIndices(int[] array) {
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < array.length; i += 2) {
            if (array[i] < min) {
                min = array[i];
            }
        }
        return min;
    }

    public static void printElementsAtEvenIndices(int[] array) {
        for (int i = 0; i < array.length; i += 2) {
            System.out.print(array[i] + " ");
        }
    }

    public static void printElementsAtEvenIndicesReverse(int[] array) {
        int lastEvenIndex = (array.length % 2 == 0) ? array.length - 2 : array.length - 1;
        for (int i = lastEvenIndex; i >= 0; i -= 2) {
            System.out.print(array[i] + " ");
        }
    }

    public static int sumElementsAtEvenIndices(int[] array) {
        int sum = 0;
        for (int i = 0; i < array.length; i += 2) {
            sum += array[i];
        }
        return sum;
    }

    public static double averageElementsAtEvenIndices(int[] array) {
        int count = (array.length + 1) / 2;
        return count > 0 ? (double) sumElementsAtEvenIndices(array) / count : 0;
    }

    public static int getMinOfOddIndices(int[] array) {
        int min = Integer.MAX_VALUE;
        for (int i = 1; i < array.length; i += 2) {
            if (array[i] < min) {
                min = array[i];
            }
        }
        return min;
    }

    public static void printElementsAtOddIndices(int[] array) {
        for (int i = 1; i < array.length; i += 2) {
            System.out.print(array[i] + " ");
        }
    }

    public static void printElementsAtOddIndicesReverse(int[] array) {
        int lastOddIndex = (array.length % 2 == 0) ? array.length - 1 : array.length - 2;
        for (int i = lastOddIndex; i >= 1; i -= 2) {
            System.out.print(array[i] + " ");
        }
    }

    public static int sumElementsAtOddIndices(int[] array) {
        int sum = 0;
        for (int i = 1; i < array.length; i += 2) {
            sum += array[i];
        }
        return sum;
    }

    public static double averageElementsAtOddIndices(int[] array) {
        int count = array.length / 2;
        return count > 0 ? (double) sumElementsAtOddIndices(array) / count : 0;
    }

    public static int getMinOfFirstHalf(int[] array) {
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < array.length / 2; i++) {
            if (array[i] < min) {
                min = array[i];
            }
        }
        return min;
    }

    public static int getMaxOfFirstHalf(int[] array) {
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < array.length / 2; i++) {
            if (array[i] > max) {
                max = array[i];
            }
        }
        return max;
    }

    public static void printFirstHalfInReverse(int[] array) {
        for (int i = (array.length / 2) - 1; i >= 0; i--) {
            System.out.print(array[i] + " ");
        }
    }

    public static int[] reverseFirstHalfElements(int[] array) {
        int start = 0;
        int end = array.length / 2 - 1;
        while (start < end) {
            int temp = array[start];
            array[start] = array[end];
            array[end] = temp;
            start++;
            end--;
        }
        return array;
    }

    public static int sumFirstHalfElements(int[] array) {
        int sum = 0;
        for (int i = 0; i < array.length / 2; i++) {
            sum += array[i];
        }
        return sum;
    }

    public static double averageFirstHalfElements(int[] array) {
        int count = array.length / 2;
        return count > 0 ? (double) sumFirstHalfElements(array) / count : 0;
    }

    public static int getMinOfSecondHalf(int[] array) {
        int min = Integer.MAX_VALUE;
        for (int i = array.length / 2; i < array.length; i++) {
            if (array[i] < min) {
                min = array[i];
            }
        }
        return min;
    }

    public static int getMaxOfSecondHalf(int[] array) {
        int max = Integer.MIN_VALUE;
        for (int i = array.length / 2; i < array.length; i++) {
            if (array[i] > max) {
                max = array[i];
            }
        }
        return max;
    }

    public static void printSecondHalfInReverse(int[] array) {
        for (int i = array.length - 1; i >= array.length / 2; i--) {
            System.out.print(array[i] + " ");
        }
    }

    public static int[] reverseSecondHalfElements(int[] array) {
        int start = array.length / 2;
        int end = array.length - 1;
        while (start < end) {
            int temp = array[start];
            array[start] = array[end];
            array[end] = temp;
            start++;
            end--;
        }
        return array;
    }

    public static int sumSecondHalfElements(int[] array) {
        int sum = 0;
        for (int i = array.length / 2; i < array.length; i++) {
            sum += array[i];
        }
        return sum;
    }

    public static double averageSecondHalfElements(int[] array) {
        int count = array.length - array.length / 2;
        return count > 0 ? (double) sumSecondHalfElements(array) / count : 0;
    }

    public static int[] swapArrayElements(int[] array, int element1, int element2) {
        int index1 = indexOf(array, element1);
        int index2 = indexOf(array, element2);
        if (index1 == -1 || index2 == -1) {
            return array;
        }
        int temp = array[index1];
        array[index1] = array[index2];
        array[index2] = temp;
        return array;
    }

    public static int[] getUniqueElements(int[] array) {
        int countUnique = 0;
        for (int i = 0; i < array.length; i++) {
            int freq = 0;
            for (int j = 0; j < array.length; j++) {
                if (array[i] == array[j]) {
                    freq++;
                }
            }
            if (freq == 1) {
                countUnique++;
            }
        }
        int[] result = new int[countUnique];
        int index = 0;
        for (int i = 0; i < array.length; i++) {
            int freq = 0;
            for (int j = 0; j < array.length; j++) {
                if (array[i] == array[j]) {
                    freq++;
                }
            }
            if (freq == 1) {
                result[index++] = array[i];
            }
        }
        return result;
    }

    public static int[] getDuplicateElements(int[] array) {
        int countDup = 0;
        for (int i = 0; i < array.length; i++) {
            boolean firstOccurrence = true;
            for (int j = 0; j < i; j++) {
                if (array[j] == array[i]) {
                    firstOccurrence = false;
                    break;
                }
            }
            if (firstOccurrence) {
                int freq = 0;
                for (int j = 0; j < array.length; j++) {
                    if (array[i] == array[j]) {
                        freq++;
                    }
                }
                if (freq > 1) {
                    countDup++;
                }
            }
        }
        int[] result = new int[countDup];
        int index = 0;
        for (int i = 0; i < array.length; i++) {
            boolean firstOccurrence = true;
            for (int j = 0; j < i; j++) {
                if (array[j] == array[i]) {
                    firstOccurrence = false;
                    break;
                }
            }
            if (firstOccurrence) {
                int freq = 0;
                for (int j = 0; j < array.length; j++) {
                    if (array[i] == array[j]) {
                        freq++;
                    }
                }
                if (freq > 1) {
                    result[index++] = array[i];
                }
            }
        }
        return result;
    }

    public static int[] retainEvenIndexedElements(int[] array) {
        int newSize = (array.length + 1) / 2;
        int[] result = new int[newSize];
        int j = 0;
        for (int i = 0; i < array.length; i += 2) {
            result[j++] = array[i];
        }
        return result;
    }

    public static int[] retainOddIndexedElements(int[] array) {
        int newSize = array.length / 2;
        int[] result = new int[newSize];
        int j = 0;
        for (int i = 1; i < array.length; i += 2) {
            result[j++] = array[i];
        }
        return result;
    }

    public static int[] removeDuplicateElements(int[] array) {
        int countUnique = 0;
        for (int i = 0; i < array.length; i++) {
            boolean alreadyPresent = false;
            for (int j = 0; j < i; j++) {
                if (array[j] == array[i]) {
                    alreadyPresent = true;
                    break;
                }
            }
            if (!alreadyPresent) {
                countUnique++;
            }
        }
        int[] result = new int[countUnique];
        int index = 0;
        for (int i = 0; i < array.length; i++) {
            boolean alreadyPresent = false;
            for (int j = 0; j < i; j++) {
                if (array[j] == array[i]) {
                    alreadyPresent = true;
                    break;
                }
            }
            if (!alreadyPresent) {
                result[index++] = array[i];
            }
        }
        return result;
    }

    public static int[] getCommonElements(int[] array1, int[] array2) {
        int[] unique1 = removeDuplicateElements(array1);
        int countCommon = 0;
        for (int i = 0; i < unique1.length; i++) {
            if (indexOf(array2, unique1[i]) != -1) {
                countCommon++;
            }
        }
        int[] result = new int[countCommon];
        int index = 0;
        for (int i = 0; i < unique1.length; i++) {
            if (indexOf(array2, unique1[i]) != -1) {
                result[index++] = unique1[i];
            }
        }
        return result;
    }

    public static int[] getUncommonElements(int[] array1, int[] array2) {
        int[] unique1 = removeDuplicateElements(array1);
        int[] unique2 = removeDuplicateElements(array2);
        int countUncommon = 0;
        for (int i = 0; i < unique1.length; i++) {
            if (indexOf(unique2, unique1[i]) == -1) {
                countUncommon++;
            }
        }
        for (int i = 0; i < unique2.length; i++) {
            if (indexOf(unique1, unique2[i]) == -1) {
                countUncommon++;
            }
        }
        int[] result = new int[countUncommon];
        int index = 0;
        for (int i = 0; i < unique1.length; i++) {
            if (indexOf(unique2, unique1[i]) == -1) {
                result[index++] = unique1[i];
            }
        }
        for (int i = 0; i < unique2.length; i++) {
            if (indexOf(unique1, unique2[i]) == -1) {
                result[index++] = unique2[i];
            }
        }
        return result;
    }

    public static int[] reverseElementsAtOddIndices(int[] array) {
        int start = 1;
        int end = (array.length % 2 == 0) ? array.length - 1 : array.length - 2;
        while (start < end) {
            int temp = array[start];
            array[start] = array[end];
            array[end] = temp;
            start += 2;
            end -= 2;
        }
        return array;
    }

    public static int[] reverseElementsAtEvenIndices(int[] array) {
        int start = 0;
        int end = (array.length % 2 == 0) ? array.length - 2 : array.length - 1;
        while (start < end) {
            int temp = array[start];
            array[start] = array[end];
            array[end] = temp;
            start += 2;
            end -= 2;
        }
        return array;
    }

    public static int[] swapAdjacentOddAndEvenElements(int[] array) {
        for (int i = 1; i < array.length; i += 2) {
            int temp = array[i];
            array[i] = array[i - 1];
            array[i - 1] = temp;
        }
        return array;
    }

    public static int[] getMissingElements(int[] array) {
        int min = getMinimumElement(array);
        int max = getMaximumElement(array);
        int countMissing = 0;
        for (int num = min + 1; num < max; num++) {
            if (indexOf(array, num) == -1) {
                countMissing++;
            }
        }
        int[] result = new int[countMissing];
        int index = 0;
        for (int num = min + 1; num < max; num++) {
            if (indexOf(array, num) == -1) {
                result[index++] = num;
            }
        }
        return result;
    }

    public static int[] removeElementsPresentInArray(int[] array1, int[] array2) {
        int count = 0;
        for (int i = 0; i < array1.length; i++) {
            if (indexOf(array2, array1[i]) == -1) {
                count++;
            }
        }
        int[] result = new int[count];
        int index = 0;
        for (int i = 0; i < array1.length; i++) {
            if (indexOf(array2, array1[i]) == -1) {
                result[index++] = array1[i];
            }
        }
        return result;
    }

    public static int[] retainElementsPresentInArray(int[] array1, int[] array2) {
        int count = 0;
        for (int i = 0; i < array1.length; i++) {
            if (indexOf(array2, array1[i]) != -1) {
                count++;
            }
        }
        int[] result = new int[count];
        int index = 0;
        for (int i = 0; i < array1.length; i++) {
            if (indexOf(array2, array1[i]) != -1) {
                result[index++] = array1[i];
            }
        }
        return result;
    }

    public static int[] concatenateArrays(int[] array1, int[] array2) {
        int[] result = new int[array1.length + array2.length];
        int index = 0;
        for (int i = 0; i < array1.length; i++) {
            result[index++] = array1[i];
        }
        for (int i = 0; i < array2.length; i++) {
            result[index++] = array2[i];
        }
        return result;
    }

    public static int[] bubbleSortElements(int[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = 0; j < array.length - 1 - i; j++) {
                if (array[j] > array[j + 1]) {
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }
        return array;
    }
}
