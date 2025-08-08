// src/main/java/com/ptfms/model/Vehicle.java
package com.ptfms.model;

import com.ptfms.business.observer.MaintenanceAlertListener;
import java.util.ArrayList;
import java.util.List;

/**
 * Vehicle holds components and notifies listeners on alerts.
 */
public class Vehicle {
    private final String id;
    private final List<Component> components = new ArrayList<>();
    private final List<MaintenanceAlertListener> listeners = new ArrayList<>();

    public Vehicle(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public Vehicle addComponent(Component c) {
        components.add(c);
        // option: register c itself as a listener if you wire components→vehicle alerts
        return this;
    }

    public void addAlertListener(MaintenanceAlertListener l) {
        listeners.add(l);
    }

    public void removeAlertListener(MaintenanceAlertListener l) {
        listeners.remove(l);
    }

    /**
     * Simulate an alert (e.g.called by Component.addUsage when threshold reached).
     * @param message
     */
    public void notifyAlert(String message) {
        for (MaintenanceAlertListener l : listeners) {
            l.onAlert(this, message);
        }
    }

    public List<Component> getComponents() {
        return components;
    }

    public void checkAlerts() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public void setType(String type) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public void setFuelType(String fuel) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public void setConsumptionRate(double rate) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public void setMaxPassengers(int max) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public void setCurrentRoute(String route) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
