// Vehicle.java
package model;

public class Vehicle {
    private int vehicleId;
    private String type;
    private String fuelType;
    private double fuelConsumptionRate; // L/100km or kWh/mile

    public Vehicle(int vehicleId, String type, String fuelType, double fuelConsumptionRate) {
        this.vehicleId = vehicleId;
        this.type = type;
        this.fuelType = fuelType;
        this.fuelConsumptionRate = fuelConsumptionRate;
    }

    public int getVehicleId() { return vehicleId; }
    public String getType() { return type; }
    public String getFuelType() { return fuelType; }
    public double getFuelConsumptionRate() { return fuelConsumptionRate; }
}