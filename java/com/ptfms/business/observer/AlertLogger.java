package com.ptfms.business.observer;

import com.ptfms.model.Vehicle;

public class AlertLogger extends MaintenanceAlertObserver {
    public AlertLogger(Vehicle vehicle) {
        super(vehicle);
    }

    @Override
    protected void handleAlert(Vehicle vehicle, String message) {
        // Example: log to console or file
        System.out.println("[LOG] " + vehicle.getId() + " -> " + message);
    }
}
