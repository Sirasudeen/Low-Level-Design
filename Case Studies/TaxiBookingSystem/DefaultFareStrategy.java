package TaxiBookingSystem;

public class DefaultFareStrategy implements  FareStrategy{

    private static double BaseFare = 50.0;
    private static double FarePerKm = 10.0;

    @Override
    public double calculateFare(Trip trip)
    {
        double distance = Math.sqrt(Math.pow(trip.getDestLocation().latitude - trip.getSourceLocation().latitude ,2)+Math.pow(trip.getDestLocation().longitude - trip.getSourceLocation().longitude,2));
        return BaseFare + distance * FarePerKm;
    }
}
