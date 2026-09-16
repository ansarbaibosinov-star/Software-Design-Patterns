public class FlightRoute {
    private String departure;
    private String destination;

    public FlightRoute(String departure,String destination) {
        this.departure = departure;
        this.destination = destination;


    }

    public String getDeparture(){
        return departure;

    }
    public String getDestination(){
        return destination;
    }

    public void printInfo(){
        System.out.println("Route "+"Departure: "+departure+" -> "+ " Destination: "+destination);
    }


}
