package com.ptfms.model;

import java.time.LocalDateTime;

public class MaintenanceTask {
    private String vehicleId  ;
    private final int componentId;
    private final LocalDateTime scheduledAt;

    public MaintenanceTask(int componentId, LocalDateTime scheduledAt) {
        this.vehicleId   = vehicleId;
        this.componentId = componentId;
        this.scheduledAt = scheduledAt;
    }

    // getters
    public String getVehicleId()     { return vehicleId; }
    public int    getComponentId()   { return componentId; }
    public LocalDateTime getScheduledAt() { return scheduledAt; }

    public int getAlertId() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public String getScheduledFor() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public void setId(int aInt) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public int getId() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}