package org.tribhaskar.factory;

/**
 * Vehicle interface - defines the contract for all vehicle products
 */
public interface Vehicle {
    /**
     * Get the type of vehicle
     * @return String representing the vehicle type
     */
    String getType();

    /**
     * Start the vehicle's engine
     * @return String describing the vehicle starting
     */
    String startEngine();

    /**
     * Get the maximum speed of the vehicle
     * @return int representing the max speed in km/h
     */
    int getMaxSpeed();
}
