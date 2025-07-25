package Facade;

public class TicketService {
    public void createTicket(String movieId, String seatNumber, String accountId) {
        System.out.println("Ticket created for movie " + movieId + " at seat " + seatNumber + " for account " + accountId);
    }
}
