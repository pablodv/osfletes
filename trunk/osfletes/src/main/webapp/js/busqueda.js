(function( $ ){

  $.fn.busqueda = function(options) {
	  
	  var settings = $.extend( {
	      'funcionpaginacion'	: function(){alert('Te olvidaste la funcion de paginacion');}
	  }, options);

	  var container = $('<div class="busqueda_container">');
	  $(container).append(dibujar_botonera(settings.botonera));
	  $(container).append(dibujar_tabla(settings));
	  $(container).append(createPagination(settings.resultado['cantidad'],settings.resultado['pagina'],settings.funcionpaginacion));
	  $(this).html($(container));
	  return this;
  };
})( jQuery );

function dibujar_cabezera(settings){
	var thead = $('<thead>');
	var head = null;
	var columnas = settings.columnas
	for(var i =0;i< columnas;i++){
		head = $('<th>'+columnas[i].title+'</th>');
		$(thead).append($(head));
	}
}

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

function dibujar_tabla(settings){
	
	var table = $('<table>');
	var tbody = $('<tbody>');
	var elementos = settings.resultado['resultados'];
	var columnas = settings.columnas; 
	for(var i=0;i<elementos.length;i++){
		$(tbody).append(dibujar_fila(elementos[i],columnas));
	}	
	
	$(table).append(dibujar_cabezera(settings));
	$(table).append($(tbody).html());
	
	var div = $('<div class="tabla_container">')
	$(div).append($(table));
	return $(div);
}

function dibujar_fila(elemento,columnas){
	
	var tr = $('<tr>');
	$(tr).append('<td><input type="radio" name="element" value="'+elemento['id']+'"/></td>');
	for(var i=0;i<columnas.length;i++){
		$(tr).append('<td>'+ elemento[columnas[i].propiedad] +'</td>');
	}
	
	return $(tr);
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
	var pagina = $('<span id="primero" class="pagina">&lt;&lt;</span>');
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
	var pagina = $('<span id="previo" class="pagina">&lt;</span>');
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
	var pagina = $('<span id="ultimo" class="pagina">&gt;&gt;</span>');
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
	var pagina = $('<span id="proximo" class="pagina">&gt;</span>');
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
	var pagina = $('<span id="'+value+'" class="pagina">'+value+'</span>')
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
	this.funcion = funcion;
	
}

function Columna(title, propiedad){
	this.title = title;
	this.propiedad = propiedad;
}