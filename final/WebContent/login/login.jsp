<%@page import="java.io.PrintWriter"%>
<%@page import="Final.*"%>
<%@page import="Final.Customer.*"%>
<%@page import="Final.Customer.Exceptions.*"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%
    //setup message BEFORE WE DISPLAY IT.
    String message = "";
    try
    {
        Customer c = CustomerSignupServlet.loginCustomer(request);

        session.setAttribute("username", c.getName()); //store their username in our session

        message += Lib.wrap("HEY BUDDY UR LOGGED IN!", "a");

    }
    catch(FormNotFilledOutException e)
    {
        message += Lib.wrap("Missing the following login fields:", "a");
        message += e.getList();
    }
    catch(CustomerNameDoesNotExistException e)
    {
        message += String.format("No account named '%s' exists!", e.name);
    }
    catch(PasswordMismatchException e)
    {
        message += String.format("Wrong password for '%s'.", e.name);
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
	<nav><jsp:include page="/navbar.inc"></jsp:include></nav>
	<aside>
		<a><%=CustomerControllerServlet.generateStatus(session)%></a>
	</aside>
	<main> <%=message%> </main>
</body>
</html>