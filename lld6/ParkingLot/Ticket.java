package ParkingLot;

import java.time.LocalDateTime;

import ParkingLot.Entity.*;
import ParkingLot.ParkingLot.ParkingLevel;

public class Ticket {
    private final Vehicle vehicle;
    private final ParkingLevel parkingLevel;
    private final ParkingSpot spot;
    private final LocalDateTime entryTime;

    public Ticket(Vehicle vehicle, ParkingLevel parkingLevel, ParkingSpot spot) {
        this.vehicle = vehicle;
        this.parkingLevel = parkingLevel;
        this.spot = spot;
        this.entryTime = LocalDateTime.now();
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public ParkingLevel getLevel() {
        return parkingLevel;
    }

    public ParkingSpot getSpot() {
        return spot;
    }

    public LocalDateTime getEntryTime() {
        return entryTime;
    }
}