<%@page import="com.ptfms.model.MaintenanceAlert"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.List" %>
<%
    List<MaintenanceAlert> alerts = (List<MaintenanceAlert>) request.getAttribute("alerts");
%>
<html>
<head>
    <title>Active Maintenance Alerts</title>
</head>
<body>
    <h2>Active Maintenance Alerts</h2>
    <table border="1">
        <tr>
            <th>Vehicle ID</th>
            <th>Component</th>
            <th>Alert Type</th>
            <th>Message</th>
            <th>Timestamp</th>
        </tr>
        <%
            if (alerts != null) {
                for (MaintenanceAlert alert : alerts) {
        %>
        <tr>
            <td><%= alert.getVehicleId() %></td>
            <td><%= alert.getAlertType() %></td>
            <td><%= alert.getMessage() %></td>
            <td><%= alert.getTimestamp() %></td>
        </tr>
        <%
                }
            } else {
        %>
        <tr><td colspan="5">No alerts available.</td></tr>
        <%
            }
        %>
    </table>
</body>
</html>