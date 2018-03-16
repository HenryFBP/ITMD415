<%@page import="Final.*"%>
<%@page import="Final.Customer.*"%>
<%@page import="Final.Customer.Exceptions.*"%>
<%
    String message = "";

    String username = (String) session.getAttribute("username");

    if(username == null)
    {
        message = "You weren't logged in, but OK. 'Logging you out' anyways.";
    }
    else
    {
        message = String.format("Goodbye, %s!", username);
    }
    message = Lib.wrap(message, "a");
    session.invalidate();
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Final Project</title>
<link rel="stylesheet" href="/final/css/screen.css" />
</head>
<body>
  <nav><jsp:include page="/navbar.jsp"></jsp:include></nav>
	<aside>
		<a><%=CustomerControllerServlet.generateStatus(session)%></a>
	</aside>
	<header>
		<h1>Login</h1>
	</header>
	<section>
		<%=message%>
	</section>
</body>
</html>