package com.example.util;

public class ArrayUtility {

    public static double sum(int[] array) {
        int sum = 0;
        for (int element : array) {
            sum += element;
        }
        return sum;
    }

    public static double average(int[] array) {
        return sum(array) / (double) array.length;
    }

    public static double averageOfEvenElements(int[] array) {
        int sum = sumOfEvenElements(array);
        int count = (array.length + 1) / 2; // Count of elements at even indices
        return count > 0 ? (double) sum / count : 0;
    }

    public static double averageOfOddElements(int[] array) {
        int sum = sumOfOddElements(array);
        int count = array.length / 2; // Count of elements at odd indices
        return count > 0 ? (double) sum / count : 0;
    }

    public static double averageOfFirstHalfElements(int[] array) {
        int sum = sumOfFirstHalfElements(array);
        int count = array.length / 2; // Count of first half elements
        return count > 0 ? (double) sum / count : 0;
    }

    public static double averageOfSecondHalfElements(int[] array) {
        int sum = sumOfSecondHalfElements(array);
        int count = array.length / 2; // Count of second half elements
        return count > 0 ? (double) sum / count : 0;
    }

    public static int sumOfEvenElements(int[] array) {
        int sum = 0;
        for (int i = 0; i < array.length; i += 2) { // Sum elements at even indices
            sum += array[i];
        }
        return sum;
    }

    public static int sumOfOddElements(int[] array) {
        int sum = 0;
        for (int i = 1; i < array.length; i += 2) { // Sum elements at odd indices
            sum += array[i];
        }
        return sum;
    }

    public static int sumOfFirstHalfElements(int[] array) {
        int sum = 0;
        for (int i = 0; i < array.length / 2; i++) {
            sum += array[i];
        }
        return sum;
    }

    public static int sumOfSecondHalfElements(int[] array) {
        int sum = 0;
        for (int i = array.length / 2; i < array.length; i++) {
            sum += array[i];
        }
        return sum;
    }
}
