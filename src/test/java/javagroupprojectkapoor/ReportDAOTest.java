package javagroupprojectkapoor;

import javagroupprojectkapoor.data.DBConnection;
import javagroupprojectkapoor.data.ReportDAO;
import javagroupprojectkapoor.buisness.model.OperatorStats;
import javagroupprojectkapoor.buisness.model.FuelUsageReport;
import javagroupprojectkapoor.buisness.model.MaintenanceReport;
import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class ReportDAOTest {

    @Test
    public void testGetFuelUsageReportFromDatabase() throws Exception {
        try (Connection conn = DBConnection.getConnection()) {
            ReportDAO dao = new ReportDAO(conn);
            List<FuelUsageReport> result = dao.getFuelUsageReport();

            assertFalse(result.isEmpty(), "Fuel usage report should not be empty");
            FuelUsageReport sample = result.get(0);
            System.out.println("Vehicle: " + sample.getVehicleType() +
                               ", Consumption: " + sample.getTotalConsumption() +
                               ", Cost: " + sample.getTotalCost());
        }
    }

    @Test
    public void testGetMaintenanceReportsFromDatabase() throws Exception {
        try (Connection conn = DBConnection.getConnection()) {
            ReportDAO dao = new ReportDAO(conn);
            List<MaintenanceReport> result = dao.getMaintenanceReports();

            assertFalse(result.isEmpty(), "Maintenance report should not be empty");
            MaintenanceReport sample = result.get(0);
            System.out.println("Vehicle: " + sample.getVehicleNumber() +
                               ", Component: " + sample.getComponent() +
                               ", Status: " + sample.getStatus() +
                               ", Next Service: " + sample.getNextServiceDate());
        }
    }

    @Test
    public void testGetOperatorPerformanceFromDatabase() throws Exception {
        try (Connection conn = DBConnection.getConnection()) {
            ReportDAO dao = new ReportDAO(conn);
            List<OperatorStats> result = dao.getOperatorPerformance();

            assertFalse(result.isEmpty(), "Operator performance report should not be empty");
            OperatorStats sample = result.get(0);
            System.out.println("Operator: " + sample.getOperatorId() +
                               ", On-Time Rate: " + sample.getOnTimeRate() +
                               ", Trips: " + sample.getTripsCompleted());
        }
    }
}
