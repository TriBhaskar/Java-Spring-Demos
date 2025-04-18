package org.tribhaskar.abstractfactory;

/**
 * Victorian style implementation of CoffeeTable
 */
public class VictorianCoffeeTable implements CoffeeTable {
    @Override
    public String getStyle() {
        return "Victorian";
    }

    @Override
    public String getShape() {
        return "Oval with intricately carved legs";
    }

    @Override
    public String placeItem(String item) {
        return "The " + item + " rests on the polished mahogany Victorian coffee table";
    }
}
