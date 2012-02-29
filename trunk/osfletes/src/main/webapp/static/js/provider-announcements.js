$(function(){
	$('#search').click(function(){search_provider_announcements(1);})
	$('#offer-form').modalpop({action:create_offer,title:'Ofertar'});
	$("#offer-form #serviceDate").datepicker();
	$('#offer').click(make_offer);
	$('#search').click();
});

function search_provider_announcements(page){
	var url = ProviderUrls['GET_PROVIDER_ANNOUNCEMENTS'];
	
	$.ajax({
	    url: url,
	    data: get_announcement_search_filter(page),
	    success: function(result){
		    	if(result.success){
		    	$('#resultado').busqueda({
		    	'element_props'			:[{title:'Creado',prop:'fechaCreacion'},
		    	               			  {title:'Fecha de Cierre',prop:'fechaCierre'},
		    	               			  {title:'Fecha de Servicio Desde',prop:'fechaDesde'},
		    	               			  {title:'Fecha de Servicio Hatsa',prop:'fechaHasta'}],
				'funcionpaginacion' : search_provider_announcements,
				'resultado'			: result.response
		    	});	    		
	    	}
	    }
	});
}

function make_offer(){
	$('#offer-form').modalpop('open');
}

function create_offer(){
	var url = ProviderUrls['CREATE_OFFER'];
	$.ajax({
	    url: url,
	    data: {announcementId: $('#resultado').busqueda('selected'),value:$('#offer-form #value').val(),serviceDate:$('#offer-form #serviceDate').val()},
	    success: function(result){
	    	if(result.success){
	    		$('#offer-form').modalpop('close');
	    		search_provider_announcements($('#resultado').busqueda('selected'));
	    	}	    		
    	}
    });
}





