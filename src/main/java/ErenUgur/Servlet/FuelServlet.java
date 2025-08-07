// FuelServlet.java
package ErenUgur.Servlet;

import ErenUgur.Service.FuelService;
import ErenUgur.Strategy.BusFuelStrategy;
import ErenUgur.Strategy.LightRailEnergyStrategy;
import ErenUgur.Strategy.TrainFuelStrategy;
import model.Vehicle;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet("/fuel")
public class FuelServlet extends HttpServlet {
    private FuelService fuelService;

    @Override
    public void init() throws ServletException {
        fuelService = new FuelService();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int vehicleId = Integer.parseInt(req.getParameter("vehicleId"));
        String type = req.getParameter("type");
        String fuelType = req.getParameter("fuelType");
        double fuelRate = Double.parseDouble(req.getParameter("fuelRate"));
        double distance = Double.parseDouble(req.getParameter("distance"));

        Vehicle vehicle = new Vehicle(vehicleId, type, fuelType, fuelRate);

        switch (type.toLowerCase()) {
            case "diesel bus":
                fuelService.logFuelUsage(vehicle, distance, new BusFuelStrategy());
                break;
            case "electric light rail":
                fuelService.logFuelUsage(vehicle, distance, new LightRailEnergyStrategy());
                break;
            case "diesel-electric train":
                fuelService.logFuelUsage(vehicle, distance, new TrainFuelStrategy());
                break;
            default:
                resp.getWriter().println("<h3>Error: Unknown vehicle type</h3>");
                return;
        }

        resp.setContentType("text/html");
        resp.getWriter().println("<h3>Fuel usage logged successfully for Vehicle " + vehicleId + "</h3>");
    }
}