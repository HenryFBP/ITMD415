
var map;
function initialize()
{ 
    var lat = '';
    var lng = '';
    var address = {zipcode} || {city, state};
    geocoder.geocode( { 'address': address }, function(results, status) 
    {

	if (status == google.maps.GeocoderStatus.OK)
        {
            lat = results[0].geometry.location.lat();
            lng = results[0].geometry.location.lng();        
        }
        else
        {
    	    alert("Geocode was not successful for the following reason: " + status);
        }
    });

    alert('Latitude: ' + lat + ' Logitude: ' + lng);
        
    var mapOptions = {zoom: 3, center: new google.maps.LatLng(lat, lng)};
    map = new google.maps.Map(document.getElementById('map-canvas'), mapOptions);
      
    
    google.maps.event.addDomListener(window, 'load', initialize);
}
  