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
                System.out.print(k + " ");
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
                System.out.print((char) (64 + k) + " ");
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
            for (int j = 1; j <= i; j++) {
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

    public static void printBinaryPattern(int rows) {
        int currentVal;
        for (int i = 1; i <= rows; i++) {
            currentVal = (i % 2 == 0) ? 0 : 1;
            for (int j = 1; j <= i; j++) {
                System.out.print(currentVal + " ");
                currentVal = (currentVal + 1) % 2;
            }
            System.out.println();
        }
    }

    public static void printCrossPattern(int size) {
        for (int i = 1; i <= size; i++) {
            for (int j = 1; j <= size; j++) {
                if ((i != (size / 2 + 1) && j == (size / 2 + 1)) || (i == (size / 2 + 1) && j != (size / 2 + 1))) {
                    System.out.print("* ");
                } else if (i == (size / 2 + 1) && j == (size / 2 + 1)) {
                    System.out.print("# ");
                } else {
                    System.out.print("  ");
                }
            }
            System.out.println();
        }
    }

    public static void printPatterns(int rows) {
        if (rows > 0) {
            System.out.println("Star Pattern:");
            printStarPattern(rows);
            System.out.println();

            System.out.println("Number Pattern:");
            printNumberPattern(rows);
            System.out.println();

            System.out.println("Alphabet Pattern:");
            printAlphabetPattern(rows);
            System.out.println();

            System.out.println("Triangle Pattern:");
            printTrianglePattern(rows);
            System.out.println();

            System.out.println("Inverted Triangle Pattern:");
            printInvertedTrianglePattern(rows);
            System.out.println();

            System.out.println("Centered Triangle Pattern:");
            printCenteredTrianglePattern(rows);
            System.out.println();

            System.out.println("Binary Pattern:");
            printBinaryPattern(rows);
            System.out.println();

            System.out.println("Cross Pattern:");
            printCrossPattern(rows);
            System.out.println();
        } else {
            System.out.println("Rows should be greater than 0.");
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of rows: ");
        int rows = scanner.nextInt();

        printPatterns(rows);
        scanner.close();
    }
}
