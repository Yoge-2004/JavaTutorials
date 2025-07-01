package com.example.matrix;

import java.util.Arrays;

public class MatrixDriver {

    public static void main(String[] args) {

        int[][] matrixA = {
            {1, 2, 3},
            {4, 5, 6},
            {7, 8, 9}
        };

        int[][] matrixB = {
            {9, 8, 7},
            {6, 5, 4},
            {3, 2, 1}
        };

        int[][] matrixC = {
            {1, 2},
            {3, 4},
            {5, 6}
        };

        System.out.println("Matrix A:");
        printMatrix(matrixA);

        System.out.println("\nMatrix B:");
        printMatrix(matrixB);

        // Addition
        System.out.println("\nAddition of Matrix A and Matrix B:");
        int[][] additionResult = MatrixOperations.addMatrices(matrixA, matrixB);
        printMatrix(additionResult);

        // Subtraction
        System.out.println("\nSubtraction of Matrix A and Matrix B:");
        int[][] subtractionResult = MatrixOperations.subtractMatrices(matrixA, matrixB);
        printMatrix(subtractionResult);

        // Multiplication
        System.out.println("\nMultiplication of Matrix A and Matrix C:");
        int[][] multiplicationResult = MatrixOperations.multiplyMatrices(matrixA, matrixC);
        printMatrix(multiplicationResult);

        // Transpose
        System.out.println("\nTranspose of Matrix A:");
        int[][] transposeResult = MatrixOperations.transposeMatrix(matrixA);
        printMatrix(transposeResult);

        // Set Zeroes
        int[][] matrixWithZeroes = {
            {5, 0, 7},
            {8, 9, 10},
            {11, 12, 0}
        };

        System.out.println("\nMatrix before setting zeroes:");
        printMatrix(matrixWithZeroes);

        MatrixOperations.setZeroes(matrixWithZeroes);

        System.out.println("\nMatrix after setting zeroes:");
        printMatrix(matrixWithZeroes);
    }

    private static void printMatrix(int[][] matrix) {
        if (matrix == null) {
            System.out.println("Operation cannot be performed (Dimension Mismatch)");
            return;
        }
        for (int[] row : matrix) {
            System.out.println(Arrays.toString(row));
        }
    }
}
