package Adapter;

public class PayUGateway implements PaymentGateway {
        @Override
        public void pay(String orderId,int amnt) {
        System.out.println("Payment done using PayU");
    }   
}
