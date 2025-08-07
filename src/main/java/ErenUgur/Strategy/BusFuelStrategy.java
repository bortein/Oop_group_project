// BusFuelStrategy.java
package ErenUgur.Strategy;

import ErenUgur.model.Vehicle;

public class BusFuelStrategy implements FuelStrategy {
    @Override
    public double calculateFuelUsage(Vehicle vehicle, double distance) {
        return (vehicle.getFuelConsumptionRate() / 100) * distance; // L/100km
    }
}
