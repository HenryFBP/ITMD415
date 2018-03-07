<%@page import="java.io.PrintWriter"%>
<%@page import="Final.Customer.*"%>
<%@page import="Final.Customer.Exceptions.*"%>
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
	<nav><jsp:include page="/navbar.inc"></jsp:include></nav>
	<%
	    try
	    {
	        Customer c = CustomerSignupServlet.loginCustomer(request);

	        out.write("HEY BUDDY UR LOGGED IN!");

	        out.write(c.toString());
	    }
	    catch(FormNotFilledOutException e)
	    {
	        out.write("Missing the following login fields:");
	        out.write(e.getList());
	    }
	    catch(CustomerNameDoesNotExistException e)
	    {
	        out.write(String.format("No account named '%s' exists!", e.name));
	    }
	    catch(PasswordMismatchException e)
	    {
	        out.write(String.format("Wrong password for '%s'.", e.name));
	    }
	%>
</body>
</html>