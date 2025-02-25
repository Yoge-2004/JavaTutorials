package com.example.patterns;

import java.util.Scanner;

public class Pattern {

    // Hollow Inverted Pyramid  
    public static void printHollowInvertedPyramid(int rows) {
        for (int i = rows; i >= 1; i--) {
            for (int j = rows - i; j >= 1; j--) {
                System.out.print(" ");
            }
            for (int k = i; k >= 1; k--) {
                if (k == 1 || k == i || i == rows) {
                    System.out.print("* ");
                } else {
                    System.out.print("  ");
                }
            }
            System.out.println();
        }
    }

    // Odd Pyramid  
    public static void printOddPyramid(int rows) {
        for (int i = 1; i <= rows; i++) {
            for (int j = 2 * (rows - i); j >= 1; j--) {
                System.out.print(" ");
            }
            for (int k = 1; k <= 2 * i - 1; k++) {
                System.out.print("* ");
            }
            System.out.println();
        }
    }

    // Inverted Odd Pyramid  
    public static void printInvertedOddPyramid(int rows) {
        for (int i = rows; i >= 1; i--) {
            for (int j = 1; j <= 2 * (rows - i); j++) {
                System.out.print(" ");
            }
            for (int k = 1; k <= 2 * i - 1; k++) {
                System.out.print("* ");
            }
            System.out.println();
        }
    }

    // Zigzag Number Pattern  
    public static void printZigzagNumberPattern(int rows) {
        int number = 1;
        for (int i = 1; i <= rows; i++) {
            number += i;
            for (int j = 1; j <= i; j++) {
                System.out.print((number - j) + " ");
            }
            System.out.println();
        }
    }

    // Star Pattern  
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

    // Number Pattern  
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

    // Alphabet Pattern  
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

    // Triangle Pattern  
    public static void printTrianglePattern(int rows) {
        for (int i = 1; i <= rows; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print("* ");
            }
            System.out.println();
        }
    }

    // Inverted Triangle Pattern  
    public static void printInvertedTrianglePattern(int rows) {
        for (int i = rows; i >= 1; i--) {
            for (int j = 1; j <= i; j++) {
                System.out.print("* ");
            }
            System.out.println();
        }
    }

    // Centered Triangle Pattern  
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

    // Binary Pattern  
    public static void printBinaryPattern(int rows) {
        for (int i = 1; i <= rows; i++) {
            int currentVal = (i % 2 == 0) ? 0 : 1;
            for (int j = 1; j <= i; j++) {
                System.out.print(currentVal + " ");
                currentVal = (currentVal + 1) % 2;
            }
            System.out.println();
        }
    }

    // Cross Pattern  
    public static void printCrossPattern(int size) {
        for (int i = 1; i <= size; i++) {
            for (int j = 1; j <= size; j++) {
                if ((i != (size / 2 + 1) && j == (size / 2 + 1))
                        || (i == (size / 2 + 1) && j != (size / 2 + 1))) {
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

    // Half Butterfly Pattern  
    public static void printHalfButterflyPattern(int rows) {
        for (int i = 1; i <= rows; i++) {
            // Left Quarter of Butterfly  
            for (int j = 1; j <= i; j++) {
                System.out.print("* ");
            }
            // White spaces (except on the last row, print an extra star)  
            if (i == rows) {
                System.out.print("* ");
            } else {
                for (int k = 1; k < 2 * (rows - i + 1); k++) {
                    System.out.print("  ");
                }
            }
            // Right Quarter of Butterfly  
            for (int l = 1; l <= i; l++) {
                System.out.print("* ");
            }
            System.out.println();
        }
    }

    // Diamond Pattern  
    public static void printDiamondPattern(int rows) {
        // Top part of Diamond  
        for (int i = 1; i <= rows; i++) {
            for (int j = 1; j <= rows - i; j++) {
                System.out.print(" ");
            }
            for (int k = 1; k <= i; k++) {
                System.out.print("* ");
            }
            System.out.println();
        }
        // Bottom part of Diamond  
        for (int i = rows; i >= 1; i--) {
            for (int j = rows - i + 1; j >= 1; j--) {
                System.out.print(" ");
            }
            for (int k = i - 1; k >= 1; k--) {
                System.out.print("* ");
            }
            System.out.println();
        }
    }

    // Diagonal Pattern (with letters on the diagonal and numbers elsewhere)
    public static void printDiagonalPattern(int rows) {
        char ch = 'A';
        int num = 2, temp = 3;
        for (int i = 1; i <= rows; i++) {
            for (int j = 1; j <= rows; j++) {
                if (i == j) {
                    System.out.print(ch++ + " ");
                    num++;
                } else {
                    System.out.print(num++ + " ");
                }
            }
            System.out.println();
            num = temp++;
        }
    }

    // Master method to print all patterns
    public static void printAllPatterns(int rows) {
        if (rows <= 0) {
            System.out.println("Rows should be greater than 0.");
            return;
        }

        System.out.println("Hollow Inverted Pyramid:");
        printHollowInvertedPyramid(rows);
        System.out.println();

        System.out.println("Odd Pyramid:");
        printOddPyramid(rows);
        System.out.println();

        System.out.println("Inverted Odd Pyramid:");
        printInvertedOddPyramid(rows);
        System.out.println();

        System.out.println("Zigzag Number Pattern:");
        printZigzagNumberPattern(rows);
        System.out.println();

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

        System.out.println("Half Butterfly Pattern:");
        printHalfButterflyPattern(rows);
        System.out.println();

        System.out.println("Diamond Pattern:");
        printDiamondPattern(rows);
        System.out.println();

        // Call the Diagonal Pattern from within printAllPatterns
        System.out.println("Diagonal Pattern:");
        printDiagonalPattern(rows);
        System.out.println();
    }

    // Main method  
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number of rows: ");
        int rows = scanner.nextInt();
        System.out.println();

        System.out.println("=== Printing All Patterns ===");
        printAllPatterns(rows);

        scanner.close();
    }
}
