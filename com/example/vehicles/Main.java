package com.example.vehicles;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the details of Car: ");
        
        System.out.print("Enter the car brand: ");
        String brand = scanner.nextLine();
        
        System.out.print("Enter the car model: ");
        String model = scanner.nextLine();
        
        System.out.print("Enter the mileage of car (in kmph): ");
        double mileage = scanner.nextDouble();
        
        System.out.print("Enter the top speed of car (in kmph): ");
        int topSpeed = scanner.nextInt();
        
        System.out.print("Enter the boot space of car (in litres): ");
        int bootSpace = scanner.nextInt();

        // Consume the leftover newline
        scanner.nextLine();

        System.out.print("Enter the car engine variant: ");
        String engineVariant = scanner.nextLine();
        
        System.out.print("Enter the torque of car (in Nm): ");
        int torque = scanner.nextInt();
        
        Car car = new Car(brand, model, mileage, topSpeed, bootSpace, engineVariant, torque);
    
        System.out.println(car);
        
        car.startVehicle();
        car.playMusic();
        car.stopVehicle();
        
        Toyota toyotaCar = new Toyota(model, mileage, topSpeed, bootSpace, engineVariant, torque);
        
        System.out.println(toyotaCar);
        
        scanner.close();
    }
}