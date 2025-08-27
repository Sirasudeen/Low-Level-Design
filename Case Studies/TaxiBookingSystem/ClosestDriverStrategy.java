package TaxiBookingSystem;




public class ClosestDriverStrategy implements DriverMatchingStrategy {
    
    @Override
    public Driver findDriver(Rider rider,Location source)
    {
        DriverManager driverManager = DriverManager.getInstance();
        Driver closestDriver = null;
        double minDistance = Double.MAX_VALUE;

        for (Driver driver : driverManager.getAvailableDrivers().values()) {
           
         double distance = Math.sqrt(Math.pow(driver.getCurrentLocation().latitude - source.latitude, 2) +
                                       Math.pow(driver.getCurrentLocation().longitude - source.longitude, 2));
          if (distance < minDistance) {
                minDistance = distance;
                closestDriver = driver;
            }
        }
        return closestDriver;
    }
}
