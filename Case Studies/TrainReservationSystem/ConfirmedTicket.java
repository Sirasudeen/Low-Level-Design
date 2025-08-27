package TrainReservationSystem;

public class ConfirmedTicket implements Booking {    
    private String TicketID;
    private Train train;
    private TicketStatus ticketStatus;
    private Passenger passenger;
    private Berth berth;
    private double fare;

    public ConfirmedTicket(String ticketID,Train train,Passenger passenger,Berth berth)
    {
        this.TicketID = ticketID;
        this.train = train;
        this.passenger = passenger;
        this.ticketStatus = TicketStatus.Confirmed;
        this.berth = berth;
        this.fare = train.fare;
    }

    @Override
    public void printTicketDetails()
    {
        System.out.println("Ticket ID: " + TicketID);
        System.out.println("Train ID: " + train.name);
        System.out.println("Passenger Name: " + passenger.getName());
        System.out.println("Berth: " + berth.getBerthType());
        System.out.println("Fare: " + fare);
    }
    @Override
    public String getTicketId() {return TicketID;}
        @Override
    public Passenger getPassenger() {return passenger;}

}
