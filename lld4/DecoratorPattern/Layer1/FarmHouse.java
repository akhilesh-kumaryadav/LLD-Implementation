package DecoratorPattern.Layer1;

import DecoratorPattern.BasePizza;

public class FarmHouse implements BasePizza {
    @Override
    public String getDescription() {
        return "Farm House Pizza";
    }

    @Override
    public double getCost() {
        return 300.0;
    }
}