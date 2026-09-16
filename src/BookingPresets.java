public class BookingPresets {

    public static Booking basic(
            String bookingId,
            Passenger passenger,
            Flight flight
    ) {

        return new Booking.Builder(
                bookingId,
                passenger,
                flight,
                "Economy"
        )
                .baggage(10)
                .build();
    }


    public static Booking business(
            String bookingId,
            Passenger passenger,
            Flight flight,
            FlightRoute route
    ) {

        return new Booking.Builder(
                bookingId,
                passenger,
                flight,
                "Business"
        )
                .baggage(30)
                .withMeal()
                .withInsurance()
                .withPriorityBoarding()
                .seat("5A")
                .route(route)
                .build();
    }


    public static Booking premium(
            String bookingId,
            Passenger passenger,
            Flight flight,
            FlightRoute route
    ) {

        return new Booking.Builder(
                bookingId,
                passenger,
                flight,
                "First"
        )
                .baggage(40)
                .withMeal()
                .withInsurance()
                .withPriorityBoarding()
                .seat("1A")
                .route(route)
                .build();
    }
}