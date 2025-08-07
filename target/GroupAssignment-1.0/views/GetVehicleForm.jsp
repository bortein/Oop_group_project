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
          form *{margin-top: 2px; font-size: 1.2rem}
          .textfield{display:flex; flex-direction: column;}
          body{background-color: #F0FAFF; font-family: sans-serif; margin:20%;}
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
