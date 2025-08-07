// FuelDAO.java
package ErenUgur.DAO;

import java.sql.*;
import dataAccessLayer.DBConnection;

public class FuelDAO {

    public void saveFuelLog(int vehicleId, double fuelUsed) {
        String sql = "INSERT INTO fuel_log (vehicle_id, fuel_used, log_time) VALUES (?, ?, NOW())";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, vehicleId);
            ps.setDouble(2, fuelUsed);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
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
