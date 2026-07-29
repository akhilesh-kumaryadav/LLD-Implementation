package DecoratorPattern.Layer1.Layer2;

import DecoratorPattern.ToppingDecorator;
import DecoratorPattern.BasePizza;

public class MushroomTopping extends ToppingDecorator {
    public MushroomTopping(BasePizza pizza) {
        super(pizza);
    }

    @Override
    public String getDescription() {
        return pizza.getDescription() + " + Mushroom";
    }

    @Override
    public double getCost() {
        return pizza.getCost() + 40;
    }
}