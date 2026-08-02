package AbstractFactoryPattern.PremiumCar;

import AbstractFactoryPattern.CarMethods.CarInterior;

public class PremiumCarInterior implements CarInterior {
    @Override
    public void addInteriorComponents() {
        System.out.println("Adding basic interior components for Premium car.");
    }
}