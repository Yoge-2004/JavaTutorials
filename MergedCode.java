import java.util.InputMismatchException;

record Computer(int id, String description) {
    public Computer(int id) {
        this(id, "Sample Description.");
    }

    // Uncommented this code for validation, if you want to check description is null.
    /* public Computer {
        if (description == null)
            throw new InputMismatchException("Input should not be empty.");
    } */
}

public class MergedCode {
    public static void main(String[] args) {
        // Code for RecordClasses functionality
        var desktop = new Computer(10, "This is laptop.");
        var desktop1 = new Computer(10);
        System.out.println(desktop);
        System.out.println(desktop.description());
        System.out.println("Is desktop 1 and desktop 2 are equal? " + desktop.equals(desktop1));

        // Code for EnhancedSwitch functionality
        String month = "December";

        int integer = switch (month) {
            case "January" -> 1;
            case "February" -> 2;
            case "March" -> 3;
            case "April" -> 4;
            case "May" -> 5;
            default -> {
                System.out.println("Invalid month");
                yield 0;
            }
        };
        System.out.println(integer);
    }
}
