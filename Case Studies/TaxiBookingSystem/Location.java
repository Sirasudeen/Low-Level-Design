package TaxiBookingSystem;

public class Location {
    double latitude;
    double longitude;

    public Location(double latitude,double longitude)
    {
        this.latitude = latitude; 
        this.longitude = longitude;
    }

        @Override
    public String toString() {
        return "Lat: " + String.format("%.2f", latitude) + ", Lon: " + String.format("%.2f", longitude);
    }
}
