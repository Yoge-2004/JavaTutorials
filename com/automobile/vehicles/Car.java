package com.automobile.vehicles;

public class Car extends Vehicle {
    private int bootSpace;
    private String engineVariant;
    private int torque;

    {
        // Instance block for default engine variant
        engineVariant = "Unknown";
    }

    public Car() {}

    public Car(String brand, String model, double mileage, int topSpeed, int bootSpace, String engineVariant, int torque) {
        super(brand, model, mileage, topSpeed);
        this.bootSpace = bootSpace;
        this.engineVariant = engineVariant;
        this.torque = torque;
    }

    // Additional functionality specific to Car
    public void playMusic() {
        System.out.println("Music is playing in " + getBrand() + " " + getModel() + "...");
    }

    @Override
    public String toString() {
        return "Car Details:" +
               "\nBrand: " + getBrand() +
               "\nModel: " + getModel() +
               "\nMileage: " + getMileage() + " km/l" +
               "\nTop Speed: " + getTopSpeed() + " km/h" +
               "\nBoot Space: " + bootSpace + " litres" +
               "\nEngine Variant: " + engineVariant +
               "\nTorque: " + torque + " Nm\n";
    }
}
