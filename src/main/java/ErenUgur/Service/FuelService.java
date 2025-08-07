// FuelService.java
package ErenUgur.Service;

import dataAccessLayer.DBConnection;
import ErenUgur.model.Vehicle;
import ErenUgur.Strategy.FuelStrategy;
import ErenUgur.DAO.FuelDAO;

public class FuelService {
    private FuelDAO fuelDAO = new FuelDAO();

    public void logFuelUsage(Vehicle vehicle, double distance, FuelStrategy strategy) {
        double fuelUsed = strategy.calculateFuelUsage(vehicle, distance);
        fuelDAO.saveFuelLog(vehicle.getVehicleId(), fuelUsed);
        if (fuelUsed > vehicle.getFuelConsumptionRate() * 2) { // Example threshold
            System.out.println("ALERT: Excessive fuel/energy consumption detected for Vehicle " + vehicle.getVehicleId());
        }
    }
}
