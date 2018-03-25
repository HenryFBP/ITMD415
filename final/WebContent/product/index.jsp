<%@page import="Final.*"%>
<%@page import="Final.Customer.*"%>
<%@page import="Final.Customer.Exceptions.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>New Product</title>
<link rel="stylesheet" href="/final/css/screen.css" />
</head>
<body>
  <nav><jsp:include page="/navbar.jsp"></jsp:include></nav>
  <aside>
    <a><%=CustomerControllerServlet.generateStatus(session)%></a>
  </aside>
  <header>
    <h1>New Product</h1>
  </header>
  <section>
  <p>
  You can record either a Car, or a Part.
  </p>
  <ul>
	<li><a href="newcar.jsp">Car</a></li>
	<li><a href="newpart.jsp">Part</a></li>
  </ul>
  </section>
</body>
</html>