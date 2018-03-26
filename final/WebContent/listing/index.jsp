<%@page import="Final.*"%>
<%@page import="Final.Customer.*"%>
<%@page import="Final.Customer.Exceptions.*"%>
<%
    boolean loggedIn = CustomerControllerServlet.isLoggedIn(session);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Listing</title>
<link rel="stylesheet" href="/final/css/screen.css" />
</head>
<body>
  <nav><jsp:include page="/navbar.jsp"></jsp:include></nav>
  <aside>
    <a><%=CustomerControllerServlet.generateStatus(session)%></a>
  </aside>
  <header>
    <h1>

      <%
          if(loggedIn)
          {
              out.write("My Listings<a href=\"new.jsp\">(new)</a>");
          }
          else
          {
              out.write("You must be logged in to view a list of your Listings.");
          }
      %>
    </h1>
  </header>
  <section>
    <p>Generated list of listings</p>
  </section>
</body>
</html>