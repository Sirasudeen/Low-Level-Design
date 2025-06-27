package SuperStore;

import java.util.UUID;

public class Seller extends User{
    private String sellerId;
    private Inventory inventory;

    public Seller(String name,String email,String password)
    {
        super(name,email,password);
        this.sellerId = UUID.randomUUID().toString();
        inventory = new Inventory(sellerId);
    }

    public String getSellerID()
    {return sellerId;}
    public Inventory getInventory(){return inventory;}
}
