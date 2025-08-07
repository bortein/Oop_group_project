<%-- 
    Document   : RegistrationForm
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
        <header>
            <h1>Enter Your Details</h1>
        </header>
        <main>
            <form action="../LoginController" method="POST">
                <div class="textfield">
                    <label for="name">Full Name</label>
                    <input type="text" name="name" id="name" placeholder="Full Name">
                </div>
                <div class="textfield">
                    <label for="email">Email Address</label>
                    <input type="text" name="email" id="email" placeholder="Email">
                </div>
                <div class="textfield">
                    <label for="password">Password</label>
                    <input type="password" name="password" id="password" placeholder="Password">
                </div>
                <div class="textfield">
                    <label for="usertype">User Type</label>
                    <select name="usertype">
                        <option value="MANAGER">MANAGER</option>
                        <option value="OPERATOR">OPERATOR</option>
                    </select>
                </div>
                <br>
                <button type="submit" name="operation" value="register">Sign Up</button>
            </form>
        </main>
    </body>
</html>
