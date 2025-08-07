package ErenUgur.Strategy;

import ErenUgur.model.Vehicle;

public interface FuelStrategy {
    double calculateFuelUsage(Vehicle vehicle, double distance);
    double calculateEfficiency(double fuelUsed, double distance);  // Add this method
}
