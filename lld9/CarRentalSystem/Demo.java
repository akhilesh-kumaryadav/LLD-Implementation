package CarRentalSystem;

import java.time.LocalDate;

import CarRentalSystem.Bill.Bill;
import CarRentalSystem.Payment.Payment;
import CarRentalSystem.Product.Vehicle;
import CarRentalSystem.Product.VehicleType;
import CarRentalSystem.Reservation.Reservation;
import CarRentalSystem.Reservation.ReservationType;
import CarRentalSystem.Bill.DailyBillingStrategy;
import CarRentalSystem.Payment.UPIPaymentStrategy;

public class Demo {
    public static void main(String[] args) throws Exception {
        System.out.println("=====> LLD: Car Rental System <=====");

        VehicleRentalSystem vehicleRentalSystem = new VehicleRentalSystem();

        Location store1Location = new Location(45, "Area1", "City1", "State1", "India", 12345);
        Store store1 = new Store(1001, store1Location);
        vehicleRentalSystem.addStore(store1);

        User user1 = new User(801, "SJ", "DL2022GDG556690");
        User user2 = new User(801, "DJ", "DL2017DHW9090765231");
        vehicleRentalSystem.addUser(user1);
        vehicleRentalSystem.addUser(user2);

        Vehicle v1 = new Vehicle(1, "DL1234", VehicleType.FOUR_WHEELER);
        v1.setDailyRentalCost(1100);
        Vehicle v2 = new Vehicle(2, "DL2234", VehicleType.FOUR_WHEELER);
        v2.setDailyRentalCost(1400);
        store1.getVehicleInventoryManager().addVehicle(v1);
        store1.getVehicleInventoryManager().addVehicle(v2);

        Store selectedStore = vehicleRentalSystem.getStore(1001);
        LocalDate fromDate = LocalDate.of(2025, 12, 5);
        LocalDate toDate = LocalDate.of(2025, 12, 7);

        System.out.println("\nAvailable vehicles from " + fromDate + " to " + toDate + ":");
        for (Vehicle v : selectedStore.getVehicles(VehicleType.FOUR_WHEELER, fromDate, toDate)) {
            System.out.println(" - " + v.getVehicleId() + ":" + v.getVehicleType());
        }

        System.out.println("\nCreating reservation...");
        Reservation reservation = selectedStore.createReservation(1, user1, fromDate, toDate, ReservationType.DAILY);
        System.out.println("Reservation created with Id: " + reservation.getReservationId());

        System.out.println("\nStaring trip...");
        selectedStore.startTrip(reservation.getReservationId());

        System.out.println("\nSubmitting vehicle...");
        selectedStore.submitVehicle(reservation.getReservationId());

        System.out.println("\nGenerating bill...");
        Bill bill = selectedStore.generateBill(reservation.getReservationId(),
                new DailyBillingStrategy(selectedStore.getVehicleInventoryManager()));
        System.out.println("Bill Id: " + bill.getBillId());
        System.out.println("Bill Amount: " + bill.getTotalBillAmount());

        System.out.println("\nProcessing Payment...");
        Payment payment = selectedStore.makePayment(bill, new UPIPaymentStrategy(), bill.getTotalBillAmount());
        System.out.println("\n=====> Payment Receipt <=====");
        System.out.println("Payment Id: " + payment.getPaymentId());
        System.out.println("Paid Amount: " + payment.getAmountPaid());
        System.out.println("Payment Mode: " + payment.getPaymentMode());
        System.out.println("Payment Date: " + payment.getPaymentDate());
        System.out.println("===================================");
    }
}