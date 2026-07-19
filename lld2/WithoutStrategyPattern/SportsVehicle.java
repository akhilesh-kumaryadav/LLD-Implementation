package WithoutStrategyPattern;

public class SportsVehicle extends Vehicle {
    // Different drive logic (Same code as sportsVehicle)
    @Override
    public void drive() {
        System.out.println("Sport Drive Capability.");
    }
}