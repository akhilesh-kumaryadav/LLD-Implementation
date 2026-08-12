package ParkingLot.ParkingLot;

import ParkingLot.Entity.Vehicle;
import ParkingLot.Ticket;

public class EntranceGate {
    public Ticket enter(ParkingBuilding building, Vehicle vehicle) {
        return building.allocate(vehicle);
    }
}