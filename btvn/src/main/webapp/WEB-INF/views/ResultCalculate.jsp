<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
  <title>Kết quả</title>
</head>
<body>
<h2>Kết quả:</h2>
<c:if test="${not empty error}">
  <p style="color: red;">${error}</p>
</c:if>
<c:if test="${not empty result}">
  <p>Kết quả phép tính là: <strong>${result}</strong></p>
</c:if>

<a href="<c:url value='/'/>">Quay lại</a>
</body>
</html>