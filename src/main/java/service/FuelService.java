// FuelService.java
package service;

import transferObjects.Vehicle;
import strategy.FuelStrategy;
import dataAccessLayer.FuelDAO;

import java.sql.Timestamp;

public class FuelService {
    private final FuelDAO fuelDAO = new FuelDAO();

    public void logFuelUsage(Vehicle vehicle, double distance, FuelStrategy strategy) {
        double fuelUsed = strategy.calculateFuelUsage(vehicle, distance);

        // Pass all four parameters: vehicleId, fuelUsed, distance, timestamp
        fuelDAO.saveFuelLog(vehicle.getVehicleId(), fuelUsed, distance, new Timestamp(System.currentTimeMillis()));

        // Example alert threshold: double the expected consumption
        if (fuelUsed > vehicle.getFuelConsumptionRate() * 2) {
            System.out.println("ALERT: Excessive fuel/energy consumption detected for Vehicle " + vehicle.getVehicleId());
        }
    }
}
