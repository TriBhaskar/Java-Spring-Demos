package com.anterka.factory;

public class Car implements Vehicle{
    @Override
    public String getType() {
        return "Car";
    }

    @Override
    public String startEngine() {
        return "Car engine starts with a quiet hum";
    }

    @Override
    public int getMaxSpeed() {
        return 220;
    }
}
