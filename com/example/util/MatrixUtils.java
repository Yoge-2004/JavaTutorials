package com.example.util;

import java.util.*;

class MatrixUtils {

    // Function to check if an array is sorted
    public boolean arraySortedOrNot(int[] arr) {
        int[] sortedArr = arr.clone();
        Arrays.sort(sortedArr);
        return Arrays.equals(arr, sortedArr);
    }

    // Function to find the largest element in an array
    public static int largest(int[] arr) {
        return Arrays.stream(arr).max().getAsInt();
    }

    // Function to compute the column sum of a matrix
    public static int[] colSum(int mat[][]) {
        int colSum[] = new int[mat[0].length];
        
        for (int i = 0; i < mat[0].length; i++) {
            int sum = 0;
            for (int j = 0; j < mat.length; j++) {
                sum += mat[j][i];
            }
            colSum[i] = sum;
        }
        
        return colSum;
    }

    // Function to return a list of integers visited in snake pattern in a matrix
    static ArrayList<Integer> snakePattern(int matrix[][]) {
        ArrayList<Integer> arr = new ArrayList<>();
        
        for (int i = 0; i < matrix.length; i++) {
            if (i % 2 == 0) {
                for (int j = 0; j < matrix[i].length; j++) {
                    arr.add(matrix[i][j]);
                }
            } else {
                for (int j = matrix[i].length - 1; j >= 0; j--) {
                    arr.add(matrix[i][j]);
                }
            }
        }
        return arr;
    }

    // Function to find the row with the minimum number of 1s in a matrix
    int minRow(int mat[][]) {
        int min1s[] = new int[mat.length]; // Fix: Use mat.length instead of mat[0].length
        
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[i].length; j++) {
                if (mat[i][j] == 1) {
                    min1s[i]++;
                }
            }
        }
        
        return Arrays.stream(min1s).min().getAsInt();
    }

    // Driver code
    public static void main(String[] args) {
        MatrixUtils utils = new MatrixUtils();

        // Test arraySortedOrNot
        int[] arr1 = {1, 2, 3, 4, 5};
        System.out.println("Array Sorted: " + utils.arraySortedOrNot(arr1));

        int[] arr2 = {5, 3, 4, 2, 1};
        System.out.println("Array Sorted: " + utils.arraySortedOrNot(arr2));

        // Test largest
        int[] arr3 = {10, 20, 5, 8, 50};
        System.out.println("Largest Element: " + largest(arr3));

        // Test colSum
        int[][] matrix = {
            {1, 2, 3},
            {4, 5, 6},
            {7, 8, 9}
        };
        System.out.println("Column Sums: " + Arrays.toString(colSum(matrix)));

        // Test snakePattern
        System.out.println("Snake Pattern: " + snakePattern(matrix));

        // Test minRow
        int[][] binaryMatrix = {
            {0, 0, 1},
            {1, 1, 1},
            {0, 1, 0}
        };
        System.out.println("Row with Minimum 1s: " + utils.minRow(binaryMatrix));
    }
}