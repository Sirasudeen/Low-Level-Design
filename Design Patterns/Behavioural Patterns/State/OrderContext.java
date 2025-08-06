package State;

public class OrderContext {
        private OrderState currentState;

    public OrderContext() {
        this.currentState = new OrderPlacedState(); 
    }

    public void setState(OrderState state) {
        this.currentState = state;
    }

    public void next() {
        currentState.next(this);
    }

    public void cancel() {
        currentState.cancel(this);
    }

    public String getCurrentState() {
        return currentState.getStateName();
    }
}
