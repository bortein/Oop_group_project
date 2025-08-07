<%-- 
    Document   : ManageMenu
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
            <button type="submit" name="operation" onclick="window.location.href='VehicleMenu'">Manage Vehicles</button>
            <br>
            <button type="submit" name="operation" onclick="window.location.href='<%--add path here--%>'">GPS Tracking</button>
            <br>
            <button type="submit" name="operation" onclick="window.location.href='<%--add path here--%>'">Performance Dashboard</button>
        </form>
    </body>
</html>
