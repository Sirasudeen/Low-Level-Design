package SuperStore;

import java.util.UUID;

public class Buyer extends User {
    private String buyerId;
    private Cart cart;

    public Buyer(String name,String password,String email)
    {
        super(name,email,password);
        this.buyerId = UUID.randomUUID().toString();
        this.cart = new Cart(buyerId);
    }
    public String getBuyerId(){return buyerId;}
    public Cart getCart(){return cart;}

}
