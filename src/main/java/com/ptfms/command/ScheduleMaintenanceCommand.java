package com.ptfms.command;

import com.ptfms.dao.MaintenanceTaskDao;
import com.ptfms.model.MaintenanceTask;
import java.time.LocalDateTime;

/**
 * Command that schedules a maintenance task in the database.
 */
public class ScheduleMaintenanceCommand implements MaintenanceCommand {
    private final int alertId;
    private final LocalDateTime scheduledFor;
    private final MaintenanceTaskDao taskDao;

    public ScheduleMaintenanceCommand(int alertId,
                                      LocalDateTime scheduledFor,
                                      MaintenanceTaskDao taskDao) {
        this.alertId      = alertId;
        this.scheduledFor = scheduledFor;
        this.taskDao      = taskDao;
    }

    public void execute() {
        MaintenanceTask task = new MaintenanceTask(alertId, scheduledFor);
        taskDao.save(task);
    }
}
