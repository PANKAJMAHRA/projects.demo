<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<table cellpadding="15" border=1>

		<tr>
			<th>server-Id</th>
			<th>server-name</th>
			
		</tr>

		<c:forEach items="${viewserver}" var="server">
			<tr>
				<td>${server.serverId}/></td>
				<td>${server.serverName}/></td>
				<td>
				<a href="edit?serverId=$(server.serverId)">Edit</a>
				<a href="delete?serverId=$(server.serverId)">Delete</a>
				</td>
			</tr>
		</c:forEach>

	</table>
</body>
</html>