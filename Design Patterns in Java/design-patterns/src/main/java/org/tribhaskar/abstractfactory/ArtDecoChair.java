package org.tribhaskar.abstractfactory;

/**
 * Art Deco style implementation of Chair
 */
public class ArtDecoChair implements Chair {
    @Override
    public String getStyle() {
        return "Art Deco";
    }

    @Override
    public boolean hasLegs() {
        return true; // Art Deco chairs typically have distinctive legs
    }

    @Override
    public String sitOn() {
        return "Sitting on a glamorous Art Deco chair with geometric patterns and luxurious materials";
    }
}