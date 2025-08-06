package State;

public class OutForDeliveryState implements OrderState{
        
        @Override
        public void next(OrderContext context) {
        context.setState(new DeliveredState());
        System.out.println("Order has been delivered.");
        }
        @Override
        public void cancel(OrderContext context) {
            System.out.println("Cannot cancel. Order is out for delivery.");
        }
        @Override
        public String getStateName() {
            return "OUT_FOR_DELIVERY";
        }
}
