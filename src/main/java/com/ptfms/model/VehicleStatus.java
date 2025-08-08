package com.ptfms.model;

import java.time.LocalDate;

public class VehicleStatus {
    private String vehicleId;
    private String status;
    private LocalDate lastMaintenanceDate;
    private LocalDate nextScheduledDate;
    private String componentHealthSummary;

    public VehicleStatus() { }

    public VehicleStatus(String vehicleId,
                         String status,
                         LocalDate lastMaintenanceDate,
                         LocalDate nextScheduledDate,
                         String componentHealthSummary) {
        this.vehicleId = vehicleId;
        this.status = status;
        this.lastMaintenanceDate = lastMaintenanceDate;
        this.nextScheduledDate = nextScheduledDate;
        this.componentHealthSummary = componentHealthSummary;
    }

    public String getVehicleId() {
        return vehicleId;
    }

    public void setVehicleId(String vehicleId) {
        this.vehicleId = vehicleId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public LocalDate getLastMaintenanceDate() {
        return lastMaintenanceDate;
    }

    public void setLastMaintenanceDate(LocalDate lastMaintenanceDate) {
        this.lastMaintenanceDate = lastMaintenanceDate;
    }

    public LocalDate getNextScheduledDate() {
        return nextScheduledDate;
    }

    public void setNextScheduledDate(LocalDate nextScheduledDate) {
        this.nextScheduledDate = nextScheduledDate;
    }

    public String getComponentHealthSummary() {
        return componentHealthSummary;
    }

    public void setComponentHealthSummary(String componentHealthSummary) {
        this.componentHealthSummary = componentHealthSummary;
    }
}