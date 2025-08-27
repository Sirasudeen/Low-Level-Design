
package TaxiBookingSystem;

public class Main {
     public static void main(String[] args) {
        System.out.println("--- Taxi Booking System Initializing ---");

        DriverManager driverManager = DriverManager.getInstance();
        driverManager.addDriver(new Driver("D1", "Siras", new Vehicle("KA-01-AB-1234", "Toyota Etios")));
        driverManager.addDriver(new Driver("D2", "Fayas", new Vehicle("MH-12-CD-5678", "Maruti Swift")));
        
        TripManager tripManager = TripManager.getInstance();
        
        Rider rider1 = new Rider("R1", "Priya");
        Location source1 = new Location(10, 10);
        Location dest1 = new Location(30, 30);
        
        Trip trip1 = tripManager.requestTrip(rider1, source1, dest1);
        
        if (trip1 != null) {
            try {
                Thread.sleep(1000);
                trip1.startTrip();
                System.out.println("...Trip for " + rider1.getName() + " is in progress...");
                Thread.sleep(2000); 
                tripManager.endTrip(trip1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        Rider rider2 = new Rider("R2", "Karan");
        Location source2 = new Location(80, 80);
        Location dest2 = new Location(95, 95);

        Trip trip2 = tripManager.requestTrip(rider2, source2, dest2);
        if (trip2 != null) {
             try {
                Thread.sleep(1000);
                tripManager.endTrip(trip2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
