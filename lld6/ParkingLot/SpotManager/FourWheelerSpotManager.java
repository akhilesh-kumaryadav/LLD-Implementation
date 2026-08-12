package ParkingLot.SpotManager;

import java.util.List;

import ParkingLot.Entity.ParkingSpot;
import ParkingLot.LookupStrategy.ParkingSpotLookupStrategy;

public class FourWheelerSpotManager extends ParkingSpotManager {
    public FourWheelerSpotManager(List<ParkingSpot> spots, ParkingSpotLookupStrategy strategy) {
        super(spots, strategy);
    }
}