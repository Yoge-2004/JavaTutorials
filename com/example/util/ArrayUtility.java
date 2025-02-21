package com.example.util;

public class ArrayUtility {

    public static int findMinimum(int[] array) {
        if (array.length == 1) {
            return array[0];
        } else if (array.length == 2) {
            return (array[0] < array[1]) ? array[0] : array[1];
        }
        
        int min = Integer.MAX_VALUE;
        for (int element : array) {
            min = (element < min) ? element : min;
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
            max = (element > max) ? element : max;
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

    public static void printArrayReverse(int[] array) {
        for (int i = array.length - 1; i >= 0; i--) {
            System.out.print(array[i] + " ");
        }
    }

    public static int[] reverseArray(int[] array) {
        int size = array.length - 1;
        for (int i = 0; i < array.length / 2; i++) {
            array[i] = array[i] + array[size];
            array[size] = array[i] - array[size];
            array[i] = array[i] - array[size];
            size--;
        }
        return array;
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
            if (i == element)
                count++;
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
            return array; // Element not found; return original array.
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
        for (int i = 0; i < positions.length; i++) {
            int index = positions[i] - shift;
            for (int j = index; j < array.length - 1; j++) {
                array[j] = array[j + 1];
            }
            array[array.length - 1] = 0;
            shift++;
        }
        return array;
    }

    public static int[] shiftRight(int[] array, int shift) {
        if (array.length == 1) {
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
