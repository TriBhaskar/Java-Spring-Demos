package org.tribhaskar.abstractfactory;

/**
 * Modern style implementation of Sofa
 */
public class ModernSofa implements Sofa {
    @Override
    public String getStyle() {
        return "Modern";
    }

    @Override
    public int getSeatingCapacity() {
        return 3;
    }

    @Override
    public String lieOn() {
        return "Lying on a clean-lined modern sofa with memory foam cushions";
    }
}
