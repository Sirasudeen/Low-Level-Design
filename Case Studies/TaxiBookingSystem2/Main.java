package TaxiBookingSystem2;
import java.util.HashMap;



public class Main {
    public static void main(String[] args) {
        System.out.println("--- Zoho Taxi Booking System ---");

        BookingManager bookingManager = BookingManager.getInstance();


        HashMap<String, Taxi> allTaxis = new HashMap<>();
        allTaxis.put("T1", new Taxi("T1", "Siras"));
        allTaxis.put("T2", new Taxi("T2", "Fayas"));
        allTaxis.put("T3", new Taxi("T3", "Mydeen"));
        allTaxis.put("T4", new Taxi("T4", "Karthik"));
        for(Taxi t : allTaxis.values())
        bookingManager.addTaxi(t);


        System.out.println("\n--- Initial Taxi Status ---");
        for(Taxi t : allTaxis.values()) {
            System.out.println("Taxi: " + t.getId() + " | Location: " + t.getLocation() + " | Earnings: " + t.getMoneyEarned());
        }


        System.out.println("\n--- Booking 1 ---");
        Rider rider1 = new Rider("Customer-1", Location.A);
        bookingManager.requestTaxi(rider1, Location.A, Location.C);


        System.out.println("\n--- Booking 2 ---");
        Rider rider2 = new Rider("Customer-2", Location.C);
        bookingManager.requestTaxi(rider2, Location.B, Location.C);


        System.out.println("\n--- Final Taxi Status ---");
        for(Taxi t : allTaxis.values()) {
            System.out.println("Taxi: " + t.getId() + " | Location: " + t.getLocation() + " | Earnings: " + t.getMoneyEarned());
        }
    }
}
