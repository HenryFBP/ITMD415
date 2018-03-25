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
    <li><a href="/final/listing/">Listing</a></li>
	<%
	    if(!loggedIn) //not logged in, let them!
	    {
	        out.write(Lib.wrapAttr("Login","li a","href","/final/login"));
	        out.write(Lib.wrapAttr("Sign up","li a","href","/final/signup"));
	    }
	    else
	    {
	        out.write(Lib.wrapAttr("My Products", "li a", "href", "/final/product"));
	        out.write(Lib.wrapAttr("Logout","li a","href","/final/logout")); //they are logged in, let them leave!
	        out.write(Lib.wrapAttr("Delete account", "li a", "href", "/final/delete-account"));
	    }
	%>
</ul>