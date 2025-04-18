package org.tribhaskar;

import org.tribhaskar.abstractfactory.*;

public class AbstractFactoryPattern {
    public static void main(String[] args) {
        System.out.println("Abstract Factory Pattern Demonstration: Furniture Store\n");

        // Create different furniture factories
        FurnitureFactory modernFactory = new ModernFurnitureFactory();
        FurnitureFactory victorianFactory = new VictorianFurnitureFactory();
        FurnitureFactory artDecoFactory = new ArtDecoFurnitureFactory();

        // Create furniture store with Modern style
        System.out.println("=== Modern Style Furniture ===");
        FurnitureStore store = new FurnitureStore(modernFactory);
        System.out.println(store.orderFurnitureSet("John Doe"));

        // Switch to Victorian style
        System.out.println("\n=== Victorian Style Furniture ===");
        store = new FurnitureStore(victorianFactory);
        System.out.println(store.orderFurnitureSet("Jane Smith"));

        // Switch to Art Deco style
        System.out.println("\n=== Art Deco Style Furniture ===");
        store = new FurnitureStore(artDecoFactory);
        System.out.println(store.orderFurnitureSet("Alice Johnson"));

        // Example of creating individual products directly from factories
        System.out.println("\n=== Individual Products Creation ===");

        Chair modernChair = modernFactory.createChair();
        System.out.println("Created a " + modernChair.getStyle() + " chair");
        System.out.println("Has legs: " + modernChair.hasLegs());
        System.out.println("Experience: " + modernChair.sitOn());

        Sofa victorianSofa = victorianFactory.createSofa();
        System.out.println("\nCreated a " + victorianSofa.getStyle() + " sofa");
        System.out.println("Seating capacity: " + victorianSofa.getSeatingCapacity());
        System.out.println("Experience: " + victorianSofa.lieOn());

        CoffeeTable artDecoCoffeeTable = artDecoFactory.createCoffeeTable();
        System.out.println("\nCreated an " + artDecoCoffeeTable.getStyle() + " coffee table");
        System.out.println("Shape: " + artDecoCoffeeTable.getShape());
        System.out.println("Using table: " + artDecoCoffeeTable.placeItem("decorative vase"));
    }
}
