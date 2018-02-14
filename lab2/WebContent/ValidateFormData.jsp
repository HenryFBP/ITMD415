<%@ page language='java' contentType='text/html; charset=ISO-8859-1'
	pageEncoding='ISO-8859-1'%>
<% log("Name is: " + request.getParameter("name")); %>
<!DOCTYPE html>
<html>
<head>
<title>Insert title here</title>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="/lab2/css/screen.css" />
  <script type="text/javascript">
    function validateName()
    {
	  var name = document.getElementByID("name");
	  return ((name.value.length>=4) & (name.value.length <=50));
    }
    
    function validateSSN()
    {
	  var ssn = document.getElementByID("ssn");
	  if(ssn.value.length != 11)
      {
        return false;
      }

      for(int i = 0; i < ssn.value.length; i++)
      {
        if(i == 3 || i == 6)
        {
          if(!(ssn.value.charAt(i) == '-'))
          {
            return false;
          }
        }
        else
        {
          if(!(Character.isDigit(ssn.value.charAt(i))))
          {
            return false;
          }
        }
      }
      return true;
    }

    function validateZip()
    {
      var zip = document.getElementByID("zip");
      if(zip.value.length != 10)
      {
        return false;
      }

      for(int i = 0; i < zip.value.length; i++)
      {
        if(i == 5)
        {
          if(!(zip.value.charAt(i) == '-'))
          {
            return false;
          }
        }
        else
        {
          if(!(Character.isDigit(zip.value.charAt(i))))
          {
            return false;
          }
        }
      }
      return true;
    }

    function validateEmail()
    {
	  var email = document.getElementByID("email");
	  return email.value.length > 7;
    }

    function validateStreet()
    {
      var street = document.getElementByID("street");
  	  return ((street.value.length>=4) & (street.value.length <=50));
    }

    function validateCity()
    {
      var city = document.getElementByID("city");
  	  return ((city.value.length>=3) & (city.value.length <=50));
    }
    
  </script>
</head>
<body>
  <nav><jsp:include page="navbar.inc"></jsp:include></nav>
  



  <footer><jsp:include page="footer.inc"></jsp:include></footer>
</body>
</html>