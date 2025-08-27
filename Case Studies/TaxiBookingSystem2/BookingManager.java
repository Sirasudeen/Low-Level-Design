package TaxiBookingSystem2;
import java.util.HashMap;
public class BookingManager {
    private static BookingManager bookingManagerInstance;
    ClosestDriverMatching driverMatcher;
    Time time;
    FareCalculator fareCalculator;
    HashMap<String,Taxi> Taxis;

    private BookingManager(){
        Taxis = new HashMap<>();
        driverMatcher = new ClosestDriverMatching();
        fareCalculator = new FareCalculator();
        time = new Time();
    }

    public static synchronized  BookingManager getInstance()
    {
        if(bookingManagerInstance == null)
        {
            bookingManagerInstance = new BookingManager();
        }
        return bookingManagerInstance;
    }

    public void requestTaxi(Rider rider,Location Source,Location Dest)
    {
        Booking booking = new Booking(rider, Source, Dest);
        Taxi taxi = driverMatcher.findTaxi(Taxis, Source);
        if(taxi!=null)
        {
            taxi.setStatus(DriverStatus.Busy);
            System.out.println("Rider "+rider.name+" is booked with the taxi Driver "+taxi.getDriverName()+" from "+Source+" to "+Dest);
            booking.assignTaxi(taxi);
            System.out.println("Taxi "+ taxi.getId()+" Picked rider "+rider.name+" at Time "+time.getTime()+" hrs");
            double fare = fareCalculator.CalculateFare(Source, Dest);
            booking.setFare(fare);
            booking.endTrip();
            taxi.setStatus(DriverStatus.Available);
            time.updateTime(((Dest.getPosition()-Source.getPosition())/15) + time.getTime());
            System.out.println("Taxi dropped rider "+rider.name+" at Time "+time.getTime()+" hrs");
        }

    }

    public void addTaxi(Taxi taxi)
    {
        Taxis.put(taxi.getId(),taxi);
    }

}
