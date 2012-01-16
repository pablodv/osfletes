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
	    	'botonera'			: [{title:'ofertar',image:'url("../imagenes/camion.png")',funcion:function(){alert('ofertar');}}],
			'columnas'			:[{title:'Identificador',propiedad:'id'}, {title:'Descripcion',propiedad:'descripcion'}],
			'funcionpaginacion' : busqueda,
			'resultado'			: resultado_paginado
		});	    		
	    	
	    }
	});
	
	
}