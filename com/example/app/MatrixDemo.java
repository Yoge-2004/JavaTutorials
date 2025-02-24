package com.example.app;

import com.example.matrix.MatrixOperations;

public class MatrixDemo {
    public static void main(String[] args) {
        int[][] matrixA = { {1, 2}, {3, 4} };
        int[][] matrixB = { {5, 6}, {7, 8} };

        System.out.println("Matrix A:");
        printMatrix(matrixA);

        System.out.println("\nMatrix B:");
        printMatrix(matrixB);

        int[][] sum = MatrixOperations.addMatrices(matrixA, matrixB);
        if (sum != null) {
            System.out.println("\nSum of Matrices:");
            printMatrix(sum);
        } else {
            System.out.println("\nMatrices cannot be added.");
        }

        int[][] product = MatrixOperations.multiplyMatrices(matrixA, matrixB);
        if (product != null) {
            System.out.println("\nProduct of Matrices:");
            printMatrix(product);
        } else {
            System.out.println("\nMatrices
