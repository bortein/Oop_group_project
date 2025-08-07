package javagroupprojectkapoor.presentation;

import dataaccesslayer.DBConnection;
import javagroupprojectkapoor.data.ReportDAO;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import java.io.IOException;
import java.sql.Connection;

@WebServlet(urlPatterns = {"/kapoor/reports", "/kapoor/reports/*"})
public class ReportController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        String path = req.getPathInfo();    
        if (path == null || "/".equals(path)) {
         
            forwardAll(req, resp, "/manager/reports.jsp");
            return;
        }

        switch (path) {
            case "/fuel": forwardFuel(req, resp); break;
            case "/maintenance": forwardMaintenance(req, resp); break;
            case "/operators": forwardOperators(req, resp); break;
            default: resp.sendError(HttpServletResponse.SC_NOT_FOUND); break;
        }
    }

    private void forwardFuel(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        try (Connection conn = DBConnection.getConnection()) {
            ReportDAO dao = new ReportDAO(conn);
            req.setAttribute("fuelReports", dao.getFuelUsageReport());
            RequestDispatcher rd = req.getRequestDispatcher("/manager/fuel.jsp");
            rd.forward(req, resp);
        } catch (Exception e) {
            handleError(resp, e);
        }
    }

    private void forwardMaintenance(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        try (Connection conn = DBConnection.getConnection()) {
            ReportDAO dao = new ReportDAO(conn);
            req.setAttribute("maintenanceReports", dao.getMaintenanceReports());
            RequestDispatcher rd = req.getRequestDispatcher("/manager/maintenance.jsp");
            rd.forward(req, resp);
        } catch (Exception e) {
            handleError(resp, e);
        }
    }

    private void forwardOperators(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        try (Connection conn = DBConnection.getConnection()) {
            ReportDAO dao = new ReportDAO(conn);
            req.setAttribute("operatorReports", dao.getOperatorPerformance());
            RequestDispatcher rd = req.getRequestDispatcher("/manager/operators.jsp");
            rd.forward(req, resp);
        } catch (Exception e) {
            handleError(resp, e);
        }
    }

    private void forwardAll(HttpServletRequest req, HttpServletResponse resp, String jsp)
            throws ServletException, IOException {
        try (Connection conn = DBConnection.getConnection()) {
            ReportDAO dao = new ReportDAO(conn);
            req.setAttribute("fuelReports", dao.getFuelUsageReport());
            req.setAttribute("maintenanceReports", dao.getMaintenanceReports());
            req.setAttribute("operatorReports", dao.getOperatorPerformance());
            req.getRequestDispatcher(jsp).forward(req, resp);
        } catch (Exception e) {
            handleError(resp, e);
        }
    }

    private void handleError(HttpServletResponse resp, Exception e) throws IOException {
        getServletContext().log("Error generating reports", e);
        resp.setContentType("text/plain");
        resp.getWriter().println("Error: " + e.getMessage());
    }
}
