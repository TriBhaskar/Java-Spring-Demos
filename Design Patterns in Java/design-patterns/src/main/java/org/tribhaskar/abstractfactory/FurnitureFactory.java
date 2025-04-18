package org.tribhaskar.abstractfactory;

/**
 * Abstract Furniture Factory interface
 * Declares a set of creation methods for all abstract furniture products
 */
public interface FurnitureFactory {
    /**
     * Creates a chair of the specific style
     * @return Chair object of the factory's style
     */
    Chair createChair();

    /**
     * Creates a sofa of the specific style
     * @return Sofa object of the factory's style
     */
    Sofa createSofa();

    /**
     * Creates a coffee table of the specific style
     * @return CoffeeTable object of the factory's style
     */
    CoffeeTable createCoffeeTable();

    /**
     * Returns the style of furniture this factory creates
     * @return String representing the furniture style
     */
    String getStyle();
}
