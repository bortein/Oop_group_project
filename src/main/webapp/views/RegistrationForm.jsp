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
                font-size: 1.2rem;
                font-weight: bold;
                letter-spacing: 1.5px;
            }
            main {
                max-width: 900px;
                margin: 40px auto;
                background: white;
                border-radius: 8px;
                padding: 40px 30px;
                box-shadow: 0 6px 15px rgba(0, 0, 0, 0.1);
            }
            main p {
                font-size: 1.1rem;
                line-height: 1.6;
                color: #555;
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
                <button type="submit" name="operation" value="register" class="btn">Sign Up</button>
            </form>
        </main>
    </body>
</html>
