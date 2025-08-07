package com.ptfms.business.command;

import com.ptfms.data.dao.MaintenanceTaskDAO;
import com.ptfms.model.MaintenanceTask;

public interface Command {
    void execute() throws Exception;
}

public class ScheduleMaintenanceCommand implements Command {
    private final MaintenanceTask task;
    private final MaintenanceTaskDAO dao = new MaintenanceTaskDAO();

    public ScheduleMaintenanceCommand(MaintenanceTask task) {
        this.task = task;
    }

    @Override
    public void execute() throws Exception {
        dao.save(task);
    }
}