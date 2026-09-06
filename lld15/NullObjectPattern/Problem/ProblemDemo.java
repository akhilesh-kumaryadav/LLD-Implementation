package NullObjectPattern.Problem;

import NullObjectPattern.Bike;
import NullObjectPattern.Car;
import NullObjectPattern.Vehicle;

public class ProblemDemo {
    private static void printVehicleDetails(Vehicle vehicle) {
        if (vehicle != null) {
            if (vehicle instanceof Car car) {
                System.out.print("\n[+] Vehicle Details: ");
                System.out.println(car.getClass().getSimpleName() + " [Model=" + car.getModel()
                        + ", Color=" + car.getColor() + ", Seating Capacity=" + car.getSeatingCapacity()
                        + ", Fuel Tank Capacity=" + car.getFuelTankCapacity() + "]");

            }
            if (vehicle instanceof Bike bike) {
                System.out.print("\n[+] Vehicle Details: ");
                System.out.println(bike.getClass().getSimpleName() + " [Model=" + bike.getModel()
                        + ", Color=" + bike.getColor() + ", Fuel Tank Capacity=" + bike.getFuelTankCapacity() + "]");
            }
        }
    }

    private static void testDrive(Vehicle vehicle) {
        if (vehicle != null) {
            vehicle.start();
            vehicle.stop();
        }
    }

    public static void main(String[] args) {
        System.out.println("\n =====> Null Object Pattern: Problem Demo <=====");

        Vehicle car = VehicleFactory.getVehicle("car");
        printVehicleDetails(car);
        testDrive(car);

        Vehicle bike = VehicleFactory.getVehicle("bike");
        printVehicleDetails(bike);
        testDrive(bike);

        Vehicle nullVehicle = VehicleFactory.getVehicle("null");
        printVehicleDetails(nullVehicle);
        testDrive(nullVehicle);
    }
}