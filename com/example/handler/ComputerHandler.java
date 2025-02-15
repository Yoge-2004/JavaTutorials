// File: com/example/handler/ComputerHandler.java
package com.example.handler;

import com.example.Computer;

public class ComputerHandler {

    public static void handleComputerRecord() {
        var desktop = new Computer(10, "This is laptop.");
        var desktop1 = new Computer(10);
        System.out.println(desktop);
        System.out.println(desktop.description());
        System.out.println("Is desktop 1 and desktop 2 are equal? " + desktop.equals(desktop1));
    }

  // Main method to run the code for ComputerHandler
    public static void main(String[] args) {
        // Invoke the handleComputerRecord method to demonstrate functionality
        handleComputerRecord();
    }
}
