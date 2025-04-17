package com.anterka.factory;

/**
 * Concrete factory for creating Car objects
 */
public class CarFactory extends VehicleFactory {

    @Override
    public Vehicle createVehicle() {
        return new Car();
    }
}
