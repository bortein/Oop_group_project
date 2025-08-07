<%-- 
    Document   : VehicleDashboard
    Author     : Patricia Sunday
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>User Registration</title>
        <style>
          form *{margin-top: 2px; font-size: 1.2rem}
          .textfield{display:flex; flex-direction: column;}
          body{background-color: #F0FAFF; font-family: sans-serif; margin:20%;}
        </style>
    </head>
    <body>
        <h1>Enter Your Details</h1>
        <form action="../ManagerServlet" method="POST">
            <button type="submit" name="operation" onclick="window.location.href='<%--add path here--%>'">Register Vehicle</button>
            <br>
            <button type="submit" name="operation" onclick="window.location.href='<%--add path here--%>'">Update Vehicle</button>
            <br>
            <button type="submit" name="operation" onclick="window.location.href='<%--add path here--%>'">Delete Vehicle</button>
            <br>
            <button type="submit" name="operation" onclick="window.location.href='<%--add path here--%>'">View Vehicle</button>
            <br>
            <button type="submit" name="operation" onclick="window.location.href='<%--add path here--%>'">View All Vehicles</button>
        </form>
    </body>
</html>
