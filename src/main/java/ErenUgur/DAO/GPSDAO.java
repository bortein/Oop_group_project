package ErenUgur.DAO;

import ErenUgur.model.GPSLocation;
import dataaccesslayer.DBConnection;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class GPSDAO {

    public List<GPSLocation> getLocationsByVehicleId(int vehicleId) {
        List<GPSLocation> locations = new ArrayList<>();
        String sql = "SELECT id, vehicle_id, latitude, longitude, timestamp FROM gps_log WHERE vehicle_id = ? ORDER BY timestamp DESC";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, vehicleId);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                GPSLocation location = new GPSLocation(
                        rs.getInt("id"),
                        rs.getInt("vehicle_id"),
                        rs.getDouble("latitude"),
                        rs.getDouble("longitude"),
                        rs.getTimestamp("timestamp")
                );
                locations.add(location);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return locations;
    }

    public void saveLocation(GPSLocation location) {
        String sql = "INSERT INTO gps_log (vehicle_id, latitude, longitude, timestamp) VALUES (?, ?, ?, ?)";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, location.getVehicleId());
            ps.setDouble(2, location.getLatitude());
            ps.setDouble(3, location.getLongitude());
            ps.setTimestamp(4, location.getTimestamp());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
