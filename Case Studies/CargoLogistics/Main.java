package CargoLogistics;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        TruckManager truckManager = TruckManager.getInstance();
        ShipmentManager shipmentManager = ShipmentManager.getInstance();
        BookingManager bookingManager = BookingManager.getInstance();
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        System.out.println("===== Z-Freight Logistics System Initializing... =====");

        truckManager.addTruck(1000, Location.Mumbai); 
        truckManager.addTruck(2500, Location.Mumbai);
        truckManager.addTruck(1500, Location.Chennai);   
        System.out.println("Initial truck fleet is ready.");

        while (running) {
            System.out.println("\n--- Z-Freight Main Menu ---");
            System.out.println("1. List All Trucks (Module 1)");
            System.out.println("2. Book a New Cargo Shipment (Module 2)");
            System.out.println("3. List Unassigned Cargo (Module 2)");
            System.out.println("4. Manually Assign Cargo to Truck (Module 3)");
            System.out.println("5. Auto-Assign Cargo (Snug Fit) (Module 4)");
            System.out.println("6. Exit");
            System.out.print("Choose an option: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); 

            switch (choice) {
                case 1:
                    truckManager.showTrucks();
                    break;
                case 2:
                    System.out.print("Enter cargo weight (kg): ");
                    int weight = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Enter source city (Mumbai, Pune, Bangalore): ");
                    Location source = Location.valueOf(scanner.nextLine());
                    System.out.print("Enter destination city (Mumbai, Pune, Bangalore): ");
                    Location dest = Location.valueOf(scanner.nextLine());
                    shipmentManager.AddShipment(weight, source, dest);
                    System.out.println("SUCCESS: Cargo booked and is awaiting assignment.");
                    break;
                case 3:
                    shipmentManager.listUnAssignedShipments();
                    break;
                case 4:
                    System.out.print("Enter Cargo ID to assign: ");
                    String manualCargoId = scanner.nextLine();
                    System.out.print("Enter Truck ID to assign it to: ");
                    String manualTruckId = scanner.nextLine();
                    List<String> manualInput = new ArrayList<>();
                    manualInput.add(manualCargoId);
                    manualInput.add(manualTruckId);
                    bookingManager.book(manualInput, "ManualBooking");
                    break;
                case 5:
                    System.out.print("Enter Cargo ID to auto-assign: ");
                    String autoCargoId = scanner.nextLine();
                    List<String> autoInput = new ArrayList<>();
                    autoInput.add(autoCargoId);
                    bookingManager.book(autoInput, "autoBooking");
                    break;
                case 6:
                    running = false;
                    System.out.println("Shutting down Z-Freight system. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
        scanner.close();
    }
}
