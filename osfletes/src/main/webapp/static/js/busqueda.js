(function( $ ){

    var methods = {
		init : function(options) {
		  
		  var settings = $.extend( {
		      'botonera': null,
			  'funcionpaginacion'	: function(){alert('Te olvidaste la funcion de paginacion');}
		  }, options);
	
		  var container = $('<div class="busqueda_container">');
		  if(settings.botonera != null){
			  $(container).append(dibujar_botonera(settings.botonera));
		  }
		  $(container).append(dibujar_tabla(settings.element_props,settings.resultado));
		  $(container).append(createPagination(settings.resultado['cantidad'],settings.resultado['pagina'],settings.funcionpaginacion));
		  $(this).html($(container));
		  return this;
	  },
	  selected : function(){ return  $('input[name=element]:checked').length == 0 ? null: $('input[name=element]:checked').val(); },
	  page: function(){ return $('.pagination_container .seleccionada').attr('id');}
    };
    
    $.fn.busqueda = function(method){
    	// Method calling logic
        if ( methods[method] ) {
          return methods[ method ].apply( this, Array.prototype.slice.call( arguments, 1 ));
        } else if ( typeof method === 'object' || ! method ) {
          return methods.init.apply( this, arguments );
        } else {
          $.error( 'Method ' +  method + ' does not exist on busqueda' );
        }  
    };
  
  
})( jQuery );

function dibujar_botonera(botones){
	var botonera = $('<div class="botonera">');
	
	for(var i=0;i<botones.length;i++){
		$(botonera).append(dibujar_boton(botones[i]));
	}
	
	var botonera_container = $('<div class="botonera_container">');
	$(botonera_container).append($(botonera))
	return $(botonera_container);
}

function dibujar_boton(elemento_boton){
	
	var boton = $('<span class="boton" title="'+elemento_boton.title+'">');
	$(boton).css('background-image',elemento_boton.imagen);
	$(boton).click(elemento_boton.funcion);
	var boton_container= $('<div class="boton_container">');
	$(boton_container).append($(boton))
	return $(boton_container);
}

function dibujar_tabla(element_props,resultado){
	
	var table = $('<table>');
	var tbody = $('<tbody>');
	var elementos = resultado['resultados'];
	for(var i=0;i<elementos.length;i++){
		$(tbody).append(dibujarfila(element_props,elementos[i]));
	}	
	
	$(table).append(dibujarcabezera(element_props));
	$(table).append($(tbody));
	
	var div = $('<div class="tabla_container">')
	$(div).append($(table));
	return $(div);
}

function dibujarcabezera(element_props){
	var thead = $('<thead>');
	var head = null;
	$(thead).append('<th></th>');
	for(var i =0;i< element_props.length;i++){
		head = $('<th>'+element_props[i].title+'</th>');
		$(thead).append($(head));
	}
	
	return $(thead);
}

function dibujarfila(element_props,element){
	tr = $('<tr>');
	$(tr).append($('<td class="first"><input type="radio" name="element" value="'+element['id']+'"></td>'));
	for(var i=0;i<element_props.length;i++){
		switch (element_props[i].type) {
		case 'boolean':
			value = solve_bool_value(element_props[i],element);
			break;
		case 'text':
			value = solve_text_value(element_props[i],element);
			break;
		default:
			value = solve_text_value(element_props[i],element);
			break;
		}
		td = solve_commons(value,element_props[i])
		$(tr).append($(td));
	}
	
	return $(tr);
	
}

function solve_bool_value(props,element){
	input = $("<input>");
	$(input).attr("type", 'checkbox');
	$(input).attr("disabled", 'disabled');
	
	if(element[props.prop] != null && element[props.prop] == 1){
		$(input).attr("checked","checked");
	}
	
	return $(input);		
}

function solve_text_value(props,element){
	
	value = element[props.prop] == null || element[props.prop] == ''? $('<span>---</span>'):$('<span>'+element[props.prop]+'</span>');
	return $(value);
}

function solve_commons(value,props){
	td = $('<td>')
	if(props.clazz != null){
		$(td).addClass(props.clazz);
	}
		
	if(props.events !=null){
		set_events(td, props.events);
	}
	
	return $(td).append($(value));
}

function set_events(element,events){
	for(var i=0;i<events.length;i++){
		$(element).bind(events[i].event,events[i].handler);
	}
}

