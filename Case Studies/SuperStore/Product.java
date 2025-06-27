package SuperStore;

import java.util.UUID;

public class Product {
    private String name;
    private String productId;
    private String sellerId;
    private double price;

    public Product(String name,String sellerId,double price)
    {
        this.name  = name;
        this.productId = UUID.randomUUID().toString();
        this.sellerId = sellerId;
        this.price = price;
    }

    public String getName()
    {return name;}
    public String getProductId(){return productId;}
    public String getSellerId(){return sellerId;}
    public double getPrice(){return price;}
}
