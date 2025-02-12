package com.example.demo;

public class VariableDemo {
    public void showVariables() {
        int a = 10;
        int b = a;
        int c = a + b;
        System.out.println("\nVariable Values:");
        System.out.println("a = " + a);
        System.out.println("b (copy of a) = " + b);
        System.out.println("c (sum of a and b) = " + c);
    }
}
