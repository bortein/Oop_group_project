<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head><title>Operator Performance</title></head>
<body>
  <h1>Operator Performance</h1>
  <table border="1" cellpadding="6">
    <tr><th>Operator ID</th><th>On-Time Rate (%)</th><th>Total Trips</th></tr>
    <c:forEach var="r" items="${operatorReports}">
      <tr>
        <td>${r.operatorId}</td>
        <td>${r.onTimeRate}</td>
        <td>${r.tripsCompleted}</td>
      </tr>
    </c:forEach>
  </table>
  <p><a href="${pageContext.request.contextPath}/">Back</a></p>
</body>
</html>
