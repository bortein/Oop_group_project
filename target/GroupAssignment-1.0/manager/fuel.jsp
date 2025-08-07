<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head><title>Fuel Usage Report</title></head>
<body>
  <h1>Fuel Usage Report</h1>
  <table border="1" cellpadding="6">
    <tr><th>Vehicle Type</th><th>Total Consumption</th><th>Total Cost</th></tr>
    <c:forEach var="r" items="${fuelReports}">
      <tr>
        <td>${r.vehicleType}</td>
        <td>${r.totalConsumption}</td>
        <td>${r.totalCost}</td>
      </tr>
    </c:forEach>
  </table>
  <p><a href="${pageContext.request.contextPath}/">Back</a></p>
</body>
</html>