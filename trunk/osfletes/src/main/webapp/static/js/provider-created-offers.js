$(function(){
	$('#search').click(function(){search_provider_created_offers(1);})
	$('#cancel').click(cancel_offer);
	$('#search').click();
});

function search_provider_created_offers(page){
	var url = ProviderUrls['GET_CREATED_PROVIDER_OFFERS'];
	
	$.ajax({
	    url: url,
	    data: get_offers_search_filter(page),
	    success: function(result){
		    	if(result.success){
		    	$('#resultado').busqueda({
		    	'element_props'			:[{title:'Identificador',prop:'id'}, {title:'Creado',prop:'fechaCreacion'}],
				'funcionpaginacion' : search_provider_created_offers,
				'resultado'			: result.response
		    	});	    		
	    	}
	    }
	});
}

function cancel_offer(){
	var url = ProviderUrls['CANCEL_OFFER'];
	if($('#resultado').busqueda('selected') == null){
		$('<div>Debe seleccionar una Oferta a Cancelar</div>').modalpop({msg:true});
	}else{
		$.ajax({
		    url: url,
		    data: {announcementId:$('#resultado').busqueda('selected')},
		    success: function(result){
		    	if(result.success){
		    		search_provider_created_offers($('#resultado').busqueda('page'));
		    	}
		    }
		});
	}
}





