package ErenUgur.Strategy;

import ErenUgur.model.Vehicle;

public class BusFuelStrategy implements FuelStrategy {
    @Override
    public double calculateFuelUsage(Vehicle vehicle, double distance) {
        return (vehicle.getFuelConsumptionRate() / 100) * distance; // liters per 100 km
    }

    @Override
    public double calculateEfficiency(double fuelUsed, double distance) {
        // Example: efficiency = distance traveled per liter of fuel
        if (fuelUsed == 0) return 0;
        return distance / fuelUsed; // km per liter
    }
}
