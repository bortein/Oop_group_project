package javagroupprojectkapoor.data;

import javagroupprojectkapoor.buisness.model.FuelUsageReport;
import javagroupprojectkapoor.buisness.model.MaintenanceReport;
import javagroupprojectkapoor.buisness.model.OperatorStats;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * DAO class for fetching report data from the database.
 */
public class ReportDAO {
    private final Connection conn;

    /**
     * Creates a new ReportDAO with the given connection.
     * @param conn the database connection
     */
    public ReportDAO(Connection conn) {
        this.conn = conn;
    }

    /**
     * Gets fuel usage data grouped by vehicle type.
     * @return list of fuel usage reports
     * @throws SQLException if a database error occurs
     */
    public List<FuelUsageReport> getFuelUsageReport() throws SQLException {
        String sql = "SELECT vehicleType,\n" + "       SUM(consumption) AS totalConsumption,\n" + "       SUM(cost)        AS totalCost\n" + "FROM FuelLog\n" + "GROUP BY vehicleType\n";
        List<FuelUsageReport> list = new ArrayList<>();
        try (PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                list.add(new FuelUsageReport(
                        rs.getString("vehicleType"),
                        rs.getDouble("totalConsumption"),
                        rs.getDouble("totalCost")
                ));
            }
        }
        return list;
    }

    /**
     * Gets all maintenance reports.
     * @return list of maintenance reports
     * @throws SQLException if a database error occurs
     */
    public List<MaintenanceReport> getMaintenanceReports() throws SQLException {
        String sql = "SELECT vehicleNumber, component, status, nextServiceDate\n" + "FROM MaintenanceLog\n";
        List<MaintenanceReport> list = new ArrayList<>();
        try (PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                list.add(new MaintenanceReport(
                        rs.getString("vehicleNumber"),
                        rs.getString("component"),
                        rs.getString("status"),
                        rs.getString("nextServiceDate")
                ));
            }
        }
        return list;
    }

    /**
     * Gets operator performance stats grouped by operator.
     * @return list of operator stats
     * @throws SQLException if a database error occurs
     */
    public List<OperatorStats> getOperatorPerformance() throws SQLException {
        String sql = "SELECT operatorId,\n" + "       AVG(onTimeRate) AS avgRate,\n" + "       COUNT(*)        AS totalTrips\n" + "FROM OperatorLog\n" + "GROUP BY operatorId\n";
        List<OperatorStats> list = new ArrayList<>();
        try (PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                list.add(new OperatorStats(
                        rs.getString("operatorId"),
                        rs.getDouble("avgRate"),
                        rs.getInt("totalTrips")
                ));
            }
        }
        return list;
    }
}