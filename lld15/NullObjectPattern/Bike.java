package NullObjectPattern;

public class Bike extends Vehicle {
    private String model;
    private String color;
    private int seatingCapacity;
    private int fuelTankingCapacity;
    private boolean isAvailableForTestDrive;

    public Bike(String model, String color, int fuelTankingCapacity) {
        this.model = model;
        this.color = color;
        this.seatingCapacity = 2;
        this.fuelTankingCapacity = fuelTankingCapacity;
        this.isAvailableForTestDrive = false;
    }

    @Override
    public void start() {
        System.out.println("Bike is started and moving.");
    }

    @Override
    public void stop() {
        System.out.println("Bike is stopped.");
    }

    public String getModel() {
        return model;
    }

    public String getColor() {
        return color;
    }

    public int getSeatingCapacity() {
        return seatingCapacity;
    }

    public int getFuelTankCapacity() {
        return fuelTankingCapacity;
    }

    public boolean isAvailableForTestDrive() {
        return isAvailableForTestDrive;
    }
}