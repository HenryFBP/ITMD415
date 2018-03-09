<%@page import="java.io.PrintWriter"%>
<%@page import="Final.*"%>
<%@page import="Final.Customer.*"%>
<%@page import="Final.Customer.Exceptions.*"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%
    String message = "";
    CustomerHandler ch = new CustomerHandler();
    try
    {

        Customer tempc = CustomerSignupServlet.createCustomer(request); //make customer and store in db
        Customer c = ch.read(tempc.getName()); //get fresh customer by name

        session.setAttribute("customer", c);
        session.setAttribute("username", c.getName()); //store their username in our session
        
        message += Lib.wrap("Welcome to hell, "+c.getName()+"!","p");
        message += Lib.wrap("Thanks for signing up.","p");
    }
    catch(FormNotFilledOutException e)
    {
        message += ("Missing this form data:");
        message += (e.getList());
    }
    catch(CustomerAlreadyExistsException e)
    {
        message += (String.format("Username '%s' is taken!", request.getParameter("username")));
    }
%>
<!DOCTYPE html>
<html>
<head>
<title>Sign up!</title>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="/final/css/screen.css" />
</head>
<body>
	<nav><jsp:include page="/navbar.jsp"></jsp:include></nav>
	<main> <%=message%> </main>
</body>
</html>