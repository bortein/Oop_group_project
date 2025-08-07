package ErenUgur.Servlet;

import ErenUgur.DAO.FuelDAO;
import java.util.List;
import ErenUgur.model.FuelLog;

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

            out.println("    <html>\n" + "    <head>\n" + "        <title>Fuel Log Submission</title>\n" + "        <style>\n" + "            body {\n" + "                font-family: Arial, sans-serif;\n" + "                background-color: #f4f4f4;\n" + "                display: flex;\n" + "                justify-content: center;\n" + "                align-items: center;\n" + "                height: 100vh;\n" + "            }\n" + "            .container {\n" + "                background: white;\n" + "                padding: 30px 40px;\n" + "                border-radius: 10px;\n" + "                box-shadow: 0 0 10px rgba(0,0,0,0.1);\n" + "                text-align: center;\n" + "            }\n" + "            h3 {\n" + "                color: #333;\n" + "            }\n" + "            a {\n" + "                display: inline-block;\n" + "                margin-top: 20px;\n" + "                color: #007bff;\n" + "                text-decoration: none;\n" + "            }\n" + "            a:hover {\n" + "                text-decoration: underline;\n" + "            }\n" + "        </style>\n" + "    </head>\n" + "    <body>\n" + "        <div class=\"container\">\n");

            if (success) {
                out.println("<h3>✅ Fuel log successfully recorded.</h3>");
            } else {
                out.println("<h3>❌ Failed to record fuel log.</h3>");
            }

            out.println("<a href='fuel'>View All Fuel Logs</a>");
            out.println("</div></body></html>");

        } catch (Exception e) {
            
            out.println("    <html><head><title>Error</title>\n" + "    <style>\n" + "        body {\n" + "            font-family: Arial, sans-serif;\n" + "            background-color: #f4f4f4;\n" + "            display: flex;\n" + "            justify-content: center;\n" + "            align-items: center;\n" + "            height: 100vh;\n" + "        }\n" + "        .container {\n" + "            background: white;\n" + "            padding: 30px 40px;\n" + "            border-radius: 10px;\n" + "            box-shadow: 0 0 10px rgba(0,0,0,0.1);\n" + "            text-align: center;\n" + "            color: red;\n" + "        }\n" + "        a {\n" + "            display: inline-block;\n" + "            margin-top: 20px;\n" + "            color: #007bff;\n" + "            text-decoration: none;\n" + "        }\n" + "    </style>\n" + "    </head><body>\n" + "    <div class=\"container\">\n");
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

        out.println("    <html>\n" + "    <head>\n" + "        <title>Fuel Logs</title>\n" + "        <style>\n" + "            body {\n" + "                font-family: Arial, sans-serif;\n" + "                background-color: #f4f4f4;\n" + "                padding: 20px;\n" + "            }\n" + "            .container {\n" + "                max-width: 900px;\n" + "                margin: auto;\n" + "                background: white;\n" + "                padding: 20px 30px;\n" + "                border-radius: 10px;\n" + "                box-shadow: 0 0 10px rgba(0,0,0,0.1);\n" + "            }\n" + "            h2 {\n" + "                text-align: center;\n" + "                color: #333;\n" + "            }\n" + "            table {\n" + "                width: 100%;\n" + "                border-collapse: collapse;\n" + "                margin-top: 20px;\n" + "            }\n" + "            th, td {\n" + "                border: 1px solid #ccc;\n" + "                padding: 10px;\n" + "                text-align: center;\n" + "            }\n" + "            th {\n" + "                background-color: #007bff;\n" + "                color: white;\n" + "            }\n" + "        </style>\n" + "    </head>\n" + "    <body>\n" + "        <div class=\"container\">\n" + "            <h2>Fuel Logs</h2>\n" + "            <table>\n" + "                <tr>\n" + "                    <th>ID</th>\n" + "                    <th>Vehicle ID</th>\n" + "                    <th>Fuel Used</th>\n" + "                    <th>Distance</th>\n" + "                    <th>Log Time</th>\n" + "                </tr>\n");

        for (FuelLog log : logs) {
            out.println("<tr>");
            out.println("<td>" + log.getId() + "</td>");
            out.println("<td>" + log.getVehicleId() + "</td>");
            out.println("<td>" + log.getFuelUsed() + "</td>");
            out.println("<td>" + log.getDistance() + "</td>");
            out.println("<td>" + log.getLogTime() + "</td>");
            out.println("</tr>");
        }

        out.println("            </table>\n" + "        </div>\n" + "    </body>\n" + "    </html>\n");
    }
}
