$(function(){
	$('#search').click(function(){search_roles(1);});
	$('#edition-div').modalpop({action:save_role,title:'create role'});
});

function search_roles(page){
	var url = AdminUrls['SEARCH_ROLES'];
	$.ajax({
	    url: url,
	    data: {'pagina':page,role:$('#role').val()},
	    success: function(resultado_paginado){
	    	$('#resultado').busqueda({
	    	'botonera'			: [{title:'Crear role',imagen:'url("static/imagenes/add.png")',funcion:create_role},
	    	          			   {title:'Eliminar role',imagen:'url("static/imagenes/delete.png")',funcion:delete_role}],
			'element_props'			:[{title:'Identificador',prop:'id'}, {title:'Role',prop:'role'}],
			'funcionpaginacion' : search_roles,
			'resultado'			: resultado_paginado
		});	    		
	    	
	    }
	});
}

function create_role(){
	$('#edition-div').modalpop('open');
}

function save_role(){
	var url = AdminUrls['CREATE_ROLE'];
	$.ajax({
	    url: url,
	    data: {role:$('#role_name').val()},
	    success: function(response){
	    	$('#edition-div').modalpop('close');
		}
	});
}

function delete_role(){
	
}