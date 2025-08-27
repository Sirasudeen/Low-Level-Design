package TaxiBookingSystem2;

public class Taxi {
    private String id;
    private String driverName;
    private Location location;
    private double moneyEarned;
    private DriverStatus status;
    public Taxi(String id,String driverName)
    {
        this.id = id;
        this.driverName = driverName;
        this.location = Location.A;
        this.moneyEarned = 0.00;
        this.status = DriverStatus.Available;
    }

    public String getId()
    {return id;}
    public String getDriverName(){return driverName;}
    public Location getLocation() {
        return location;
    }

    public DriverStatus getStatus() {return status;}
    public double getMoneyEarned() {return moneyEarned;}

    public void setLocation(Location loc) {this.location = loc;}

    public void setStatus(DriverStatus status) {this.status = status;}
    public void setMoneyEarned(double moneyEarned) {this.moneyEarned = moneyEarned;}

    

}
