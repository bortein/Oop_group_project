// LightRailEnergyStrategy.java
package ErenUgur.Strategy;

import ErenUgur.model.Vehicle;

public class LightRailEnergyStrategy implements FuelStrategy {
    @Override
    public double calculateFuelUsage(Vehicle vehicle, double distance) {
        return vehicle.getFuelConsumptionRate() * distance; // kWh/mile
    }
}
