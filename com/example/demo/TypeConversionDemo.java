package com.example.demo;

public class TypeConversionDemo {
    public void showTypeConversion() {
        short a = 10;
        int b = a; // Implicit widening
        short c = (short) b; // Explicit narrowing
        
        System.out.println("\nType Conversion:");
        System.out.println("Widening (short to int): " + b);
        System.out.println("Narrowing (int to short): " + c);
    }
}
