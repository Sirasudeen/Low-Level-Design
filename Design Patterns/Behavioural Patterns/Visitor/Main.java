package Visitor;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<Item>  items = new ArrayList<>();

        items.add(new PhysicalProduct("Laptop",2));
        items.add(new DigitalProduct("Atomic Habits Ebook", 54));
        
        ItemVisitor invoiceGenerator = new InvoiceVisitor();
        ItemVisitor shippingCalculator = new ShippingCostVisitor();

        for (Item item : items) {
            item.accept(invoiceGenerator);
            item.accept(shippingCalculator);
            
            System.out.println("");
        }

    }
}
