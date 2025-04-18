package org.tribhaskar.abstractfactory;

/**
 * Art Deco style implementation of CoffeeTable
 */
public class ArtDecoCoffeeTable implements CoffeeTable {
    @Override
    public String getStyle() {
        return "Art Deco";
    }

    @Override
    public String getShape() {
        return "Geometric with mirrored accents";
    }

    @Override
    public String placeItem(String item) {
        return "The " + item + " stands out beautifully on the luxurious Art Deco coffee table";
    }
}
