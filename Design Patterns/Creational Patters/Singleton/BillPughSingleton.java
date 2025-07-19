
public class BillPughSingleton {
    
    private  BillPughSingleton(){}

    private static class innerClass{
       private static final BillPughSingleton i = new BillPughSingleton();
    }

    public static BillPughSingleton getInstance()
    {
        return innerClass.i;
    }
}
