$(function(){
	$('#search').click(function(){getOfertas();});
	
});
function getOfertas(){
	
	var url = JsonUrls['GET_ALL_OFFERS'];
	
	$.ajax({
	    url: url,
	    data: null,
	    success: function(data){
	    	for(i=0;i<data.length;i++){
	    		$('#results').append('<div>'+data[i].valorOferta+'</div>');	    		
	    	}
	    },
	    error: function (XMLHttpRequest, textStatus, errorThrown) {
			alert('ERROR');
	    }
	});
	
}