$(function(){
	$('#search').click(function(){search_users(1)});
});

function search_users(page){
	var url = AdminUrls['SEARCH_USERS'];
	$.ajax({
	    url: url,
	    data: {'pagina':page,username:$('#username').val(),enable:$('#enable').val()},
	    success: function(resultado_paginado){
	    	$('#resultado').busqueda({
	    	'botonera'			: [{title:'Cambiar Disponibilidad',imagen:'url("static/imagenes/delete.png")',funcion:function(){change_status()}}],
			'element_props'			:[{title:'Identificador',prop:'id'}, {title:'Username',prop:'username'},{title:'Fecha Creacion',prop:'fechaCreacion'},{title:'Habilitado',prop:'enabled',type:"boolean"}],
			'funcionpaginacion' : search_users,
			'resultado'			: resultado_paginado
		});	    		
	    	
	    }
	});
}

function change_status(){
	var url = AdminUrls['CHANGE_USER_STATUS'];
	
	$.ajax({
	    url: url,
	    data: {'userId': $('#resultado').busqueda('selected') },
	    success: function(response){
	    	search_users($('#resultado').busqueda('page'));    	
	    }
	});
}