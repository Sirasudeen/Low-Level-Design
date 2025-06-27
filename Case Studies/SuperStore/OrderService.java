package SuperStore;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class OrderService {
    private static  OrderService instance;
    private final ProfileService profileService;
    private final InventoryService inventoryService;
    private final PaymentService paymentService;
    private final HashMap<String,Order> orders;

    private OrderService(){
        profileService = ProfileService.getInstance();
        inventoryService = InventoryService.getInstance();
        paymentService = PaymentService.getInstance();
        orders = new HashMap<>();
    }

    public static synchronized OrderService getInstance()
    {
            if(instance == null) instance = new OrderService();
            return instance;
    }

    public void addToCart(Buyer buyer,String productId,int quantity)
    {
        if(inventoryService.getProduct(productId)== null)
        {
            System.out.println("Product does not exist!!");
            return;
        }
        Cart cart = buyer.getCart();
        cart.addItem(productId,quantity);

        System.out.println(quantity + " units of product " + productId + " added to " + buyer.getName() + "'s cart.");


    }   

    public Order placeOrder(Buyer buyer,PaymentDetails paymentDetails)
    {
            Cart cart = buyer.getCart();
            if (cart.getItems().isEmpty()) {
                System.out.println("ERROR: Cart is empty. Cannot place order.");
                return null;
            }

            for (Map.Entry<String, Integer> entry : cart.getItems().entrySet()) {
                if (!inventoryService.hasEnoughStock(entry.getKey(), entry.getValue())) {
                    System.out.println("ERROR: Not enough stock for product " + entry.getKey() + ". Order cancelled.");
                    return null;
                }
            }
            ArrayList<OrderItem> orderItems = new ArrayList<>();
            int totAmnt = 0;
            for(String pid : cart.getItems().keySet())
            {
                    Product product = inventoryService.getProduct(pid);
                   int quantity = cart.getItems().get(pid); 
                   totAmnt += (product.getPrice() * quantity);
                   OrderItem orderItem = new OrderItem(product,quantity);
                   orderItems.add(orderItem);
            }

            Order order = new Order(buyer.getBuyerId(),orderItems,totAmnt);
            System.out.println("Order " + order.getOrderId() + " created with total amount: " + totAmnt);

            boolean paymentSuccessful = paymentService.processPayment(order, paymentDetails);

            if (paymentSuccessful) {
                order.setStatus(OrderStatus.CONFIRMED);
                for (Map.Entry<String, Integer> entry : cart.getItems().entrySet()) {
                    inventoryService.reduceStock(entry.getKey(), entry.getValue());
                }
                cart.clearCart(); 
                orders.put(order.getOrderId(), order);
                System.out.println("Order " + order.getOrderId() + " confirmed!");
                return order;
            } else {
                order.setStatus(OrderStatus.CANCELLED);
                System.out.println("Payment failed. Order " + order.getOrderId() + " cancelled.");
                return null;
            }

            

    }
}
