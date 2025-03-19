package com.example.vehicles;

class Vehicle {  //Base Class
    void start() {
        System.out.println("Vehicle is starting...");
    }
}

class Car extends Vehicle { //Single Inheritance
    void honk() {
        System.out.println("Car is honking...");
    }
}

class Bike extends Vehicle { //Hierarchical Inheritance
    void ride() {
        System.out.println("Bike is riding...");
    }
}

interface Flyable { //Multiple, Hybrid Inheitance Base Class
    void fly();
}

interface Drivable extends Flyable { //Multi-level Inheritance
    void drive();
}

interface MusicSystem {
    void playMusic();
}

class FlyingCar extends Car implements Drivable, MusicSystem {  //Hybrid Inheritance
    public void fly() {
        System.out.println("Can fly...");
    }
    
    public void drive() {
        System.out.println("Can drive...");
    }
    
    public void playMusic() {
        System.out.println("Playing music...");
    }
}

public class InheritanceDemo {
    public static void main(String[] args) {
        FlyingCar flyingCar = new FlyingCar();
        flyingCar.start(); 
        flyingCar.honk();  
        flyingCar.fly();
        flyingCar.drive();
        flyingCar.playMusic();
        
        Bike bike = new Bike();
        bike.start(); 
        bike.ride();
    }
}
