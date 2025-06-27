package CargoLogistics;

import java.util.ArrayList;
import java.util.List;

public class BookManualStrategy implements BookingStrategy{
    
    public CargoTruck book(Object input)
    {   
        CargoShipment shipment = null;
        CargoTruck truck = null;
        List<String> inp = null;
        if(input instanceof ArrayList arrayList)
        {
            inp = arrayList;
            
        }
        if(inp == null) return null;
        ShipmentManager shipmentManager =  ShipmentManager.getInstance();
        TruckManager truckManager =  TruckManager.getInstance();
        
        shipment =  shipmentManager.getShipmentByID(inp.get(0));
        truck = truckManager.getTruckById(inp.get(1));
        if(truck.getLocation() == shipment.getSourceCity() && truck.getStatus() == TruckStatus.Available)
        return truck;
        
        return null;
    }
}
