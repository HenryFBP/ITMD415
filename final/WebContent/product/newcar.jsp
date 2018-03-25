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
    <h1>New Car</h1>
  </header>
      <form id="new-car" action="newcarpost.jsp" method="POST">
      <ol>
        <li>
          <label for="name">Name</label>
          <input type="text" id="name" name="name" />
        </li>
        <li>
          <label for="model">Model</label>
          <input type="text" id="model" name="model" />            
        </li>
      </ol>
      <input id='submit' type='submit' value='Create car'/>    
    	
    </form>
  
</body>
</html>