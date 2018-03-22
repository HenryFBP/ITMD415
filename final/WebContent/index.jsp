<%@page import="Final.*"%>
<%@page import="Final.Customer.*"%>
<%@page import="Final.Customer.Exceptions.*"%>
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
    <h1>Welcome to the Final Project servlet hell!</h1>
  </header>
  <main id="listings">
  <ul>
    <li>
      <ul>
        <li><a>name</a></li>
        <li><a>make</a></li>
        <li><a>model</a></li>
        <li><a>afasfasdf</a></li>
      </ul>
    </li>
    <li>
      <ul>
        <li><a>name</a></li>
        <li><a>make</a></li>
        <li><a>model</a></li>
        <li><a>afasfasdf</a></li>
      </ul>
    </li>
    <li>
      <ul>
        <li><a>name</a></li>
        <li><a>make</a></li>
        <li><a>model</a></li>
        <li><a>afasfasdf</a></li>
      </ul>
    </li>
    <li>
      <ul>
        <li><a>name</a></li>
        <li><a>make</a></li>
        <li><a>model</a></li>
        <li><a>afasfasdf</a></li>
      </ul>
    </li>
  </ul>
  </main>
</body>
</html>