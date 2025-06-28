package com.example.stringoperations;

import java.util.*;
import java.util.stream.*;
import java.util.regex.*;

public class PasswordValidator {
    private static final Pattern PASSWORD_PATTERN = Pattern.compile("^(?=.*[A-Z])(?=.*[a-z])(?=.*[0-9])(?=.*[@#&_])(?!.*\\s)[A-Za-z0-9@#&_]{8,15}$");
    
    public static boolean isValidPassword(String password) {
            return PASSWORD_PATTERN.matcher(password).matches();
    }
    
    public static void main(String[] args) {
        System.out.print("Enter the password: ");
        String password = new Scanner(System.in).nextLine();
        
        System.out.println(isValidPassword(password)? "Valid Password": "Invalid Password!");
    }
}
