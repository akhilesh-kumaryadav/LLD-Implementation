package FactoryPattern.ShapesCreationMethods;

import FactoryPattern.Shapes.Rectangle;
import FactoryPattern.Shapes.Shape;

public class RectangleCreator extends ShapeFactory {
    @Override
    public Shape createShape() {
        return new Rectangle();
    }
}