package ErenUgur.DAO;

import ErenUgur.model.Vehicle;
import dataaccesslayer.DBConnection;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class VehicleDAO {

    public List<Vehicle> getAllVehicles() throws SQLException {
        List<Vehicle> vehicles = new ArrayList<>();
        String sql = "SELECT vehicle_id, vehicle_type, assigned_route, fuel_consumption_rate FROM vehicle";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {
             
            while (rs.next()) {
                int id = rs.getInt("vehicle_id");
                String type = rs.getString("vehicle_type");
                String route = rs.getString("assigned_route");
                double consumptionRate = rs.getDouble("fuel_consumption_rate");

                vehicles.add(new Vehicle(id, type, route, consumptionRate));
            }
        }
        return vehicles;
    }

    public Vehicle getVehicleById(int vehicleId) throws SQLException {
        String sql = "SELECT vehicle_id, vehicle_type, assigned_route, fuel_consumption_rate FROM vehicle WHERE vehicle_id = ?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
             
            stmt.setInt(1, vehicleId);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                int id = rs.getInt("vehicle_id");
                String type = rs.getString("vehicle_type");
                String route = rs.getString("assigned_route");
                double consumptionRate = rs.getDouble("fuel_consumption_rate");

                return new Vehicle(id, type, route, consumptionRate);
            }
        }
        return null;
    }
}