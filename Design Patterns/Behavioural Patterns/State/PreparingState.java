package State;

public class PreparingState implements OrderState {
    @Override
    public void next(OrderContext context) {
        context.setState(new OutForDeliveryState());
        System.out.println("Order is out for delivery.");
    }
    @Override
    public void cancel(OrderContext context) {
        context.setState(new CancelledState());
        System.out.println("Order has been cancelled.");
    }
    @Override
    public String getStateName() {
        return "PREPARING";
    }
}
