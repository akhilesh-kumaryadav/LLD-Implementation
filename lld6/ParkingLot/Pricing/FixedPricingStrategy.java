package ParkingLot.Pricing;

import ParkingLot.Ticket;

public class FixedPricingStrategy implements PricingStrategy {
    @Override
    public double calculate(Ticket ticket) {
        return 100;
    }
}