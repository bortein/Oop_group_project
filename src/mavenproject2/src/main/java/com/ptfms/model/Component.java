package com.ptfms.model;

import com.ptfms.business.observer.ComponentSubject;
import java.util.ArrayList;
import java.util.List;

public class Component implements ComponentSubject {
    private final String name;
    private double usageHours;
    private final double threshold = 0;
    private final List<MaintenanceAlertObserver> observers = new ArrayList<>();

    public Component(int par, String name, int par1) {
        this.name = name;
    }

    public Component(String brakes, int i) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public void addUsage(double hours) {
        usageHours += hours;
        if (usageHours >= threshold) {
            notifyObservers();
        }
    }

    public boolean needsMaintenance() {
        return usageHours >= threshold;
    }

    public String getName() { return name; }
    public double getUsageHours() { return usageHours; }
    public double getThreshold() { return threshold; }

    @Override
    public void register(MaintenanceAlertObserver o) {
        observers.add(o);
    }

    @Override
    public void unregister(MaintenanceAlertObserver o) {
        observers.remove(o);
    }

    @Override
    public void notifyObservers() {
        for (MaintenanceAlertObserver o : observers) {
            o.update(this);
        }
    }

    public void addUsage(Vehicle bus, int i) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public void setUsageHours(double hrs) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public double getMeasurement(String voltage) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public Object getVehicle() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public void getID() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}