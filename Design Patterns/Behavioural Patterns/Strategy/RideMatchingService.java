package Strategy;

public class RideMatchingService {
    private MatchingStrategy strategy;

    public RideMatchingService(MatchingStrategy strategy) {
        this.strategy = strategy;
    }

    public void setStrategy(MatchingStrategy strategy) {
        this.strategy = strategy;
    }

    public void matchRider(String location) {
        strategy.match(location);
    }
}