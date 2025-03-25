package com.automobile.vehicles;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // ----- Demonstrate Car (Single Inheritance) -----
        System.out.println("Enter details for a generic Car:");
        System.out.print("Enter the brand: ");
        String brand = scanner.nextLine();
        System.out.print("Enter the model: ");
        String model = scanner.nextLine();
        System.out.print("Enter mileage (in km/l): ");
        double mileage = scanner.nextDouble();
        System.out.print("Enter top speed (in km/h): ");
        int topSpeed = scanner.nextInt();
        System.out.print("Enter boot space (in litres): ");
        int bootSpace = scanner.nextInt();
        scanner.nextLine(); // consume newline
        System.out.print("Enter engine variant: ");
        String engineVariant = scanner.nextLine();
        System.out.print("Enter torque (in Nm): ");
        int torque = scanner.nextInt();
        scanner.nextLine(); // consume newline

        Car car = new Car(brand, model, mileage, topSpeed, bootSpace, engineVariant, torque);
        System.out.println("\n" + car);
        car.startVehicle();
        car.playMusic();
        car.stopVehicle();

        // ----- Demonstrate Toyota (Single/Hierarchical Inheritance) -----
        Toyota toyotaCar = new Toyota(model, mileage, topSpeed, bootSpace, engineVariant, torque);
        System.out.println("\n" + toyotaCar);
        toyotaCar.startVehicle();
        toyotaCar.stopVehicle();

        // ----- Demonstrate ElectricCar (Multi-level Inheritance) -----
        System.out.print("\nEnter battery capacity for Electric Car (in kWh): ");
        int batteryCapacity = scanner.nextInt();
        ElectricCar electricCar = new ElectricCar(model, mileage, topSpeed, bootSpace, engineVariant, torque, batteryCapacity);
        System.out.println("\n" + electricCar);
        electricCar.startVehicle();
        electricCar.stopVehicle();

        // ----- Demonstrate Bike (Hierarchical Inheritance) -----
        Bike bike = new Bike();
        // Optionally, you can set bike details through a constructor or setters.
        System.out.println("\nBike Details (using default values):");
        System.out.println(bike);
        bike.startVehicle();
        bike.ride();

        // ----- Demonstrate FlyingCar (Hybrid Inheritance & Multiple Interfaces) -----
        FlyingCar flyingCar = new FlyingCar(brand, model, mileage, topSpeed, bootSpace, engineVariant, torque);
        System.out.println("\n" + flyingCar);
        flyingCar.startVehicle();
        flyingCar.drive();
        flyingCar.fly();
        flyingCar.playMusic();
        flyingCar.stopVehicle();

        scanner.close();
    }
}
