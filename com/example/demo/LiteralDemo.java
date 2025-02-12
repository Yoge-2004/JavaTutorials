package com.example.demo;

public class LiteralDemo {
    public void showLiterals() {
        byte a = 10;
        short b = 10;
        int c = 10;
        long d = 10L;
        float e = 10.0f;
        double f = 10.0;
        char g = 97; // Equivalent to 'a'
        boolean h = true;
        String i = "Hello World!";
        
        System.out.println("\nLiterals:");
        System.out.println("Byte: " + a);
        System.out.println("Short: " + b);
        System.out.println("Integer: " + c);
        System.out.println("Long: " + d);
        System.out.println("Float: " + e);
        System.out.println("Double: " + f);
        System.out.println("Char (ASCII 97): " + g);
        System.out.println("Boolean: " + h);
        System.out.println("String: " + i);
    }
}
