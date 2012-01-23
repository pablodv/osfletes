$(function(){
	$('#signup').click(function(){signup()});
	$('#signin').click(function(){signin()});
});

function signin(){
	window.open(PublicUrls['SIGNIN'],'_self');	
}

function signup(){
	window.open(PublicUrls['SIGNUP'],'_self');	
}