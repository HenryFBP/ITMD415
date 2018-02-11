<!DOCTYPE html>
<html>
<head>
<title>Insert title here</title>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="/lab2/css/screen.css" />
</head>
<body>
  <nav><jsp:include page="navbar.inc"></jsp:include></nav>
  
  <p><% log("Name is: " + request.getParameter("name")); %></p>

  <footer><jsp:include page="footer.inc"></jsp:include></footer>
</body>
</html>