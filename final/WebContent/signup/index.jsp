<%@page import="org.apache.tomcat.jni.Directory"%>
<%@page import="java.io.File"%>
<!DOCTYPE html>
<html>
<head>
  <title>Sign up</title>
  <meta charset="ISO-8859-1">
  <link rel="stylesheet" href="/final/css/screen.css" />
</head>
<body>
  <nav><jsp:include page="/navbar.inc"></jsp:include></nav>

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