<%@page import="Final.*"%>
<%@page import="Final.Customer.*"%>
<%@page import="Final.Customer.Exceptions.*"%>
<!DOCTYPE html>
<html>
<head>
  <title>Sign up</title>
  <meta charset="ISO-8859-1">
  <link rel="stylesheet" href="/final/css/screen.css" />
</head>
<body>
    <nav><jsp:include page="/navbar.jsp"></jsp:include></nav>
	<aside>
		<a><%=CustomerControllerServlet.generateStatus(session)%></a>
	</aside>
  <header>
    <h1>Sign up</h1>
  </header>
  <section>
    <form id="signup" action="signup.jsp" method="POST">
      <ol>
        <li>
          <label for="username">Username</label>
          <input type="text" id="username" name="username" />
        </li>
        <li>
          <label for="email">Email</label>
          <input pattern="^(.+)@(.+)$" type="email" id="email" name="email" />            
        </li>
        <li>
          <label for="password">Password</label>
          <input type="password" id="password" name="password"/>
        </li>
      </ol>
      <input id='submit' type='submit' value='Register'/>    
    </form>
  </section>
</body>
</html>