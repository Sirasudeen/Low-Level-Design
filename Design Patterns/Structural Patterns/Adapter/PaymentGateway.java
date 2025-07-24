package Adapter;

public interface PaymentGateway {
    void pay(String orderId,int amnt);
}
