package javatutorial;

import java.util.Scanner;

class InputOutputStatements {
    // Variable Declaration
    public static byte a;
    static short b;
    static int c;
    static long d;

    static void display() {
        System.out.println("Output Statements:");
        System.out.println("Printing number: " + 10);
        System.out.print("Print without new line: " + 10);
        System.out.println(); // Adding newline
        System.out.printf("Formatted output (%%d): %d%n", 10);

        // Input Statements
        Scanner scanner = new Scanner(System.in);

        System.out.println("\nEnter values for different data types:");
        System.out.print("Enter a byte value: ");
        a = scanner.nextByte();
        System.out.print("Enter a short value: ");
        b = scanner.nextShort();
        System.out.print("Enter an integer value: ");
        c = scanner.nextInt();
        System.out.print("Enter a long value: ");
        d = scanner.nextLong();
        System.out.print("Enter a float value: ");
        float e = scanner.nextFloat();
        System.out.print("Enter a double value: ");
        double f = scanner.nextDouble();
        System.out.print("Enter a character: ");
        char g = scanner.next().charAt(0);
        System.out.print("Enter a boolean value (true/false): ");
        boolean h = scanner.nextBoolean();
        System.out.print("Enter a single word string: ");
        String i = scanner.next();
        scanner.nextLine(); // Consume the leftover newline
        System.out.print("Enter a full sentence: ");
        String j = scanner.nextLine();

        System.out.println("\nYou entered:");
        System.out.println("Byte: " + a);
        System.out.println("Short: " + b);
        System.out.println("Integer: " + c);
        System.out.println("Long: " + d);
        System.out.println("Float: " + e);
        System.out.println("Double: " + f);
        System.out.println("Character: " + g);
        System.out.println("Boolean: " + h);
        System.out.println("Single word: " + i);
        System.out.println("Full sentence: " + j);

        scanner.close(); //Avoids Resource Leakage
    }
}

class Variables {
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

class Operators {
    void assignmentOperators() {
        int a = 20, b = 10;
        System.out.println("\nAssignment Operators:");
        System.out.println("a += b -> " + (a += b));
        System.out.println("a -= b -> " + (a -= b));
        System.out.println("a *= b -> " + (a *= b));
        System.out.println("a /= b -> " + (a /= b));
        System.out.println("a %= b -> " + (a %= b));
    }

    void arithmeticOperators() {
        byte a = 10, b = 10;
        byte c = (byte) (a + b);
        System.out.println("\nArithmetic Operators:");
        System.out.println("10 + 10 = " + (10 + 10));
        System.out.println("\"Hi\" + true = " + ("Hi" + true));
        System.out.println("10 * 'a' (ASCII) = " + (10 * 'a'));
        System.out.println("'a' / 'b' (ASCII division) = " + ('a' / 'b'));
        System.out.println("'a' % 'b' (ASCII modulus) = " + ('a' % 'b'));
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
}

class Literals {
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

class TypeConversion {
    void showTypeConversion() {
        short a = 10;
        int b = a; // Implicit widening
        short c = (short) b; // Explicit narrowing
        
        System.out.println("\nType Conversion:");
        System.out.println("Widening (short to int): " + b);
        System.out.println("Narrowing (int to short): " + c);
    }
}

class Methods {
    //Addition
    public static int add(int a, int b) {
        return a + b;
    }
    
    //Candy(s) Distribution 
    public int[] candiesDistribution(int totalCandies, int studentsCount) {
        return new int[] {totalCandies / studentsCount, totalCandies % studentsCount};
    }
    
    //Speed checking
    public boolean isOverSpeeding(int carKmph, int thresholdKmph) {
        return (carKmph > thresholdKmph);
    }
    
    //Method overloading
    static void show() {
        System.out.println("Welcome");
    }
    
    static void show(String name) {
        System.out.println("Hi " + name);
    }
    
    static void show(String greeting, String name) {
        System.out.println(greeting + ", " + name);
    }
}

class BranchingStatements {
    
