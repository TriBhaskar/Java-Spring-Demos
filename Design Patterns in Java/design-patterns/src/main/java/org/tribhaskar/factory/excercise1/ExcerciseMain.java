package org.tribhaskar.factory.excercise1;

public class ExcerciseMain {
    public static void main(String[] args) {
        Shape shape1 = ShapeFactory.getShape("CIRCLE");
        shape1.draw();  // Output: Drawing a circle

        Shape shape2 = ShapeFactory.getShape("SQUARE");
        shape2.draw();  // Output: Drawing a square

        Shape shape3 = ShapeFactory.getShape("RECTANGLE");
        shape3.draw();  // Output: Drawing a rectangle
    }
}
