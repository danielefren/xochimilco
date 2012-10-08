var puntos = [];
var ventanas= [];
var unpunto = null;
var map = null;
var center = null;
 
$.getJSON("/cultureservlet?opcion=1", {}, function(data){
	$.each(data.places, function(i, item){
		center  = new google.maps.LatLng(item.lat, item.lon);                          
    });
});       

function initialize() {      
	var mapOptions = {
			center: center,
            zoom: 12,
            mapTypeId: google.maps.MapTypeId.ROADMAP,
            mapTypeControl: true,
            disableDoubleClickZoom: true,
            minZoom:10,
            maxZoom:18,                    
            mapTypeControlOptions: {
            	style: google.maps.MapTypeControlStyle.DROPDOWN_MENU
            },
            navigationControl: true,
            navigationControlOptions: {
            	style: google.maps.NavigationControlStyle.SMALL
            }
     };
    map = new google.maps.Map(document.getElementById("mapa"), mapOptions);
}
 
function hide(){
	if(puntos){
		for(p in puntos){
			puntos[p].setMap(null);
		}
    }
}

function culture(){
    	var church = 'imgs/Church.jpg';
        $.getJSON("/cultureservlet?opcion=3", {}, function(data){
            $.each(data.places, function(i, item){
            	var marker = new google.maps.Marker({
            		position: new google.maps.LatLng(item.lat,item.lon),
                    map: map,
                    title: item.title,
                    icon:church
                });
                puntos[i] = marker;
                var infowindow = new google.maps.InfoWindow({
                	content: "<h3>"+ item.title +"</h3><p>"+
                	item.title +"</p>" + '<div>'+
                    '<img src="' + item.img + '" />'+'</div>'
                });
                ventanas[i] = infowindow;
                google.maps.event.addListener(marker, 'click', function() {
                            infowindow.open(map, marker);
                });
            });
       });
}

function showCulture(){
        hide();
        culture();
}