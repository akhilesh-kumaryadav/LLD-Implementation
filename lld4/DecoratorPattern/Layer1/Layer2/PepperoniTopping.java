package DecoratorPattern.Layer1.Layer2;

import DecoratorPattern.ToppingDecorator;
import DecoratorPattern.BasePizza;

public class PepperoniTopping extends ToppingDecorator {
    public PepperoniTopping(BasePizza pizza) {
        super(pizza);
    }

    @Override
    public String getDescription() {
        return pizza.getDescription() + " + Pepperoni";
    }

    @Override
    public double getCost() {
        return pizza.getCost() + 50;
    }
}