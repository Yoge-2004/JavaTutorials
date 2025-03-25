package com.automobile.vehicles;

public class ElectricCar extends Toyota {
    private int batteryCapacity; // in kWh

    public ElectricCar(String model, double mileage, int topSpeed, int bootSpace, String engineVariant, int torque, int batteryCapacity) {
        super(model, mileage, topSpeed, bootSpace, engineVariant, torque);
        this.batteryCapacity = batteryCapacity;
    }

    // Overriding to include battery capacity details
    @Override
    public String toString() {
        return "Electric Car Details:" +
               "\nBrand: " + getBrand() +
               "\nModel: " + getModel() +
               "\nMileage: " + getMileage() + " km/l equivalent" +
               "\nTop Speed: " + getTopSpeed() + " km/h" +
               "\nBoot Space: " + /* inherited bootSpace is private so not accessible here */ "N/A" +
               "\nEngine Variant: " + "Electric" +
               "\nTorque: " + /* inherited torque is private so not accessible here */ "N/A" +
               "\nBattery Capacity: " + batteryCapacity + " kWh\n";
    }

    @Override
    public void startVehicle() {
        System.out.println("Electric " + getBrand() + " " + getModel() + " is starting silently...");
    }
}
