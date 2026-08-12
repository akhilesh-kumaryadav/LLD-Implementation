package ParkingLot.Pricing;

import ParkingLot.Ticket;

public interface PricingStrategy {
    double calculate(Ticket ticket);
}