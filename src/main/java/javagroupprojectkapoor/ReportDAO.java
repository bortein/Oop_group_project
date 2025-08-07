package javagroupprojectkapoor;

import java.sql.*;
import java.util.*;

/**
 * DAO class for fetching report data from the database.
 */
public class ReportDAO {
    private final Connection conn;

    /**
     * Creates a new ReportDAO with the given connection.
     *
     * @param conn the database connection
     */
    public ReportDAO(Connection conn) {
        this.conn = conn;
    }

    /**
     * Gets fuel usage data grouped by vehicle type.
     *
     * @return list of fuel usage reports
     * @throws SQLException if a database error occurs
     */
    public List<FuelUsageReport> getFuelUsageReport() throws SQLException {
        List<FuelUsageReport> list = new ArrayList<>();
        String sql = "SELECT vehicleType, SUM(consumption) AS totalConsumption, SUM(cost) AS totalCost FROM FuelLog GROUP BY vehicleType";
        PreparedStatement stmt = conn.prepareStatement(sql);
        ResultSet rs = stmt.executeQuery();
        while (rs.next()) {
            list.add(new FuelUsageReport(
                rs.getString("vehicleType"),
                rs.getDouble("totalConsumption"),
                rs.getDouble("totalCost")
            ));
        }
        return list;
    }

    /**
     * Gets all maintenance reports.
     *
     * @return list of maintenance reports
     * @throws SQLException if a database error occurs
     */
    public List<MaintenanceReport> getMaintenanceReports() throws SQLException {
        List<MaintenanceReport> list = new ArrayList<>();
        String sql = "SELECT vehicleNumber, component, status, nextServiceDate FROM MaintenanceLog";
        PreparedStatement stmt = conn.prepareStatement(sql);
        ResultSet rs = stmt.executeQuery();
        while (rs.next()) {
            list.add(new MaintenanceReport(
                rs.getString("vehicleNumber"),
                rs.getString("component"),
                rs.getString("status"),
                rs.getString("nextServiceDate")
            ));
        }
        return list;
    }

    /**
     * Gets operator performance stats grouped by operator.
     *
     * @return list of operator stats
     * @throws SQLException if a database error occurs
     */
    public List<OperatorStats> getOperatorPerformance() throws SQLException {
        List<OperatorStats> list = new ArrayList<>();
        String sql = "SELECT operatorId, AVG(onTimeRate) AS avgRate, COUNT(*) AS totalTrips FROM OperatorLog GROUP BY operatorId";
        PreparedStatement stmt = conn.prepareStatement(sql);
        ResultSet rs = stmt.executeQuery();
        while (rs.next()) {
            list.add(new OperatorStats(
                rs.getString("operatorId"),
                rs.getDouble("avgRate"),
                rs.getInt("totalTrips")
            ));
        }
        return list;
    }
}