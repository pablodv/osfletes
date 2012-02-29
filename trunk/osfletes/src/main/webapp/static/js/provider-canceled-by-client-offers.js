$(function(){
	$('#search').click(function(){search_provider_canceled_by_provider_offers(1);})
	$('#search').click();
});

function search_provider_canceled_by_provider_offers(page){
	var url = ProviderUrls['GET_CANCELED_BY_CLIENT_PROVIDER_OFFERS'];
	
	$.ajax({
	    url: url,
	    data: get_offers_search_filter(page),
	    success: function(result){
		    	if(result.success){
		    	$('#resultado').busqueda({
		    	'element_props'			:[{title:'Identificador',prop:'id'}, {title:'Creado',prop:'fechaCreacion'}],
				'funcionpaginacion' : search_provider_canceled_by_provider_offers,
				'resultado'			: result.response
		    	});	    		
	    	}
	    }
	});
}