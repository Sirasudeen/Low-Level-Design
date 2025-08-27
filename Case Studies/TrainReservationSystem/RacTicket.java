package TrainReservationSystem;

public class RacTicket implements Booking {    
    private String TicketID;
    private Train train;
    private TicketStatus ticketStatus;
    private Passenger passenger;
    private double fare;
    private int RacNo;
    public RacTicket(String ticketID,Train train,Passenger passenger,int RacNo)
    {
        this.TicketID = ticketID;
        this.train = train;
        this.passenger = passenger;
        this.ticketStatus = TicketStatus.RAC;
        this.fare = train.fare;
        this.RacNo = RacNo;
    }

    @Override
    public void printTicketDetails()
    {
        System.out.println("Ticket ID: " + TicketID);
        System.out.println("Train ID: " + train.name);
        System.out.println("Passenger Name: " + passenger.getName());
        System.out.println("RAC No: " + RacNo);
        System.out.println("Fare: " + fare);
    }
    @Override
    public String getTicketId() {return TicketID;}
    @Override
    public Passenger getPassenger() {return passenger;}
    public void setRacNo(int no)
    {
        this.RacNo = no;
    }

}
