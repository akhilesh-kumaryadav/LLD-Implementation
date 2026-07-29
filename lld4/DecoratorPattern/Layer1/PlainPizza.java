package DecoratorPattern.Layer1;

import DecoratorPattern.BasePizza;

public class PlainPizza implements BasePizza {
    @Override
    public String getDescription() {
        return "Plain Pizza Pizza";
    }

    @Override
    public double getCost() {
        return 200.0;
    }
}