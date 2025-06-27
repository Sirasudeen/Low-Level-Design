package SuperStore;

import java.util.Scanner;

public class Main {
    private static final ProfileService profileService = ProfileService.getInstance();
    private static final InventoryService inventoryService = InventoryService.getInstance();
    private static final OrderService orderService = OrderService.getInstance();
    private static User loggedInUser = null;
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("--- Welcome to Super Store ---");

        while (true) {
            if (loggedInUser == null) {
                showMainMenu();
            } else if (loggedInUser instanceof Seller) {
                showSellerMenu((Seller) loggedInUser);
            } else if (loggedInUser instanceof Buyer) {
                showBuyerMenu((Buyer) loggedInUser);
            }
        }
    }

    private static void showMainMenu() {
        System.out.println("\n--- Main Menu ---");
        System.out.println("1. Register");
        System.out.println("2. Login");
        System.out.println("3. Exit");
        System.out.print("Choose an option: ");
        int choice = scanner.nextInt();
        scanner.nextLine(); 

        switch (choice) {
            case 1:
                registerUser();
                break;
            case 2:
                loginUser();
                break;
            case 3:
                System.out.println("Thank you for visiting Super Store!");
                System.exit(0);
                break;
            default:
                System.out.println("Invalid option. Please try again.");
        }
    }

    private static void registerUser() {
        System.out.print("Enter name: ");
        String name = scanner.nextLine();
        System.out.print("Enter email: ");
        String email = scanner.nextLine();
        System.out.print("Enter password: ");
        String password = scanner.nextLine();
        System.out.print("Register as (BUYER/SELLER): ");
        String userTypeStr = scanner.nextLine();
        UserType userType = UserType.valueOf(userTypeStr.toUpperCase());
        loggedInUser = profileService.register(name, email, password, userType);
    }

    private static void loginUser() {
        System.out.print("Enter email: ");
        String email = scanner.nextLine();
        System.out.print("Enter password: ");
        String password = scanner.nextLine();
        loggedInUser = profileService.login(email, password);
    }

    private static void showSellerMenu(Seller seller) {
        System.out.println("\n--- Seller Menu (" + seller.getName() + ") ---");
        System.out.println("1. Add Product");
        System.out.println("2. View Inventory");
        System.out.println("3. Logout");
        System.out.print("Choose an option: ");
        int choice = scanner.nextInt();
        scanner.nextLine(); 

        switch (choice) {
            case 1:
                addProduct(seller);
                break;
            case 2:
                viewInventory(seller);
                break;
            case 3:
                loggedInUser = null;
                break;
            default:
                System.out.println("Invalid option.");
        }
    }

    private static void addProduct(Seller seller) {
        System.out.print("Enter product name: ");
        String name = scanner.nextLine();
        System.out.print("Enter price: ");
        double price = scanner.nextDouble();
        System.out.print("Enter quantity: ");
        int quantity = scanner.nextInt();
        scanner.nextLine(); 
        inventoryService.addProduct(seller, name, price, quantity);
    }
    
    private static void viewInventory(Seller seller) {
        System.out.println("\n--- " + seller.getName() + "'s Inventory ---");
        seller.getInventory().getItems().forEach((productId, quantity) -> {
            Product product = inventoryService.getProduct(productId);
            if (product != null) {
                System.out.println(product.getName() + " (ID: " + productId + ") - Stock: " + quantity);
            }
        });
    }

    private static void showBuyerMenu(Buyer buyer) {
        System.out.println("\n--- Buyer Menu (" + buyer.getName() + ") ---");
        System.out.println("1. View Products");
        System.out.println("2. Add to Cart");
        System.out.println("3. View Cart");
        System.out.println("4. Place Order");
        System.out.println("5. Logout");
        System.out.print("Choose an option: ");

        int choice = scanner.nextInt();
        scanner.nextLine();

        switch (choice) {
            case 1:
                viewAllProducts();
                break;
            case 2:
                addToCart(buyer);
                break;
            case 3:
                viewCart(buyer);
                break;
            case 4:
                placeOrder(buyer);
                break;
            case 5:
                loggedInUser = null;
                break;
            default:
                System.out.println("Invalid option.");
        }
    }
    
    private static void viewAllProducts() {
        System.out.println("\n--- Available Products ---");
        // This is a simplified approach. A more robust implementation 
        // would involve a method in InventoryService to get all products.
        // For now, let's assume we can ask the inventory service.
        // We'll create a temporary method in this class to simulate this.
        
        // As the current InventoryService does not have a method to list all products,
        // this functionality will be limited. A proper implementation would require
        // modifying InventoryService to expose a list of all products.
        System.out.println("Note: A comprehensive product list requires changes to InventoryService.");
    }
    
    private static void addToCart(Buyer buyer) {
        System.out.print("Enter Product ID to add to cart: ");
        String productId = scanner.nextLine();
        System.out.print("Enter quantity: ");
        int quantity = scanner.nextInt();
        scanner.nextLine();
        orderService.addToCart(buyer, productId, quantity);
    }
    
    private static void viewCart(Buyer buyer) {
        System.out.println("\n--- " + buyer.getName() + "'s Cart ---");
        Cart cart = buyer.getCart();
        if (cart.getItems().isEmpty()) {
            System.out.println("Your cart is empty.");
        } else {
            cart.getItems().forEach((productId, quantity) -> {
                Product product = inventoryService.getProduct(productId);
                if (product != null) {
                    System.out.println(product.getName() + " - Quantity: " + quantity);
                }
            });
        }
    }
    
    private static void placeOrder(Buyer buyer) {
        System.out.println("\n--- Placing Order ---");
        System.out.print("Enter payment method (e.g., Credit Card): ");
        String paymentMode = scanner.nextLine();
        PaymentDetails paymentDetails = new PaymentDetails(paymentMode);
        Order finalOrder = orderService.placeOrder(buyer, paymentDetails);

        if (finalOrder != null) {
            System.out.println("\n--- Order Summary ---");
            System.out.println("Order ID: " + finalOrder.getOrderId());
            System.out.println("Status: " + finalOrder.getOrderStatus());
            System.out.println("Total: " + finalOrder.getTotalAmount());
        }
    }
}