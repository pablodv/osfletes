$(function(){
	$('#user-menu').menu({items:[{label:'Inbox',funcion:inbox},{label:'Salir',funcion:logout}]});
});

function logout(){
	$('#logout-form').submit();
}

function inbox(){
	window.open(PrivateUrls['INBOX'],'_self');
}
