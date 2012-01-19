$(function(){
	$('#signup-client').click(function(){signup_client()});
	$('#signup-provider').click(function(){signup_provider()});
});

function signup_client(){
	window.open(Urls['SIGNUP_CLIENT'],'_self');
}

function signup_provider(){
	window.open(Urls['SIGNUP_PROVIDER'],'_self');
}