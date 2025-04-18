package org.tribhaskar.abstractfactory;

/**
 * Modern style implementation of Chair
 */
public class ModernChair implements Chair {
    @Override
    public String getStyle() {
        return "Modern";
    }

    @Override
    public boolean hasLegs() {
        return false; // Modern chairs often have a central support instead of legs
    }

    @Override
    public String sitOn() {
        return "Sitting on a sleek, minimalist modern chair with ergonomic design";
    }
}
