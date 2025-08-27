package TaxiBookingSystem2;

public enum Location{
    A(0),
    B(15),
    C(30),
    D(45),
    E(60);

    private final int pos;

    Location(int pos)
    {
        this.pos = pos;
    }
    
    public int getPosition()
    {
        return pos;
    }
}
