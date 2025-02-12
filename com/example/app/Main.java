package com.example.app;

import java.util.Scanner;
import com.example.io.IOHelper;
import com.example.demo.VariableDemo;
import com.example.demo.OperatorDemo;
import com.example.demo.LiteralDemo;
import com.example.demo.TypeConversionDemo;
import com.example.demo.MethodDemo;
import com.example.demo.BranchingDemo;
import com.example.util.GradeCalculator;
import com.example.util.GeneralUtility;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // I/O demonstration
        IOHelper.display();
        
        // Variable demonstration
        VariableDemo variableDemo = new VariableDemo();
        variableDemo.showVariables();
        
        // Operator demonstrations
        OperatorDemo opDemo = new OperatorDemo();
        opDemo.assignmentOperators();
        opDemo.arithmeticOperators();
        opDemo.logicalOperators();
        opDemo.bitwiseOperators();
        opDemo.incrementDecrementDemo();
        opDemo.relationalOperatorsDemo();
        
        // Literal demonstration
        LiteralDemo literalDemo = new LiteralDemo();
        literalDemo.showLiterals();
        
        // Type Conversion demonstration
        TypeConversionDemo typeConvDemo = new TypeConversionDemo();
        typeConvDemo.showTypeConversion();
        
        // Methods demonstration
        System.out.println("\nMethod Demonstrations:");
        int sum = MethodDemo.add(10, 20);
        System.out.println("Sum of 10 and 20 is: " + sum);
        
        MethodDemo methodDemo = new MethodDemo();
        int[] candyDistribution = methodDemo.distributeCandies(30, 7);
        System.out.println("Candy Distribution:");
        System.out.println(candyDistribution[0] + " candies per student, " + candyDistribution[1] + " remaining.");
        
        boolean speeding = methodDemo.isOverSpeeding(60, 75);
        System.out.println("Car speed check: " + (speeding ? "Car crosses the threshold speed." : "Car does not cross the threshold speed."));
        
        // Overloaded method calls
        MethodDemo.displayMessage();
        MethodDemo.displayMessage("Alex");
        MethodDemo.displayMessage("Hello", "Alex");
        
        // Branching statements demonstration
        BranchingDemo.determineWeather(true, 30.0);
        System.out.println("Is 3 even? " + BranchingDemo.isEven(3));
        System.out.println("Is 2024 a leap year? " + BranchingDemo.isLeapYear(2024));
        
        // Gross Salary Calculation
        System.out.print("\nEnter the basic salary: ");
        int basicSalary = scanner.nextInt();
        System.out.print("Enter the current year: ");
        int currentYear = scanner.nextInt();
        System.out.print("Enter the year of joining: ");
        int yearJoined = scanner.nextInt();
        
        if (String.valueOf(currentYear).length() == 4 && String.valueOf(yearJoined).length() == 4) {
            int experience = currentYear - yearJoined;
            double grossSalary = BranchingDemo.calculateGrossSalary(basicSalary, experience);
            System.out.println("Gross Salary: Rs." + grossSalary);
        } else {
            System.out.println("Invalid Year Input!");
        }
        
        // Grade Calculation demonstration
        System.out.println("\nGrade Calculation:");
        char grade = GradeCalculator.calculateGrade(95, 85, 76);
        System.out.println("Calculated Grade: " + grade);
        
        // General Utility Functions Demonstration
        System.out.println("\nTriangle Validity Check:");
        boolean validTriangle = GeneralUtility.isValidTriangle(60, 60, 60);
        System.out.println("Is triangle valid? " + validTriangle);
        
        System.out.println("\nRectangle Area vs Perimeter:");
        boolean areaGreater = GeneralUtility.compareRectangleAreaPerimeter(5.0, 3.0);
        System.out.println("Is area greater than perimeter? " + areaGreater);
        
        System.out.println("\nCalculator Simulation:");
        GeneralUtility.calculator(10, '+', 5);
        GeneralUtility.calculator(10, '-', 5);
        GeneralUtility.calculator(10, '*', 5);
        GeneralUtility.calculator(10, '/', 5);
        GeneralUtility.calculator(10, '%', 5);
        
        System.out.println("\nMonth Name Display:");
        GeneralUtility.displayMonthName(4);
        
        System.out.println("\nYoungest Age Determination:");
        int youngest = GeneralUtility.findYoungest(25, 30, 22);
        System.out.println("Youngest age is: " + youngest);
        
        System.out.println("\nSteel Grade Determination:");
        int steelGrade = GeneralUtility.determineSteelGrade(55, 0.6, 6000);
        System.out.println("Steel Grade is: " + steelGrade);
        
        System.out.println("\nWorker Efficiency Evaluation:");
        String efficiency = GeneralUtility.evaluateWorkerEfficiency(4);
        System.out.println("Worker Efficiency: " + efficiency);
        
        System.out.println("\nATM Simulation:");
        String atmResult = GeneralUtility.simulateATMTransaction(5000, 2000);
        System.out.println("ATM Transaction: " + atmResult);
        
        System.out.println("\nElevator Load Evaluation:");
        String elevatorStatus = GeneralUtility.evaluateElevatorLoad(450);
        System.out.println("Elevator Status: " + elevatorStatus);
        
        scanner.close();
    }
}
