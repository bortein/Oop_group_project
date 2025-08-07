// FuelDAO.java
package ErenUgur.DAO;

import java.sql.*;
import dataaccesslayer.DBConnection;
import java.util.ArrayList;
import java.util.List;
import ErenUgur.model.FuelLog;

public class FuelDAO {

public boolean saveFuelLog(int vehicleId, double fuelUsed, double distance, Timestamp timestamp) {
    String sql = "INSERT INTO fuel_log (vehicle_id, fuel_used, distance, log_time) VALUES (?, ?, ?, ?)";
    try (Connection conn = DBConnection.getConnection();
         PreparedStatement ps = conn.prepareStatement(sql)) {

        ps.setInt(1, vehicleId);
        ps.setDouble(2, fuelUsed);
        ps.setDouble(3, distance);

        if (timestamp != null) {
            ps.setTimestamp(4, timestamp);
        } else {
            ps.setNull(4, java.sql.Types.TIMESTAMP);
        }

        return ps.executeUpdate() > 0;

    } catch (SQLException e) {
        e.printStackTrace();
        return false; // ✅ Fix: Add this line to satisfy return type
    }
}
public List<FuelLog> getAllFuelLogs() {
    List<FuelLog> logs = new ArrayList<>();
    String sql = "SELECT * FROM fuel_log";

    try (Connection conn = DBConnection.getConnection();
         PreparedStatement ps = conn.prepareStatement(sql);
         ResultSet rs = ps.executeQuery()) {

        while (rs.next()) {
            FuelLog log = new FuelLog();
            log.setId(rs.getInt("id"));
            log.setVehicleId(rs.getInt("vehicle_id"));
            log.setFuelUsed(rs.getDouble("fuel_used"));
            log.setDistance(rs.getDouble("distance"));
            log.setLogTime(rs.getTimestamp("log_time"));
            logs.add(log);
        }

    } catch (SQLException e) {
        e.printStackTrace();
    }

    return logs;
}


    public double getTotalFuelUsed(int vehicleId) {
        String sql = "SELECT SUM(fuel_used) as total FROM fuel_log WHERE vehicle_id = ?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, vehicleId);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return rs.getDouble("total");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0.0;
    }
    
 
}
