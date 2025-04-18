package org.tribhaskar.abstractfactory;

/**
 * FurnitureStore client class
 * Uses the abstract factory to create furniture sets
 */
public class FurnitureStore {
    private final FurnitureFactory factory;

    /**
     * Constructor that takes a furniture factory
     * @param factory the furniture factory to use for creating furniture
     */
    public FurnitureStore(FurnitureFactory factory) {
        this.factory = factory;
        System.out.println("Furniture store initialized with " + factory.getStyle() + " style");
    }

    /**
     * Orders a complete furniture set
     * @param customerName name of the customer ordering the set
     * @return String describing the ordered set
     */
    public String orderFurnitureSet(String customerName) {
        Chair chair = factory.createChair();
        Sofa sofa = factory.createSofa();
        CoffeeTable coffeeTable = factory.createCoffeeTable();

        StringBuilder order = new StringBuilder();
        order.append("Order for ").append(customerName).append(":\n");
        order.append("- ").append(chair.getStyle()).append(" Chair: ").append(chair.sitOn()).append("\n");
        order.append("- ").append(sofa.getStyle()).append(" Sofa for ").append(sofa.getSeatingCapacity());
        order.append(" people: ").append(sofa.lieOn()).append("\n");
        order.append("- ").append(coffeeTable.getStyle()).append(" Coffee Table (").append(coffeeTable.getShape());
        order.append("): ").append(coffeeTable.placeItem("coffee cup")).append("\n");

        return order.toString();
    }

    /**
     * Changes the furniture factory used by the store
     * @param newFactory the new furniture factory to use
     */
    public void changeStyle(FurnitureFactory newFactory) {
        System.out.println("Changing store style from " + this.factory.getStyle() +
                " to " + newFactory.getStyle());
    }
}
