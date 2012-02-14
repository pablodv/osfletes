$(function(){
	$('#search').click(function(){search_client_created_announcements(1);})
	$('#select').click(select_offer);
	$('#cancel').click(cancel_announcement);
});

function search_client_created_announcements(page){
	var url = ClientUrls['GET_PUBLISHED_ANNOUNCEMENTS'];
	$.ajax({
	    url: url,
	    data: get_announcement_search_filter(page),
	    success: function(result){
	    	$('#resultado').busqueda({
	    	'element_props'			:[{title:'Identificador',prop:'id'}, {title:'Role',prop:'role'}],
			'funcionpaginacion' : search_client_created_announcements,
			'resultado'			: result.response
	    	});	    		
	    }
	});
}

function cancel_announcement(){
	var url = ClientUrls['CANCEL_ANNOUNCEMENT'];
	if($('#resultado').busqueda('selected') == null){
		$('<div>Debe seleccionar un Anuncio a cancelar</div>').modalpop({msg:true});
	}else{
		$.ajax({
		    url: url,
		    data: {announcementId:$('#resultado').busqueda('selected')},
		    success: function(result){
		    	if(result.success()){
		    		search_client_created_announcements($('#resultado').('page'));
		    	}
		    }
		});
	}
}

function select_offer(){
	var url = ClientUrls['SELECT_OFFER'];
	window.open(url+'/'+$('#resultado').busqueda('selected'),'_self');
}



