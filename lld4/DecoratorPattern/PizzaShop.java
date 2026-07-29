package DecoratorPattern;

import DecoratorPattern.Layer1.PlainPizza;
import DecoratorPattern.Layer1.FarmHouse;
import DecoratorPattern.Layer1.TandooriPaneerDlight;
import DecoratorPattern.Layer1.ChickenDominator;

import DecoratorPattern.Layer1.Layer2.ExtraCheeseTopping;
import DecoratorPattern.Layer1.Layer2.VeggiesTopping;
import DecoratorPattern.Layer1.Layer2.PepperoniTopping;
import DecoratorPattern.Layer1.Layer2.MushroomTopping;

public class PizzaShop {
    public static void main(String[] args) {
        System.out.println("===== Decorator Design Pattern =====");

        BasePizza pizza1 = new PlainPizza();
        System.out.println("Order 1: " + pizza1.getDescription() + " = Rs. " + pizza1.getCost());

        BasePizza pizza2 = new ExtraCheeseTopping(new PlainPizza());
        System.out.println("Order 2: " + pizza2.getDescription() + " = Rs. " + pizza2.getCost());

        BasePizza pizza3 = new VeggiesTopping(new ExtraCheeseTopping(new PlainPizza()));
        System.out.println("Order 3: " + pizza3.getDescription() + " = Rs. " + pizza3.getCost());

        BasePizza pizza4 = new PepperoniTopping(new ExtraCheeseTopping(new PlainPizza()));
        System.out.println("Order 4: " + pizza4.getDescription() + " = Rs. " + pizza4.getCost());

        BasePizza pizza5 = new MushroomTopping(new PepperoniTopping(new ExtraCheeseTopping(new PlainPizza())));
        System.out.println("Order 5: " + pizza5.getDescription() + " = Rs. " + pizza5.getCost());

        BasePizza pizza6 = new FarmHouse();
        System.out.println("Order 6: " + pizza6.getDescription() + " = Rs. " + pizza6.getCost());

        BasePizza pizza7 = new ExtraCheeseTopping(new MushroomTopping(new FarmHouse()));
        System.out.println("Order 7: " + pizza7.getDescription() + " = Rs. " + pizza7.getCost());

        BasePizza pizza8 = new TandooriPaneerDlight();
        System.out.println("Order 8: " + pizza8.getDescription() + " = Rs. " + pizza8.getCost());

        BasePizza pizza9 = new ChickenDominator();
        System.out.println("Order 9: " + pizza9.getDescription() + " = Rs. " + pizza9.getCost());

        BasePizza pizza10 = new MushroomTopping(new ChickenDominator());
        System.out.println("Order 10: " + pizza10.getDescription() + " = Rs. " + pizza10.getCost());

    }
}
