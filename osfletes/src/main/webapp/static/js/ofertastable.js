$(function(){
	$('#buscar').click(function(){busqueda(1);});
});
function busqueda(pagina){
	var url = ProviderUrls['OBTENER_ANUNCIOS_FILTRADOS'];
	$.ajax({
	    url: url,
	    data: {'pagina':pagina},
	    success: function(resultado_paginado){
	    	$('#latabla').busqueda({
	    	'botonera'			: [{title:'ofertar',imagen:'url("static/imagenes/add.png")',funcion:function(){alert('ofertar');}}],
			'element_props'			:[{title:'Identificador',prop:'id'}, {title:'Descripcion',prop:'descripcion'},{title:'Fecha Creacion',prop:'fechaDesde'},{title:'Fecha Cierre',prop:'fechaHasta'},{title:'Hora Desde',prop:'horaDesde'},{title:'Hora Hasta',prop:'horaHasta'}],
			'funcionpaginacion' : busqueda,
			'resultado'			: resultado_paginado
		});	    		
	    	
	    }
	});
	
	
}