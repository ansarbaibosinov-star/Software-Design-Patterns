public class Booking {
    private String bookingId;
    private Passenger passenger;
    private Flight flightNumber;
    private String seatClass;



    private double baggageWeight;
    private boolean meal;
    private boolean insurance;//srahovanie
    private boolean priorityBoarding;
    private String seatNumber;
    private FlightRoute route;

    public Booking(String bookingId, Passenger passenger, Flight flightNumber, String seatClass, double baggageWeight, boolean meal, boolean insurance, boolean priorityBoarding, String seatNumber, FlightRoute route) {
        this.bookingId = bookingId;
        this.passenger = passenger;
        this.flightNumber = flightNumber;
        this.seatClass = seatClass;
        this.baggageWeight = baggageWeight;
        this.meal = meal;
        this.insurance = insurance;
        this.priorityBoarding = priorityBoarding;
        this.seatNumber = seatNumber;
        this.route = route;




    }

    public void printInfo() {

        System.out.println("Booking ID: " + bookingId);
        System.out.println("Passenger: " + passenger.getName());
        System.out.println("Flight: " + flightNumber.getFlightNumber());
        System.out.println("Class: " + seatClass);
        System.out.println("Baggage: " + baggageWeight + " kg");
        System.out.println("Meal: " + meal);
        System.out.println("Insurance: " + insurance);
        System.out.println("Priority boarding: " + priorityBoarding);
        System.out.println("Seat: " + seatNumber);


        if (route != null) {
            route.printInfo();
        }
    }
}