$(function(){
	$('#signup').click(function(){signup()});
	$('#signin').click(function(){signin()});
});

function signin(){
	window.open(Urls['SIGNIN'],'_self');	
}

function signup(){
	window.open(Urls['SIGNUP'],'_self');	
}