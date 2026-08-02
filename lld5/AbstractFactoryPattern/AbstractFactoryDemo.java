package AbstractFactoryPattern;

import AbstractFactoryPattern.CarMethods.CarFactoryProvider;
import AbstractFactoryPattern.CarMethods.CarFactory;

import AbstractFactoryPattern.Common.CarType;

public class AbstractFactoryDemo {
    public static void main(String[] args) {
        System.out.println("===== Abstract Factory Pattern =====");

        CarFactoryProvider carFactoryProvider = new CarFactoryProvider();

        CarFactory economyCar = carFactoryProvider.getFactory(CarType.ECONOMY, "Tata Nexon");
        economyCar.produceCompleteVehicle();

        CarFactory luxuryCar = carFactoryProvider.getFactory(CarType.LUXURY, "Range Rover Sports");
        luxuryCar.produceCompleteVehicle();

        CarFactory PremiumCar = carFactoryProvider.getFactory(CarType.PREMIUM, "Ferrari Amalfi");
        PremiumCar.produceCompleteVehicle();
    }
}