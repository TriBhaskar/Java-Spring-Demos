package org.tribhaskar.factory;

/**
 * Simple Factory (not a true Factory Method pattern, but commonly used)
 * Creates vehicles based on a type string
 */
public class SimpleVehicleFactory {

    /**
     * Creates a vehicle based on the specified type
     * @param vehicleType the type of vehicle to create
     * @return A Vehicle instance
     * @throws IllegalArgumentException if vehicleType is invalid
     */
    public Vehicle createVehicle(String vehicleType) {
        Vehicle vehicle;

        switch (vehicleType.toLowerCase()) {
            case "car":
                vehicle = new Car();
                break;
            case "motorcycle":
                vehicle = new Motorcycle();
                break;
            case "truck":
                vehicle = new Truck();
                break;
            default:
                throw new IllegalArgumentException("Unknown vehicle type: " + vehicleType);
        }

        return vehicle;
    }
}
