<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.*, javagroupprojectkapoor.*" %>
<%@ page import="javagroupprojectkapoor.buisness.mode.FuelUsageReport" %>
<html>
<head>
    <title>Transit Reporting & Analytics</title>
</head>
<body>
    <h1> Fuel Usage Report</h1>
    <table border="1">
        <tr>
            <th>Vehicle Type</th>
            <th>Total Consumption</th>
            <th>Total Cost</th>
        </tr>
        <%
            List<FuelUsageReport> fuelReports = (List<FuelUsageReport>) request.getAttribute("fuelReports");
            if (fuelReports != null) {
                for (FuelUsageReport report : fuelReports) {
        %>
        <tr>
            <td><%= report.getVehicleType() %></td>
            <td><%= report.getTotalConsumption() %></td>
            <td><%= report.getTotalCost() %></td>
        </tr>
        <%      }
            }
        %>
    </table>

    <h1>Maintenance Report</h1>
    <table border="1">
        <tr>
            <th>Vehicle Number</th>
            <th>Component</th>
            <th>Status</th>
            <th>Next Service Date</th>
        </tr>
        <%
            List<MaintenanceReport> maintenanceReports = (List<MaintenanceReport>) request.getAttribute("maintenanceReports");
            if (maintenanceReports != null) {
                for (MaintenanceReport report : maintenanceReports) {
        %>
        <tr>
            <td><%= report.getVehicleNumber() %></td>
            <td><%= report.getComponent() %></td>
            <td><%= report.getStatus() %></td>
            <td><%= report.getNextServiceDate() %></td>
        </tr>
        <%      }
            }
        %>
    </table>

    <h1>Operator Performance</h1>
    <table border="1">
        <tr>
            <th>Operator ID</th>
            <th>On-Time Rate (%)</th>
            <th>Total Trips</th>
        </tr>
        <%
            List<OperatorStats> operatorReports = (List<OperatorStats>) request.getAttribute("operatorReports");
            if (operatorReports != null) {
                for (OperatorStats stats : operatorReports) {
        %>
        <tr>
            <td><%= stats.getOperatorId() %></td>
            <td><%= stats.getOnTimeRate() %></td>
            <td><%= stats.getTripsCompleted() %></td>
        </tr>
        <%      }
            }
        %>
    </table>
</body>
</html>