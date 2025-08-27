package TrainReservationSystem;

public class Passenger {
    private final String name;
    private final int age;
    private final String gender;
    private final BerthType berthPreference;

    public Passenger(String name,int age,String gender,BerthType berthpref)
    {
        this.name = name;
        this.age = age;
        this.berthPreference = berthpref;
        this.gender = gender;
    }

    public String getName() {return name;}
    public int getAge() {return age;}
    public String getGender() {return gender;}
    public BerthType getBerthPref() {return berthPreference;}
}
