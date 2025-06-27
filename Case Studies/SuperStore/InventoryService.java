package SuperStore;
import java.util.HashMap;
public class InventoryService {
    private static InventoryService instance;

    private final HashMap<String,Product> productById = new HashMap<>();
    private final HashMap<String,Inventory> inventoryBySellerId = new HashMap<>();

    private InventoryService(){}

    public static synchronized InventoryService getInstance()
    {
        if(instance == null) instance = new InventoryService();
        return instance;
    }

    public Product addProduct(Seller seller,String name,double price,int quantity)
    {
        Product product = new Product(name, seller.getUserId(),price);
        productById.put(product.getProductId(),product);
        seller.getInventory().addItem(product.getProductId(), quantity);
        inventoryBySellerId.put(seller.getUserId(),seller.getInventory());
        System.out.println("Seller "+seller.getName()+ " added product :"+ name + " (Qtry : "+quantity+ " )");
        return product;
    }

    public boolean hasEnoughStock(String productId,int quantity)
    {
        Product product = productById.get(productId);
        if(product == null) return false;
        int stock = inventoryBySellerId.get(product.getSellerId()).getStock(productId);
        return stock >= quantity;
    }
    public Product getProduct(String productId)
    {return productById.get(productId);}
    public void reduceStock(String productId,int quantity)
    {
        Product product = productById.get(productId);
        Inventory inventory = inventoryBySellerId.get(product.getSellerId());
        inventory.addItem(productId, inventory.getStock(productId) - quantity);
    }


}
