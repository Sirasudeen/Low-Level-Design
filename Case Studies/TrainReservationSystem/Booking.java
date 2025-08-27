package TrainReservationSystem;

// public class Booking {
    
//     private String TickerID;
//     private Train train;
//     private TicketStatus ticketStatus;
//     private Passenger passenger;
//     private Berth berth;
//     private double fare;

//     public Booking(Train train,Passenger passenger,TicketStatus ticketStatus,Berth berth,double fare)
//     {
//         this.train = train;
//         this.passenger = passenger;
//         this.ticketStatus = TicketStatus.Confirmed;
//         this.berth = berth;
//         this.fare = fare;
//     }

//     public void printTicketDetails()
//     {

//     }

// }

public interface Booking
{
    public void printTicketDetails();
    public String getTicketId();
    public Passenger getPassenger();

}