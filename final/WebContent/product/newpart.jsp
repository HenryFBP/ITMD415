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
    <h1>New Part</h1>
  </header>
      <form id="new-part" action="newobjectpost.jsp" method="POST">
      <input type="hidden" id="producttype" name="producttype" value="part"/>
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
          <label for="type">Type</label>
          <input type="text" id="type" name="type" />
        </li>
        <li>
          <label for="condition">Condition</label>
          <input type="text" id="condition" name="condition" />
        </li>
      </ol>
      <input id='submit' type='submit' value='Create part'/>    
    	
    </form>
  
</body>
</html>