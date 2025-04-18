package org.tribhaskar.abstractfactory;

/**
 * Abstract CoffeeTable product interface
 * Defines methods that all coffee table variants must implement
 */
public interface CoffeeTable {
    /**
     * Returns the style of the coffee table
     * @return String representing the coffee table style
     */
    String getStyle();

    /**
     * Returns the shape of the coffee table
     * @return String describing the shape
     */
    String getShape();

    /**
     * Places an item on the coffee table
     * @param item name of the item being placed
     * @return String describing the placement
     */
    String placeItem(String item);
}
