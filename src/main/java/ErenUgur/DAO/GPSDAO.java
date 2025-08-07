// GPSDAO.java
package ErenUgur.DAO;

import model.GPSLocation;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import dataAccessLayer.DBConnection;

public class GPSDAO {

    public void saveLocation(GPSLocation location) {
        String sql = "INSERT INTO gps_log (vehicle_id, latitude, longitude, timestamp) VALUES (?, ?, ?, ?)";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, location.getVehicleId());
            ps.setDouble(2, location.getLatitude());
            ps.setDouble(3, location.getLongitude());
            ps.setTimestamp(4, Timestamp.valueOf(location.getTimestamp()));
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<GPSLocation> getVehicleLocations(int vehicleId) {
        List<GPSLocation> locations = new ArrayList<>();
        String sql = "SELECT * FROM gps_log WHERE vehicle_id = ?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, vehicleId);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                locations.add(new GPSLocation(
                        rs.getInt("vehicle_id"),
                        rs.getDouble("latitude"),
                        rs.getDouble("longitude"),
                        rs.getTimestamp("timestamp").toLocalDateTime()
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return locations;
    }
}
