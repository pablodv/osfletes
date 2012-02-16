$(function(){
	$('#search').click(function(){search_client_created_announcements(1);})
	$('#delete').click(delete_announcement);
	$('#publish').click(publish_announcement);
	$('#search').click();
});

function search_client_created_announcements(page){
	var url = ClientUrls['GET_CREATED_ANNOUNCEMENTS'];
	
	$.ajax({
	    url: url,
	    data: get_announcement_search_filter(page),
	    success: function(result){
		    	if(result.success){
		    	$('#resultado').busqueda({
		    	'element_props'			:[{title:'Identificador',prop:'id'}, {title:'Creado',prop:'fechaCreacion'}],
				'funcionpaginacion' : search_client_created_announcements,
				'resultado'			: result.response
		    	});	    		
	    	}
	    }
	});
}

function delete_announcement(){
	var url = ClientUrls['DELETE_ANNOUNCEMENT'];
	if($('#resultado').busqueda('selected') == null){
		$('<div>Debe seleccionar un Anuncio a eliminar</div>').modalpop({msg:true});
	}else{
		$.ajax({
		    url: url,
		    data: {announcementId:$('#resultado').busqueda('selected')},
		    success: function(result){
		    	if(result.success){
		    		search_client_created_announcements($('#resultado').busqueda('page'));
		    	}
		    }
		});
	}
}

function publish_announcement(){
	var url = ClientUrls['PUBLISH_ANNOUNCEMENT'];
	if($('#resultado').busqueda('selected') == null){
		$('<div>Debe seleccionar un Anuncio a publicar</div>').modalpop({msg:true});
	}else{
		$.ajax({
		    url: url,
		    data: {announcementId:$('#resultado').busqueda('selected')},
		    success: function(result){
		    	if(result.success){
		    		search_client_created_announcements($('#resultado').busqueda('page'));
		    	}
		    }
		});
	}
}



