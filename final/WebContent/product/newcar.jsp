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
      <form id="new-car" action="newobjectpost.jsp" method="POST">
      <input type="hidden" id="producttype" name="producttype" value="car"/>
      <ol>
        <li>
          <label for="name">Name</label>
          <input type="text" id="name" name="name" />
        </li>
        <li>
          <label for="make">Make</label>
          <input type="text" id="make" name="make" />
        </li>
        <li>
          <label for="model">Model</label>
          <input type="text" id="model" name="model" />
        </li>        
        <li>
          <label for="miles">Miles</label>
          <input type="number" id="miles" name="miles" />
        </li>
        <li>
          <label for="year">Year</label>
          <input type="date" id="year" name="year" />
        </li>
      </ol>
      <input id='submit' type='submit' value='Create car'/>    
    	
    </form>
  
</body>
</html>