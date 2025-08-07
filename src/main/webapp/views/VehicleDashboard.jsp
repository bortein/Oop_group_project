<%-- 
    Document   : VehicleDashboard
    Author     : Patricia Sunday
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Vehicle Dashboard</title>
        <style>
          form *{margin-top: 2px; font-size: 1.2rem}
          .textfield{display:flex; flex-direction: column;}
          body{background-color: #F0FAFF; font-family: sans-serif; margin:20%;}
        </style>
    </head>
    <body>
        <header>
            <h1>Pick an Action</h1>
        </header>
        <main>
            <form action="/GroupAssignment/LoginController" method="POST">
                <button type="submit" name="operation" value="registerVehicle">Register Vehicle</button>
                <br>
                <button type="submit" name="operation" value="updateVehicle">Update Vehicle</button> <input type="text" name="updateNumber">
                <br>
                <button type="submit" name="operation" value="deleteVehicle">Delete Vehicle</button>
                <br>
                <button type="submit" name="operation" value="viewVehicle">View Vehicle</button>
                <br>
                <button type="submit" name="operation" value="viewAllVehicles">View All Vehicles</button>
            </form>
        </main>
    </body>
</html>
