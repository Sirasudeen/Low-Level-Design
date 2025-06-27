package CargoLogistics;

import java.util.UUID;


public class Booking {
    private final String id;
    private final CargoShipment shipment;
    private final CargoTruck truck;
    private final Location source;
    private final Location dest;
    private  BookingStatus status;

    public Booking(CargoShipment shipment,CargoTruck truck,Location source,Location dest)
    {
        this.shipment = shipment;
        this.truck = truck;
        this.source = source;
        this.dest = dest;
        this.id = UUID.randomUUID().toString();
        this.status = BookingStatus.Requested;
    }

    public void printBooking()
    {
        System.out.println("-------------------------------------------------------");
        System.out.println("Booked Id : " + id);
        System.out.println("Shipment(ID NO : " + shipment.getId() + " ) is Booked with Truck (Id NO: "+ truck.getId()+" ) from "+ source + " to "+ dest);
        System.out.println("-------------------------------------------------------");
        
    }

    public void setStatus(BookingStatus status){this.status = status;}
}
