package com.ptfms.dao.impl;

import com.ptfms.dao.MaintenanceTaskDao;
import com.ptfms.model.MaintenanceTask;

import javax.sql.DataSource;
import java.sql.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class JdbcMaintenanceTaskDao implements MaintenanceTaskDao {
    private final DataSource dataSource;

    public JdbcMaintenanceTaskDao(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public void save(MaintenanceTask task) {
        String sql = "INSERT INTO maintenance_tasks (alert_id, scheduled_for) VALUES (?, ?)";
        try (Connection conn = dataSource.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
             
            ps.setInt(1, task.getAlertId());
            ps.setTimestamp(2, Timestamp.valueOf(task.getScheduledFor()));
            ps.executeUpdate();
            
            // retrieve generated ID
            try (ResultSet keys = ps.getGeneratedKeys()) {
                if (keys.next()) {
                    task.setId(keys.getInt(1));
                }
            }
            
        } catch (SQLException e) {
            throw new RuntimeException("Error saving MaintenanceTask", e);
        }
    }

    @Override
    public MaintenanceTask findById(int id) {
        String sql = "SELECT id, alert_id, scheduled_for FROM maintenance_tasks WHERE id = ?";
        try (Connection conn = dataSource.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
             
            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    LocalDateTime when = rs.getTimestamp("scheduled_for").toLocalDateTime();
                    MaintenanceTask task = new MaintenanceTask(rs.getInt("alert_id"), when);
                    task.setId(rs.getInt("id"));
                    return task;
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException("Error finding MaintenanceTask by id", e);
        }
        return null;
    }

    @Override
    public List<MaintenanceTask> findAll() {
        String sql = "SELECT id, alert_id, scheduled_for FROM maintenance_tasks";
        List<MaintenanceTask> tasks = new ArrayList<>();
        try (Connection conn = dataSource.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
             
            while (rs.next()) {
                LocalDateTime when = rs.getTimestamp("scheduled_for").toLocalDateTime();
                MaintenanceTask task = new MaintenanceTask(rs.getInt("alert_id"), when);
                task.setId(rs.getInt("id"));
                tasks.add(task);
            }
        } catch (SQLException e) {
            throw new RuntimeException("Error fetching all MaintenanceTasks", e);
        }
        return tasks;
    }

    @Override
    public void update(MaintenanceTask task) {
        String sql = "UPDATE maintenance_tasks SET alert_id = ?, scheduled_for = ? WHERE id = ?";
        try (Connection conn = dataSource.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
             
            ps.setInt(1, task.getAlertId());
            ps.setTimestamp(2, Timestamp.valueOf(task.getScheduledFor()));
            ps.setInt(3, task.getId());
            ps.executeUpdate();
            
        } catch (SQLException e) {
            throw new RuntimeException("Error updating MaintenanceTask", e);
        }
    }

    @Override
    public void delete(int id) {
        String sql = "DELETE FROM maintenance_tasks WHERE id = ?";
        try (Connection conn = dataSource.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
             
            ps.setInt(1, id);
            ps.executeUpdate();
            
        } catch (SQLException e) {
            throw new RuntimeException("Error deleting MaintenanceTask", e);
        }
    }
}
