package TaxiBookingSystem2;

public class Time {
    private int time;
    public Time()
    {
        time = 0;
    }

    public void updateTime(int time)
    {
        
        this.time = time%24;
    }
    public int getTime() {return time;}
}
