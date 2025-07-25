package Facade;

public class Main
{
    public static void main(String[] args)
    {
        MovieBookingFacade movieBookingFacade = new MovieBookingFacade();
        movieBookingFacade.bookMovie("123", "M1", "A1", 100.0);
        movieBookingFacade.bookMovie("1234", "M2", "A2", 200.0);
        
    }

}