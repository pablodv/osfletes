$(function(){
	init_btns();	
});

function init_btns(){
	$('#btn_busqueda').click(function (){submit_busqueda();});
}

function submit_busqueda(){
	var url = JsonUrls['OBTENER_ANUNCIOS_FILTRADOS'];
	
	$.ajax({
	    type: "post",
	    url: url,
	    dataType: "json",
	    data: null,
	    success: function(data){
	    	for(i=0;i<data.length;i++){
	    		$('#results').append('<div>'+data[i].valorOferta+'</div>');	    		
	    	}
	    },
	    error: function (XMLHttpRequest, textStatus, errorThrown) {
			alert('ERROR');
	    }
	});
}