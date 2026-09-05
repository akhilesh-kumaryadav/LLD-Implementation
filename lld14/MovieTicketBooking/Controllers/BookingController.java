package MovieTicketBooking.Controllers;

import java.util.List;
import java.util.UUID;

import MovieTicketBooking.Entities.Booking;
import MovieTicketBooking.Entities.Show;
import MovieTicketBooking.Entities.User;
import MovieTicketBooking.Service.BookingService;

public class BookingController {
    private final BookingService bookingService;

    public BookingController() {
        this.bookingService = new BookingService();
    }

    public Booking createBooking(User user, Show show, List<Integer> seats) {
        Booking booking = bookingService.book(user, show, seats);
        return booking;
    }

    public Booking getBooking(UUID bookingId) {
        return bookingService.getBooking(bookingId);
    }

    public List<Booking> getBookingsForUser(User user) {
        return bookingService.getBookingsForUser(user);
    }
}