$(function(){
	iniciar_mapa();
});

function iniciar_mapa(){
	window.map = new google.maps.Map(document.getElementById("google_map_container"), {
        center: new google.maps.LatLng(61.850966,-45.15564),
        mapTypeId: google.maps.MapTypeId.ROADMAP,
        draggable:false ,
        mapTypeControl:false
    });
	
    $('#google_map_container').show();
}