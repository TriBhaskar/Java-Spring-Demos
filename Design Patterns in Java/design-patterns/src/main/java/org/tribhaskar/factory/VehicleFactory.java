package org.tribhaskar.factory;

/**
 * Abstract Vehicle Factory class with factory method pattern
 * This class defines the factory method that will be implemented by concrete factories
 */
public abstract class VehicleFactory {

    /**
     * Factory method that will be implemented by subclasses
     * @return a new Vehicle instance
     */
    public abstract Vehicle createVehicle();

    /**
     * This is an operation that uses the factory method
     * Demonstrates how the factory method is meant to be used
     * @return String with vehicle information
     */
    public String getVehicleInfo() {
        // Notice how the factory method is used
        Vehicle vehicle = createVehicle();

        return "Vehicle Type: " + vehicle.getType() +
                "\nEngine Start: " + vehicle.startEngine() +
                "\nMax Speed: " + vehicle.getMaxSpeed() + " km/h";
    }
}
