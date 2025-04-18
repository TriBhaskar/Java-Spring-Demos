package org.tribhaskar;

import org.tribhaskar.factory.*;

/**
 * Main class to demonstrate the Factory Design Pattern
 */
public class FactoryPattern {
    public static void main(String[] args) {
        System.out.println("Factory Method Pattern Demonstration\n");

        // Using the Factory Method pattern
        System.out.println("=== Factory Method Pattern ===");

        VehicleFactory carFactory = new CarFactory();
        System.out.println(carFactory.getVehicleInfo());
        System.out.println();

        VehicleFactory motorcycleFactory = new MotorcycleFactory();
        System.out.println(motorcycleFactory.getVehicleInfo());
        System.out.println();

        VehicleFactory truckFactory = new TruckFactory();
        System.out.println(truckFactory.getVehicleInfo());
        System.out.println();

        // Using the Simple Factory pattern
        System.out.println("=== Simple Factory Pattern ===");
        SimpleVehicleFactory simpleFactory = new SimpleVehicleFactory();

        try {
            Vehicle car = simpleFactory.createVehicle("car");
            System.out.println("Created: " + car.getType());
            System.out.println(car.startEngine());
            System.out.println("Max Speed: " + car.getMaxSpeed() + " km/h");
            System.out.println();

            Vehicle motorcycle = simpleFactory.createVehicle("motorcycle");
            System.out.println("Created: " + motorcycle.getType());
            System.out.println(motorcycle.startEngine());
            System.out.println("Max Speed: " + motorcycle.getMaxSpeed() + " km/h");
            System.out.println();

            // This will throw an exception
            // Vehicle unknown = simpleFactory.createVehicle("boat");

        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}