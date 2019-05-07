<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
	<link rel="stylesheet" href ="${pageContext.request.contextPath}/css/styles.css">
	<link href="https://fonts.googleapis.com/css?family=Bungee+Inline" rel="stylesheet"> 
	<link href="https://fonts.googleapis.com/css?family=Oxygen" rel="stylesheet"> 
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">	
	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" />
<title>Scoreboard</title>
</head>
<body>
<h1>Score</h1>
<form action = "devpro" method = "get">
<button type="submit" class="btn btn-dark" >Play Again!</button>
</form>
<br>
<div>

<table class="table table_striped">
<thead class = "thead-dark">
<tr>
	<th>User</th>
	<th>Score</th>
</tr>
</thead>
<c:forEach items="${scorelist}" var="score">
<tr>
	<td><c:out value="${score.userName}"></c:out></td>
	<td><c:out value="${score.score}"></c:out></td>
</tr>
</c:forEach>

</table>
</div>
</body>
</html>