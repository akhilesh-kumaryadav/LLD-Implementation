package SimpleFactoryPattern;

import Common.ShapeType;
import FactoryPattern.Shapes.Shape;

public class SimpleFactoryPatternDemo {
    public static void main(String[] args) {
        System.out.println("===== Simple Factory Design Pattern =====");

        ShapeType shapeType = ShapeType.SQUARE;

        Shape shape = ShapeFactory.createShape(shapeType);
        shape.draw();
        shape.computeArea();
    }
}