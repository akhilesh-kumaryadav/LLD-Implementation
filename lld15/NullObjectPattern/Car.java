package NullObjectPattern;

public class Car extends Vehicle {
    private String model;
    private String color;
    private int seatingCapacity;
    private int fuelTankingCapacity;
    private boolean isAvailableForTestDrive;

    public Car(String model, String color, int seatingCapacity, int fuelTankingCapacity,
            boolean isAvailableForTestDrive) {
        this.model = model;
        this.color = color;
        this.seatingCapacity = seatingCapacity;
        this.fuelTankingCapacity = fuelTankingCapacity;
        this.isAvailableForTestDrive = isAvailableForTestDrive;
    }

    @Override
    public void start() {
        System.out.println("Car is started and moving.");
    }

    @Override
    public void stop() {
        System.out.println("Car is stopped.");
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