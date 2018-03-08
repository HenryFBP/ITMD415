<%@page import="Final.*"%>
<%@page import="Final.Customer.*"%>
<%@page import="Final.Customer.Exceptions.*"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%
    Boolean loggedIn = CustomerControllerServlet.isLoggedIn(session);
%>
<ul>
	<li><a href="/final">Home</a></li>
	<%
	    if(!loggedIn) //not logged in, let them!
	    {
	        out.write(Lib.wrap("<a href=\"/final/login\">Login</a>", "li"));
	        out.write(Lib.wrap("<a href=\"/final/signup\">Sign up</a>", "li"));
	    }
	    else
	    {
	        out.write(Lib.wrap("<a href=\"/final/logout\">Logout</a>", "li")); //they are logged in, let them leave!
	    }
	%>
</ul>