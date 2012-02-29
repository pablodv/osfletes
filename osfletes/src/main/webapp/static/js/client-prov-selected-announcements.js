$(function(){
	$('#search').click(function(){search_client_deleted_announcements(1);})
	$('#search').click();
});

function search_client_deleted_announcements(page){
	var url = ClientUrls['GET_SELECTED_ANNOUNCEMENTS'];
	$.ajax({
	    url: url,
	    data: get_announcement_search_filter(page),
	    success: function(result){
		    	if(result.success){
		    	$('#resultado').busqueda({
		    	'element_props'			:[{title:'Identificador',prop:'id'}, {title:'Creado',prop:'fechaCreacion'}],
				'funcionpaginacion' : search_client_deleted_announcements,
				'resultado'			: result.response
		    	});	    		
	    	}
	    }
	});
}


