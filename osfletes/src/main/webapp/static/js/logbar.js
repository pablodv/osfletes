$(function(){
	$('#logout').click(function(){logout()})
});

function logout(){
	$('#logout-form').submit();
}