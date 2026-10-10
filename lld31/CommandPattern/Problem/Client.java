package CommandPattern.Problem;

public class Client {
    public static void main(String[] args) {
        System.out.println("=====> Command Pattern: Problem Demo <=====");

        AirConditioner airConditioner = new AirConditioner();
        airConditioner.turnOn();
        airConditioner.setTemperature(35);
        airConditioner.turnOff();

        Bulb bulb = new Bulb();
        bulb.turnOn();
        bulb.turnOff();
    }
}