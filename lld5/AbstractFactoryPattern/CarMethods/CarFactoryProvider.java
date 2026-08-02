package AbstractFactoryPattern.CarMethods;

import AbstractFactoryPattern.EconomyCar.EconomyCarFactory;
import AbstractFactoryPattern.PremiumCar.PremiumCarFactory;
import AbstractFactoryPattern.LuxuryCar.LuxuryCarFactory;
import AbstractFactoryPattern.Common.CarType;

public class CarFactoryProvider {
    public CarFactory getFactory(CarType type, String brand) {
        switch (type) {
            case ECONOMY:
                return new EconomyCarFactory(brand);
            case PREMIUM:
                return new PremiumCarFactory(brand);
            case LUXURY:
                return new LuxuryCarFactory(brand);
            default:
                throw new IllegalArgumentException("Unknown car type: " + type);
        }
    }
}