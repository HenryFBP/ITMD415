<%@page import="Final.*"%>
<%@page import="Final.Customer.*"%>
<%@page import="Final.Customer.Exceptions.*"%>
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
    <h1>New Listing</h1>
  </header>
  <section>
    <form id="signup" action="new.jsp" method="POST">
      <ol>
        <li>
          <label for="name">Product Name</label>
          <input type="text" id="username" name="username" />
        </li>
      </ol>
      <input id='submit' type='submit' value='Create Item'/>    
    </form>
  </section>
</body>
</html>