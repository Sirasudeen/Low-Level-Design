package Adapter;

public class CheckoutService {
    private PaymentGateway paymentGateway;

    public CheckoutService(PaymentGateway paymentGateway) {
        this.paymentGateway = paymentGateway;
    }
    public void checkOut(String orderId,int amount)
    {
        paymentGateway.pay(orderId,amount);
        System.out.println("Order ID: " + orderId + " Amount: " + amount);
    }
}
