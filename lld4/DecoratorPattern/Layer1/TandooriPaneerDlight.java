package DecoratorPattern.Layer1;

import DecoratorPattern.BasePizza;

public class TandooriPaneerDlight implements BasePizza {
    @Override
    public String getDescription() {
        return "Tandoori Paneer Dlight Pizza";
    }

    @Override
    public double getCost() {
        return 600.0;
    }
}