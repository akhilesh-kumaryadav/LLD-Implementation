package AbstractFactoryPattern.LuxuryCar;

import AbstractFactoryPattern.CarMethods.CarExterior;

public class LuxuryCarExterior implements CarExterior {
    @Override
    public void addExteriorComponents() {
        System.out.println("Adding basic exterior components for Luxury car.");
    }
}