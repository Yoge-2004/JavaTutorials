package com.automobile.vehicles;

public class Bike extends Vehicle {
    public Bike() {
        super();
    }

    // Unique method for Bike
    public void ride() {
        System.out.println(getBrand() + " " + getModel() + " bike is riding...");
    }

    @Override
    public String toString() {
        return "Bike Details:" +
               "\nBrand: " + getBrand() +
               "\nModel: " + getModel() +
               "\nMileage: " + getMileage() + " km/l" +
               "\nTop Speed: " + getTopSpeed() + " km/h\n";
    }
}
