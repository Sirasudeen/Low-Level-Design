package TrainReservationSystem;

public class Train {
    String name;
    String TrainNo;
    int NoOfBerths;
    int NoOfRacBerths;
    int NoOfWaitingListTickets;
    double fare;
    public Train(String name,String TrainNo,int NoOfBerths,int NoOfRacBerths,int NoOfWaitingListTickets,double fare)
    {
        this.name = name;
        this.TrainNo = TrainNo;
        this.NoOfBerths = NoOfBerths;
        this.NoOfRacBerths = NoOfRacBerths;
        this.NoOfWaitingListTickets = NoOfWaitingListTickets;
        this.fare = fare;
    }
}
