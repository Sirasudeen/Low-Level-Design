package SuperStore;

public class OrderItem {
    private String productName;
    private int quantity;
    private double priceAtPurchase;

    public OrderItem(Product product, int quantity) {
        this.productName = product.getName();
        this.quantity = quantity;
        this.priceAtPurchase = product.getPrice();
    }
    
    @Override
    public String toString() {
        return productName + " (Qty: " + quantity + ", Price: " + priceAtPurchase + ")";
    }
}
