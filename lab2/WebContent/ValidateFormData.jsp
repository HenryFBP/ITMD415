<%@ page import="lab2.*"%>
<%@ page import="lab2.Customer.*"%>
<%@ page language='java' contentType='text/html; charset=ISO-8859-1'
	pageEncoding='ISO-8859-1'%>
<%
    Customer c = CustomerFormHandler.handleForm(request);
%>
<%
	boolean valid = Validation.customerIsValid(c);
%>

<!DOCTYPE html>
<html>
<head>
<title>Insert title here</title>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="/lab2/css/screen.css" />
</head>
<body>
	<nav><jsp:include page="navbar.inc"></jsp:include></nav>
	<section id="validation">
		<%= CustomerFormHandler.displayValidity(c) %>
		<%
		
		if(valid)
		{
		    out.write(lib.wrap(String.format("Thank you, %s!",c.getName()),"p"));
		}
		else
		{
		    out.write(lib.wrap(String.format("Sorry %s, but you've got something wrong with your information.",c.getName()),"p"));
		}
		
		%>
	</section>

	<script src="https://maps.googleapis.com/maps/api/js?key=AIzaSyCJJpsVGWAK7xK0Btcu33hFId_7qU1B0ZA">
    </script>
    <script> 
    
      var map;
      function initialize() { 
    	var lat = '';
    	var lng = '';
    	var address = {zipcode} or {city and state};
    	geocoder.geocode( { 'address': address}, function(results, status) {
    	  if (status == google.maps.GeocoderStatus.OK) {
    	    lat = results[0].geometry.location.lat();
    	    lng = results[0].geometry.location.lng();
    	    });
    	  } else {
    	    alert("Geocode was not successful for the following reason: " + status);
    	  }
    	});
    	alert('Latitude: ' + lat + ' Logitude: ' + lng);
    	
	    var mapOptions = {zoom: 3, center: new google.maps.LatLng(lat, lng)};
	    map = new google.maps.Map(document.getElementById('map-canvas'), mapOptions);
	  }
	
	  google.maps.event.addDomListener(window, 'load', initialize);

	</script>
  
  <div id="map-canvas" style="height:300px; width:500px"></div>

	<footer><jsp:include page="footer.inc"></jsp:include></footer>
</body>
</html>