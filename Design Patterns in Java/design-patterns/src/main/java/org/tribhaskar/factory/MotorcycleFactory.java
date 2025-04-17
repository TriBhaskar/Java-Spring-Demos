package org.tribhaskar.factory;

/**
 * Concrete factory for creating Motorcycle objects
 */
public class MotorcycleFactory extends VehicleFactory {

    @Override
    public Vehicle createVehicle() {
        return new Motorcycle();
    }
}
