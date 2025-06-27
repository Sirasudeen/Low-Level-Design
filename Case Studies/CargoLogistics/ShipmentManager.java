package CargoLogistics;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
public class ShipmentManager {
    public static ShipmentManager instance;
    
    List<CargoShipment> shipments;
    HashMap<String,CargoShipment> shipmentById;

    private ShipmentManager(){
        shipmentById = new HashMap<>();
        shipments = new ArrayList<>();
    }

    public static ShipmentManager getInstance()
    {
        if(instance == null)
        {
            synchronized (ShipmentManager.class) {
                    if(instance==null)
                    instance = new ShipmentManager();
            }
        }
        return instance;
    }

    public void AddShipment(int weight,Location s,Location d)
    {
        CargoShipment shipment = new CargoShipment(weight,s,d);
        shipments.add(shipment);
        shipmentById.put(shipment.getId(),shipment);
    }

    public CargoShipment getShipmentByID(String id)
    {
        return shipmentById.get(id);
    }

    public void listUnAssignedShipments()
    {
        System.out.println("--------------------------------------------------------------------------------");
        System.out.println("List of All Unassigned Cargo Shipments : ");
        for(CargoShipment s : shipments)
        {
            if(s.getStatus()!= ShipmentStatus.UnAssigned) continue;
            System.out.println("Shipment Id : " + s.getId() +" Weight : "+s.getWeight()+ " Source Location : "+s.getSourceCity()+ " Destination : "+ s.getDestCity());
            System.out.println("");
        }
        System.out.println("--------------------------------------------------------------------------------");

    }

}
