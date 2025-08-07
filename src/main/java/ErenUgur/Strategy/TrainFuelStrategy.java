// TrainFuelStrategy.java
package ErenUgur.Strategy;

import model.Vehicle;

public class TrainFuelStrategy implements FuelStrategy {
    @Override
    public double calculateFuelUsage(Vehicle vehicle, double distance) {
        return (vehicle.getFuelConsumptionRate() / 100) * distance; // Hybrid usage
    }
}
