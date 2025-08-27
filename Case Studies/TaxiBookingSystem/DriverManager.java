package TaxiBookingSystem;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;
public class DriverManager {
    private static DriverManager driverManager;
    private Map<String,Driver> drivers = new HashMap<>();
    private DriverManager()
    {}

    public static synchronized DriverManager getInstance()
    {
        if(driverManager == null)
        {
            driverManager = new DriverManager();
        }
        return driverManager;
    }

    public void addDriver(Driver driver)
    {
        drivers.put(driver.getId(),driver);
    }
    public Driver getDriver(String id)
    {
        return drivers.get(id);
    }
    public Map<String,Driver> getAvailableDrivers()
    {
        return drivers.values().stream().filter(driver -> driver.getStatus()==TaxiDriverStatus.Available).collect(Collectors.toMap(driver->driver.getId(),driver->driver));
        
    }

}
