// src/main/java/com/ptfms/business/observer/MaintenanceAlertListener.java
package com.ptfms.business.observer;

import com.ptfms.model.Vehicle;

/**
 * Fired whenever a Vehicle issues a maintenance alert.
 */
public interface MaintenanceAlertListener {
    void onAlert(Vehicle vehicle, String message);
}
