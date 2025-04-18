package org.tribhaskar.abstractfactory;

/**
 * Art Deco style implementation of Sofa
 */
public class ArtDecoSofa implements Sofa {
    @Override
    public String getStyle() {
        return "Art Deco";
    }

    @Override
    public int getSeatingCapacity() {
        return 2; // Art Deco often features smaller love seats
    }

    @Override
    public String lieOn() {
        return "Lying on a sophisticated Art Deco sofa with bold curves and contrasting colors";
    }
}
