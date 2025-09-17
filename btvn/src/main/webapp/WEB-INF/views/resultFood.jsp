<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <title>Kết quả lựa chọn</title>
</head>
<body>
<h2>Bạn đã chọn:</h2>

<c:if test="${empty selectedFoods}">
  <p>Không có món ăn nào được chọn.</p>
</c:if>

<c:if test="${not empty selectedFoods}">
  <ul>
    <c:forEach var="f" items="${selectedFoods}">
      <li>${f.name}</li>
    </c:forEach>
  </ul>
</c:if>

<a href="<c:url value='/'/>">Quay lại chọn tiếp</a>
</body>
</html>
