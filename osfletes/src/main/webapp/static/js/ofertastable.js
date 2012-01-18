$(function(){
	$('#buscar').click(function(){busqueda(1);});
});
function busqueda(pagina){
	var url = JsonUrls['OBTENER_ANUNCIOS_FILTRADOS'];
	$.ajax({
	    url: url,
	    data: {'pagina':pagina},
	    success: function(resultado_paginado){
	    	$('#latabla').busqueda({
	    	'botonera'			: [{title:'ofertar',imagen:'url("static/imagenes/add.png")',funcion:function(){alert('ofertar');}}],
			'element_props'			:[{title:'Identificador',prop:'id'}, {title:'Descripcion',prop:'descripcion'}],
			'funcionpaginacion' : busqueda,
			'resultado'			: resultado_paginado
		});	    		
	    	
	    }
	});
	
	
}