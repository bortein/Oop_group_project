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
            input{
                border: #333;
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
                <button type="submit" name="operation" value="registerVehicleProcess" class="btn">Register Vehicle</button>
            </form>
        </main>
    </body>
</html>
