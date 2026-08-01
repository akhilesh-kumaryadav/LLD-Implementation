package FactoryPattern;

import Common.ShapeType;

import FactoryPattern.Shapes.Shape;
import FactoryPattern.ShapesCreationMethods.ShapeFactory;
import FactoryPattern.ShapesCreationMethods.CircleCreator;
import FactoryPattern.ShapesCreationMethods.RectangleCreator;
import FactoryPattern.ShapesCreationMethods.SquareCreator;

public class FactoryPatternDemo {
    private static Shape getShapeInstance(ShapeType shapeType) {
        Shape shape = null;

        if (shapeType == null) {
            return null;
        }

        switch (shapeType) {
            case CIRCLE:
                ShapeFactory circleCreator = new CircleCreator();
                shape = circleCreator.createShape();
                break;
            case SQUARE:
                ShapeFactory squareCreator = new SquareCreator();
                shape = squareCreator.createShape();
                break;
            case RECTANGLE:
                ShapeFactory rectangleCreator = new RectangleCreator();
                shape = rectangleCreator.createShape();
                break;
            default:
                throw new IllegalStateException("ShapeType doesn't exist");
        }

        return shape;
    }

    public static void main(String[] args) {
        System.out.println("===== Factory Method Design Pattern =====");

        ShapeType shapeType = ShapeType.RECTANGLE;

        Shape shape = getShapeInstance(shapeType);

        shape.draw();
        shape.computeArea();
    }
}