package com.ptfms.data.dao;

import com.ptfms.model.MaintenanceTask;

import java.sql.*;

public class MaintenanceTaskDAO {
    private final String url  = "jdbc:mysql://localhost:3306/ptfms";
    private final String user = "cst8288";
    private final String pass = "cst8288";

    public void save(MaintenanceTask task) throws SQLException {
        String sql = """
            INSERT INTO maintenance_tasks
              (vehicle_id, component_id, scheduled_at)
            VALUES (?, ?, ?)
        """;
        try (Connection conn = DriverManager.getConnection(url, user, pass);
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, task.getVehicleId());
            ps.setInt(2, task.getComponentId());
            ps.setTimestamp(3, Timestamp.valueOf(task.getScheduledAt()));
            ps.executeUpdate();
        }
    }
}