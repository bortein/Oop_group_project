<%-- 
    Document   : ManageMenu
    Author     : Patricia Sunday
--%>
<%--store user from session attribute--%>
<% transferobjects.UserDTO user = (transferobjects.UserDTO) session.getAttribute("user");%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Manager Menu</title>
        <style>
          form *{margin-top: 2px; font-size: 1.2rem}
          .textfield{display:flex; flex-direction: column;}
          body{background-color: #F0FAFF; font-family: sans-serif; margin:20%;}
        </style>
    </head>
    <body>
        <header>
            <form action="/GroupAssignment/LoginController">
                <button name="operation" value="logout">Logout</button>
            </form>
            <h1>Hello <%=user.getName()%>!</h1>
        </header>
        <main>
            <form action="../LoginController" method="POST">
                <button type="submit" name="operation" value="manageVehicles">Manage Vehicles</button>
                <br>
                <button type="submit" name="operation" value="<%--add value here--%>">GPS Tracking</button>
                <br>
                <button type="submit" name="operation" value="<%--add value here--%>">Performance Dashboard</button>
            </form>
        </main>
    </body>
</html>
