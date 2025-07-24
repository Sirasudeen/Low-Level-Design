package Adapter;


public class RazorPayAdapter  implements PaymentGateway{
    
    private RazorPayAPI razorPayAPI;

    public RazorPayAdapter()
    {
        this.razorPayAPI = new RazorPayAPI();
    }
    
    public void pay(String orderId,int amnt) {
        razorPayAPI.makePayment(orderId, amnt);
    }

}
