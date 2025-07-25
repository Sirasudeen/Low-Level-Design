package Composite;

public class Product implements CartItem{
    private String name;
    private double price;

    public Product(String name, double price) {
        this.name = name;
        this.price = price;
    }
    
    @Override
    public double getPrice() {
        return price;
    }
    @Override
    public void display(String indent) {
        System.out.println(indent + "Product: " + name + " - $" + price);
    }
}
