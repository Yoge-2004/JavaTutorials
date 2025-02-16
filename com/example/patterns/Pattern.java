package com.example.patterns;

import java.util.Scanner;

public class Pattern {

    public static void printStarPattern(int rows) {
        for (int i = 1; i <= rows; i++) {
            // Print leading spaces for a right-aligned pattern
            for (int j = 1; j <= rows - i; j++) {
                System.out.print(" ");
            }
            // Print stars with a trailing space
            for (int k = 1; k <= i; k++) {
                System.out.print("* ");
            }
            System.out.println();
        }
    }

    public static void printNumberPattern(int rows) {
        for (int i = 1; i <= rows; i++) {
            // Print leading spaces
            for (int j = 1; j <= rows - i; j++) {
                System.out.print(" ");
            }
            // Print numbers from 1 to i
            for (int k = 1; k <= i; k++) {
                System.out.print(k + " ");
            }
            System.out.println();
        }
    }

    public static void printAlphabetPattern(int rows) {
        for (int i = 1; i <= rows; i++) {
            // Print leading spaces
            for (int j = 1; j <= rows - i; j++) {
                System.out.print(" ");
            }
            // Print alphabets from 'A' onward (where A = 65 in ASCII)
            for (int k = 1; k <= i; k++) {
                System.out.print((char) (64 + k) + " ");
            }
            System.out.println();
        }
    }

    public static void printTrianglePattern(int rows) {
        for (int i = 1; i <= rows; i++) {
            // Print i stars
            for (int j = 1; j <= i; j++) {
                System.out.print("* ");
            }
            System.out.println();
        }
    }

    public static void printInvertedTrianglePattern(int rows) {
        for (int i = rows; i >= 1; i--) {
            // Print i stars in inverted order
            for (int j = 1; j <= i; j++) {
                System.out.print("* ");
            }
            System.out.println();
        }
    }

    public static void printCenteredTrianglePattern(int rows) {
        for (int i = 1; i <= rows; i++) {
            // Print leading spaces for centering
            for (int j = 1; j < 2 * (rows - i + 1); j++) {
                System.out.print(" ");
            }
            // Print i stars with a space after each star
            for (int k = 1; k <= i; k++) {
                System.out.print("* ");
            }
            System.out.println();
        }
    }

    // Added binary pattern method (alternating 1s and 0s for each row)
    public static void printBinaryPattern(int rows) {
        int currentVal;
        for (int i = 1; i <= rows; i++) {
            // Reset currentVal to 1 for odd-numbered rows
            if (i % 2 != 0) {
                currentVal = 1;
            } else {
                // For even-numbered rows, we continue with the last value from the previous row
                // (Alternatively, you could reset it for each row if desired)
                currentVal = 0;
            }
            for (int j = 1; j <= i; j++) {
                System.out.print(currentVal + " ");
                // Toggle between 1 and 0
                currentVal = (currentVal + 1) % 2;
            }
            System.out.println();
        }
    }

    // Method to call all pattern-printing methods
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
        } else {
            System.out.println("Rows should be greater than 0.");
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Prompt the user for the number of rows
        System.out.print("Enter the number of rows: ");
        int rows = scanner.nextInt();

        // Print all patterns
        printPatterns(rows);
        scanner.close();
    }
}
