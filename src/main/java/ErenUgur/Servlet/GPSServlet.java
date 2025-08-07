// GPSServlet.java
package ErenUgur.Servlet;

import ErenUgur.Observer.DashboardObserver;
import ErenUgur.Service.GPSService;

import javax.servlet.annotation.WebServlet;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import java.io.IOException;

@WebServlet("/gps")
public class GPSServlet extends HttpServlet {
    private GPSService gpsService;

    @Override
    public void init() throws ServletException {
        gpsService = new GPSService();
        gpsService.addObserver(new DashboardObserver()); // Attach observer
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int vehicleId = Integer.parseInt(req.getParameter("vehicleId"));
        double latitude = Double.parseDouble(req.getParameter("latitude"));
        double longitude = Double.parseDouble(req.getParameter("longitude"));

        gpsService.updateLocation(vehicleId, latitude, longitude);

        resp.setContentType("text/html");
        resp.getWriter().println("<h3>GPS location updated successfully for Vehicle " + vehicleId + "</h3>");
    }
}