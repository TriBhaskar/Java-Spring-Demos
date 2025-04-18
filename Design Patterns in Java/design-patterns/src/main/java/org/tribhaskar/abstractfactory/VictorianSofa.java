package org.tribhaskar.abstractfactory;

/**
 * Victorian style implementation of Sofa
 */
public class VictorianSofa implements Sofa {
    @Override
    public String getStyle() {
        return "Victorian";
    }

    @Override
    public int getSeatingCapacity() {
        return 4;
    }

    @Override
    public String lieOn() {
        return "Lying on a lavish Victorian sofa with tufted cushions and wooden trim";
    }
}
