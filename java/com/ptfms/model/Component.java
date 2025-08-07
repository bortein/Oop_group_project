package com.ptfms.model;

import com.ptfms.business.observer.ComponentSubject;
import com.ptfms.business.observer.MaintenanceAlertObserver;
import java.util.ArrayList;
import java.util.List;

public class Component implements ComponentSubject {
    private final String name;
    private double usageHours;
    private final double threshold;
    private final List<MaintenanceAlertObserver> observers = new ArrayList<>();

    public Component(String name, double threshold) {
        this.name = name;
        this.threshold = threshold;
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
}