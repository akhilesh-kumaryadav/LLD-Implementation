package NullObjectPattern.Solution;

import NullObjectPattern.Vehicle;

public class NullVehicle extends Vehicle {
    private String model;
    private String color;
    private int seatingCapacity;
    private int fuelTankingCapacity;
    private boolean isAvailableForTestDrive;

    public NullVehicle() {
        this.model = "Default";
        this.color = "Default";
        this.seatingCapacity = 0;
        this.fuelTankingCapacity = 0;
        this.isAvailableForTestDrive = false;
    }

    @Override
    public void start() {
        System.out.print("\n[-] Null Vehicle: start() - do nothing");
    }

    @Override
    public void stop() {
        System.out.println("\n[-] Null Vehicle: stop() - do nothing");
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