package CommandPattern.Problem;

public class Bulb {
    boolean isOn;

    public void turnOn() {
        this.isOn = true;
        System.out.println("Bulb is on.");
    }

    public void turnOff() {
        this.isOn = false;
        System.out.println("Bulb is off.");
    }
}