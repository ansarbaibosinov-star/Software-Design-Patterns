import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class BookingTest {

    private Passenger passenger =
            new Passenger("Arman", "K123");

    private Flight flight =
            new Flight("KC101", "Almaty", 200);

    private FlightRoute route =
            new FlightRoute("Astana", "Almaty");


    @Test
    void validEconomyBooking() {

        Booking booking = new Booking.Builder(
                "B001",
                passenger,
                flight,
                "Economy"
        )
                .seat("12A")
                .baggage(20)
                .withMeal()
                .route(route)
                .build();

        assertEquals("B001", booking.getBookingId());
        assertEquals("Economy", booking.getSeatClass());
        assertEquals(20, booking.getBaggageWeight());
        assertTrue(booking.hasMeal());
    }


    @Test
    void validBusinessBooking() {

        Booking booking = new Booking.Builder(
                "B002",
                passenger,
                flight,
                "Business"
        )
                .seat("2A")
                .baggage(30)
                .withMeal()
                .withInsurance()
                .withPriorityBoarding()
                .route(route)
                .build();

        assertEquals("Business", booking.getSeatClass());
        assertEquals(30, booking.getBaggageWeight());
        assertTrue(booking.hasMeal());
        assertTrue(booking.hasInsurance());
        assertTrue(booking.hasPriorityBoarding());
    }


    @Test
    void validFirstClassBooking() {

        Booking booking = new Booking.Builder(
                "B003",
                passenger,
                flight,
                "First"
        )
                .seat("1A")
                .baggage(40)
                .withMeal()
                .withInsurance()
                .withPriorityBoarding()
                .route(route)
                .build();

        assertEquals("First", booking.getSeatClass());
        assertEquals(40, booking.getBaggageWeight());
        assertTrue(booking.hasPriorityBoarding());
    }


    @Test
    void emptyBookingIdThrowsException() {

        assertThrows(
                IllegalArgumentException.class,
                () -> new Booking.Builder(
                        "",
                        passenger,
                        flight,
                        "Economy"
                ).build()
        );
    }


    @Test
    void nullPassengerThrowsException() {

        assertThrows(
                IllegalArgumentException.class,
                () -> new Booking.Builder(
                        "B005",
                        null,
                        flight,
                        "Economy"
                ).build()
        );
    }


    @Test
    void nullFlightThrowsException() {

        assertThrows(
                IllegalArgumentException.class,
                () -> new Booking.Builder(
                        "B006",
                        passenger,
                        null,
                        "Economy"
                ).build()
        );
    }


    @Test
    void negativeBaggageThrowsException() {

        assertThrows(
                IllegalArgumentException.class,
                () -> new Booking.Builder(
                        "B007",
                        passenger,
                        flight,
                        "Economy"
                )
                        .baggage(-5)
                        .build()
        );
    }


    @Test
    void baggageOver50KgThrowsException() {

        assertThrows(
                IllegalArgumentException.class,
                () -> new Booking.Builder(
                        "B008",
                        passenger,
                        flight,
                        "Economy"
                )
                        .baggage(55)
                        .build()
        );
    }


    @Test
    void priorityBoardingForEconomyThrowsException() {

        assertThrows(
                IllegalArgumentException.class,
                () -> new Booking.Builder(
                        "B009",
                        passenger,
                        flight,
                        "Economy"
                )
                        .withPriorityBoarding()
                        .build()
        );
    }


    @Test
    void heavyBaggageForEconomyThrowsException() {

        assertThrows(
                IllegalArgumentException.class,
                () -> new Booking.Builder(
                        "B010",
                        passenger,
                        flight,
                        "Economy"
                )
                        .baggage(25)
                        .build()
        );
    }


    @Test
    void builderCreatesIndependentBookings() {

        Booking.Builder builder = new Booking.Builder(
                "B011",
                passenger,
                flight,
                "Economy"
        );

        Booking firstBooking = builder
                .seat("1A")
                .build();

        Booking secondBooking = builder
                .seat("2B")
                .build();

        assertNotSame(firstBooking, secondBooking);

        assertEquals("1A", firstBooking.getSeatNumber());
        assertEquals("2B", secondBooking.getSeatNumber());
    }


    @Test
    void exactly20KgBaggageIsAllowedForEconomy() {

        Booking booking = new Booking.Builder(
                "B012",
                passenger,
                flight,
                "Economy"
        )
                .baggage(20)
                .build();

        assertEquals(20, booking.getBaggageWeight());
    }
}