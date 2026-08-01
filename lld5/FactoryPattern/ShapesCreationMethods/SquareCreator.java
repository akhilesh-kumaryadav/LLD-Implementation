package FactoryPattern.ShapesCreationMethods;

import FactoryPattern.Shapes.Square;
import FactoryPattern.Shapes.Shape;

public class SquareCreator extends ShapeFactory {
    @Override
    public Shape createShape() {
        return new Square();
    }
}