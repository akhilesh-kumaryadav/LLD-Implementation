package FactoryPattern.ShapesCreationMethods;

import FactoryPattern.Shapes.Circle;
import FactoryPattern.Shapes.Shape;

public class CircleCreator extends ShapeFactory {
    @Override
    public Shape createShape() {
        return new Circle();
    }
}