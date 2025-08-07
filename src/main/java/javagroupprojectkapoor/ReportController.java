package javagroupprojectkapoor;

import dataAccessLayer.DBConnection;
import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;
import java.sql.*;

/**
 * Servlet that handles report requests and forwards data to the JSP page.
 */
public class ReportController extends HttpServlet {

    /**
     * Handles GET requests to generate report data and forward it to the view.
     *
     * @param request  the HTTP request
     * @param response the HTTP response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try (Connection conn = DBConnection.getConnection()) {
            ReportDAO dao = new ReportDAO(conn);

            ReportBuilder builder = new ReportBuilder()
                .setFuelReports(dao.getFuelUsageReport())
                .setMaintenanceReports(dao.getMaintenanceReports())
                .setOperatorReports(dao.getOperatorPerformance());

            ReportBuilder.Reports reports = builder.build();

            request.setAttribute("fuelReports", reports.getFuelReports());
            request.setAttribute("maintenanceReports", reports.getMaintenanceReports());
            request.setAttribute("operatorReports", reports.getOperatorReports());

            RequestDispatcher rd = request.getRequestDispatcher("/manager/reports.jsp");
            rd.forward(request, response);

        } catch (Exception e) {
            e.printStackTrace();
            response.setContentType("text/plain");
            response.getWriter().println("Error: " + e.getMessage());
        }
    }
}