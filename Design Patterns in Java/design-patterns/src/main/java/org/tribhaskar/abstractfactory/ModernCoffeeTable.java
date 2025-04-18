package org.tribhaskar.abstractfactory;

/**
 * Modern style implementation of CoffeeTable
 */
public class ModernCoffeeTable implements CoffeeTable {
    @Override
    public String getStyle() {
        return "Modern";
    }

    @Override
    public String getShape() {
        return "Rectangular with rounded corners";
    }

    @Override
    public String placeItem(String item) {
        return "The " + item + " sits elegantly on the glass top modern coffee table";
    }
}
