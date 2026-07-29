package DecoratorPattern.Layer1.Layer2;

import DecoratorPattern.ToppingDecorator;
import DecoratorPattern.BasePizza;

public class ExtraCheeseTopping extends ToppingDecorator {
    public ExtraCheeseTopping(BasePizza pizza) {
        super(pizza);
    }

    @Override
    public String getDescription() {
        return pizza.getDescription() + " + Extra Cheese";
    }

    @Override
    public double getCost() {
        return pizza.getCost() + 20;
    }
}