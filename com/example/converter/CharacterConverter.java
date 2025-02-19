package com.example.converter;

import java.util.Scanner;

public class CharacterConverter {
    public static void convertToUppercase() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a character: ");
        char ch = scanner.next().charAt(0);
        
        if (ch >= 'a' && ch <= 'z') {
            System.out.println("Uppercase Equivalent: " + (char) (ch - 32));
        } else {
            System.out.println("Character is already uppercase or not a letter.");
        }
    }
}
