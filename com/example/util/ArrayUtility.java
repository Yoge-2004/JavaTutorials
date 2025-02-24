package com.example.util;

import java.util.Arrays;

public class ArrayUtility {

    public static int[] rotateFirstHalfElements(int[] array) {
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

    public static int findMinimum(int[] array) {
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

    public static int findMaximum(int[] array) {
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

    public static int nthMinimum(int[] array, int n) {
        int minimum = findMinimum(array);
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

    public static int nthMaximum(int[] array, int n) {
        int maximum = findMaximum(array);
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

    public static int search(int[] array, int element) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] == element) {
                return i;
            }
        }
        return -1;
    }

    public static int[] searchAll(int[] array, int element) {
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

    public static int[] delete(int[] array, int element) {
        int position = search(array, element);
        if (position == -1) {
            return array;
        }
        for (int i = position; i < array.length - 1; i++) {
            array[i] = array[i + 1];
        }
        array[array.length - 1] = 0;
        return array;
    }

    public static int[] deleteAll(int[] array, int element) {
        int[] positions = searchAll(array, element);
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

    public static int[] shiftRight(int[] array, int shift) {
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

    public static int[] leftShift(int[] array, int n) {
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

    public static int sum(int[] array) {
        int sum = 0;
        for (int element : array) {
            sum += element;
        }
        return sum;
    }

    public static double average(int[] array) {
        return array.length > 0 ? (double) sum(array) / array.length : 0;
    }

    public static void printArrayReverse(int[] array) {
        for (int i = array.length - 1; i >= 0; i--) {
            System.out.print(array[i] + " ");
        }
    }

    public static int[] reverseArray(int[] array) {
        int end = array.length - 1;
        for (int i = 0; i < array.length / 2; i++) {
            int temp = array[i];
            array[i] = array[end];
            array[end] = temp;
            end--;
        }
        return array;
    }

    public static int minOfEvenIndexedElements(int[] array) {
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < array.length; i += 2) {
            if (array[i] < min) {
                min = array[i];
            }
        }
        return min;
    }

    public static void printEvenIndexedElements(int[] array) {
        for (int i = 0; i < array.length; i += 2) {
            System.out.print(array[i] + " ");
        }
    }

    public static void printEvenIndexedElementsReverse(int[] array) {
        int lastEvenIndex = (array.length % 2 == 0) ? array.length - 2 : array.length - 1;
        for (int i = lastEvenIndex; i >= 0; i -= 2) {
            System.out.print(array[i] + " ");
        }
    }

    public static int sumOfEvenIndexedElements(int[] array) {
        int sum = 0;
        for (int i = 0; i < array.length; i += 2) {
            sum += array[i];
        }
        return sum;
    }

    public static double averageOfEvenIndexedElements(int[] array) {
        int count = (array.length + 1) / 2;
        return count > 0 ? (double) sumOfEvenIndexedElements(array) / count : 0;
    }

    public static int minOfOddIndexedElements(int[] array) {
        int min = Integer.MAX_VALUE;
        for (int i = 1; i < array.length; i += 2) {
            if (array[i] < min) {
                min = array[i];
            }
        }
        return min;
    }

    public static void printOddIndexedElements(int[] array) {
        for (int i = 1; i < array.length; i += 2) {
            System.out.print(array[i] + " ");
        }
    }

    public static void printOddIndexedElementsReverse(int[] array) {
        int lastOddIndex = (array.length % 2 == 0) ? array.length - 1 : array.length - 2;
        for (int i = lastOddIndex; i >= 1; i -= 2) {
            System.out.print(array[i] + " ");
        }
    }

    public static int sumOfOddIndexedElements(int[] array) {
        int sum = 0;
        for (int i = 1; i < array.length; i += 2) {
            sum += array[i];
        }
        return sum;
    }

    public static double averageOfOddIndexedElements(int[] array) {
        int count = array.length / 2;
        return count > 0 ? (double) sumOfOddIndexedElements(array) / count : 0;
    }

    public static int minOfFirstHalfElements(int[] array) {
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < array.length / 2; i++) {
            if (array[i] < min) {
                min = array[i];
            }
        }
        return min;
    }

    public static int maxOfFirstHalfElements(int[] array) {
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < array.length / 2; i++) {
            if (array[i] > max) {
                max = array[i];
            }
        }
        return max;
    }

    public static void printFirstHalfReverse(int[] array) {
        for (int i = (array.length / 2) - 1; i >= 0; i--) {
            System.out.print(array[i] + " ");
        }
    }

    public static int[] reverseFirstHalf(int[] array) {
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

    public static int sumOfFirstHalfElements(int[] array) {
        int sum = 0;
        for (int i = 0; i < array.length / 2; i++) {
            sum += array[i];
        }
        return sum;
    }

    public static double averageOfFirstHalfElements(int[] array) {
        int count = array.length / 2;
        return count > 0 ? (double) sumOfFirstHalfElements(array) / count : 0;
    }

    public static int minOfSecondHalfElements(int[] array) {
        int min = Integer.MAX_VALUE;
        for (int i = array.length / 2; i < array.length; i++) {
            if (array[i] < min) {
                min = array[i];
            }
        }
        return min;
    }

    public static int maxOfSecondHalfElements(int[] array) {
        int max = Integer.MIN_VALUE;
        for (int i = array.length / 2; i < array.length; i++) {
            if (array[i] > max) {
                max = array[i];
            }
        }
        return max;
    }

    public static void printSecondHalfReverse(int[] array) {
        for (int i = array.length - 1; i >= array.length / 2; i--) {
            System.out.print(array[i] + " ");
        }
    }

    public static int[] reverseSecondHalf(int[] array) {
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

    public static int sumOfSecondHalfElements(int[] array) {
        int sum = 0;
        for (int i = array.length / 2; i < array.length; i++) {
            sum += array[i];
        }
        return sum;
    }

    public static double averageOfSecondHalfElements(int[] array) {
        int count = array.length - array.length / 2;
        return count > 0 ? (double) sumOfSecondHalfElements(array) / count : 0;
    }

    public static int[] swapElements(int[] array, int element1, int element2) {
        int index1 = search(array, element1);
        int index2 = search(array, element2);
        if (index1 == -1 || index2 == -1) {
            return array;
        }
        int temp = array[index1];
        array[index1] = array[index2];
        array[index2] = temp;
        return array;
    }

    public static int[] findUniqueElements(int[] array) {
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

    public static int[] findDuplicateElements(int[] array) {
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

    public static int[] removeOddIndexedElements(int[] array) {
        int newSize = (array.length + 1) / 2;
        int[] result = new int[newSize];
        int j = 0;
        for (int i = 0; i < array.length; i += 2) {
            result[j++] = array[i];
        }
        return result;
    }

    public static int[] removeEvenIndexedElements(int[] array) {
        int newSize = array.length / 2;
        int[] result = new int[newSize];
        int j = 0;
        for (int i = 1; i < array.length; i += 2) {
            result[j++] = array[i];
        }
        return result;
    }

    public static int[] removeDuplicates(int[] array) {
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

    public static int[] findCommonElements(int[] array1, int[] array2) {
        int[] unique1 = removeDuplicates(array1);
        int countCommon = 0;
        for (int i = 0; i < unique1.length; i++) {
            if (search(array2, unique1[i]) != -1) {
                countCommon++;
            }
        }
        int[] result = new int[countCommon];
        int index = 0;
        for (int i = 0; i < unique1.length; i++) {
            if (search(array2, unique1[i]) != -1) {
                result[index++] = unique1[i];
            }
        }
        return result;
    }

    public static int[] findUncommonElements(int[] array1, int[] array2) {
        int[] unique1 = removeDuplicates(array1);
        int[] unique2 = removeDuplicates(array2);
        int countUncommon = 0;
        for (int i = 0; i < unique1.length; i++) {
            if (search(unique2, unique1[i]) == -1) {
                countUncommon++;
            }
        }
        for (int i = 0; i < unique2.length; i++) {
            if (search(unique1, unique2[i]) == -1) {
                countUncommon++;
            }
        }
        int[] result = new int[countUncommon];
        int index = 0;
        for (int i = 0; i < unique1.length; i++) {
            if (search(unique2, unique1[i]) == -1) {
                result[index++] = unique1[i];
            }
        }
        for (int i = 0; i < unique2.length; i++) {
            if (search(unique1, unique2[i]) == -1) {
                result[index++] = unique2[i];
            }
        }
        return result;
    }

    public static int[] reverseOddIndexedElements(int[] array) {
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

    public static int[] reverseEvenIndexedElements(int[] array) {
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

    public static int[] swapAdjacentOddEvenElements(int[] array) {
        for (int i = 1; i < array.length; i += 2) {
            int temp = array[i];
            array[i] = array[i - 1];
            array[i - 1] = temp;
        }
        return array;
    }

    public static int[] findMissedElements(int[] array) {
        int min = findMinimum(array);
        int max = findMaximum(array);
        int countMissing = 0;
        for (int num = min + 1; num < max; num++) {
            if (search(array, num) == -1) {
                countMissing++;
            }
        }
        int[] result = new int[countMissing];
        int index = 0;
        for (int num = min + 1; num < max; num++) {
            if (search(array, num) == -1) {
                result[index++] = num;
            }
        }
        return result;
    }

    public static int[] removeElements(int[] array1, int[] array2) {
        int count = 0;
        for (int i = 0; i < array1.length; i++) {
            if (search(array2, array1[i]) == -1) {
                count++;
            }
        }
        int[] result = new int[count];
        int index = 0;
        for (int i = 0; i < array1.length; i++) {
            if (search(array2, array1[i]) == -1) {
                result[index++] = array1[i];
            }
        }
        return result;
    }

    public static int[] retainElements(int[] array1, int[] array2) {
        int count = 0;
        for (int i = 0; i < array1.length; i++) {
            if (search(array2, array1[i]) != -1) {
                count++;
            }
        }
        int[] result = new int[count];
        int index = 0;
        for (int i = 0; i < array1.length; i++) {
            if (search(array2, array1[i]) != -1) {
                result[index++] = array1[i];
            }
        }
        return result;
    }

    public static int[] mergeArrays(int[] array1, int[] array2) {
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

    public static int[] bubbleSort(int[] array) {
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
