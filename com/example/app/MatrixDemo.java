package com.example.app;

import com.example.matrix.MatrixOperations;

import java.util.Scanner;

public class MatrixDemo {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Reading Matrix A
        System.out.print("Enter the number of rows for Matrix A: ");
        int rowsA = scanner.nextInt();
        System.out.print("Enter the number of columns for Matrix A: ");
        int colsA = scanner.nextInt();
        int[][] matrixA = readMatrix(scanner, rowsA, colsA, "A");

        // Reading Matrix B
        System.out.print("Enter the number of rows for Matrix B: ");
        int rowsB = scanner.nextInt();
        System.out.print("Enter the number of columns for Matrix B: ");
        int colsB = scanner.nextInt();
        int[][] matrixB = readMatrix(scanner, rowsB, colsB, "B");

        // Matrix Addition
        int[][] sum = MatrixOperations.addMatrices(matrixA, matrixB);
        printResult("Addition", sum);

        // Matrix Subtraction
        int[][] difference = MatrixOperations.subtractMatrices(matrixA, matrixB);
        printResult("Subtraction", difference);

        // Matrix Multiplication
        int[][] product = MatrixOperations.multiplyMatrices(matrixA, matrixB);
        printResult("Multiplication", product);

        // Transpose of Matrix A
        int[][] transposeA = MatrixOperations.transposeMatrix(matrixA);
        printResult("Transpose of Matrix A", transposeA);

        // Transpose of Matrix B
        int[][] transposeB = MatrixOperations.transposeMatrix(matrixB);
        printResult("Transpose of Matrix B", transposeB);

        scanner.close();
    }

    private static int[][] readMatrix(Scanner scanner, int rows, int cols, String name) {
        int[][] matrix = new int[rows][cols];
        System.out.println("Enter elements of Matrix " + name + ":");
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                System.out.printf("Element [%d][%d]: ", i, j);
                matrix[i][j] = scanner.nextInt();
            }
        }
        return matrix;
    }

    private static void printResult(String operation, int[][] result) {
        System.out.println("\nResult of " + operation + ":");
        if (result == null) {
            System.out.println("Operation not possible due to incompatible matrix dimensions.");
            return;
        }
        for (int[] row : result) {
            for (int element : row) {
                System.out.print(element + "\t");
            }
            System.out.println();
        }
    }
}
