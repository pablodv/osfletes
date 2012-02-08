$(function(){
	$('#search').click(function(){search_client_created_announcements(1);})
});

function search_client_created_announcements(page){
	var url = ClientUrls['GET_CREATED_ANNOUNCEMENTS'];
	$.ajax({
	    url: url,
	    data: get_announcement_search_filter(page),
	    success: function(result){
	    	$('#resultado').busqueda({
	    	'botonera'			: [{title:'Crear role',imagen:'url("static/imagenes/add.png")',funcion:alert('a')},
	    	          			   {title:'Eliminar role',imagen:'url("static/imagenes/delete.png")',funcion:alert('a')}],
			'element_props'			:[{title:'Identificador',prop:'id'}, {title:'Role',prop:'role'}],
			'funcionpaginacion' : search_client_created_announcements,
			'resultado'			: result.response
		});	    		
	    	
	    }
	});
}