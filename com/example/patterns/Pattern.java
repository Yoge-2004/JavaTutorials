package com.example.patterns;

import java.util.Scanner;

public class PatternDemo {

    public static void printButterflyPattern(int rows) {
        for (int i = 1; i <= rows; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print("* ");
            }
            for (int space = 1; space < 2 * (rows - i); space++) {
                System.out.print("  ");
            }
            for (int j = 1; j <= i; j++) {
                System.out.print("* ");
            }
            System.out.println();
        }
        for (int i = rows - 1; i >= 1; i--) {
            for (int j = 1; j <= i; j++) {
                System.out.print("* ");
            }
            for (int space = 1; space < 2 * (rows - i); space++) {
                System.out.print("  ");
            }
            for (int j = 1; j <= i; j++) {
                System.out.print("* ");
            }
            System.out.println();
        }
    }

    public static void printSpiralPattern(int rows) {
        int[][] matrix = new int[rows][rows];
        int top = 0, bottom = rows - 1, left = 0, right = rows - 1;
        int value = 1;
        while (left <= right && top <= bottom) {
            for (int i = left; i <= right; i++) {
                matrix[top][i] = value++;
            }
            top++;
            for (int i = top; i <= bottom; i++) {
                matrix[i][right] = value++;
            }
            right--;
            if (top <= bottom) {
                for (int i = right; i >= left; i--) {
                    matrix[bottom][i] = value++;
                }
                bottom--;
            }
            if (left <= right) {
                for (int i = bottom; i >= top; i--) {
                    matrix[i][left] = value++;
                }
                left++;
            }
        }
        for (int[] row : matrix) {
            for (int col : row) {
                System.out.printf("%2d ", col);
            }
            System.out.println();
        }
    }

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
        for (int i = 1; i <= rows; i++) {
            int currentVal = (i % 2 == 0) ? 0 : 1;
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

    public static void printHalfButterflyPattern(int rows) {
        for (int i = 1; i <= rows; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print("* ");
            }
            if (i == rows) {
                System.out.print("* ");
            } else {
                for (int k = 1; k < 2 * (rows - i + 1); k++) {
                    System.out.print("  ");
                }
            }
            for (int l = 1; l <= i; l++) {
                System.out.print("* ");
            }
            System.out.println();
        }
    }

    public static void printDiamondPattern(int rows) {
        for (int i = 1; i <= rows; i++) {
            for (int j = 1; j <= rows - i; j++) {
                System.out.print(" ");
            }
            for (int k = 1; k <= i; k++) {
                System.out.print("* ");
            }
            System.out.println();
        }
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

    public static void printAllPatterns(int rows) {
        if (rows <= 0) {
            System.out.println("Rows should be greater than 0.");
            return;
        }
        System.out.println("Butterfly Pattern:");
        printButterflyPattern(rows);
        System.out.println();
        System.out.println("Spiral Pattern:");
        printSpiralPattern(rows);
        System.out.println();
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
        System.out.println("Diagonal Pattern:");
        printDiagonalPattern(rows);
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choice;
        do {
            System.out.println("=== Pattern Printer Menu ===");
            System.out.println("1. All Patterns");
            System.out.println("2. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            System.out.println();
            switch (choice) {
                case 1:
                    System.out.print("Enter number of rows for All Patterns: ");
                    int allRows = scanner.nextInt();
                    System.out.println();
                    printAllPatterns(allRows);
                    break;
                case 2:
                    System.out.println("Exiting. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice. Please select again.");
            }
            System.out.println();
        } while (choice != 2);
        scanner.close();
    }
}