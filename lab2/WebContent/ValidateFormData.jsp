<%@page import="lab2.*"%>
<%@ page language='java' contentType='text/html; charset=ISO-8859-1'
	pageEncoding='ISO-8859-1'%>
<% Customer c = CustomerFormHandler.handleForm(request); %>
<% Validation val = new Validation(); %>
<!DOCTYPE html>
<html>
<head>
<title>Insert title here</title>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="/lab2/css/screen.css" />
</head>
<body>
  <nav><jsp:include page="navbar.inc"></jsp:include></nav>
  <section>
     <p><%= (Validation.nameIsValid(c.getName()) ? "Name Validated" : "Error: Name Invalid") %><p>
     <p><%= (Validation.sSecurityIsValid(c.getSSN()) ? "SSN Validated" : "Error: SSN Invalid") %><p>
     <p><%= (Validation.zipIsValid(c.getZip()) ? "Zip Validated" : "Error: Zip Invalid") %><p>
     <p><%= (Validation.emailIsValid(c.getEmail()) ? "Email Validated" : "Error: Email Invalid") %><p>
     <p><%= (Validation.addressIsValid(c.getAddress()) ? "Address Validated" : "Error: Address Invalid") %><p>
     <p><%= (Validation.cityIsValid(c.getCity()) ? "City Validated" : "Error: City Invalid") %><p>
 	 <p>THANKS A LOT, <%= c.getName() %>!</p> 
  </section>
 

  <footer><jsp:include page="footer.inc"></jsp:include></footer>
</body>
</html>