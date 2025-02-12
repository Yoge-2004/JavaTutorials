package com.example.demo;

public class OperatorDemo {
    public void assignmentOperators() {
        int a = 20, b = 10;
        System.out.println("\nAssignment Operators:");
        a += b;
        System.out.println("a += b -> " + a);
        a -= b;
        System.out.println("a -= b -> " + a);
        a *= b;
        System.out.println("a *= b -> " + a);
        a /= b;
        System.out.println("a /= b -> " + a);
        a %= b;
        System.out.println("a %= b -> " + a);
    }
    
    public void arithmeticOperators() {
        byte a = 10, b = 10;
        byte c = (byte) (a + b);
        System.out.println("\nArithmetic Operators:");
        System.out.println("10 + 10 = " + (10 + 10));
        System.out.println("\"Hi\" + true = " + ("Hi" + true));
        System.out.println("10 * 'a' (ASCII of 'a' is " + (int)'a' + ") = " + (10 * 'a'));
        System.out.println("'a' / 'b' (ASCII division: " + (int)'a' + " / " + (int)'b' + ") = " + ('a' / 'b'));
        System.out.println("'a' % 'b' (ASCII modulus: " + (int)'a' + " % " + (int)'b' + ") = " + ('a' % 'b'));
    }
    
    public void logicalOperators() {
        boolean a = true, b = false;
        System.out.println("\nLogical Operators:");
        System.out.println("a && b -> " + (a && b));
        System.out.println("a || b -> " + (a || b));
        System.out.println("!a -> " + (!a));
    }
    
    public void bitwiseOperators() {
        int a = 10, b = 1;
        System.out.println("\nBitwise Operators:");
        System.out.println("a & b -> " + (a & b));
        System.out.println("a | b -> " + (a | b));
        System.out.println("~a (bitwise NOT) -> " + (~a));
        System.out.println("a ^ b (XOR) -> " + (a ^ b));
        System.out.println("a << b (Left shift) -> " + (a << b));
        System.out.println("a >> b (Right shift) -> " + (a >> b));
        System.out.println("-5 >>> b (Unsigned Right Shift) -> " + (-5 >>> b));
    }
    
    public void incrementDecrementDemo() {
        System.out.println("\nIncrement and Decrement Operators:");
        int x = 5;
        System.out.println("Initial x = " + x);
        System.out.println("Post-increment (x++) = " + (x++));
        System.out.println("After post-increment, x = " + x);
        System.out.println("Pre-increment (++x) = " + (++x));
        System.out.println("Post-decrement (x--) = " + (x--));
        System.out.println("After post-decrement, x = " + x);
        System.out.println("Pre-decrement (--x) = " + (--x));
    }
    
    public void relationalOperatorsDemo() {
        System.out.println("\nRelational Operators:");
        int a = 10, b = 20;
        System.out.println("a = " + a + ", b = " + b);
        System.out.println("a == b: " + (a == b));
        System.out.println("a != b: " + (a != b));
        System.out.println("a > b: " + (a > b));
        System.out.println("a < b: " + (a < b));
        System.out.println("a >= b: " + (a >= b));
        System.out.println("a <= b: " + (a <= b));
    }
}
