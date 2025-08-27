package TrainReservationSystem;

public class Berth {
    private BerthType berthType;
    private int BerthNumber;
    public Berth(BerthType berthType,int BerthNumber)
    {
        this.berthType = berthType;
        this.BerthNumber = BerthNumber;
    }

    public BerthType getBerthType() {return berthType;}
    public int getBerthNumber() {return BerthNumber;}

}
