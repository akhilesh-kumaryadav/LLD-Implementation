package WithoutStrategyPattern;

public class OffRoadVehicle extends Vehicle {
    @Override
    // Different drive logic (Same code as sportsVehicle)
    public void drive() {
        System.out.println("Sports Drive Capability.");
    }
}