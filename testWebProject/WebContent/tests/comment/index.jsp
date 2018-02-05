<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
  pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Comments test</title>
</head>
  <body>
	<nav><jsp:include page="/navbar.inc"></jsp:include></nav>
    <header>
      <h1>Comment below</h1>
    </header>
    <main>
      <form id="sign-up" action="register" method="post">
        <ol>
          <li>
            <label for="name">Name</label>
            <input type="text" id="name" name="name" />            
          </li>
          <li>
            <label for="comment">Comment</label>
            <input type="text" id="comment" name="comment" />            
          </li>
        </ol>
        <input id="submit" type="submit" value="Post!"/>
      </form>
    </main>
    <section id="comments">
    </section>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
    <script src="index.js"></script>
  </body>

</html>