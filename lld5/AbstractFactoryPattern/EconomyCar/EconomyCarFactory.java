package AbstractFactoryPattern.EconomyCar;

import AbstractFactoryPattern.CarMethods.CarFactory;
import AbstractFactoryPattern.CarMethods.CarInterior;
import AbstractFactoryPattern.CarMethods.CarExterior;

public class EconomyCarFactory implements CarFactory {
    private String brand;

    public EconomyCarFactory(String brand) {
        this.brand = brand;
    }

    @Override
    public CarInterior createInterior() {
        return new EconomyCarInterior();
    }

    @Override
    public CarExterior createExterior() {
        return new EconomyCarExterior();
    }
}