package javagroupprojectkapoor;

/**
 * Represents fuel usage data for a vehicle type.
 */
public class FuelUsageReport {
    private final String vehicleType;
    private final double totalConsumption;
    private final double totalCost;

    /**
     * Creates a fuel usage report.
     *
     * @param vehicleType the type of vehicle
     * @param totalConsumption the amount of fuel used
     * @param totalCost the cost of the fuel used
     */
    public FuelUsageReport(String vehicleType, double totalConsumption, double totalCost) {
        this.vehicleType = vehicleType;
        this.totalConsumption = totalConsumption;
        this.totalCost = totalCost;
    }

    /**
     * Gets the vehicle type.
     *
     * @return the vehicle type
     */
    public String getVehicleType() { return vehicleType; }

    /**
     * Gets the total fuel consumption.
     *
     * @return total fuel consumption
     */
    public double getTotalConsumption() { return totalConsumption; }

    /**
     * Gets the total fuel cost.
     *
     * @return total fuel cost
     */
    public double getTotalCost() { return totalCost; }
}