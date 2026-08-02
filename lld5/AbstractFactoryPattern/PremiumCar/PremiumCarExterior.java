package AbstractFactoryPattern.PremiumCar;

import AbstractFactoryPattern.CarMethods.CarExterior;

public class PremiumCarExterior implements CarExterior {
    @Override
    public void addExteriorComponents() {
        System.out.println("Adding basic exterior components for Premium car.");
    }
}