$(function(){
	$('#user-menu').menu({items:[{label:'Inbox',funcion:inbox},{label:'Salir',funcion:logout},{label:'Crear Anuncio',funcion:crearAnuncio}]});
});

function logout(){
	$('#logout-form').submit();
}

function inbox(){
	window.open(PrivateUrls['INBOX'],'_self');
}

function crearAnuncio(){
	window.open(ClientUrls['CREATE_ANNOUNCEMENT'],'_self');
}