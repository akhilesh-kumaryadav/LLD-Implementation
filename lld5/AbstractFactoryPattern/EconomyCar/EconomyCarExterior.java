package AbstractFactoryPattern.EconomyCar;

import AbstractFactoryPattern.CarMethods.CarExterior;

public class EconomyCarExterior implements CarExterior {
    @Override
    public void addExteriorComponents() {
        System.out.println("Adding basic exterior components for Economy car.");
    }
}