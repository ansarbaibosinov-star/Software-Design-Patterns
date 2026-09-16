//public class Main {
//
//    public static void main(String[] args) {
//
//        Flight f1 = new Flight("KC101", "Almaty", 180);
//        Flight f2 = new Flight("KC102", "Astana", 160);
//        FlightRoute fr = new FlightRoute("Astana","Almaty");
//        Passenger p1 = new Passenger("Ayan", "P12345");
//        Passenger p2 = new Passenger("Dana", "P54321");
//        Booking b1 = new Booking(p1, f1, "12A");
//        Booking b2 = new Booking(p2, f2, "18C");
//        b1.printInfo();
//        b2.printInfo();
//
//
//
//
//    }
//}
public class Main {

    public static void main(String[] args) {

        FlightRoute route =
                new FlightRoute("Astana", "Almaty");
        Passenger passenger = new Passenger("Arman","k123");
        Flight flight = new Flight("KC101","Almaty",200);

        Booking booking = new Booking(
                "B001",
                passenger,
                flight,
                "Economy",
                20,
                true,
                false,
                false,
                "12A",
                route
        );

        booking.printInfo();

    }
}