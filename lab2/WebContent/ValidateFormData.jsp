<%@page import="lab2.*"%>
<%@ page language='java' contentType='text/html; charset=ISO-8859-1'
	pageEncoding='ISO-8859-1'%>
<% Customer c = CustomerFormHandler.handleForm(request); %>
<!DOCTYPE html>
<html>
<head>
<title>Insert title here</title>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="/lab2/css/screen.css" />
</head>
<body>
  <nav><jsp:include page="navbar.inc"></jsp:include></nav>
  
 	<p>THANKS A LOT, <%= c.name %>!</p>


  <footer><jsp:include page="footer.inc"></jsp:include></footer>
</body>
</html>