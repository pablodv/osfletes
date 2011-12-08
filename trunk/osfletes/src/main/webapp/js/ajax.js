function PostJSON(data, callback){
				$.ajax({
				    type: "post",
				    url: "/controllers/AJAX-Controller.php",
				    dataType: "json",
				    data: data,
				    success: callback,
				    error: function (XMLHttpRequest, textStatus, errorThrown) {
						$('#php_error').html(XMLHttpRequest.responseText);
						$('#php_error').show();
				    }
				});
				
			}