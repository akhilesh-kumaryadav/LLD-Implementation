package AbstractFactoryPattern.LuxuryCar;

import AbstractFactoryPattern.CarMethods.CarFactory;
import AbstractFactoryPattern.CarMethods.CarInterior;
import AbstractFactoryPattern.CarMethods.CarExterior;

public class LuxuryCarFactory implements CarFactory {
    private String brand;

    public LuxuryCarFactory(String brand) {
        this.brand = brand;
    }

    @Override
    public CarInterior createInterior() {
        return new LuxuryCarInterior();
    }

    @Override
    public CarExterior createExterior() {
        return new LuxuryCarExterior();
    }
}