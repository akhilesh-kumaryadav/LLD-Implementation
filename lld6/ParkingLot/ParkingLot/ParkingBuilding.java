package ParkingLot.ParkingLot;

import ParkingLot.Ticket;
import ParkingLot.Entity.*;
import ParkingLot.Pricing.*;

import java.util.List;

public class ParkingBuilding {
    private final List<ParkingLevel> levels;

    public ParkingBuilding(List<ParkingLevel> levels, CostComputation costComputation) {
        this.levels = levels;
        // wh costcomputation needed here
    }

    Ticket allocate(Vehicle vehicle) {
        for (ParkingLevel level : levels) {
            if (level.hasAvailibility(vehicle.getVehicleType())) {
                ParkingSpot spot = level.park(vehicle.getVehicleType());

                if (spot != null) {
                    Ticket ticket = new Ticket(vehicle, level, spot);

                    System.out.println(
                            "Parking allocated at level: " + level.getLevelNumber() + " spot: " + spot.getSpotId());

                    return ticket;
                }
            }
        }

        throw new RuntimeException("Parking Full");
    }

    void release(Ticket ticket) {
        ticket.getLevel().unPark(ticket.getVehicle().getVehicleType(), ticket.getSpot());
    }
}