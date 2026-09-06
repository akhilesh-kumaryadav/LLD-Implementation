package NullObjectPattern.Problem;

import NullObjectPattern.Bike;
import NullObjectPattern.Car;
import NullObjectPattern.Vehicle;

public class VehicleFactory {
    public static Vehicle getVehicle(String type) {
        if (type.equals("car")) {
            return new Car("Toyota", "Red", 5, 60, true);
        } else if (type.equals("bike")) {
            return new Bike("Yamaha", "Black", 60);
        } else {
            // The PROBLEM
            return null;
        }
    }
}