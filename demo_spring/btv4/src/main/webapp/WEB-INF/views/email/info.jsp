<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
  <title>Config Info</title>
</head>
<body>
<h1>Email Configuration</h1>
<p><b>Language:</b> ${emailSettings.language}</p>
<p><b>Page Size:</b> ${emailSettings.pageSize}</p>
<p><b>Spams Filter:</b> ${emailSettings.spamsFilter}</p>
<p><b>Signature:</b><br> ${emailSettings.signature}</p>

<a href="/email/settings">Back to Settings</a>
</body>
</html>
