package TaxiBookingSystem2;

public class Booking {
    private Taxi taxi;
    private Rider rider;
    private Location source;
    private Location dest;
    private double fare;
    private TripStatus status;

    public Booking(Rider rider,Location source,Location dest)
    {
        this.rider = rider;
        this.source = source;
        this.dest = dest;
        this.status = TripStatus.REQUESTED;
    }

    public void assignTaxi(Taxi taxi)
    {
        this.taxi = taxi;
        this.status = TripStatus.ACCEPTED;
    }
    public void setFare(double fare)
    {
        this.fare = fare;
    }
    public void endTrip()
    {
        double money = taxi.getMoneyEarned()+this.fare;
        taxi.setMoneyEarned(money);
        taxi.setLocation(dest);
        this.status = TripStatus.COMPLETED;
    }
    

}
