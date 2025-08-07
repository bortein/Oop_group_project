<!DOCTYPE html>
<html>
<head>
    <title>Login ? CST8288 Assignment</title>
    <style>
        body { font-family: Arial, sans-serif; background-color: #f2f2f2; text-align: center; margin-top: 50px; }
        input[type="text"], input[type="password"] { padding: 8px; width: 200px; margin: 5px auto; display: block; }
        input[type="submit"] { padding: 10px 20px; margin: 10px; }
        h2 { margin-bottom: 20px; }
        .button-row { margin-top: 20px; }
    </style>
</head>
<body>
    <h2>Enter DBMS Credentials</h2>

    <form method="get" action="controller">
        <input type="text" name="username" placeholder="Username" required />
        <input type="password" name="password" placeholder="Password" required />

        <div class="button-row">
            <input type="submit" name="action" value="GetAllAuthorsServlet" />
            <input type="submit" name="action" value="getAuthorById" />
            <input type="submit" name="action" value="addAuthor" />
            <input type="submit" name="action" value="updateAuthor" />
            <input type="submit" name="action" value="deleteAuthor" />
        </div>
    </form>

    <br><br>
    <p>
        Program by: Eren Ugur 041112121<br>
        For: 25S CST8288 Section 020 Assignment 2
    </p>
</body>
</html>