package CargoLogistics;

import java.util.UUID;

public class CargoTruck {
    private final String id;
    private final int cap;
    private final Location location;
    private TruckStatus status;

    public CargoTruck(int cap,Location location,TruckStatus status)
    {
        this.id = UUID.randomUUID().toString();
        this.cap = cap; this.location = location; this.status = status;
    }

    public String getId(){return id;}
    public int getCapacity(){return cap;}
    public Location getLocation(){return location;}
    public TruckStatus getStatus(){return status;}

    public void setStatus(TruckStatus status)
    {
        this.status = status;
    }

    
}
