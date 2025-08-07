package com.ptfms.dao;

import com.ptfms.model.MaintenanceTask;
import java.util.List;

public interface MaintenanceTaskDao {
    /** 
     * @param task 
     */
    void save(MaintenanceTask task);

    /** Lookup a task by its primary key.Returns null if not found.
     * @param id
     * @return  */
    MaintenanceTask findById(int id);

    /** Return all scheduled maintenance tasks.
     * @return  */
    List<MaintenanceTask> findAll();

    /** Update an existing task (must have a valid id).
     * @param task */
    void update(MaintenanceTask task);

    /** Delete the task with the given id.
     * @param id */
    void delete(int id);

    
}