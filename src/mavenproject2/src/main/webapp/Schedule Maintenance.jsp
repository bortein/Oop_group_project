<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Schedule Maintenance Task</title>
</head>
<body>
    <h2>Schedule Maintenance Task</h2>
    <form action="ScheduleMaintenanceServlet" method="post">
        <label for="vehicleId">Vehicle ID:</label>
        <input type="text" name="vehicleId" required><br><br>

        <label for="component">Component:</label>
        <select name="component">
            <option value="engine">Engine</option>
            <option value="pantograph">Pantograph</option>
            <option value="brakes">Brakes</option>
            <option value="circuitBreaker">Circuit Breaker</option>
        </select><br><br>

        <label for="taskDescription">Task Description:</label><br>
        <textarea name="taskDescription" rows="4" cols="50" required></textarea><br><br>

        <label for="scheduledDate">Scheduled Date:</label>
        <input type="date" name="scheduledDate" required><br><br>

        <input type="submit" value="Schedule Task">
    </form>
</body>
</html>

