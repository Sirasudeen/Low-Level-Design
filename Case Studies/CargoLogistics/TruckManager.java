package CargoLogistics;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
public class TruckManager {
    
    private static TruckManager instance;
    private HashMap<Location,List<CargoTruck>> trucksByLocation;
    private HashMap<String,CargoTruck> truckById;
    private TruckManager(){
            truckById = new HashMap<>();
            trucksByLocation = new HashMap<>();
    }

    public static TruckManager getInstance()
    {
        if(instance == null)
        {
            synchronized (TruckManager.class) {
                if(instance == null)
                {
                    instance = new TruckManager();
                }
            }
        }
        return instance;
    }

    public void addTruck(int cap,Location loc)
    {
        CargoTruck truck = new CargoTruck(cap, loc, TruckStatus.Available);
        truckById.put(truck.getId(),truck);
        trucksByLocation.putIfAbsent(loc, new ArrayList<>());
        trucksByLocation.get(loc).add(truck);
    }

    public List<CargoTruck> getTrucksByLocation(Location loc)
    {
        return trucksByLocation.get(loc);
    }
    public CargoTruck getTruckById(String id){return truckById.get(id);}

    public void showTrucks()
    {
        System.out.println("----------------------------------------------------------------------");
        System.out.println("List of All Trucks ");
        for(CargoTruck t : truckById.values())
        {
            System.out.println("Truck Id no : "+ t.getId()+ " Status : "+t.getStatus()+" Capacity : "+ t.getCapacity() + " Location : "+ t.getLocation());
            System.out.println("");
        }
        System.out.println("----------------------------------------------------------------------");

    }
}
