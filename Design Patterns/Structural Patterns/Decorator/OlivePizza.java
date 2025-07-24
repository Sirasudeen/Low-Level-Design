package Decorator;

public class OlivePizza extends PizzaDecorator{
    public OlivePizza(Pizza pizza) {
        super(pizza);
    }
    @Override
    public String getDescription() {
        return pizza.getDescription() + " with olive";
    }
    @Override
    public double getCost() {
        return pizza.getCost() + 30.0;
    }
}
