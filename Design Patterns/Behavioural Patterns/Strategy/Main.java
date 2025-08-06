package Strategy;

public class Main {
    public static void main(String[] args) {
        
        RideMatchingService rideMatchingService = new RideMatchingService(new AirportQueueStrategy());
        rideMatchingService.matchRider("Terminal 2");

        RideMatchingService rideMatchingService1 = new RideMatchingService(new NearestDriverStrategy());
        rideMatchingService1.matchRider("Tirunelveli");
        rideMatchingService1.setStrategy(new SurgePriorityStrategy());

        rideMatchingService1.matchRider("Tirunelveli");
    }
}
