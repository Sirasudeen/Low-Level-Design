package TrainReservationSystem;

public class WaitingTicket implements Booking {    
    private String TicketID;
    private Train train;
    private TicketStatus ticketStatus;
    private Passenger passenger;
    private int waitingNo;
    private double fare;

    public WaitingTicket(String ticketID,Train train,Passenger passenger,int waitingNo)
    {
        this.TicketID = ticketID;
        this.train = train;
        this.passenger = passenger;
        this.ticketStatus = TicketStatus.RAC;
        this.fare = train.fare;
        this.waitingNo = waitingNo;
    }

    @Override
    public void printTicketDetails()
    {
        System.out.println("Ticket ID: " + TicketID);
        System.out.println("Train ID: " + train.name);
        System.out.println("Passenger Name: " + passenger.getName());
        System.out.println("Waiting No: " + waitingNo);
        System.out.println("Fare: " + fare);
    }

    @Override
    public String getTicketId() {return TicketID;}
    @Override
    public Passenger getPassenger() {return passenger;}
    public void setWaitingNo(int waitingNo) {this.waitingNo = waitingNo;}
}
