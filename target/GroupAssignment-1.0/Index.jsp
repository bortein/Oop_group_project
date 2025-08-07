<%-- 
    Document   : Login
    Created on : Aug 7, 2025, 12:24:16 p.m.
    Author     : patri
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>User Login</title>  
        <style>
          form *{margin-top: 2px; font-size: 1.2rem}
          .textfield{display:flex; flex-direction: column;}
          body{background-color: #F0FAFF; font-family: sans-serif; margin:20%;}
        </style>
    </head>
    <body>
        <h1>Welcome, Enter Login Details</h1>
        <form action="/GroupAssignment/LoginController" method="POST">
            <div class="textfield">
                <label for="email">Email:</label>
                <input type="text" id="email" name="email" placeholder="Enter email here">
            </div>
            <div class="textfield">
                <label for="password">Password:</label>
                <input type="password" id="password" name="password" placeholder="Enter password here">
            </div>
            <br>
            <button type="submit" name="operation" value="login">Login</button>
            <button type="button" onclick="window.location.href='views/RegistrationForm.jsp'">Sign Up</button>
            
            <%--show error message if it exists--%>
            <%if(request.getAttribute("error") != null){%>
                <p style="color:red;"><%= request.getAttribute("error") %></p>
            <%}%>

        </form>
    </body>
</html>
