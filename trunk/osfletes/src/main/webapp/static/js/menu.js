(function( $ ){

    var methods = {
		init : function(options) {
		  
		  var settings = $.extend( {
		      
		  }, options);
		  
		  
		  menu = dibujar_menu(settings.items);
		  $(this).append($(menu));
		  $(this).click(function(){$('#'+$(this).attr('id') +' .menu').toggle()})
		  return this;
	  },
    };
    
    $.fn.menu = function(method){
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

function dibujar_menu(items){
	menu = $('<ul class="menu">')
	for(var i=0;i<items.length;i++){
		item  = dibujar_item(items[i]);
		$(menu).append($(item));
	}
	
	$(menu).focusout(function(){alert('aaa');$(this).hide()})
	return $(menu);
}

function dibujar_item(item){
	item_element = $('<li class="item">');
	item_element.click(item.funcion);
	if(item.events !=null){
		set_events(item_element,item.events);
	}
	item_element.text(item.label);
	return $(item_element);
}

function set_events(element,events){
	for(var i=0;i<events.length;i++){
		$(element).bind(events[i].event,events[i].handler);
	}
}