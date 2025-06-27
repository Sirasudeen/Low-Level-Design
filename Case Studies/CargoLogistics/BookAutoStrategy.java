package CargoLogistics;

import java.util.ArrayList;
import java.util.List;

public class BookAutoStrategy implements  BookingStrategy{
    
    public CargoTruck book(Object input)
    {
        CargoShipment shipment = null;
        List<String> inp = null;
        if(input instanceof ArrayList arrayList)
        {
            inp = arrayList;
        }
        if(inp == null || inp.size()!=1) return null;
        ShipmentManager shipmentManager = ShipmentManager.getInstance();
        shipment = shipmentManager.getShipmentByID(inp.get(0));

        TruckManager truckManager = TruckManager.getInstance();
        List<CargoTruck> trucks = truckManager.getTrucksByLocation(shipment.getSourceCity());
        CargoTruck truck = null; int truckCap = Integer.MAX_VALUE;
        for(CargoTruck t : trucks)
        {
            if(t.getStatus()==TruckStatus.Available && t.getCapacity()==shipment.getWeight()) {truck = t; break;}
            else if(t.getStatus()==TruckStatus.Available && t.getCapacity() > shipment.getWeight() && t.getCapacity()<truckCap) {truck = t; truckCap = t.getCapacity();}
        }
        return truck;

        
    }
}
