package SuperStore;

import java.util.HashMap;
import java.util.UUID;

public class Cart {
    private String buyerId;
    private HashMap<String,Integer> items;
    private String cartId;

    public Cart(String  buyerId)
    {
        this.buyerId = buyerId;
        this.cartId = UUID.randomUUID().toString();
        items = new HashMap<>();
    }

    public HashMap<String,Integer> getItems(){
        return items;
    }

    public void addItem(String productId,int quantity)
    {
        items.put(productId,items.getOrDefault(productId,0)+quantity);
    }
    public String getCartId(){return cartId;}
    public void clearCart(){items.clear();}
}
