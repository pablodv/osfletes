$(function() {
	$('body').ajaxStart(function(){showLoading();});
	$('body').ajaxComplete(function(){removeLoading();});

});

function showLoading(){
    // fondo transparente
    // creamos un div nuevo, con dos atributos
    var bgdiv = $('<div>').attr({
                            className: 'bgtransparent',
                            id: 'bgtransparent'
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
    $('#bgtransparent').css("width", wscr);
    $('#bgtransparent').css("height", hscr);
    
    
    
    // agregamos contenido HTML a la ventana modal
    $('#bgtransparent').after('<div id="loading" class="loading-indicator-overlay">'+
		   	'<div class="loading-indicator"></div>'+
			'</div>');
    
    center('loading');
    $('#loading').show();
    
    
    // redimensionamos para que se ajuste al centro y mas
    

    
}

function center(id){
   // dimensiones de la ventana del explorer 
   var wscr = $(window).width();
   var hscr = $(window).height();
   
   var wcnt = $('#'+id).width();
   var hcnt = $('#'+id).height();
   
   // obtener posicion central
   var mleft = ( wscr - wcnt ) / 2;
   var mtop = ( hscr - hcnt ) / 2;
   
   // estableciendo ventana modal en el centro
   $('#'+id).css("left", mleft+'px');
   $('#'+id).css("top", mtop+'px');
} 

       
function removeLoading(){
       // removemos divs creados
       $('#loading').remove();
       $('#bgtransparent').remove();
}
