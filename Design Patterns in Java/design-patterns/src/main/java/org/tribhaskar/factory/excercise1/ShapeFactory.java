package org.tribhaskar.factory.excercise1;

public abstract class ShapeFactory {

    public static Shape getShape(String shapeType) {
        if (shapeType == null) return null;
        switch (shapeType.toUpperCase()) {
            case "CIRCLE":
                return new Circle();
            case "SQUARE":
                return new Square();
            case "RECTANGLE":
                return new Rectangle();
            default:
                throw new IllegalArgumentException("Unknown shape type: " + shapeType);
        }
    }
}
