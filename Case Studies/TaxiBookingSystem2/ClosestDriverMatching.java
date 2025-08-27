package TaxiBookingSystem2;

import java.util.Map;

public class ClosestDriverMatching {
    
public Taxi findTaxi(Map<String, Taxi> taxis, Location Source) {
    int min = Integer.MAX_VALUE;
    Taxi taxi = null;
    for (Taxi t : taxis.values()) {
        if (t.getStatus() == DriverStatus.Busy) continue;
        int distance = Math.abs(t.getLocation().getPosition() - Source.getPosition());
        if (distance < min) {
            min = distance;
            taxi = t;
        } else if (distance == min) {
            if (taxi != null && t.getMoneyEarned() < taxi.getMoneyEarned()) {
                taxi = t;
            }
        }
    }
    return taxi;
}
}
