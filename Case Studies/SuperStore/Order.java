package SuperStore;

import java.util.ArrayList;
import java.util.UUID;
public class Order {
    private String orderId;
    private ArrayList<OrderItem> orders;
    private  String buyerId;
    private double totalAmount;
    private OrderStatus status;

    public Order(String buyerId,ArrayList<OrderItem> items,double totalAmount)
    {
        this.orderId = UUID.randomUUID().toString();
        this.buyerId = buyerId;
        this.totalAmount = totalAmount;
        this.status = OrderStatus.PENDING_PAYMENT;
    }

    public void setStatus(OrderStatus orderStatus){this.status = orderStatus;}
    public String getOrderId(){return orderId;}
    public double getTotalAmount(){return totalAmount;}
    public OrderStatus getOrderStatus(){return status;}
}
