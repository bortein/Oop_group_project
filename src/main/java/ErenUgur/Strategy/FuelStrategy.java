// FuelStrategy.java
package ErenUgur.Strategy;

import model.Vehicle;

public interface FuelStrategy {
    double calculateFuelUsage(Vehicle vehicle, double distance);
}
