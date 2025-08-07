package ErenUgur.Servlet;

import ErenUgur.DAO.GPSDAO;
import ErenUgur.model.GPSLocation;
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
        html.append("    <html>\n" + "    <head>\n" + "        <title>Enter Vehicle ID</title>\n" + "        <style>\n" + "            body {\n" + "                font-family: Arial, sans-serif;\n" + "                background-color: #f4f4f4;\n" + "                margin: 0;\n" + "                padding: 0;\n" + "                display: flex;\n" + "                justify-content: center;\n" + "                align-items: center;\n" + "                height: 100vh;\n" + "            }\n" + "            .container {\n" + "                background: white;\n" + "                padding: 30px 40px;\n" + "                border-radius: 10px;\n" + "                box-shadow: 0 0 10px rgba(0,0,0,0.1);\n" + "                text-align: center;\n" + "            }\n" + "            h2 {\n" + "                margin-bottom: 20px;\n" + "                color: #333;\n" + "            }\n" + "            label, input {\n" + "                display: block;\n" + "                margin: 10px auto;\n" + "                font-size: 16px;\n" + "            }\n" + "            input[type=\"number\"], input[type=\"submit\"] {\n" + "                padding: 10px;\n" + "                width: 80%;\n" + "                border: 1px solid #ccc;\n" + "                border-radius: 5px;\n" + "            }\n" + "            input[type=\"submit\"] {\n" + "                background-color: #007bff;\n" + "                color: white;\n" + "                cursor: pointer;\n" + "                transition: background-color 0.3s ease;\n" + "            }\n" + "            input[type=\"submit\"]:hover {\n" + "                background-color: #0056b3;\n" + "            }\n" + "        </style>\n" + "    </head>\n" + "    <body>\n" + "        <div class='container'>\n" + "            <h2>Enter Vehicle ID to View GPS Logs</h2>\n" + "            <form method='post' action='gps'>\n" + "                <label for='vehicleId'>Vehicle ID:</label>\n" + "                <input type='number' name='vehicleId' id='vehicleId' required>\n" + "                <input type='submit' value='Show GPS Logs'>\n" + "            </form>\n" + "        </div>\n" + "    </body>\n" + "    </html>\n");

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
            html.append("    <html>\n" + "    <head>\n" + "        <title>GPS Logs</title>\n" + "        <style>\n" + "            body {\n" + "                font-family: Arial, sans-serif;\n" + "                background-color: #f4f4f4;\n" + "                padding: 20px;\n" + "            }\n" + "            .container {\n" + "                max-width: 800px;\n" + "                margin: auto;\n" + "                background: white;\n" + "                padding: 20px 30px;\n" + "                border-radius: 10px;\n" + "                box-shadow: 0 0 10px rgba(0,0,0,0.1);\n" + "            }\n" + "            h2 {\n" + "                color: #333;\n" + "                text-align: center;\n" + "            }\n" + "            a {\n" + "                display: inline-block;\n" + "                margin-bottom: 20px;\n" + "                color: #007bff;\n" + "                text-decoration: none;\n" + "            }\n" + "            a:hover {\n" + "                text-decoration: underline;\n" + "            }\n" + "            table {\n" + "                width: 100%;\n" + "                border-collapse: collapse;\n" + "                margin-top: 20px;\n" + "            }\n" + "            th, td {\n" + "                border: 1px solid #ccc;\n" + "                padding: 10px;\n" + "                text-align: center;\n" + "            }\n" + "            th {\n" + "                background-color: #007bff;\n" + "                color: white;\n" + "            }\n" + "            p {\n" + "                text-align: center;\n" + "                font-size: 18px;\n" + "                color: #555;\n" + "            }\n" + "        </style>\n" + "    </head>\n" + "    <body>\n" + "        <div class='container'>\n");

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
