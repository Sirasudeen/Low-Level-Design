package TaxiBookingSystem;

public class TripManager {
    private static TripManager tripManagerInstance;
    private DriverMatchingStrategy driverMatcher;
    private FareStrategy FareCalculator;

    private TripManager()
    {
        driverMatcher = new ClosestDriverStrategy();
        FareCalculator = new DefaultFareStrategy();
    }

    public static synchronized TripManager getInstance()
    {
        if(tripManagerInstance == null)
        {
            tripManagerInstance = new TripManager();
        }
        return tripManagerInstance;
    }

    public Trip requestTrip(Rider rider,Location Source,Location Dest)
    {
        System.out.println("\n[SYSTEM] Rider " + rider.getName() + " is requesting a trip from " + Source + " to " + Dest);
        Driver driver = driverMatcher.findDriver(rider, Source);
        if(driver != null)
        {
            Trip trip = new Trip(rider, Source, Dest,TripStatus.Requested);
            trip.assignDriver(driver);
            driver.setStatus(TaxiDriverStatus.Busy);
            System.out.println("[SYSTEM] Trip assigned to driver " + driver.getName() + " at " + driver.getCurrentLocation());
            return trip;
        } else {
            System.out.println("[SYSTEM] No available drivers found. Please try again later.");
            return null;
        }

    }

    public void endTrip(Trip trip)
    {
        trip.endTrip();
        trip.getDriver().setStatus(TaxiDriverStatus.Available);
        double fare = FareCalculator.calculateFare(trip);
        trip.getDriver().updateLocation(trip.getDestLocation());
        System.out.println("[SYSTEM] Trip ended. Fare calculated: ₹" + String.format("%.2f", fare));
    }
}
