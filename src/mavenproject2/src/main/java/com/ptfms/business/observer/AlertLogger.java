// src/main/java/com/ptfms/business/observer/AlertLogger.java
package com.ptfms.business.observer;

import com.ptfms.model.Vehicle;

/**
 * Logs any incoming maintenance alerts to the console.
 */
public class AlertLogger implements MaintenanceAlertListener {

    @Override
    public void onAlert(Vehicle vehicle, String message) {
        System.out.printf("ALERT for Vehicle %s: %s%n",vehicle.getId(),message);
    }
}
