package ParkingLot.LookupStrategy;

import ParkingLot.Entity.ParkingSpot;

import java.util.List;

public interface ParkingSpotLookupStrategy {
    ParkingSpot selectSpot(List<ParkingSpot> spots);
}