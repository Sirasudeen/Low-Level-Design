package TaxiBookingSystem;

public class Trip {
    private Rider rider;
    private Driver driver;
    private Location source;
    private Location dest;
    private double fare;
    private TripStatus tripStatus;

    public Trip(Rider rider,Location s,Location dest,TripStatus status)
    {
        this.rider = rider;
        this.source = s;
        this.dest = dest;
        this.tripStatus = status;
    }

    public void assignDriver(Driver driver)
    {
        this.driver = driver;
        this.tripStatus = TripStatus.Accepted;
    }

    public void setFare(double fare)
    {
        this.fare = fare;
    }
    public void startTrip()
    {this.tripStatus = TripStatus.InProgress;}
    public void endTrip()
    {this.tripStatus = TripStatus.Completed;}
    public Location getSourceLocation()
    {return source;}
    public Driver getDriver() {return driver;}
    public Location getDestLocation()
    {
        return dest;
    }
}
