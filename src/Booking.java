public class Booking {

    private final String bookingId;
    private final Passenger passenger;
    private final Flight flight;
    private final String seatClass;

    private final String seatNumber;
    private final double baggageWeight;
    private final boolean meal;
    private final boolean insurance;
    private final boolean priorityBoarding;
    private final FlightRoute route;

    private Booking(Builder builder) {

        this.bookingId = builder.bookingId;
        this.passenger = builder.passenger;
        this.flight = builder.flight;
        this.seatClass = builder.seatClass;

        this.seatNumber = builder.seatNumber;
        this.baggageWeight = builder.baggageWeight;
        this.meal = builder.meal;
        this.insurance = builder.insurance;
        this.priorityBoarding = builder.priorityBoarding;
        this.route = builder.route;
    }

    public String getBookingId() {
        return bookingId;
    }

    public Passenger getPassenger() {
        return passenger;
    }

    public Flight getFlight() {
        return flight;
    }

    public String getSeatClass() {
        return seatClass;
    }

    public String getSeatNumber() {
        return seatNumber;
    }

    public double getBaggageWeight() {
        return baggageWeight;
    }

    public boolean hasMeal() {
        return meal;
    }

    public boolean hasInsurance() {
        return insurance;
    }

    public boolean hasPriorityBoarding() {
        return priorityBoarding;
    }

    public FlightRoute getRoute() {
        return route;
    }

    public void printInfo() {

        System.out.println("Booking ID: " + bookingId);
        System.out.println("Passenger: " + passenger.getName());
        System.out.println("Flight: " + flight.getFlightNumber());
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


    public static class Builder {

        private final String bookingId;
        private final Passenger passenger;
        private final Flight flight;
        private final String seatClass;

        private String seatNumber = "Not selected";
        private double baggageWeight = 0;
        private boolean meal = false;
        private boolean insurance = false;
        private boolean priorityBoarding = false;
        private FlightRoute route = null;


        public Builder(
                String bookingId,
                Passenger passenger,
                Flight flight,
                String seatClass
        ) {
            this.bookingId = bookingId;
            this.passenger = passenger;
            this.flight = flight;
            this.seatClass = seatClass;
        }


        public Builder seat(String seatNumber) {
            this.seatNumber = seatNumber;
            return this;
        }


        public Builder baggage(double baggageWeight) {
            this.baggageWeight = baggageWeight;
            return this;
        }


        public Builder withMeal() {
            this.meal = true;
            return this;
        }


        public Builder withInsurance() {
            this.insurance = true;
            return this;
        }


        public Builder withPriorityBoarding() {
            this.priorityBoarding = true;
            return this;
        }


        public Builder route(FlightRoute route) {
            this.route = route;
            return this;
        }


        public Booking build() {
            return new Booking(this);
        }
    }
}






























