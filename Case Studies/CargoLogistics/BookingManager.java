package CargoLogistics;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
public class BookingManager {
    private static BookingManager instance;
    private List<Booking> bookings;
    private HashMap<String,BookingStrategy> bookingStrategies;
    private BookingManager(){
        bookings = new ArrayList<>();
        bookingStrategies = new HashMap<>();
        bookingStrategies.put("autoBooking",new BookAutoStrategy());
        bookingStrategies.put("ManualBooking",new BookManualStrategy());
    }

    public static BookingManager getInstance()
    {

        if(instance == null)
        {
            synchronized (BookingManager.class) {
                if(instance == null)
                {
                    instance = new BookingManager();
                }
            }
        }
        return instance;
    }

    public void book(List<String> input,String BookingStrategy)
    {
        BookingStrategy bs= bookingStrategies.get(BookingStrategy);
        CargoTruck truck = bs.book(input);
        ShipmentManager shipmentManager = ShipmentManager.getInstance();
        CargoShipment shipment = shipmentManager.getShipmentByID(input.get(0));
        if(truck == null) {System.out.println("Truck is not available");}
        Booking booking = new Booking(shipment, truck, shipment.getSourceCity(), shipment.getDestCity());
        truck.setStatus(TruckStatus.OnTrip);
        shipment.updateStatus(ShipmentStatus.Assigned);
        booking.setStatus(BookingStatus.Booked);
    }


}
