package org.tribhaskar.abstractfactory;

/**
 * Victorian style implementation of Chair
 */
public class VictorianChair implements Chair {
    @Override
    public String getStyle() {
        return "Victorian";
    }

    @Override
    public boolean hasLegs() {
        return true; // Victorian chairs typically have ornate legs
    }

    @Override
    public String sitOn() {
        return "Sitting on an ornately carved Victorian chair with plush velvet upholstery";
    }
}
