package ErenUgur.Strategy;

import ErenUgur.model.Vehicle;

public class TrainFuelStrategy implements FuelStrategy {

    @Override
    public double calculateFuelUsage(Vehicle vehicle, double distance) {
        // Fuel used (e.g., liters per 100 km) multiplied by distance
        return (vehicle.getFuelConsumptionRate() / 100) * distance;
    }

    @Override
    public double calculateEfficiency(double fuelUsed, double distance) {
        // Efficiency as distance per unit fuel (e.g., km per liter)
        if (fuelUsed == 0) return 0;
        return distance / fuelUsed;
    }
}
