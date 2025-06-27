package CargoLogistics;

import java.util.UUID;

public class CargoShipment {
    private final String id;
    private final int weight;
    private final Location source;
    private final Location destination;
    private ShipmentStatus status;
    public CargoShipment(int weight,Location source,Location destination)
    {
        this.id = UUID.randomUUID().toString();
        this.source = source;
        this.destination = destination;
        this.weight = weight;
        this.status = ShipmentStatus.UnAssigned;
    }


   public int getWeight() { return weight;}
    
    public String getId() { return id;}
    public Location getSourceCity() {return source;}
    public Location getDestCity() { return destination;}
    public ShipmentStatus getStatus() {return status;}
    public void updateStatus(ShipmentStatus status) {this.status = status;}

}
