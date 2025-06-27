package TrainReservationSystem;

import java.util.*;

public class Main {
public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    BookingManager bm = BookingManager.getInstance();

    bm.addTrain(new Train("Nellai Express", "29912", 2, 1, 2, 450));
    bm.addTrain(new Train("Chennai Express", "212332", 3, 2, 3, 400));

    while (true) {
        System.out.println("\n=== Train Reservation System ===");
        System.out.println("1. Show All Trains");
        System.out.println("2. Book Ticket");
        System.out.println("3. Cancel Ticket");
        System.out.println("4. Show Ticket Details");
        System.out.println("5. Exit");
        System.out.print("Choose an option: ");

        int choice = -1;
        try {
            choice = sc.nextInt();
        } catch (InputMismatchException e) {
            System.out.println("Invalid input. Please enter a number.");
            sc.nextLine();
            continue;
        }
        sc.nextLine(); 

        switch (choice) {
            case 1:
                showTrains(bm);
                break;

            case 2:
                showTrains(bm);
                System.out.print("Enter Train No to book: ");
                String trainNo = sc.nextLine();
                Train selectedTrain = findTrain(bm, trainNo);

                if (selectedTrain == null) {
                    System.out.println("Invalid Train No.");
                    break;
                }

                System.out.print("Enter Passenger Name: ");
                String name = sc.nextLine();
                int age = -1;
                while (age == -1) {
                    try {
                        System.out.print("Enter Age: ");
                        age = sc.nextInt();
                    } catch (InputMismatchException e) {
                        System.out.println("Invalid age. Please enter a number.");
                        sc.nextLine();
                    }
                }
                sc.nextLine(); 

                System.out.print("Enter Gender: ");
                String gender = sc.nextLine();
                BerthType berthPref = null;
                while(berthPref == null){
                    System.out.print("Enter Berth Preference (lower/middle/upper/none): ");
                    String pref = sc.nextLine();
                    if (pref.equalsIgnoreCase("none")) {
                        break;
                    }
                    try {
                        berthPref = BerthType.valueOf(pref.toLowerCase());
                    } catch (IllegalArgumentException e) {
                        System.out.println("Invalid berth type. Please try again.");
                    }
                }


                Passenger p = new Passenger(name, age, gender, berthPref);
                String booked = bm.bookTicket(p, selectedTrain);

                if (booked!=null) {
                    System.out.println("Ticket booked successfully!");
                    System.out.println("Ticket ID: " + booked);
                } else {
                    System.out.println("Booking failed. No seats available.");
                }
                break;

            case 3:
                System.out.print("Enter Ticket ID to cancel: ");
                String ticketId = sc.nextLine();
                if (bm.cancelTicket(ticketId)) {
                    System.out.println("Ticket cancelled successfully!");
                } else {
                    System.out.println("Ticket not found.");
                }
                break;

            case 4:
                System.out.print("Enter Ticket ID to view details: ");
                String id = sc.nextLine();
                Booking ticket = bm.getTicketById(id);
                if (ticket != null) {
                    ticket.printTicketDetails();
                } else {
                    System.out.println("Ticket not found.");
                }
                break;

            case 5:
                System.out.println("Exiting... Thank you!");
                sc.close();
                return;

            default:
                System.out.println("Invalid option. Try again.");
        }
    }
}

    private static void showTrains(BookingManager bm) {
        System.out.println("\nAvailable Trains:");
        for (Train t : bm.getTrains()) { 
            System.out.println("Train No: " + t.TrainNo + " | Name: " + t.name + 
                               " | Berths: " + t.NoOfBerths + 
                               " | RAC: " + t.NoOfRacBerths + 
                               " | Waiting: " + t.NoOfWaitingListTickets +
                               " | Fare: " + t.fare);
        }
    }

    private static Train findTrain(BookingManager bm, String trainNo) {
        for (Train t : bm.getTrains()) {
            if (t.TrainNo.equals(trainNo)) {
                return t;
            }
        }
        return null;
    }
}
