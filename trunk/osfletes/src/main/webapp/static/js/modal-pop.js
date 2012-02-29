(function( $ ){

    var methods = {
		init : function(options) {
		  
		  var settings = $.extend( {
		      size:{width:400,height:300},
		      clazz:'popup',
		      buttons:[],
		      msg:false
		  }, options);
		  
		  menu = create_popup(settings,$(this));
		  return this;
	  },
	  	open: function(){ show_popup($(this).parent());},
	    close: function(){ close_popup($(this).parent());}
    };
    
    $.fn.modalpop = function(method){
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

function create_popup(settings,body){
	popup = $('<div>');
	var time = new Date();
	
	id = 'popup_'+time.getTime();
	popup.attr('id', id);
	$(popup).css('display','none');
	$(popup).addClass(settings.clazz);
	$(popup).css('width',settings.size.width);
	$(popup).css('height',settings.size.height);
	title = create_title(settings);
	buttons = create_buttons(settings,id);
	$(popup).append(title);
	$(body).addClass('body');
	$(body).height(settings.size.height - (80 + 20 + 20));
	$(popup).append(body);
	$(popup).append(buttons);
	$('body').append($(popup));
	if(settings.msg){
		show_popup($(popup));
	}
}

function create_title(settings){
	title = $('<div>');
	$(title).addClass('title')
	$(title).text(settings.title);
	return $(title);
}

function create_buttons(settings,id){
	buttons_container = $('<div class="buttons-container">');
	buttons_list = $('<ul>');
	if(!settings.msg){
		button_ok = create_button({label:'ok',funcion:settings.action});
		$(buttons_list).append($(button_ok));
		button_cancel = create_button({label:'cancel',funcion:function(){close_popup($('#'+id))}});
		for(var i=0;i<settings.buttons.length;i++){
			button = create_button(setting.buttons[i]);
			$(buttons_list).append($(button));
		}
	}else{
		button_cancel = create_button({label:'ok',funcion:function(){close_popup($('#'+id)); $('#'+id).remove();}});
	}
	

	
	$(buttons_list).append($(button_cancel));
	$(buttons_container).append($(buttons_list));
	return $(buttons_container);
}

function create_button(settings){
	button_container = $('<li >');
	button = $('<span class="button-class">')
	button.text(settings.label);
	button.click(settings.funcion);
	$(button_container).append($(button));
	return $(button_container);
}

function create_overlay(){
	// fondo transparente
    // creamos un div nuevo, con dos atributos
    var bgdiv = $('<div>').attr({
                            id: 'modal-pop-overlay'
                            });
    
    // agregamos nuevo div a la pagina
    $(bgdiv).css({
   	 'position':'fixed',
       'left':0,
       'top':0,
       'background-color':'#dfdfdf',
       'opacity':0.75,
       'filter':'alpha(opacity=75)'});
    
    $('body').append(bgdiv);
    
    // obtenemos ancho y alto de la ventana del explorer
    var wscr = $(window).width();
    var hscr = $(window).height();
    
    //establecemos las dimensiones del fondo
    $('#modal-pop-overlay').css("width", wscr);
    $('#modal-pop-overlay').css("height", hscr);	
}

function center_popup(element){
	   // dimensiones de la ventana del explorer 
	   var wscr = $(window).width();
	   var hscr = $(window).height();
	   
	   var wcnt = $(element).width();
	   var hcnt = $(element).height();
	   
	   // obtener posicion central
	   var mleft = ( wscr - wcnt ) / 2;
	   var mtop = ( hscr - hcnt ) / 2;
	   
	   // estableciendo ventana modal en el centro
	   $(element).css("left", mleft+'px');
	   $(element).css("top", mtop+'px');
	}

function close_popup(popup){
	$('#modal-pop-overlay').remove();
	$(popup).hide();
}

function show_popup(popup){
	create_overlay();
	center_popup($(popup));
	$(popup).show();
}