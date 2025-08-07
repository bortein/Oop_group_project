package strategy;

import transferObjects.Vehicle;

public interface FuelStrategy {
    double calculateFuelUsage(Vehicle vehicle, double distance);
    double calculateEfficiency(double fuelUsed, double distance);  // Add this method
}
