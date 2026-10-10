package CommandPattern.Problem;

public class AirConditioner {
    boolean isOn;
    int temperature;

    public void turnOn() {
        this.isOn = true;
        System.out.println("Air conditioner is on.");
    }

    public void turnOff() {
        this.isOn = false;
        System.out.println("Air conditioner is off.");
    }

    public void setTemperature(int temperature) {
        this.temperature = temperature;
        System.out.println("Air conditioner temperature set to " + temperature);
    }
}