function createPagination(cantPaginas,selectedPage,functionParam){
	var longitudPaginador =  5
	longitudPaginador = cantPaginas<longitudPaginador ? cantPaginas : longitudPaginador; 
	var paginas_container = $('<div id="pagination_container" class="pagination_container"></div>');
	$(paginas_container).append(primero(functionParam,selectedPage));
	$(paginas_container).append(previo(functionParam,selectedPage));
	var desde = null;
	if(cantPaginas-selectedPage < longitudPaginador){
		desde = (cantPaginas + 1) - (longitudPaginador);
		hasta = cantPaginas
	}else{
		if(selectedPage < Math.floor(longitudPaginador)){
			desde = 1;
			hasta = longitudPaginador;
		}else{
			desde = selectedPage- Math.floor(longitudPaginador/2);
			hasta = parseInt(selectedPage) + parseInt(Math.floor(longitudPaginador/2));
		}
	}
	
	for(var i=desde; i<= hasta; i++){
		var a = createPageElement(i,functionParam,selectedPage,cantPaginas);
		$(paginas_container).append(a);
	}
	
	$(paginas_container).append(proximo(functionParam,selectedPage,cantPaginas));
	$(paginas_container).append(ultimo(functionParam,selectedPage,cantPaginas));
	procesarSeleccionado(selectedPage, cantPaginas);
	return $(paginas_container);	
}

function primero(funcion_paginar,selectedPage){
	var pagina = $('<span id="primero" class="pagina" name="pagina">&lt;&lt;</span>');
	$(pagina).click(
			function(){
				if(!$(this).hasClass('deshabilitado')){
					funcion_paginar(1);
				}
			});
	
	
	$(pagina).toggleClass('deshabilitado',selectedPage == 1); 
	
	return $(pagina);
	
}

function previo(funcion_paginar,selectedPage){
	var pagina = $('<span id="previo" class="pagina" name="pagina">&lt;</span>');
	$(pagina).click(
			function(){
				if(!$(this).hasClass('deshabilitado')){
					funcion_paginar(parseInt($('.pagination_container .seleccionada').attr('id'))-1);
				}
			});
	$(pagina).toggleClass('deshabilitado',selectedPage == 1);
	return $(pagina);
}

function ultimo(funcion_paginar,paginaSeleccionada,cantPaginas){
	var pagina = $('<span id="ultimo" class="pagina" name="pagina">&gt;&gt;</span>');
	$(pagina).click(
			function(){
				if(!$(this).hasClass('deshabilitado')){
					funcion_paginar(cantPaginas);
				}
			});
	$(pagina).toggleClass('deshabilitado',paginaSeleccionada == cantPaginas);
	return $(pagina);
}

function proximo(funcion_paginar,paginaSeleccionada,cantPaginas){
	var pagina = $('<span id="proximo" class="pagina" name="pagina">&gt;</span>');
	$(pagina).click(
			function(){
				if(!$(this).hasClass('deshabilitado')){
					funcion_paginar(parseInt($('.pagination_container .seleccionada').attr('id'))+1);
				}
			});
	$(pagina).toggleClass('deshabilitado',paginaSeleccionada == cantPaginas);
	return $(pagina);
}

function createPageElement(value, functionClick, paginaSeleccionada,cantPaginas){
	var pagina = $('<span id="'+value+'" class="pagina" name="pagina">'+value+'</span>')
	$(pagina).click(
	function(){
		if($(this).hasClass('seleccionada')) return;
		$('.pagination_container .seleccionada').removeClass('seleccionada');
		$(this).addClass('seleccionada');
		procesarSeleccionado(value,cantPaginas);
		functionClick($(this).attr('id'));
	});
	if(value == paginaSeleccionada){
		$(pagina).addClass('seleccionada');
	}
	
	return $(pagina);
}

function procesarSeleccionado(value, cantPaginas){
		
	$('#previo').toggleClass('deshabilitado',value == 1);
	$('#primero').toggleClass('deshabilitado',value == 1);
	$('#proximo').toggleClass('deshabilitado',value == cantPaginas);
	$('#ultimo').toggleClass('deshabilitado',value == cantPaginas);
	
}

function showPreviousGroup(index){
	
	$('#pagination > #'+(index+1)+'').hide();
	$('#pagination > #'+(index)+'').show();

}

function showNextGroup(index){

	$('#pagination > #'+index+'').hide();
	$('#pagination > #'+(index+1)+'').show();

}

function Boton(title,imagen,funcion){
	this.title = title;
	this.imagen =imagen;
	this.funcion = funcion
	
}

function get_selected_id(){
	return $('input[name=element]:checked').val();
}

function get_active_page(){
	return $('.pagination_container .seleccionada').attr('id');
}