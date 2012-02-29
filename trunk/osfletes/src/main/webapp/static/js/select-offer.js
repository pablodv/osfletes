$(function(){
	$('#search').click(function(){search_client_announcement_offers(1);})
	$('#confirm-selection').modalpop({action:create_contract,title:'Esta Seguro?'});
	$('#select').click(select_offer);
	$('#search').click();
	
});

function search_client_announcement_offers(page){
	var url = ClientUrls['GET_ANNOUNCEMENT_OFFERS'];
	$.ajax({
	    url: url,
	    data: get_announcement_offers_search_filter(page,$('#announcementId').val()),
	    success: function(result){
		    	if(result.success){
		    	$('#resultado').busqueda({
		    	'element_props'			:[{title:'Oferta',prop:'valorOferta'},{title:'Fecha del Servicio',prop:'fechaServicio'}],
				'funcionpaginacion' : search_client_announcement_offers,
				'resultado'			: result.response
		    	});	    		
	    	}
	    }
	});
}

function select_offer(){
	if($('#resultado').busqueda('selected') != null){
		open_confirm();
	}else{
		$('<div>Debe seleccionar una Oferta</div>').modalpop({msg:true});
	}
}

function open_confirm(){
	var url = ClientUrls['GET_ANNOUNCEMENT_OFFER'];
	$.ajax({
	    url: url,
	    data: {announcementId:$('#announcementId').val(),offerId:$('#resultado').busqueda('selected')},
	    success: function(result){
		    	if(result.success){
		    		var offer = result.response;
		    		$('#confirm-selection #offer-user').text();
		    		$('#confirm-selection #offer-price').text(offer.valorOferta);
		    		$('#confirm-selection #offer-date').text(offer.fechaServicio);
		    		$('#confirm-selection').modalpop('open');
		    	}	    		
	    	}
	    });
}

function create_contract(){
	$('#selected_offer').val($('#resultado').busqueda('selected'));
	$('#form').submit();
}