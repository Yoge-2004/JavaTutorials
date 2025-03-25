package com.automobile.vehicles;

public class Toyota extends Car {
    // Constructor that fixes the brand as "Toyota"
    public Toyota(String model, double mileage, int topSpeed, int bootSpace, String engineVariant, int torque) {
        super("Toyota", model, mileage, topSpeed, bootSpace, engineVariant, torque);
    }

    @Override
    public void startVehicle() {
        System.out.println("Toyota " + getModel() + " is starting with advanced ignition...");
    }

    @Override
    public void stopVehicle() {
        System.out.println("Toyota " + getModel() + " is stopping smoothly...");
    }
}
