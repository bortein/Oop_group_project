package ErenUgur.Strategy;

import ErenUgur.model.Vehicle;

public class LightRailEnergyStrategy implements FuelStrategy {

    @Override
    public double calculateFuelUsage(Vehicle vehicle, double distance) {
        return vehicle.getFuelConsumptionRate() * distance; // kWh per mile
    }

    @Override
    public double calculateEfficiency(double fuelUsed, double distance) {
        // Efficiency could be miles per kWh
        if (fuelUsed == 0) return 0;
        return distance / fuelUsed; // miles per kWh
    }
}
