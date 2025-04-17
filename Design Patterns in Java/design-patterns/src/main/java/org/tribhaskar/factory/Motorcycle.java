package org.tribhaskar.factory;

public class Motorcycle implements Vehicle{
    @Override
    public String getType() {
        return "Motorcycle";
    }

    @Override
    public String startEngine() {
        return "Motorcycle engine revs loudly";
    }

    @Override
    public int getMaxSpeed() {
        return 280;
    }
}
