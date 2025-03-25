package com.automobile.vehicles;

public class FlyingCar extends Car implements Drivable, MusicSystem {
    public FlyingCar(String brand, String model, double mileage, int topSpeed, int bootSpace, String engineVariant, int torque) {
        super(brand, model, mileage, topSpeed, bootSpace, engineVariant, torque);
    }

    @Override
    public void fly() {
        System.out.println(getBrand() + " " + getModel() + " is flying...");
    }

    @Override
    public void drive() {
        System.out.println(getBrand() + " " + getModel() + " is driving on the road...");
    }

    @Override
    public void playMusic() {
        System.out.println("FlyingCar " + getBrand() + " " + getModel() + " is playing music while flying...");
    }

    @Override
    public String toString() {
        return "Flying Car Details:" +
               "\nBrand: " + getBrand() +
               "\nModel: " + getModel() +
               "\nMileage: " + getMileage() + " km/l" +
               "\nTop Speed: " + getTopSpeed() + " km/h" +
               "\nBoot Space: " + "Inherited" +
               "\nEngine Variant: " + "Inherited" +
               "\nTorque: " + "Inherited" + "\n";
    }
}
