package javagroupprojectkapoor;

/**
 * Represents a maintenance report for a vehicle.
 * Stores component status and next service date.
 * 
 * @author kapoor
 */
public class MaintenanceReport {
    private final String vehicleNumber;
    private final String component;
    private final String status;
    private final String nextServiceDate;

    /**
     * Creates a maintenance report.
     * 
     * @param vehicleNumber the vehicle ID
     * @param component the component being reported
     * @param status the condition of the component
     * @param nextServiceDate the next scheduled service date
     */
    public MaintenanceReport(String vehicleNumber, String component,
                             String status, String nextServiceDate) {
        this.vehicleNumber = vehicleNumber;
        this.component = component;
        this.status = status;
        this.nextServiceDate = nextServiceDate;
    }

    /**
     * Gets the vehicle number.
     *
     * @return the vehicle number
     */
    public String getVehicleNumber() { return vehicleNumber; }

    /**
     * Gets the component name.
     *
     * @return the component
     */
    public String getComponent() { return component; }

    /**
     * Gets the component status.
     *
     * @return the status
     */
    public String getStatus() { return status; }

    /**
     * Gets the next service date.
     *
     * @return the next service date
     */
    public String getNextServiceDate() { return nextServiceDate; }
}