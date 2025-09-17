<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <title>Chọn món ăn</title>
</head>
<body>
<h2>Chọn món ăn của bạn:</h2>

<form action="save" method="post">
  <c:forEach var="f" items="${foods}">
    <input type="checkbox" name="food" value="${f.id}"/> ${f.name} <br/>
  </c:forEach>
  <input type="submit" value="Lưu lựa chọn"/>
</form>

</body>
</html>
