package viewLayer;

import dataAccessLayer.FuelDAO;
import java.util.List;
import transferObjects.FuelLog;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Timestamp;

@WebServlet("/fuel")
public class FuelServlet extends HttpServlet {

    private final FuelDAO dao = new FuelDAO();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        try {
            int vehicleId = Integer.parseInt(request.getParameter("vehicle_id"));
            double fuelUsed = Double.parseDouble(request.getParameter("fuel_used"));
            double distance = Double.parseDouble(request.getParameter("distance"));
            String timestampStr = request.getParameter("timestamp");

            Timestamp timestamp = (timestampStr != null && !timestampStr.isEmpty())
                    ? Timestamp.valueOf(timestampStr)
                    : null;

            boolean success = dao.saveFuelLog(vehicleId, fuelUsed, distance, timestamp);

            out.println("""
                <html>
                <head>
                    <title>Fuel Log Submission</title>
                    <style>
                        body {
                            font-family: Arial, sans-serif;
                            background-color: #f4f4f4;
                            display: flex;
                            justify-content: center;
                            align-items: center;
                            height: 100vh;
                        }
                        .container {
                            background: white;
                            padding: 30px 40px;
                            border-radius: 10px;
                            box-shadow: 0 0 10px rgba(0,0,0,0.1);
                            text-align: center;
                        }
                        h3 {
                            color: #333;
                        }
                        a {
                            display: inline-block;
                            margin-top: 20px;
                            color: #007bff;
                            text-decoration: none;
                        }
                        a:hover {
                            text-decoration: underline;
                        }
                    </style>
                </head>
                <body>
                    <div class="container">
            """);

            if (success) {
                out.println("<h3>✅ Fuel log successfully recorded.</h3>");
            } else {
                out.println("<h3>❌ Failed to record fuel log.</h3>");
            }

            out.println("<a href='fuel'>View All Fuel Logs</a>");
            out.println("</div></body></html>");

        } catch (Exception e) {
            out.println("""
                <html><head><title>Error</title>
                <style>
                    body {
                        font-family: Arial, sans-serif;
                        background-color: #f4f4f4;
                        display: flex;
                        justify-content: center;
                        align-items: center;
                        height: 100vh;
                    }
                    .container {
                        background: white;
                        padding: 30px 40px;
                        border-radius: 10px;
                        box-shadow: 0 0 10px rgba(0,0,0,0.1);
                        text-align: center;
                        color: red;
                    }
                    a {
                        display: inline-block;
                        margin-top: 20px;
                        color: #007bff;
                        text-decoration: none;
                    }
                </style>
                </head><body>
                <div class="container">
            """);
            out.println("<h3>Error: " + e.getMessage() + "</h3>");
            out.println("<a href='fuel'>Back to Fuel Logs</a>");
            out.println("</div></body></html>");
            e.printStackTrace(out);
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        List<FuelLog> logs = dao.getAllFuelLogs();

        out.println("""
            <html>
            <head>
                <title>Fuel Logs</title>
                <style>
                    body {
                        font-family: Arial, sans-serif;
                        background-color: #f4f4f4;
                        padding: 20px;
                    }
                    .container {
                        max-width: 900px;
                        margin: auto;
                        background: white;
                        padding: 20px 30px;
                        border-radius: 10px;
                        box-shadow: 0 0 10px rgba(0,0,0,0.1);
                    }
                    h2 {
                        text-align: center;
                        color: #333;
                    }
                    table {
                        width: 100%;
                        border-collapse: collapse;
                        margin-top: 20px;
                    }
                    th, td {
                        border: 1px solid #ccc;
                        padding: 10px;
                        text-align: center;
                    }
                    th {
                        background-color: #007bff;
                        color: white;
                    }
                </style>
            </head>
            <body>
                <div class="container">
                    <h2>Fuel Logs</h2>
                    <table>
                        <tr>
                            <th>ID</th>
                            <th>Vehicle ID</th>
                            <th>Fuel Used</th>
                            <th>Distance</th>
                            <th>Log Time</th>
                        </tr>
        """);

        for (FuelLog log : logs) {
            out.println("<tr>");
            out.println("<td>" + log.getId() + "</td>");
            out.println("<td>" + log.getVehicleId() + "</td>");
            out.println("<td>" + log.getFuelUsed() + "</td>");
            out.println("<td>" + log.getDistance() + "</td>");
            out.println("<td>" + log.getLogTime() + "</td>");
            out.println("</tr>");
        }

        out.println("""
                    </table>
                </div>
            </body>
            </html>
        """);
    }
}
