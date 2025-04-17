package com.anterka.factory;

/**
 * Concrete factory for creating Truck objects
 */
public class TruckFactory extends VehicleFactory {

    @Override
    public Vehicle createVehicle() {
        return new Truck();
    }
}
