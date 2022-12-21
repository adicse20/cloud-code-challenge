<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>


<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<h1>

<c:if test="${successMsg!=null}">
	<h2><c:out value="${successMsg}"></c:out></h2>

</c:if>

</h1>

</body>
</html>