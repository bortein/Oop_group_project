<%-- 
    Document   : GetVehicleForm
    Author     : Patricia Sunday
--%>
<%@page import="transferobjects.VehicleDTO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Vehicle Retrieval</title>
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
                font-size: 2rem;
                font-weight: bold;
                letter-spacing: 1.5px;
            }
            nav {
                background-color: #0056b3;
                display: flex;
                justify-content: center;
                gap: 30px;
                padding: 15px 0;
            }
            nav a {
                color: white;
                font-weight: 600;
                text-decoration: none;
                font-size: 1.1rem;
                transition: color 0.3s ease;
            }
            nav a:hover {
                color: #ffcc00;
            }
            main {
                max-width: 900px;
                margin: 40px auto;
                background: white;
                border-radius: 8px;
                padding: 40px 30px;
                box-shadow: 0 6px 15px rgba(0, 0, 0, 0.1);
                text-align: center;
            }
            main h2 {
                font-weight: 700;
                color: #007BFF;
                margin-bottom: 20px;
            }
            main p {
                font-size: 1.1rem;
                line-height: 1.6;
                color: #555;
            }
            .btn-group {
                margin-top: 35px;
                display: flex;
                justify-content: center;
                gap: 25px;
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
            footer {
                margin-top: 60px;
                text-align: center;
                color: #777;
                font-size: 0.9rem;
                padding-bottom: 20px;
            }
        </style>
    </head>
    <body>
        <header>
            <h1>Single Vehicle Retrieval</h1>
        </header>
        <main>
            <form action="/GroupAssignment/LoginController" method="POST">
                <%if(session.getAttribute("foundVehicle") == null){%>
                    <p>Enter vehicle number</p>
                    <div class="textfield">
                    <label for="number">Vehicle Number</label>
                    <input type="text" name="number" id="number" placeholder="Vehicle Number here">
                    <input type="submit" name="operation" value="viewVehicleProcess" hidden>
                    </div>
                <%}else{%>
                    <%--store found vehicle if exists in session--%>
                    <%VehicleDTO vehicle = (VehicleDTO )session.getAttribute("foundVehicle");%>
                    <table border="2">
                        <tr><th><strong>Vehicle ID: <%=vehicle.getId()%></strong></th></tr>
                        <tr><th><strong>Number: <%=vehicle.getNumber()%></strong></th></tr>
                        <tr><th><strong>Type: <%=vehicle.getType().toString()%></strong></th></tr>
                        <tr><th><strong>Consumption Rate: <%=vehicle.getConsumptionRate()%></strong></th></tr>
                        <tr><th><strong>Fuel Type: <%=vehicle.getFuelType().toString()%></strong></th></tr>
                        <tr><th><strong>Maximum Passengers: <%=vehicle.getMaxPassengers()%></strong></th></tr>
                        <tr><th><strong>Route: <%=vehicle.getRoute()%></strong></th></tr>
                   </table>
                   </table>
                <%}%>
        </main>
    </body>
</html>
