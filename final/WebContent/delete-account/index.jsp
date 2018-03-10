<%@page import="Final.*"%>
<%@page import="Final.Customer.*"%>
<%@page import="Final.Customer.Exceptions.*"%>
<%
    Object o = session.getAttribute("customer");

    if(o == null)
    {
        Lib.sendToLogin(response); //send em to login screen if they aren't logged in
        return;
    }

    Customer c = (Customer) o;

    String username = c.getName();

    String confirm = "I understand that this will permanently delete my account, " + Lib.wrap(username, "a") + ".";
%>
<!DOCTYPE html>
<html>
<head>
  <meta charset="ISO-8859-1">
  <title>Delete account</title>
  <link rel="stylesheet" href="/final/css/screen.css" />
</head>
<body>
  <nav><jsp:include page="/navbar.jsp"></jsp:include></nav>
	<aside>
		<a><%=CustomerControllerServlet.generateStatus(session)%></a>
	</aside>
  <header>
    <h1>Delete my account</h1>
  </header>
  <section>
    <form id="delete" action="delete.jsp" method="POST">
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
		<li class="form-two">
          <label for="confirm">Delete account</label>
          <a>To delete your account, type the following in the below box:</a>
          <pre id="important"><code><%=confirm%></code></pre>
          <input type="text" id="confirm" name="confirm"/>
        </li>
      </ol>
      <input id='submit' type='submit' value='Delete my account'/>    
    	
    </form>
  </section>
</body>
</html>