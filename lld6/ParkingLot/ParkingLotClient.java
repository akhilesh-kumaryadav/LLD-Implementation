package ParkingLot;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import ParkingLot.LookupStrategy.*;
import ParkingLot.Entity.*;
import ParkingLot.SpotManager.*;
import ParkingLot.Enum.*;
import ParkingLot.Pricing.*;
import ParkingLot.ParkingLot.*;
import ParkingLot.Payment.*;

public class ParkingLotClient {
    public static void main(String[] args) {
        ParkingSpotLookupStrategy strategy = new RandomLookupStrategy();

        Map<VehicleType, ParkingSpotManager> levelOneMangers = new HashMap<>();
        levelOneMangers.put(VehicleType.TWO_WHEELER,
                new TwoWheelerSpotManager(List.of(new ParkingSpot("L1-S1"), new ParkingSpot("L1-S2")), strategy));
        levelOneMangers.put(VehicleType.FOUR_WHEELER,
                new FourWheelerSpotManager(List.of(new ParkingSpot("L1-S3")), strategy));
        ParkingLevel level1 = new ParkingLevel(1, levelOneMangers);

        Map<VehicleType, ParkingSpotManager> levelTwoMangers = new HashMap<>();
        levelTwoMangers.put(VehicleType.TWO_WHEELER,
                new TwoWheelerSpotManager(List.of(new ParkingSpot("L2-S1")), strategy));
        levelTwoMangers.put(VehicleType.FOUR_WHEELER,
                new FourWheelerSpotManager(List.of(new ParkingSpot("L2-S2")), strategy));
        ParkingLevel level2 = new ParkingLevel(2, levelTwoMangers);

        ParkingBuilding parkingBuilding = new ParkingBuilding(List.of(level1, level2),
                new CostComputation(new FixedPricingStrategy()));

        ParkingLot parkingLot = new ParkingLot(parkingBuilding, new EntranceGate(),
                new ExitGate(new CostComputation(new FixedPricingStrategy())));

        Vehicle bike = new Vehicle("Bike-101", VehicleType.TWO_WHEELER);
        Ticket t1 = parkingLot.vehicleArrives(bike);
        Vehicle car = new Vehicle("Car-201", VehicleType.FOUR_WHEELER);
        Ticket t2 = parkingLot.vehicleArrives(car);

        parkingLot.vehicleExits(t1, new CashPayment());
        parkingLot.vehicleExits(t2, new UpiPayment());
    }
}