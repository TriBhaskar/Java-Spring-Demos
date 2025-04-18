package org.tribhaskar.abstractfactory;

/**
 * Victorian style furniture factory
 * Creates Victorian style furniture products
 */
public class VictorianFurnitureFactory implements FurnitureFactory {
    @Override
    public Chair createChair() {
        return new VictorianChair();
    }

    @Override
    public Sofa createSofa() {
        return new VictorianSofa();
    }

    @Override
    public CoffeeTable createCoffeeTable() {
        return new VictorianCoffeeTable();
    }

    @Override
    public String getStyle() {
        return "Victorian";
    }
}
