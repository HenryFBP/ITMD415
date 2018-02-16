<%@page import="lab2.*"%>
<%@ page language='java' contentType='text/html; charset=ISO-8859-1'
	pageEncoding='ISO-8859-1'%>
<%-- Customer c = CustomerFormHandler.handleForm(request); --%>
<% Validation val = new Validation(); %>
<!DOCTYPE html>
<html>
<head>
<title>Insert title here</title>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="/lab2/css/screen.css" />
</head>
<script>
  function validateform()
  {
    var	name = GetFormData.sign-up.name.value;
    var ssn = GetFormData.sign-up.ssn.value;
    var zip = GetFormData.sign-up.zip.value;
    var email = GetFormData.sign-up.email.value;
    var street = GetFormData.sign-up.street.value;
    var city = GetFormData.sign-up.city.value;

    if(!val.nameIsValid(name)){
	  alert("Name must be between 5-50 characters!");
	  return false;
    }
    if(!val.sSecurityIsValid(ssn)){
      alert("Socical Security Number must be in format, XXX-XX-XXXX with all X's being a number!");
      return false;
    }
    if(!val.zipIsValid(zip)){
      alert("Zip must be in format, XXXXX-XXXX with all X's being a number!");
      return false;
    }
    if(!val.emailIsValid(email)){
      alert("Email must be longer than 7 characters!");
      return false;
    }
    if(!val.addressIsValid(street)){
      alert("Street Address must be between 4-50 characters!");
      return false;
    }
    if(!val.cityIsValid(city)){
      alert("City must be between 3-50 characters!");
      return false
    }
  }
</script>
<body>
  <nav><jsp:include page="navbar.inc"></jsp:include></nav>
  
 	<%-- <p>THANKS A LOT, <%= c.name %>!</p> --%>


  <footer><jsp:include page="footer.inc"></jsp:include></footer>
</body>
</html>