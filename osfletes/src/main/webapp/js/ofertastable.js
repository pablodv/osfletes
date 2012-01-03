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
	    	'botonera'			: [new Boton('ofertar','url("../imagenes/camion.png")',function(){alert('ofertar');})],
			'columnas'			:[new Columna('Identificador','id'), new Columna('Descripcion','descripcion')],
			'funcionpaginacion' : busqueda,
			'resultado'			: resultado_paginado
		});	    		
	    	
	    }
	});
	
	
}