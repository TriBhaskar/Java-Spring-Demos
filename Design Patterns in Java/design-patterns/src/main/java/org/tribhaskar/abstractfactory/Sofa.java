package org.tribhaskar.abstractfactory;

/**
 * Abstract Sofa product interface
 * Defines methods that all sofa variants must implement
 */
public interface Sofa {
    /**
     * Returns the style of the sofa
     * @return String representing the sofa style
     */
    String getStyle();

    /**
     * Returns the number of people the sofa can seat
     * @return int representing seating capacity
     */
    int getSeatingCapacity();

    /**
     * Allows users to lie down on the sofa
     * @return String describing the lying experience
     */
    String lieOn();
}
