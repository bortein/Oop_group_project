package com.ptfms.model;

import java.time.LocalDateTime;

public class MaintenanceTask {
    private final String vehicleId;
    private final int componentId;
    private final LocalDateTime scheduledAt;

    public MaintenanceTask(String vehicleId, int componentId, LocalDateTime scheduledAt) {
        this.vehicleId   = vehicleId;
        this.componentId = componentId;
        this.scheduledAt = scheduledAt;
    }

    // getters
    public String getVehicleId()     { return vehicleId; }
    public int    getComponentId()   { return componentId; }
    public LocalDateTime getScheduledAt() { return scheduledAt; }
}