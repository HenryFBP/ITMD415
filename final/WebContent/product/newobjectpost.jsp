<%@page import="java.io.PrintWriter"%>
<%@page import="Final.*"%>
<%@page import="Final.Product.*"%>
<%@page import="Final.Customer.*"%>
<%@page import="Final.Customer.Exceptions.*"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%
    ProductHandler ph = new ProductHandler();
    String message = "";
    String title = "Error creating new product";
    try
    {
        Product p = ProductCreationServlet.createProduct(request);
        title = p.getObjectClass().getSimpleName();
    }
    catch(FormNotFilledOutException e)
    {
        message += e.getList();
        message = Lib.wrap(message, "ul");
        message = Lib.wrap("Missing form elements: ", "p") + message;

    }
    catch(CustomerNotLoggedInException e)
    {
        message += Lib.wrap("You must be logged in to make a new Product.", "p");
    }
%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title><%=title%></title>
<link rel="stylesheet" href="/final/css/screen.css" />
</head>
<body>
	<nav><jsp:include page="/navbar.jsp"></jsp:include></nav>

	<%=message%>
</body>
</html>