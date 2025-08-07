package com.ptfms.model;

import java.util.ArrayList;
import java.util.List;

public class Vehicle {
    private final String id;
    private final List<Component> components = new ArrayList<>();
    public Object[] getVehicleID;

    public Vehicle(String id) {
        this.id = id;
    }

    public Vehicle addComponent(Component c) {
        components.add(c);
        return this;
    }

    public void simulateUsage(double hours) {
        for (Component c : components) {
            c.addUsage(hours);
        }
    }

    public void checkAlerts() {
        System.out.println("Vehicle " + id + " status:");
        for (Component c : components) {
            String status = c.needsMaintenance() ? "OVERDUE" : "OK";
            System.out.printf("  %s: %s (%.1f/%.1f hrs)%n",
                              c.getName(), status,
                              c.getUsageHours(), c.getThreshold());
        }
    }

    public String getId() { return id; }
    public List<Component> getComponents() { return components; }
}
