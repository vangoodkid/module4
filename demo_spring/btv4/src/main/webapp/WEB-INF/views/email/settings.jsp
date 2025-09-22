<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
  <title>Settings</title>
</head>
<body>
<h1>Settings</h1>
<form:form modelAttribute="emailSettings" action="/email/update" method="post">
  Languages:
  <form:select path="language" items="${languages}"/><br><br>

  Page Size:
  Show <form:select path="pageSize" items="${pageSizes}"/> emails per page <br><br>

  Spams filter:
  <form:checkbox path="spamsFilter"/> Enable spams filter <br><br>

  Signature:<br>
  <form:textarea path="signature" rows="5" cols="40"/><br><br>

  <input type="submit" value="Update"/>
  <input type="reset" value="Cancel"/>
</form:form>
</body>
</html>
