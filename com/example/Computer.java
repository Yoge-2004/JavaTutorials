// File: com/example/Computer.java
package com.example;

import java.util.InputMismatchException;

public record Computer(int id, String description) {
    public Computer(int id) {
        this(id, "Sample Description.");
    }

    // Uncommented this code for validation, if you want to check description is null.
    /* public Computer {
        if (description == null)
            throw new InputMismatchException("Input should not be empty.");
    } */
}
