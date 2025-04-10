package com.example.util;

import java.util.*;

class MatrixUtils {

    // Function to find the largest element in an array
    public static int largest(int[] arr) {
        return Arrays.stream(arr).max().getAsInt();
    }

    // Function to find the row with the minimum number of 1s in a matrix
    public int minRow(int mat[][]) {
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

        // Test largest
        int[] arr = {10, 20, 5, 8, 50};
        System.out.println("Largest Element: " + largest(arr));
        
        // Test snakePattern
        int[][] matrix = {
            {1, 2, 3},
            {4, 5, 6},
            {7, 8, 9}
        };
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
