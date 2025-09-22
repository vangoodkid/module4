
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
<head><title>Mail Configuration</title></head>
<body>
<h2>Current Mail Configuration</h2>
<p><b>Language:</b> ${mailConfig.language}</p>
<p><b>Page Size:</b> ${mailConfig.pageSize}</p>
<p><b>Spam Filter:</b> ${mailConfig.spamFilter ? "Enabled" : "Disabled"}</p>
<p><b>Signature:</b> ${mailConfig.signature}</p>

<a href="${pageContext.request.contextPath}/mail/update">Update Config</a>
</body>
</html>
