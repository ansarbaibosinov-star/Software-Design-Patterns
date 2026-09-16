public class BookingServiceImpl implements BookingService {

    @Override
    public Booking createBooking(Booking booking) {
        return booking;
    }


    @Override
    public double calculatePrice(Booking booking) {

        double price = 100.0;

        if (booking.getSeatClass().equals("Business")) {
            price += 150.0;
        }

        if (booking.getSeatClass().equals("First")) {
            price += 300.0;
        }

        if (booking.hasMeal()) {
            price += 20.0;
        }

        if (booking.hasInsurance()) {
            price += 15.0;
        }

        if (booking.hasPriorityBoarding()) {
            price += 25.0;
        }

        return price;
    }


    @Override
    public void confirmBooking(Booking booking) {

        System.out.println(
                "Booking " +
                        booking.getBookingId() +
                        " confirmed."
        );
    }
}