// FuelStrategy.java
package ErenUgur.Strategy;

import ErenUgur.model.Vehicle;

public interface FuelStrategy {
    double calculateFuelUsage(Vehicle vehicle, double distance);
}
