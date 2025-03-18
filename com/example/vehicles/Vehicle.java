package com.example.vehicles;

public class Vehicle {
    private String brand;
    private String model;
    private double mileage;
    private int topSpeed;
    
    {
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
    
    public void startVehicle() {
        System.out.println("Vehicle is starting...");
    }
    
    public void stopVehicle() {
        System.out.println("Vehicle is stopping...");
    }
}