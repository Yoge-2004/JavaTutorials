package com.example.vehicles;

public class Car extends Vehicle {
    private int bootSpace;
    private String engineVariant;
    private int torque;
    
    {
        engineVariant = "Unknown";
    }
    
    public Car() {}
    
    public Car(String brand, String model, double mileage, int topSpeed, int bootSpace, String engineVariant, int torque) {
        super(brand, model, mileage, topSpeed);
            
        this.bootSpace = bootSpace;
        this.engineVariant = engineVariant;
        this.torque = torque;
    }
    
    public void playMusic() {
        System.out.println("Music is playing...");
    }
    
    @Override
    public String toString() {
        return 
        "Car Details:" + 
        "\nBrand: " + getBrand() + 
        "\nModel: " + getModel() + 
        "\nMileage: " + getMileage() + " kmph" + 
        "\nTop Speed: " + getTopSpeed() + " kmph" + 
        "\nBoot Space: " + bootSpace + " litres" + 
        "\nEngine Variant: " + engineVariant + 
        "\nTorque: " + torque + "Nm" + "\n";
    }
}