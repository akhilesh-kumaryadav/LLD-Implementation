package CarRentalSystem;

import java.time.LocalDate;
import java.util.List;

import CarRentalSystem.Bill.Bill;
import CarRentalSystem.Bill.BillManager;
import CarRentalSystem.Bill.BillingStrategy;
import CarRentalSystem.Bill.DailyBillingStrategy;
import CarRentalSystem.Payment.*;
import CarRentalSystem.Product.Vehicle;
import CarRentalSystem.Product.VehicleInventoryManager;
import CarRentalSystem.Product.VehicleType;
import CarRentalSystem.Reservation.*;

public class Store {
    private final int storeId;
    private final Location storeLocation;
    private final CarRentalSystem.Product.VehicleInventoryManager vehicleInventoryManager;
    private final ReservationManager reservationManager;
    private final BillManager billManager;
    private final PaymentManager paymentManager;

    public Store(int storeId, Location storeLocation) {
        this.storeId = storeId;
        this.storeLocation = storeLocation;
        this.vehicleInventoryManager = new VehicleInventoryManager();
        this.billManager = new BillManager(new DailyBillingStrategy(vehicleInventoryManager));
        this.paymentManager = new PaymentManager(new UPIPaymentStrategy());
        this.reservationManager = new ReservationManager(vehicleInventoryManager);
    }

    public List<Vehicle> getVehicles(VehicleType type, LocalDate from, LocalDate to) {
        return vehicleInventoryManager.getAvailableVehicles(type, from, to);
    }

    public Reservation createReservation(int vehicleId, User user, LocalDate from, LocalDate to, ReservationType type)
            throws Exception {
        return reservationManager.createReservation(vehicleId, user, from, to, type);
    }

    public void cancelReservation(int reservationId) {
        reservationManager.cancelReservation(reservationId);
    }

    public void startTrip(int reservationId) {
        reservationManager.startTrip(reservationId);
    }

    public void submitVehicle(int reservationId) {
        reservationManager.submitVehicle(reservationId);
    }

    public Bill generateBill(int reservationId, BillingStrategy billingStrategy) {
        Reservation r = reservationManager.findById(reservationId)
                .orElseThrow(() -> new RuntimeException("Reservation not found."));

        billManager.setBillingStrategy(billingStrategy);
        return billManager.generateBill(r);
    }

    public Payment makePayment(Bill bill, PaymentStrategy paymentStrategy, double paymentAmount) {
        paymentManager.setPaymentStrategy(paymentStrategy);
        Payment payment = paymentManager.makePayment(bill, paymentAmount);

        if (!bill.isBillPaid()) {
            throw new RuntimeException("Payment Failed");
        }

        reservationManager.remove(bill.getReservationId());
        return payment;
    }

    public VehicleInventoryManager getVehicleInventoryManager() {
        return vehicleInventoryManager;
    }

    public int getStoreId() {
        return storeId;
    }
}