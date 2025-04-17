package org.tribhaskar.factory;

public class Truck implements Vehicle {
    @Override
    public String getType() {
        return "Truck";
    }

    @Override
    public String startEngine() {
        return "Truck engine rumbles heavily";
    }

    @Override
    public int getMaxSpeed() {
        return 160;
    }
}