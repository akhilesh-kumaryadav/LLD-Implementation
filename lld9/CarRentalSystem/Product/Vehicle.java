package CarRentalSystem.Product;

public class Vehicle {
    private final int vehicleId;
    private final String vehicleNumber;
    private final VehicleType vehicleType;
    private double dailyRentalCost;
    private volatile VehicleStatus vehicleStatus;

    /*
     * we can add more properties like below if required
     * private String companyName;
     * private String modelName;
     * private int kmDriven;
     * private int average;
     * private int cc;
     * private int noOfSeat;
     */

    public Vehicle(int vehicleId, String vehicleNumber, VehicleType vehicleType) {
        this.vehicleId = vehicleId;
        this.vehicleNumber = vehicleNumber;
        this.vehicleType = vehicleType;
        this.vehicleStatus = VehicleStatus.AVAILABLE;
    }

    public int getVehicleId() {
        return vehicleId;
    }

    public String getVehicleNubmer() {
        return vehicleNumber;
    }

    public VehicleType getVehicleType() {
        return vehicleType;
    }

    public double getDailyRentalCost() {
        return dailyRentalCost;
    }

    public VehicleStatus getVehicleStatus() {
        return vehicleStatus;
    }

    public void setDailyRentalCost(double dailyRentalCost) {
        this.dailyRentalCost = dailyRentalCost;
    }

    public void setVehicleStatus(VehicleStatus vehicleStatus) {
        this.vehicleStatus = vehicleStatus;
    }
}