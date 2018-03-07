<%@page import="org.apache.tomcat.jni.Directory"%>
<%@page import="java.io.File"%>
<!DOCTYPE html>
<html>
<head>
  <meta charset="ISO-8859-1">
  <title>Final Project</title>
  <link rel="stylesheet" href="/final/css/screen.css" />
</head>
<body>
  <nav><jsp:include page="/navbar.inc"></jsp:include></nav>

  <header>
    <h1>Login</h1>
  </header>
  <section>
    <form id="login" action="login.jsp" method="POST">
      <ol>
        <li>
          <label for="username">Username</label>
          <input type="text" id="username" name="username" />
        </li>
        <li>
          <label for="password">Password</label>
          <input type="password" id="password" name="password"/>
        </li>
      </ol>
      <input id='submit' type='submit' value='Login'/>    
    	
    </form>
  </section>
</body>
</html>