package com.example.io;

import java.util.Scanner;

public class IOHelper {
    public static byte byteValue;
    public static short shortValue;
    public static int intValue;
    public static long longValue;
    
    public static void display() {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Output Statements:");
        System.out.println("Printing number: " + 10);
        System.out.print("Print without new line: " + 10);
        System.out.println();
        System.out.printf("Formatted output (%%d): %d%n", 10);
        
        System.out.println("\nEnter values for different data types:");
        System.out.print("Enter a byte value: ");
        byteValue = scanner.nextByte();
        System.out.print("Enter a short value: ");
        shortValue = scanner.nextShort();
        System.out.print("Enter an integer value: ");
        intValue = scanner.nextInt();
        System.out.print("Enter a long value: ");
        longValue = scanner.nextLong();
        System.out.print("Enter a float value: ");
        float floatValue = scanner.nextFloat();
        System.out.print("Enter a double value: ");
        double doubleValue = scanner.nextDouble();
        System.out.print("Enter a character: ");
        char charValue = scanner.next().charAt(0);
        System.out.print("Enter a boolean value (true/false): ");
        boolean booleanValue = scanner.nextBoolean();
        System.out.print("Enter a single word string: ");
        String singleWord = scanner.next();
        scanner.nextLine(); // consume newline
        System.out.print("Enter a full sentence: ");
        String fullSentence = scanner.nextLine();
        
        System.out.println("\nYou entered:");
        System.out.println("Byte: " + byteValue);
        System.out.println("Short: " + shortValue);
        System.out.println("Integer: " + intValue);
        System.out.println("Long: " + longValue);
        System.out.println("Float: " + floatValue);
        System.out.println("Double: " + doubleValue);
        System.out.println("Character: " + charValue);
        System.out.println("Boolean: " + booleanValue);
        System.out.println("Single word: " + singleWord);
        System.out.println("Full sentence: " + fullSentence);
        // Note: Scanner is intentionally not closed to allow further input usage.
    }
}
