package SuperStore;

import java.util.HashMap;

public class Inventory {
    private String sellerId;
    private HashMap<String,Integer> products;

    public Inventory(String sellerId)
    {
        this.sellerId = sellerId;
        products = new HashMap<>();
    }

    public HashMap<String,Integer> getItems(){return products;}
    
    public void addItem(String productId,int quantity)
    {products.put(productId,products.getOrDefault(productId,0)+quantity);}

    public int getStock(String productId)
    {
        return products.getOrDefault(productId, 0);
    }

}
