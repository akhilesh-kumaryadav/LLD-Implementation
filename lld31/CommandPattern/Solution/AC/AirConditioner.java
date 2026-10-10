package CommandPattern.Solution.AC;

// Receiver - The AC device that perfomrs actual operations
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

    public boolean isOn() {
        return this.isOn;
    }

    public void setOn(boolean on) {
        this.isOn = on;
    }

    public int getTemperature() {
        return this.temperature;
    }

    public void setTemperature(int temperature) {
        this.temperature = temperature;
        System.out.println("Air conditioner temperature is set to " + temperature + "C");
    }
}