$(function(){
	$('#search').click(function(){search_provider_non_awarded_offers(1);})
	$('#search').click();
});

function search_provider_non_awarded_offers(page){
	var url = ProviderUrls['GET_NON_AWARDED_PROVIDER_OFFERS'];
	
	$.ajax({
	    url: url,
	    data: get_offers_search_filter(page),
	    success: function(result){
		    	if(result.success){
		    	$('#resultado').busqueda({
		    	'element_props'			:[{title:'Identificador',prop:'id'}, {title:'Creado',prop:'fechaCreacion'}],
				'funcionpaginacion' : search_provider_non_awarded_offers,
				'resultado'			: result.response
		    	});	    		
	    	}
	    }
	});
}