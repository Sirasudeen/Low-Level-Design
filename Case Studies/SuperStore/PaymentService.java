package SuperStore;

public class PaymentService {
    private static PaymentService instance;

    private PaymentService(){}
    
    public static synchronized PaymentService getInstance()
    {
        if(instance == null) instance = new PaymentService();
        return instance;
    }

    public boolean processPayment(Order order,PaymentDetails details)
    {
        System.out.println("Processing payment of " + order.getTotalAmount() + " for order " + order.getOrderId());
        System.out.println("Payment successful!");
        return true;
    }
}
