package dataAccessLayer;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class VehicleDAO {

    public static class Vehicle {
        public String vehicleId;
        public String fuelType;
        public double fuelLevel;

        public Vehicle(String vehicleId, String fuelType, double fuelLevel) {
            this.vehicleId = vehicleId;
            this.fuelType = fuelType;
            this.fuelLevel = fuelLevel;
        }
    }

    public List<Vehicle> getAllVehicles() throws SQLException {
        List<Vehicle> vehicles = new ArrayList<>();

        String sql = "SELECT vehicle_id, fuel_type, fuel_level FROM vehicles";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                String id = rs.getString("vehicle_id");
                String type = rs.getString("fuel_type");
                double level = rs.getDouble("fuel_level");
                vehicles.add(new Vehicle(id, type, level));
            }
        }

        return vehicles;
    }
}
