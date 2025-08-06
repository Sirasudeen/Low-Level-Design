package Strategy;

public class NearestDriverStrategy implements MatchingStrategy{
    @Override
    public void match(String riderLocation) {
        System.out.println("Matching with the nearest available driver to " + riderLocation);
    }
}
