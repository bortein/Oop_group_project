<%-- 
    Document   : RegisterVehicleForm
    Author     : Patricia Sunday
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Vehicle Registration</title>
        <style>
          form *{margin-top: 2px; font-size: 1.2rem}
          .textfield{display:flex; flex-direction: column;}
          body{background-color: #F0FAFF; font-family: sans-serif; margin:20%;}
        </style>
    </head>
    <body>
        <header>
            <h1>Enter Vehicle Details</h1>
        </header>
        <main>
            <form action="/GroupAssignment/LoginController" method="POST">
                <div class="textfield">
                    <label for="number">Vehicle Number</label>
                    <input type="text" name="number" id="number" placeholder="Vehicle Number here">
                </div>
                <div class="textfield">
                    <label for="vehicleType">User Type</label>
                    <select name="vehicleType">
                        <option value="DIESEL_BUS">DIESEL BUS</option>
                        <option value="ELECTRIC_LIGHT_RAIL">ELECTRIC LIGHT RAIL</option>
                        <option value="DIESEL_ELECTRIC_TRAIN">DIESEL ELECTRIC TRAIN</option>
                    </select>
                </div>
                 <div class="textfield">
                    <label for="fuelType">Fuel Type</label>
                    <input type="text" name="fuelType" id="fuelType" placeholder="Fuel Type here">
                </div>
                <div class="textfield">
                    <label for="consumptionRate">Consumption Rate</label>
                    <input type="text" name="consumptionRate" id="consumptionRate" placeholder="Consumption Rate Here">
                </div>
                <div class="textfield">
                    <label for="maxPassengers">Max Passenger Count</label>
                    <input type="text" name="maxPassengers" id="maxPassengers" placeholder="Max Passenger Count Here">
                </div>
                <div class="textfield">
                    <label for="route">Route</label>
                    <input type="text" name="route" id="route" placeholder="Route Here">
                </div>
                <br>
                <button type="submit" name="operation" value="registerVehicleProcess">Register Vehicle</button>
            </form>
        </main>
    </body>
</html>
