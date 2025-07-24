package Decorator;

public class Main {
    public static void main(String[] args) {
        
        Pizza plainPizza = new PlainPizza();
        Pizza margheritPizza = new MargheritaPizza();
        Pizza extraCheesePlainPizza = new ExtraCheesePizza(plainPizza);
        Pizza extraCheeseMargheritaPizza = new ExtraCheesePizza(margheritPizza);
        Pizza olivesCheeseMargheritaPizza = new OlivePizza(extraCheeseMargheritaPizza);
        System.out.println(olivesCheeseMargheritaPizza.getDescription() + " - $" + olivesCheeseMargheritaPizza.getCost());    
        

        System.out.println(plainPizza.getDescription() + " - $" + plainPizza.getCost());
        System.out.println(margheritPizza.getDescription() + " - $" + margheritPizza.getCost());
        System.out.println(extraCheesePlainPizza.getDescription() + " - $" + extraCheesePlainPizza.getCost());
        System.out.println(extraCheeseMargheritaPizza.getDescription() + " - $" + extraCheeseMargheritaPizza.getCost());
    }
}
