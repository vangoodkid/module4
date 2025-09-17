<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
  <title>Calculator</title>
</head>
<body>
<h2>Máy tính cá nhân</h2>
<form action="operation" method="post">
  <input type="number" step="any" name="num1" required/>
  <select name="operation">
    <c:forEach var="op" items="${operations}">
      <option value="${op.symbol}">${op.name} (${op.symbol})</option>
    </c:forEach>
  </select>
  <input type="number" step="any" name="num2" required/>
  <input type="submit" value="=" />
</form>
</body>
</html>
