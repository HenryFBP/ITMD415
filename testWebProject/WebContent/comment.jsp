<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
  pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Comments test</title>
</head>
  <body>
    <header>
      <h1>Comment below</h1>
    </header>
    <main>
      <form id="sign-up" action="#null" method="get">
        <ol>
          <li>
            <label for="name">Name</label>
            <input type="text" id="name" name="name" />            
          </li>
          <li>
            <label for="comment">Phone</label>
            <input type="text" id="comment" name="comment" />            
          </li>
        </ol>
        <input id="submit" type="submit" value="Go!"/>
      </form>
    </main>
    <section id="comments">
    </section>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
    <script src="index.js"></script>
    <section id="problems" class="hidden">
      <h2>
        Problems:
      </h2>
      <ol>
        
      </ol>
      
    </section>
  </body>

</html>