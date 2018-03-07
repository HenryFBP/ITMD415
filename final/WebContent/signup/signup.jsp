<%@page import="java.io.PrintWriter"%>
<%@page import="Final.Customer.*"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<title>Sign up!</title>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="/final/css/screen.css" />
</head>
<body>
	<%
	    try
	    {
	        Customer c = CustomerSignupServlet.createCustomer(request);

	        out.write(c.toString());
	    }
	    catch(FormNotFilledOutException e)
	    {
	        out.write("Missing this form data:");
	        for(String s : e.missing)
	        {
	            out.write("<li>" + s + "</li>");
	        }
	    }
	    catch(CustomerAlreadyExistsException e)
	    {
	        out.write(String.format("Username '%s' is taken!", request.getParameter("username")));
	    }
	%>
</body>
</html>