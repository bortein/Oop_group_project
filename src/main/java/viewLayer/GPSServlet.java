package viewLayer;

import dataAccessLayer.GPSDAO;
import transferObjects.GPSLocation;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class GPSServlet extends HttpServlet {

    private final GPSDAO gpsDAO = new GPSDAO();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        resp.setCharacterEncoding("UTF-8");

        StringBuilder html = new StringBuilder();
        html.append("""
            <html>
            <head>
                <title>Enter Vehicle ID</title>
                <style>
                    body {
                        font-family: Arial, sans-serif;
                        background-color: #f4f4f4;
                        margin: 0;
                        padding: 0;
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
                    h2 {
                        margin-bottom: 20px;
                        color: #333;
                    }
                    label, input {
                        display: block;
                        margin: 10px auto;
                        font-size: 16px;
                    }
                    input[type="number"], input[type="submit"] {
                        padding: 10px;
                        width: 80%;
                        border: 1px solid #ccc;
                        border-radius: 5px;
                    }
                    input[type="submit"] {
                        background-color: #007bff;
                        color: white;
                        cursor: pointer;
                        transition: background-color 0.3s ease;
                    }
                    input[type="submit"]:hover {
                        background-color: #0056b3;
                    }
                </style>
            </head>
            <body>
                <div class='container'>
                    <h2>Enter Vehicle ID to View GPS Logs</h2>
                    <form method='post' action='gps'>
                        <label for='vehicleId'>Vehicle ID:</label>
                        <input type='number' name='vehicleId' id='vehicleId' required>
                        <input type='submit' value='Show GPS Logs'>
                    </form>
                </div>
            </body>
            </html>
        """);

        resp.getWriter().write(html.toString());
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String vehicleIdStr = req.getParameter("vehicleId");
        if (vehicleIdStr == null) {
            resp.sendError(HttpServletResponse.SC_BAD_REQUEST, "Vehicle ID is required");
            return;
        }

        try {
            int vehicleId = Integer.parseInt(vehicleIdStr);
            List<GPSLocation> locations = gpsDAO.getLocationsByVehicleId(vehicleId);

            resp.setContentType("text/html");
            resp.setCharacterEncoding("UTF-8");

            StringBuilder html = new StringBuilder();
            html.append("""
                <html>
                <head>
                    <title>GPS Logs</title>
                    <style>
                        body {
                            font-family: Arial, sans-serif;
                            background-color: #f4f4f4;
                            padding: 20px;
                        }
                        .container {
                            max-width: 800px;
                            margin: auto;
                            background: white;
                            padding: 20px 30px;
                            border-radius: 10px;
                            box-shadow: 0 0 10px rgba(0,0,0,0.1);
                        }
                        h2 {
                            color: #333;
                            text-align: center;
                        }
                        a {
                            display: inline-block;
                            margin-bottom: 20px;
                            color: #007bff;
                            text-decoration: none;
                        }
                        a:hover {
                            text-decoration: underline;
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
                        p {
                            text-align: center;
                            font-size: 18px;
                            color: #555;
                        }
                    </style>
                </head>
                <body>
                    <div class='container'>
            """);

            html.append("<h2>GPS Logs for Vehicle ID: ").append(vehicleId).append("</h2>");
            html.append("<a href='gps'>&larr; Back</a><br>");

            if (locations.isEmpty()) {
                html.append("<p>No GPS log data found for this vehicle.</p>");
            } else {
                html.append("<table>");
                html.append("<tr><th>Latitude</th><th>Longitude</th><th>Timestamp</th></tr>");

                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
                for (GPSLocation loc : locations) {
                    html.append("<tr>")
                        .append("<td>").append(loc.getLatitude()).append("</td>")
                        .append("<td>").append(loc.getLongitude()).append("</td>")
                        .append("<td>").append(loc.getTimestamp().toLocalDateTime().format(formatter)).append("</td>")
                        .append("</tr>");
                }

                html.append("</table>");
            }

            html.append("</div></body></html>");
            resp.getWriter().write(html.toString());

        } catch (NumberFormatException e) {
            resp.sendError(HttpServletResponse.SC_BAD_REQUEST, "Invalid vehicle ID format");
        }
    }
}
