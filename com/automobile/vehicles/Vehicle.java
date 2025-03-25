package com.automobile.vehicles;

public class Vehicle {
    private String brand;
    private String model;
    private double mileage;
    private int topSpeed;

    {
        // Instance initialization block for default values
        brand = "Unknown";
        model = "Unknown";
    }

    public Vehicle() {}

    public Vehicle(String brand, String model, double mileage, int topSpeed) {
        this.brand = brand;
        this.model = model;
        this.mileage = mileage;
        this.topSpeed = topSpeed;
    }

    // Getters
    public String getBrand() {
        return brand;
    }
    public String getModel() {
        return model;
    }
    public double getMileage() {
        return mileage;
    }
    public int getTopSpeed() {
        return topSpeed;
    }

    // Methods to start and stop the vehicle
    public void startVehicle() {
        System.out.println(brand + " " + model + " is starting...");
    }
    public void stopVehicle() {
        System.out.println(brand + " " + model + " is stopping...");
    }

    @Override
    public String toString() {
        return "Vehicle Details:" +
               "\nBrand: " + brand +
               "\nModel: " + model +
               "\nMileage: " + mileage + " km/l" +
               "\nTop Speed: " + topSpeed + " km/h\n";
    }
}
