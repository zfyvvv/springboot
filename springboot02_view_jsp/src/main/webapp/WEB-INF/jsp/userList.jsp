<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>User List</title>
</head>
<body>
<table border="1" align="center" width="50%">
	<tr>
		<th>ID</th>
		<th>Name</th>
		<th>Age</th>
	</tr>
	<c:forEach items="${userList }" var="user">
		<tr>
			<td>${user.userId }</td>
			<td>${user.userName }</td>
			<td>${user.userAge }</td>
		</tr>
	</c:forEach>
</table>
</body>
</html>