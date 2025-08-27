package TaxiBookingSystem;

class Driver {
    String id;
    String name;
    Vehicle vehicle;
    Location currentLocation;
    TaxiDriverStatus status;

    public Driver(String id, String name, Vehicle vehicle) {
        this.id = id;
        this.name = name;
        this.vehicle = vehicle;
        this.status = TaxiDriverStatus.Available;
        this.currentLocation = new Location(Math.random() * 100, Math.random() * 100);
    }

    public void updateLocation(Location newLocation) { this.currentLocation = newLocation; }
    public void setStatus(TaxiDriverStatus status) { this.status = status; }
    public String getId() { return id; }
    public String getName() { return name; }
    public Location getCurrentLocation() { return currentLocation; }
    public TaxiDriverStatus getStatus() { return status; }
}
