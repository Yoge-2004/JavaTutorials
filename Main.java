import java.util.Scanner;

//Class dedicated to Grade Calculation.
class GradeCalculator {
    static char calculateGrade(int... subjectMarks) {
        int total = 0;
        for (int mark : subjectMarks) {
            total += mark;
        }
        double totalPercentage = (double) total / subjectMarks.length;
        if (totalPercentage >= 90.0) {
            return 'A';
        } else if (totalPercentage >= 80.0) {
            return 'B';
        } else if (totalPercentage >= 70.0) {
            return 'C';
        } else if (totalPercentage >= 60.0) {
            return 'D';
        } else if (totalPercentage >= 40.0) {
            return 'E';
        } else {
            return 'F';
        }
    }
}

// Class grouping miscellaneous utility methods.
class GeneralUtility {
    static boolean isValidTriangle(int... angles) {
        int sum = 0;
        for (int angle : angles) {
            sum += angle;
        }
        return (sum == 180);
    }
    
    static boolean compareRectangleAreaPerimeter(double length, double breadth) {
        double area = length * breadth;
        double perimeter = 2 * (length + breadth);
        return (area > perimeter);
    }
    
    static void calculator(double op1, char operator, double op2) {
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
    
    static void displayMonthName(int month) {
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
    
    static int findYoungest(int age1, int age2, int age3) {
        int youngest = age1;
        if (age2 < youngest) {
            youngest = age2;
        }
        if (age3 < youngest) {
            youngest = age3;
        }
        return youngest;
    }
    
    static int determineSteelGrade(int hardness, double carbonContent, int tensileStrength) {
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
    
    static String evaluateWorkerEfficiency(int timeTaken) {
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
    
    static String simulateATMTransaction(int availableBalance, int withdrawAmount) {
        boolean isValidAmount = (withdrawAmount % 100 == 0);
        boolean isBalanceSufficient = (availableBalance >= withdrawAmount);
        return (isValidAmount && isBalanceSufficient) ? "Transaction Successful." : "Insufficient Balance.";
    }
    
    static String evaluateElevatorLoad(double currentWeight) {
        return (currentWeight > 500) ? "Overloaded" : "Can lift";
    }
}

class IOHelper {
    public static byte byteValue;
    public static short shortValue;
    public static int intValue;
    public static long longValue;
    
    static void display() {
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
        // Scanner is intentionally not closed here for further input use.
    }
}

class VariableDemo {
    void showVariables() {
        int a = 10;
        int b = a;
        int c = a + b;
        System.out.println("\nVariable Values:");
        System.out.println("a = " + a);
        System.out.println("b (copy of a) = " + b);
        System.out.println("c (sum of a and b) = " + c);
    }
}

class OperatorDemo {
    void assignmentOperators() {
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
    
    void arithmeticOperators() {
        byte a = 10, b = 10;
        byte c = (byte) (a + b);
        System.out.println("\nArithmetic Operators:");
        System.out.println("10 + 10 = " + (10 + 10));
        System.out.println("\"Hi\" + true = " + ("Hi" + true));
        System.out.println("10 * 'a' (ASCII of 'a' is " + (int)'a' + ") = " + (10 * 'a'));
        System.out.println("'a' / 'b' (ASCII division: " + (int)'a' + " / " + (int)'b' + ") = " + ('a' / 'b'));
        System.out.println("'a' % 'b' (ASCII modulus: " + (int)'a' + " % " + (int)'b' + ") = " + ('a' % 'b'));
    }
    
    void logicalOperators() {
        boolean a = true, b = false;
        System.out.println("\nLogical Operators:");
        System.out.println("a && b -> " + (a && b));
        System.out.println("a || b -> " + (a || b));
        System.out.println("!a -> " + (!a));
    }
    
    void bitwiseOperators() {
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
    
    void incrementDecrementDemo() {
        System.out.println("\nIncrement and Decrement Operators:");
        int x = 5;
        System.out.println("Initial x = " + x);
        System.out.println("Post-increment (x++) = " + (x++)); // prints 5 then x becomes 6
        System.out.println("After post-increment, x = " + x);
        System.out.println("Pre-increment (++x) = " + (++x)); // increments then prints 7
        System.out.println("Post-decrement (x--) = " + (x--)); // prints 7 then x becomes 6
        System.out.println("After post-decrement, x = " + x);
        System.out.println("Pre-decrement (--x) = " + (--x)); // decrements then prints 5
    }
    
    void relationalOperatorsDemo() {
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

class LiteralDemo {
    void showLiterals() {
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

class TypeConversionDemo {
    void showTypeConversion() {
        short a = 10;
        int b = a; // Implicit widening
        short c = (short) b; // Explicit narrowing
        
        System.out.println("\nType Conversion:");
        System.out.println("Widening (short to int): " + b);
        System.out.println("Narrowing (int to short): " + c);
    }
}

class MethodDemo {
    // Addition method
    public static int add(int a, int b) {
        return a + b;
    }
    
    // Candy distribution: returns an array with evenly distributed candies and the remainder.
    public int[] distributeCandies(int totalCandies, int studentsCount) {
        int candiesEach = totalCandies / studentsCount;
        int remaining = totalCandies % studentsCount;
        return new int[] {candiesEach, remaining};
    }
    
    // Speed checking method
    public boolean isOverSpeeding(int carSpeed, int thresholdSpeed) {
        return (carSpeed > thresholdSpeed);
    }
    
    // Method overloading for displaying messages
    static void displayMessage() {
        System.out.println("Welcome");
    }
    
    static void displayMessage(String name) {
        System.out.println("Hi " + name);
    }
    
    static void displayMessage(String greeting, String name) {
        System.out.println(greeting + ", " + name);
    }
}

class BranchingDemo {
    // Weather determination for outing
    static void determineWeather(boolean isSunny, double outdoorTemperature) {
        if (isSunny && outdoorTemperature >= 30) {
            System.out.println("The weather is just perfect for an outing.");
        } else if (isSunny && outdoorTemperature < 30) {
            System.out.println("We can go for an outing but wear sweaters.");
        } else if (!isSunny) {
            System.out.println("The weather is not suitable for an outing.");
        }
    }
    
    // Check if a number is even
    static boolean isEven(int number) {
        return number % 2 == 0;
    }
    
    // Check if a year is a leap year
    static boolean isLeapYear(int year) {
        return (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);
    }
    
    // Gross Salary Calculation
    protected static double calculateGrossSalary(int basicSalary, int experience) {
        int bonus = 0;
        double hra = 0.0, da = 0.0;
        if (experience > 3)
            bonus = 2500;
        
        if (basicSalary > 0 && basicSalary <= 10000) {
            hra = (20 / 100.0) * basicSalary;
            da = (80 / 100.0) * basicSalary;
        } else if (basicSalary > 10000 && basicSalary <= 20000) {
            hra = (25 / 100.0) * basicSalary;
            da = (90 / 100.0) * basicSalary;
        } else if (basicSalary > 20000) {
            hra = (30 / 100.0) * basicSalary;
            da = (95 / 100.0) * basicSalary;
        }
        return basicSalary + hra + da + bonus;
    }
}

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
