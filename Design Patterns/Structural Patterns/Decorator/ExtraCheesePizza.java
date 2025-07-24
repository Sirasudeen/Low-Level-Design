package Decorator;

public class ExtraCheesePizza extends PizzaDecorator{
    public ExtraCheesePizza(Pizza pizza)
    {
        super(pizza);
    }
    @Override
    public String getDescription() {
        return pizza.getDescription() + " with extra cheese";
    }
    @Override
    public double getCost() {
        return pizza.getCost() + 20.0;
    }
}
