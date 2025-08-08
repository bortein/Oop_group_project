// File: src/main/java/com/ptfms/model/MaintenanceAlert.java
package com.ptfms.model;

import java.time.LocalDateTime;

public class MaintenanceAlert {
    private String vehicleId;
    private String componentName;
    private String alertType;
    private String message;
    private LocalDateTime timestamp;

    public MaintenanceAlert() {
    }

    public MaintenanceAlert(String vehicleId,
                            String componentName,
                            String alertType,
                            String message,
                            LocalDateTime timestamp) {
        this.vehicleId = vehicleId;
        this.componentName = componentName;
        this.alertType = alertType;
        this.message = message;
        this.timestamp = timestamp;
    }

    public String getVehicleId() {
        return vehicleId;
    }

    public void setVehicleId(String vehicleId) {
        this.vehicleId = vehicleId;
    }

    public String getComponentName() {
        return componentName;
    }

    public void setComponentName(String componentName) {
        this.componentName = componentName;
    }

    public String getAlertType() {
        return alertType;
    }

    public void setAlertType(String alertType) {
        this.alertType = alertType;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }

    @Override
    public String toString() {
        return "MaintenanceAlert{" +
               "vehicleId='" + vehicleId + '\'' +
               ", componentName='" + componentName + '\'' +
               ", alertType='" + alertType + '\'' +
               ", message='" + message + '\'' +
               ", timestamp=" + timestamp +
               '}';
    }
}