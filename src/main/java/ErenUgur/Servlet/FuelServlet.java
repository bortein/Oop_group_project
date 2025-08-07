package ErenUgur.Servlet;

import dataAccessLayer.VehicleDAO;
import dataAccessLayer.VehicleDAO.Vehicle;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;

@WebServlet("/fuel")
public class FuelServlet extends HttpServlet {

    private VehicleDAO vehicleDAO;

    @Override
    public void init() throws ServletException {
        vehicleDAO = new VehicleDAO(); // Uses DBConnection internally
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();

        List<Vehicle> vehicles;
        try {
            vehicles = vehicleDAO.getAllVehicles();
        } catch (SQLException e) {
            resp.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            out.println("<h2>Database error: " + e.getMessage() + "</h2>");
            e.printStackTrace(out);
            return;
        }

        out.println("<!DOCTYPE html><html lang='en'><head><meta charset='UTF-8'>");
        out.println("<meta name='viewport' content='width=device-width, initial-scale=1.0'>");
        out.println("<title>Fuel Usage Report</title>");
        out.println("<style>");
        out.println("body { font-family: Arial, sans-serif; background:#f9f9f9; margin:0; padding:0; }");
        out.println(".container { max-width: 900px; margin: 40px auto; background: white; padding: 30px; border-radius: 8px; box-shadow:0 0 10px rgba(0,0,0,0.1);}");
        out.println("h1 { color:#007BFF; text-align:center; }");
        out.println("table { width: 100%; border-collapse: collapse; margin-top: 25px; }");
        out.println("th, td { padding: 12px; border-bottom: 1px solid #ddd; text-align: center; }");
        out.println("th { background-color: #007BFF; color: white; }");
        out.println(".low-fuel { color: red; font-weight: bold; }");
        out.println("</style></head><body>");
        out.println("<div class='container'>");
        out.println("<h1>Fleet Fuel Usage Report</h1>");

        if (vehicles.isEmpty()) {
            out.println("<p>No vehicle data found.</p>");
        } else {
            out.println("<table>");
            out.println("<thead><tr><th>Vehicle ID</th><th>Fuel Type</th><th>Fuel Level (%)</th><th>Status</th></tr></thead>");
            out.println("<tbody>");

            for (Vehicle v : vehicles) {
                String status = v.fuelLevel < 20.0 ? "<span class='low-fuel'>Low Fuel</span>" : "OK";
                out.printf("<tr><td>%s</td><td>%s</td><td>%.1f</td><td>%s</td></tr>%n",
                        v.vehicleId, v.fuelType, v.fuelLevel, status);
            }

            out.println("</tbody></table>");
        }

        out.println("</div></body></html>");
    }
}
