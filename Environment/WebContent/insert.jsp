<%@page import="com.hydra.model.Server" %>
<%@page import="com.hydra.dao.ServerDao" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form method="get" action="ServerController?action=insert"></form>
<% int ID=(Integer.parseInt(request.getParameter("sid")));
  String Name=request.getParameter("sname");
  
  Server server= new Server();
  ServerDao dao=new ServerDao();
  dao.addServer(server);

  response.sendRedirect("ServerController");
%>


</body>
</html>