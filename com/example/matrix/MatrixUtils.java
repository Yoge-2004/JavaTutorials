package com.example.matrix;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;

public class MatrixUtils {

    // Check if the given array is sorted in non-decreasing order.
    public static boolean isArraySorted(int[] arr) {
        int[] sortedArr = arr.clone();
        Arrays.sort(sortedArr);
        return Arrays.equals(arr, sortedArr);
    }

    // Returns an array containing the sum of each row in the matrix.
    public static int[] rowSum(int[][] mat) {
        int[] rowSums = new int[mat.length];
        int i = 0;
        for (int[] row : mat) {
            int sum = 0;
            for (int ele : row) {
                sum += ele;
            }
            rowSums[i++] = sum;
        }
        return rowSums;
    }

    // Returns an array containing the sum of each column in the matrix.
    public static int[] colSum(int[][] mat) {
        int[] colSums = new int[mat[0].length];
        for (int i = 0; i < mat[0].length; i++) {
            int sum = 0;
            for (int j = 0; j < mat.length; j++) {
                sum += mat[j][i];
            }
            colSums[i] = sum;
        }
        return colSums;
    }

    // Returns a list of integers representing the matrix traversed in a snake pattern.
    public static ArrayList<Integer> snakePattern(int[][] matrix) {
        ArrayList<Integer> result = new ArrayList<>();
        for (int i = 0; i < matrix.length; i++) {
            if (i % 2 == 0) {
                for (int j = 0; j < matrix[i].length; j++) {
                    result.add(matrix[i][j]);
                }
            } else {
                for (int j = matrix[i].length - 1; j >= 0; j--) {
                    result.add(matrix[i][j]);
                }
            }
        }
        return result;
    }

    // Returns the minimum number of 1's present in any row of the matrix.
    public static int minRow(int[][] mat) {
        int[] countOnes = new int[mat.length];
        for (int i = 0; i < mat.length; i++) {
            int count = 0;
            for (int j = 0; j < mat[i].length; j++) {
                if (mat[i][j] == 1) {
                    count++;
                }
            }
            countOnes[i] = count;
        }
        return Arrays.stream(countOnes).min().orElse(0);
    }

    // Checks if the matrix is a magic square.
    public static String magicSquare(int[][] mat) {
        // Check that all elements are distinct.
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[i].length; j++) {
                if (!set.add(mat[i][j])) {
                    return "Not a Magic Square";
                }
            }
        }
        
        int magicSum = Arrays.stream(mat[0]).sum();
        
        // Check sum of each row.
        for (int i = 1; i < mat.length; i++) {
            if (magicSum != Arrays.stream(mat[i]).sum()) {
                return "Not a Magic Square";
            }
        }
        
        // Check sum of each column.
        for (int i = 0; i < mat[0].length; i++) {
            int sum = 0;
            for (int j = 0; j < mat.length; j++) {
                sum += mat[j][i];
            }
            if (magicSum != sum) {
                return "Not a Magic Square";
            }
        }
        
        // Check sum of the main diagonal.
        int diagonalSum = 0;
        for (int i = 0; i < mat.length; i++) {
            diagonalSum += mat[i][i];
        }
        if (diagonalSum != magicSum) {
            return "Not a Magic Square";
        }
        
        // Check sum of the secondary diagonal.
        diagonalSum = 0;
        for (int i = 0; i < mat.length; i++) {
            diagonalSum += mat[i][mat.length - i - 1];
        }
        if (diagonalSum != magicSum) {
            return "Not a Magic Square";
        }
        
        return "Magic Square";
    }

    // Driver code to test all methods
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Testing isArraySorted
        System.out.print("Enter size of array: ");
        int n = sc.nextInt();
        int[] arr = new int[n];
        System.out.println("Enter array elements:");
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        System.out.println("Is array sorted? " + isArraySorted(arr));

        // Testing rowSum, colSum, snakePattern, minRow, and magicSquare
        System.out.print("\nEnter size of matrix (n x m): ");
        int rows = sc.nextInt();
        int cols = sc.nextInt();
        int[][] mat = new int[rows][cols];

        System.out.println("Enter matrix elements:");
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                mat[i][j] = sc.nextInt();
            }
        }

        // Testing rowSum
        System.out.println("Row sums: " + Arrays.toString(rowSum(mat)));

        // Testing colSum
        System.out.println("Column sums: " + Arrays.toString(colSum(mat)));

        // Testing snakePattern
        System.out.println("Snake pattern traversal: " + snakePattern(mat));

        // Testing minRow
        System.out.println("Minimum number of 1s in any row: " + minRow(mat));

        // Testing magicSquare (only valid for square matrices)
        if (rows == cols) {
            System.out.println("Magic square test: " + magicSquare(mat));
        } else {
            System.out.println("Magic square test skipped (matrix is not square).");
        }

        sc.close();
    }
}