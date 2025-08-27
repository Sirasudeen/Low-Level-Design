package TaxiBookingSystem;

public class Rider {
    String name;
    String id;
    Location location;

    public Rider(String name,String id)
    {
        this.name = name; this.id = id;
    }

    public String getName() {return name;}
}
