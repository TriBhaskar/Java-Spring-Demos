package org.tribhaskar.abstractfactory;

/**
 * Modern style furniture factory
 * Creates modern style furniture products
 */
public class ModernFurnitureFactory implements FurnitureFactory {
    @Override
    public Chair createChair() {
        return new ModernChair();
    }

    @Override
    public Sofa createSofa() {
        return new ModernSofa();
    }

    @Override
    public CoffeeTable createCoffeeTable() {
        return new ModernCoffeeTable();
    }

    @Override
    public String getStyle() {
        return "Modern";
    }
}
