package DecoratorPattern.Layer1.Layer2;

import DecoratorPattern.ToppingDecorator;
import DecoratorPattern.BasePizza;

public class VeggiesTopping extends ToppingDecorator {
    public VeggiesTopping(BasePizza pizza) {
        super(pizza);
    }

    @Override
    public String getDescription() {
        return pizza.getDescription() + " + Veggies";
    }

    @Override
    public double getCost() {
        return pizza.getCost() + 20;
    }
}