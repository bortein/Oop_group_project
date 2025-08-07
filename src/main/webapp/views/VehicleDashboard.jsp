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
            <form action="../" method="POST">
                <button type="submit" name="operation" value="">Register Vehicle</button>
                <br>
                <button type="submit" name="operation" value="">Update Vehicle</button>
                <br>
                <button type="submit" name="operation" value="">Delete Vehicle</button>
                <br>
                <button type="submit" name="operation" value="">View Vehicle</button>
                <br>
                <button type="submit" name="operation" value=""View All Vehicles</button>
            </form>
        </main>
    </body>
</html>
