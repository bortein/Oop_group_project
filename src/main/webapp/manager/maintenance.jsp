<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head><title>Maintenance Report</title></head>
<body>
  <h1>Maintenance Report</h1>
  <table border="1" cellpadding="6">
    <tr><th>Vehicle Number</th><th>Component</th><th>Status</th><th>Next Service Date</th></tr>
    <c:forEach var="r" items="${maintenanceReports}">
      <tr>
        <td>${r.vehicleNumber}</td>
        <td>${r.component}</td>
        <td>${r.status}</td>
        <td>${r.nextServiceDate}</td>
      </tr>
    </c:forEach>
  </table>
  <p><a href="${pageContext.request.contextPath}/">Back</a></p>
</body>
</html>
