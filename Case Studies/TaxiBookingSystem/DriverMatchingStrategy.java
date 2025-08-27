package TaxiBookingSystem;

public interface DriverMatchingStrategy {
    public Driver findDriver(Rider rider,Location source);
}
