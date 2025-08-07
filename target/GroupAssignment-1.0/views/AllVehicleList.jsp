<%-- 
    Document   : AllVehicleList
    Author     : Patricia Sunday
--%>

<%@page import="java.util.List"%>
<%@page import="transferobjects.VehicleDTO"%>
<% List<VehicleDTO> vehicles = (List<VehicleDTO>) session.getAttribute("vehicles");%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Vehicles List</title>
        <style>
            body {
                margin: 0; 
                font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
                background-color: #f0f4f8;
                color: #333;
            }
            header {
                background-color: #007BFF;
                color: white;
                padding: 20px 0;
                text-align: center;
                font-size: 1.2rem;
                font-weight: bold;
                letter-spacing: 1.5px;
            }
            main {
                max-width: 900px;
                margin: 40px auto;
                background: white;
                border-radius: 8px;
                padding: 40px 30px;
                box-shadow: 0 6px 15px rgba(0, 0, 0, 0.1);
                display: flex;
                flex-direction: row;
            }
            main p {
                font-size: 1.1rem;
                line-height: 1.6;
                color: #555;
            }
            .btn {
                background-color: #007BFF;
                color: white;
                padding: 14px 32px;
                text-decoration: none;
                font-weight: 600;
                border-radius: 6px;
                font-size: 1rem;
                box-shadow: 0 3px 7px rgba(0, 123, 255, 0.4);
                transition: background-color 0.3s ease;
            }
            .btn:hover {
                background-color: #0056b3;
            }
        </style>
    </head>
    <body>
        <header>
            <h1>List of Vehicles</h1>
        </header>
        <main>
            <%if (vehicles == null || vehicles.isEmpty()) {%>
                <p><em>No authors found in the database.</em></p>
            <% } else { %>
                <%for (VehicleDTO vehicle : vehicles) { %>
                   <table border="2">
                        <tr><th><strong>Vehicle ID: <%=vehicle.getId()%></strong></th></tr>
                        <tr><th><strong>Number: <%=vehicle.getNumber()%></strong></th></tr>
                        <tr><th><strong>Type: <%=vehicle.getType().toString()%></strong></th></tr>
                        <tr><th><strong>Consumption Rate: <%=vehicle.getConsumptionRate()%></strong></th></tr>
                        <tr><th><strong>Fuel Type: <%=vehicle.getFuelType().toString()%></strong></th></tr>
                        <tr><th><strong>Maximum Passengers: <%=vehicle.getMaxPassengers()%></strong></th></tr>
                        <tr><th><strong>Route: <%=vehicle.getRoute()%></strong></th></tr>
                   </table>
                <%}%>
            <%}%>
        </main>
    </body>
</html>
