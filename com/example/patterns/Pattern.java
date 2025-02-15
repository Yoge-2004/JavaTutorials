// File: com/example/patterns/RefactoredCode.java
package com.example.patterns;

import java.util.Scanner;

public class Pattern {

    public static void printStarPattern(int rows) {
        for (int i = 1; i <= rows; i++) {
            for (int j = 1; j <= rows - i; j++) {
                System.out.print(" ");
            }

            for (int k = 1; k <= i; k++) {
                System.out.print("* ");
            }
            System.out.println();
        }
    }

    public static void printNumberPattern(int rows) {
        for (int i = 1; i <= rows; i++) {
            for (int j = 1; j <= rows - i; j++) {
                System.out.print(" ");
            }

            for (int k = 1; k <= i; k++) {
                System.out.print(k);
                System.out.print(" ");
            }
            System.out.println();
        }
    }

    public static void printAlphabetPattern(int rows) {
        for (int i = 1; i <= rows; i++) {
            for (int j = 1; j <= rows - i; j++) {
                System.out.print(" ");
            }

            for (int k = 1; k <= i; k++) {
                System.out.print((char) (64 + k));
                System.out.print(" ");
            }
            System.out.println();
        }
    }

    public static void printTrianglePattern(int rows) {
        for (int i = 1; i <= rows; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print("* ");
            }
            System.out.println();
        }
    }

    public static void printInvertedTrianglePattern(int rows) {
        for (int i = rows; i >= 1; i--) {
            for (int j = i; j >= 1; j--) {
                System.out.print("* ");
            }
            System.out.println();
        }
    }

    public static void printCenteredTrianglePattern(int rows) {
        for (int i = 1; i <= rows; i++) {
            for (int j = 1; j < 2 * (rows - i + 1); j++) {
                System.out.print(" ");
            }
            for (int k = 1; k <= i; k++) {
                System.out.print("* ");
            }
            System.out.println();
        }
    }

    public static void printPatterns(int rows) {
        if (rows > 0) {
            printStarPattern(rows);
            System.out.println();
            printNumberPattern(rows);
            System.out.println();
            printAlphabetPattern(rows);
            System.out.println();
            printTrianglePattern(rows);
            System.out.println();
            printInvertedTrianglePattern(rows);
            System.out.println();
            printCenteredTrianglePattern(rows);
        } else {
            System.out.println("Rows should be greater than 0.");
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Prompt user for number of rows
        System.out.print("Enter the number of rows: ");
        int rows = scanner.nextInt();

        // Call method to print patterns
        printPatterns(rows);

    }
}
