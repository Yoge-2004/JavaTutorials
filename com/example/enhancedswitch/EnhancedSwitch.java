// File: com/example/enhancedswitch/EnhancedSwitch.java
package com.example.enhancedswitch;

public class EnhancedSwitch {

    public static void handleEnhancedSwitch(String month) {
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
