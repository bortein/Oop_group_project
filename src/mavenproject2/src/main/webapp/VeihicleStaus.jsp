<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.List" %>
+ <%@ page import="com.ptfms.model.VehicleStatus" %>
<%
    List<VehicleStatus> statuses = (List<VehicleStatus>) request.getAttribute("statuses");
%>
<html>
<head>
    <title>Fleet Dashboard</title>
</head>
<body>
    <h2>Fleet Status Dashboard</h2>
    <table border="1">
        <tr>
            <th>Vehicle ID</th>
            <th>Status</th>
            <th>Last Maintenance</th>
            <th>Next Scheduled</th>
            <th>Component Health</th>
        </tr>
        <%
            if (statuses != null) {
                for (VehicleStatus status : statuses) {
        %>
        <tr>
            <td><%= status.getVehicleId() %></td>
            <td><%= status.getStatus() %></td>
            <td><%= status.getLastMaintenanceDate() %></td>
            <td><%= status.getNextScheduledDate() %></td>
            <td><%= status.getComponentHealthSummary() %></td>
        </tr>
        <%
                }
            } else {
        %>
        <tr><td colspan="5">No vehicle data available.</td></tr>
        <%
            }
        %>
    </table>
</body>
</html>
