
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>
<head><title>Update Mail Config</title></head>
<body>
<h2>Update Mail Configuration</h2>
<form:form modelAttribute="mailConfig" method="post">

    <label>Language: </label>
    <form:select path="language" items="${languages}"/><br/><br/>

    <label>Page Size: </label>
    <form:select path="pageSize" items="${pageSizes}"/><br/><br/>

    <label>Spam Filter: </label>
    <form:checkbox path="spamFilter"/> Enable<br/><br/>

    <label>Signature: </label><br/>
    <form:textarea path="signature" rows="4" cols="40"/><br/><br/>

    <input type="submit" value="Save"/>
</form:form>
</body>
</html>
