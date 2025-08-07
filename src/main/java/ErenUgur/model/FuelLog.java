// ErenUgur/model/FuelLog.java
package ErenUgur.model;

import java.sql.Timestamp;

public class FuelLog {
    private int id;
    private int vehicleId;
    private double fuelUsed;
    private double distance;
    private Timestamp logTime;

    // Getters and Setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public int getVehicleId() { return vehicleId; }
    public void setVehicleId(int vehicleId) { this.vehicleId = vehicleId; }

    public double getFuelUsed() { return fuelUsed; }
    public void setFuelUsed(double fuelUsed) { this.fuelUsed = fuelUsed; }

    public double getDistance() { return distance; }
    public void setDistance(double distance) { this.distance = distance; }

    public Timestamp getLogTime() { return logTime; }
    public void setLogTime(Timestamp logTime) { this.logTime = logTime; }
}