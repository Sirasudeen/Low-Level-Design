package TrainReservationSystem;
import java.util.ArrayList;
import java.util.HashMap;
public class BookingManager {
    private static BookingManager bookingManagerInstance;
    private static int ticketCounter = 1000;
    private ArrayList<Train> trains;
    HashMap<Train,ArrayList<Booking>> bookingList;

    private BookingManager()
    {
        trains = new ArrayList<>();
        bookingList = new HashMap<>();
    }

    public static synchronized BookingManager getInstance()
    {
        if(bookingManagerInstance == null)
        {
            bookingManagerInstance = new BookingManager();
        }

        return bookingManagerInstance;
    }

    public void addTrain(Train train)
    {
        trains.add(train);
        bookingList.put(train, new ArrayList<>());
    }

    public String bookTicket(Passenger passenger,Train train)
    {
        int bookingNo = bookingList.get(train).size();
        Booking Ticket;
            String TicketId = ticketCounter+""+train.name.substring(0,2);
        
        if(bookingNo <= train.NoOfBerths)
        {
            Berth berth;
            if(passenger.getBerthPref() != null)
            {
                berth = new Berth(passenger.getBerthPref(),bookingNo);
            }
            else if(passenger.getAge() > 50) berth = new Berth(BerthType.lower, bookingNo);
            else berth = new Berth(BerthType.upper, bookingNo);
             Ticket = new ConfirmedTicket(TicketId,train,passenger,berth);
            bookingList.get(train).add(Ticket);
            
        }
        else if((bookingNo - train.NoOfBerths) <= train.NoOfRacBerths)
        {
             Ticket  = new RacTicket(TicketId, train, passenger,bookingNo -train.NoOfBerths);
            bookingList.get(train).add(Ticket);
        }
        else if((bookingNo - train.NoOfBerths - train.NoOfRacBerths) <= train.NoOfWaitingListTickets)
        {
             Ticket  = new WaitingTicket(TicketId, train, passenger,bookingNo-train.NoOfBerths-train.NoOfRacBerths);
        bookingList.get(train).add(Ticket);

        }
        else 
        return null;
        ticketCounter++;
        return TicketId;
    }

    public boolean cancelTicket(String ticketId)
    {
        for(Train train : trains)
        {
            for(Booking ticket : bookingList.get(train))
            {
                if(ticket.getTicketId().equals(ticketId))
                {
                    int index = bookingList.get(train).indexOf(ticket);
                    bookingList.get(train).remove(ticket);
                    updateBookingList(train, index);
                    return true;
                }
            }
        }
        return false;
    }

    public Booking getTicketById(String ticketId) {
    for (Train train : trains) {
        for (Booking ticket : bookingList.get(train)) {
            if (ticket.getTicketId().equals(ticketId)) {
                return ticket;
            }
        }
    }
    return null;
    }

    public ArrayList<Train> getTrains() {return trains;}
    private void updateBookingList(Train train, int cancelledIndex)
    {
        ArrayList<Booking> bookings = bookingList.get(train);
        int confirmEnd = train.NoOfBerths;
        int racEnd = confirmEnd + train.NoOfRacBerths;
        
        if(cancelledIndex < confirmEnd && bookings.size() >= confirmEnd)
        {
            for(int i = confirmEnd; i < bookings.size(); i++)
            {
                if(bookings.get(i) instanceof RacTicket)
                {
                    RacTicket racTicket = (RacTicket) bookings.get(i);
                    Berth berth = new Berth(BerthType.lower, cancelledIndex);
                    bookings.set(i, new ConfirmedTicket(racTicket.getTicketId(), train, racTicket.getPassenger(), berth));
                    break;
                }
            }
        }
        
        int racNo = 1;
        for(int i = confirmEnd; i < Math.min(racEnd, bookings.size()); i++)
        {
            if(bookings.get(i) instanceof RacTicket)
            {
                ((RacTicket) bookings.get(i)).setRacNo(racNo++);
            }
            else if(bookings.get(i) instanceof WaitingTicket)
            {
                WaitingTicket waitingTicket = (WaitingTicket) bookings.get(i);
                bookings.set(i, new RacTicket(waitingTicket.getTicketId(), train, waitingTicket.getPassenger(), racNo++));
            }
        }
        
        int waitingNo = 1;
        for(int i = racEnd; i < bookings.size(); i++)
        {
            if(bookings.get(i) instanceof WaitingTicket)
            {
                ((WaitingTicket) bookings.get(i)).setWaitingNo(waitingNo++);
            }
        }
    }
}