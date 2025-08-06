package State;

public class Main {
    public static void main(String[] args) {
        OrderContext order = new OrderContext();
        System.out.println("Current State: " + order.getCurrentState());

        order.next(); 
        order.next();  
        order.cancel(); 
        order.next();  
        order.cancel(); 

        System.out.println("Final State: " + order.getCurrentState());
    }
}
