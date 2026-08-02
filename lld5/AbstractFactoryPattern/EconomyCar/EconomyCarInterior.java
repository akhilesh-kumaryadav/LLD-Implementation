package AbstractFactoryPattern.EconomyCar;

import AbstractFactoryPattern.CarMethods.CarInterior;

public class EconomyCarInterior implements CarInterior {
    @Override
    public void addInteriorComponents() {
        System.out.println("Adding basic interior components for Economy car.");
    }
}