    //Checking the weather for outing 
    static void determineWeather(boolean isSunny, double outdoorTemperature) {
        if (isSunny && outdoorTemperature >= 30) {
            System.out.println("The weather is just perfect for outing.");
            return;
        } else if (isSunny && outdoorTemperature < 30) {
            System.out.println("We can go for outing but wear the sweaters.");
            return;
        } else if (!isSunny) {
            System.out.println("The weather is not just perfect for outing.");
            return;
        }
    }
    
    //Check whether the number is odd or even
    static boolean isEven(int number) {
        if (number % 2 == 0)
            return true;
        else
            return false;
    }
    
    //Check whether the number is leap year or not
    static boolean isLeapYear(int year) {
        if (year % 4 == 0 && year % 100 != 0 || year % 400 == 0) {
            return true;
        } else {
            return false;
        }
    }

    //Gross Salary Calculation
    protected static double grossSalary(int basicSalary, int experience) {
        int bonus = 0;
        double hra = 0.0, da = 0.0;
        if (experience > 3)
            bonus = 2500;

        if (basicSalary > 0 && basicSalary <= 10000) {
            hra = (20 / 100.0) * basicSalary;
            da = (80 / 100.0) * basicSalary;
            return hra + da + bonus + basicSalary;
        } else if (basicSalary > 10000 && basicSalary <= 20000) {
            hra = (25 / 100.0) * basicSalary;
            da = (90 / 100.0) * basicSalary;
            return hra + da + bonus + basicSalary;
        } else if (basicSalary > 20000) {
            hra = (30 / 100.0) * basicSalary;
            da = (95 / 100.0) * basicSalary;
            return hra + da + bonus + basicSalary;
        }
        return 0.0;
    }


}

}

public class Main {
    public static void main(String[] args) {
        // Calling methods from all classes

        // Input/Output
        InputOutputStatements.display();

        // Variables
        Variables varObj = new Variables();
        varObj.showVariables();

        // Operators
        Operators opObj = new Operators();
        opObj.assignmentOperators();
        opObj.arithmeticOperators();
        opObj.logicalOperators();
        opObj.bitwiseOperators();

        // Literals
        Literals litObj = new Literals();
        litObj.showLiterals();

        // Type Conversion
        TypeConversion tcObj = new TypeConversion();
        tcObj.showTypeConversion();

        // Methods
        int sum = Methods.add(10, 20);
        System.out.println("\nCalling Method:");
        System.out.println("Sum of 10 and 20 is: " + sum);
        
        System.out.println("Candy Distribution:");
        int[] candyDetails = new Methods().candiesDistribution(30, 7);
        System.out.println(candyDetails[0] + " candies are distributed evenly.");
        System.out.println(candyDetails[1] + " candies are remaining after distribution.");
        
        System.out.println("Car Overspeeding:");
        System.out.println(new Methods().isOverSpeeding(60, 75)? "Car crosses the threshold speed.": "Car doesn't crosses the threshold speed.");
        
        //Compile Time Polymorphism 
        new Methods().show();
        new Methods().show("Alex");
        new Methods().show("Hi", "Alex");
        
        //If statements 
        BranchingStatements.determineWeather(true, 30.0);
        System.out.println(BranchingStatements.isEven(3));
        System.out.println(BranchingStatements.isLeapYear(2024));

        //Gross Calculation 
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the basic salary: ");
        int basicSalary = scanner.nextInt();
        System.out.println();

        System.out.print("Enter the current year: ");
        int currentYear = scanner.nextInt();
        System.out.println();

        System.out.print("Enter the year of joining: ");
        int yearJoined = scanner.nextInt();
        System.out.println();
        
        int experience;

        if (String.valueOf(currentYear).length() == 4 && String.valueOf(yearJoined).length() == 4) {
            experience = currentYear - yearJoined;
            System.out.println("Gross Salary: Rs." + BranchingStatement.grossSalary(basicSalary, experience));
        } else {
            System.out.println("Entered Invalid Year!");
        }
    }
}
