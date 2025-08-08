package com.ptfms;

import com.ptfms.model.Vehicle;
import java.util.ArrayList;
import java.util.List;

public class TransitManager {
    private final List<Vehicle> fleet = new ArrayList<>();

    public void addVehicle(Vehicle v) {
        fleet.add(v);
    }

    public void monitorFleet() {
        for (Vehicle v : fleet) {
            v.checkAlerts();
        }
    }

    public void scheduleMaintenance(String vehicleId, String componentName) {
        System.out.printf("🔧 Scheduling maintenance for %s on %s%n",
                          componentName, vehicleId);
    }
}