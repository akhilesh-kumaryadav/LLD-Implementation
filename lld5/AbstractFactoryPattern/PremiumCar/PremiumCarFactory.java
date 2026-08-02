package AbstractFactoryPattern.PremiumCar;

import AbstractFactoryPattern.CarMethods.CarFactory;
import AbstractFactoryPattern.CarMethods.CarInterior;
import AbstractFactoryPattern.CarMethods.CarExterior;

public class PremiumCarFactory implements CarFactory {
    private String brand;

    public PremiumCarFactory(String brand) {
        this.brand = brand;
    }

    @Override
    public CarInterior createInterior() {
        return new PremiumCarInterior();
    }

    @Override
    public CarExterior createExterior() {
        return new PremiumCarExterior();
    }
}