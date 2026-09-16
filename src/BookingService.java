public interface BookingService {

    Booking createBooking(Booking booking);

    double calculatePrice(Booking booking);

    void confirmBooking(Booking booking);
}