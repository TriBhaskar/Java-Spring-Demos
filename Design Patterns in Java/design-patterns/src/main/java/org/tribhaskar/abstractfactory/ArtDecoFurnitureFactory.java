package org.tribhaskar.abstractfactory;

/**
 * Art Deco style furniture factory
 * Creates Art Deco style furniture products
 */
public class ArtDecoFurnitureFactory implements FurnitureFactory {
    @Override
    public Chair createChair() {
        return new ArtDecoChair();
    }

    @Override
    public Sofa createSofa() {
        return new ArtDecoSofa();
    }

    @Override
    public CoffeeTable createCoffeeTable() {
        return new ArtDecoCoffeeTable();
    }

    @Override
    public String getStyle() {
        return "Art Deco";
    }
}
