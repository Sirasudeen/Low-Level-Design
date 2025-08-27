package TaxiBookingSystem2;

public class FareCalculator {
    private final double BaseFare = 100.00;
    private final double FarePerKM = 10.00;

    public double CalculateFare(Location Source,Location Dest)
    {
        int totDistance  = Dest.getPosition() - Source.getPosition();

        if(totDistance <= 5) return BaseFare;
        totDistance-=5;
        return BaseFare+(totDistance*FarePerKM);
    }
}
