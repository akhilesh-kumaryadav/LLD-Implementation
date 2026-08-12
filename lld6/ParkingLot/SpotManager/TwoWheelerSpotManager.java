package ParkingLot.SpotManager;

import java.util.List;

import ParkingLot.Entity.ParkingSpot;
import ParkingLot.LookupStrategy.ParkingSpotLookupStrategy;

public class TwoWheelerSpotManager extends ParkingSpotManager {
    public TwoWheelerSpotManager(List<ParkingSpot> spots, ParkingSpotLookupStrategy strategy) {
        super(spots, strategy);
    }
}