<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>User</title>
<link rel="icon" href="data:;base64,=">
</head>
<body>
	<h1>User by JSTL</h1>
	<table>
		<tr>
			<th>id</th>
			<th>first name</th>
			<th>last name</th>
		</tr>
		<c:forEach var="cur" items="${users}">
			<tr>
				<td>${cur.id}</td>
				<td>${cur.firstName}</td>
				<td>${cur.lastName}</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>