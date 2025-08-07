package com.ptfms.business.service;

import com.ptfms.data.dao.ComponentDAO;
import com.ptfms.model.Component;
import com.ptfms.business.observer.AlertLogger;
import com.ptfms.model.MaintenanceTask;
import com.ptfms.business.command.ScheduleMaintenanceCommand;

import java.time.LocalDateTime;
import java.util.List;

public class MaintenanceService {
    private final ComponentDAO dao = new ComponentDAO();

    public void checkAndSchedule(String vehicleId) throws Exception {
        // 1) load components & attach observer
        List<Component> comps = dao.findAllByVehicle(vehicleId);
        for (var c : comps) {
            c.registerObserver(new AlertLogger());
        }

        // 2) simulate wear, notify, and schedule if needed
        for (var comp : comps) {
            comp.addUsage(5.0);  // simulate 5 hrs of use
            if (comp.needsMaintenance()) {
                var task = new MaintenanceTask(
                    vehicleId,
                    comp.getId(),
                    LocalDateTime.now().plusDays(1)
                );
                new ScheduleMaintenanceCommand(task).execute();
            }
            // persist updated usage
            dao.updateUsage(comp.getId(), comp.getUsageHours());
        }
    }
}