package com.example.util;

public class GeneralUtility {
    public static boolean isValidTriangle(int... angles) {
        int sum = 0;
        for (int angle : angles) {
            sum += angle;
        }
        return (sum == 180);
    }
    
    public static boolean compareRectangleAreaPerimeter(double length, double breadth) {
        double area = length * breadth;
        double perimeter = 2 * (length + breadth);
        return (area > perimeter);
    }
    
    public static void calculator(double op1, char operator, double op2) {
        switch (operator) {
            case '+':
                System.out.println(op1 + " + " + op2 + " = " + (op1 + op2));
                break;
            case '-':
                System.out.println(op1 + " - " + op2 + " = " + (op1 - op2));
                break;
            case '*':
                System.out.println(op1 + " * " + op2 + " = " + (op1 * op2));
                break;
            case '/':
                if (op2 == 0) {
                    System.out.println("Division by zero error.");
                    return;
                }
                System.out.println(op1 + " / " + op2 + " = " + (op1 / op2));
                break;
            case '%':
                if (op2 == 0) {
                    System.out.println("Modulus by zero error.");
                    return;
                }
                System.out.println(op1 + " % " + op2 + " = " + (op1 % op2));
                break;
            default:
                System.out.println("Invalid Operation.");
        }
    }
    
    public static void displayMonthName(int month) {
        switch (month) {
            case 1:  System.out.println("January"); break;
            case 2:  System.out.println("February"); break;
            case 3:  System.out.println("March"); break;
            case 4:  System.out.println("April"); break;
            case 5:  System.out.println("May"); break;
            case 6:  System.out.println("June"); break;
            case 7:  System.out.println("July"); break;
            case 8:  System.out.println("August"); break;
            case 9:  System.out.println("September"); break;
            case 10: System.out.println("October"); break;
            case 11: System.out.println("November"); break;
            case 12: System.out.println("December"); break;
            default: System.out.println("Invalid Month! Month ranges from 1 to 12.");
        }
    }
    
    public static int findYoungest(int age1, int age2, int age3) {
        int youngest = age1;
        if (age2 < youngest) {
            youngest = age2;
        }
        if (age3 < youngest) {
            youngest = age3;
        }
        return youngest;
    }
    
    public static int determineSteelGrade(int hardness, double carbonContent, int tensileStrength) {
        boolean condition1 = hardness > 50;
        boolean condition2 = carbonContent < 0.7;
        boolean condition3 = tensileStrength > 5600;
        
        if (condition1 && condition2 && condition3) {
            return 10;
        } else if (condition1 && condition2) {
            return 9;
        } else if (condition2 && condition3) {
            return 8;
        } else if (condition1 && condition3) {
            return 7;
        } else if (condition1 || condition2 || condition3) {
            return 6;
        } else {
            return 5;
        }
    }
    
    public static String evaluateWorkerEfficiency(int timeTaken) {
        if (timeTaken >= 2 && timeTaken <= 3) {
            return "High Efficiency";
        } else if (timeTaken > 3 && timeTaken <= 4) {
            return "Should Improve the Speed of Worker";
        } else if (timeTaken > 4 && timeTaken <= 5) {
            return "The worker has to be trained.";
        } else if (timeTaken > 5) {
            return "The worker has to leave the company.";
        } else {
            return "Invalid Input.";
        }
    }
    
    public static String simulateATMTransaction(int availableBalance, int withdrawAmount) {
        boolean isValidAmount = (withdrawAmount % 100 == 0);
        boolean isBalanceSufficient = (availableBalance >= withdrawAmount);
        return (isValidAmount && isBalanceSufficient) ? "Transaction Successful." : "Insufficient Balance.";
    }
    
    public static String evaluateElevatorLoad(double currentWeight) {
        return (currentWeight > 500) ? "Overloaded" : "Can lift";
    }
}
