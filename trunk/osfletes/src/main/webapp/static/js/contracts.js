$(function(){
	$('#search').click(function(){search_contracts_announcements(1);})
	$('#search').click();
});

function search_contracts_announcements(page){
	var url = PrivateUrls['GET_CONTRACTS'];
	$.ajax({
	    url: url,
	    data: get_contracts_search_filter(page),
	    success: function(result){
		    	if(result.success){
		    	$('#resultado').busqueda({
		    	'element_props'			:[{title:'Identificador',prop:'id'}, {title:'Creado',prop:'fechaCreacion'}],
				'funcionpaginacion' : search_contracts_announcements,
				'resultado'			: result.response
		    	});	    		
	    	}
	    }
	});
}