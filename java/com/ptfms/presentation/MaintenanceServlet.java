package com.ptfms.presentation;

import com.ptfms.business.service.MaintenanceService;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import java.io.IOException;

public class MaintenanceServlet extends HttpServlet {
    private final MaintenanceService service = new MaintenanceService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
                       throws ServletException, IOException {
        String vehicleId = req.getParameter("vehicleId");
        try {
            service.checkAndSchedule(vehicleId);
            req.setAttribute("message", "Checked maintenance for " + vehicleId);
        } catch (Exception ex) {
            req.setAttribute("error", ex.getMessage());
        }
        RequestDispatcher rd = req.getRequestDispatcher("/maintenance.jsp");
        rd.forward(req, resp);
    }
}