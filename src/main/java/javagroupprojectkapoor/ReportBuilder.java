package javagroupprojectkapoor;

import java.util.*;

/**
 * Builds a Reports object containing fuel, maintenance, and operator reports.
 */
public class ReportBuilder {
    private List<FuelUsageReport> fuelReports;
    private List<MaintenanceReport> maintenanceReports;
    private List<OperatorStats> operatorReports;

    /**
     * Sets the fuel usage reports.
     *
     * @param fuelReports the fuel usage report list
     * @return this builder instance
     */
    public ReportBuilder setFuelReports(List<FuelUsageReport> fuelReports) {
        this.fuelReports = fuelReports;
        return this;
    }

    /**
     * Sets the maintenance reports.
     *
     * @param maintenanceReports the maintenance report list
     * @return this builder instance
     */
    public ReportBuilder setMaintenanceReports(List<MaintenanceReport> maintenanceReports) {
        this.maintenanceReports = maintenanceReports;
        return this;
    }

    /**
     * Sets the operator performance reports.
     *
     * @param operatorReports the operator performance report list
     * @return this builder instance
     */
    public ReportBuilder setOperatorReports(List<OperatorStats> operatorReports) {
        this.operatorReports = operatorReports;
        return this;
    }

    /**
     * Builds and returns a Reports object.
     *
     * @return a new Reports object
     */
    public Reports build() {
        return new Reports(fuelReports, maintenanceReports, operatorReports);
    }

    /**
     * Holds all types of reports.
     */
    public static class Reports {
        private final List<FuelUsageReport> fuelReports;
        private final List<MaintenanceReport> maintenanceReports;
        private final List<OperatorStats> operatorReports;

        /**
         * Creates a new Reports object.
         *
         * @param fuelReports list of fuel usage reports
         * @param maintenanceReports list of maintenance reports
         * @param operatorReports list of operator performance reports
         */
        public Reports(List<FuelUsageReport> fuelReports,
                       List<MaintenanceReport> maintenanceReports,
                       List<OperatorStats> operatorReports) {
            this.fuelReports = fuelReports;
            this.maintenanceReports = maintenanceReports;
            this.operatorReports = operatorReports;
        }

        /**
         * Gets the fuel reports.
         *
         * @return fuel report list
         */
        public List<FuelUsageReport> getFuelReports() { return fuelReports; }

        /**
         * Gets the maintenance reports.
         *
         * @return maintenance report list
         */
        public List<MaintenanceReport> getMaintenanceReports() { return maintenanceReports; }

        /**
         * Gets the operator performance reports.
         *
         * @return operator performance report list
         */
        public List<OperatorStats> getOperatorReports() { return operatorReports; }
    }
}