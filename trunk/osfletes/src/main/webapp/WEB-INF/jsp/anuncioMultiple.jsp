<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<link type="text/css" href="css/ui-lightness/jquery-ui-1.8.16.custom.css" rel="Stylesheet" />	
 
<html>
<head>
	<script type="text/javascript" src="js/jquery-1.6.2.min.js"></script>
	<script type="text/javascript" src="js/jquery-ui-1.8.16.custom.min.js"></script>
	<script>
	$(function() {
		var dates = $( "#from, #to" ).datepicker({
			defaultDate: "+1w",
			changeMonth: true,
			numberOfMonths: 1,
			onSelect: function( selectedDate ) {
				var option = this.id == "from" ? "minDate" : "maxDate",
					instance = $( this ).data( "datepicker" ),
					date = $.datepicker.parseDate(
						instance.settings.dateFormat ||
						$.datepicker._defaults.dateFormat,
						selectedDate, instance.settings );
				dates.not( this ).datepicker( "option", option, date );
			}
		});
	});
	</script>
</head>
<body>
	<h1>New Car</h1>
	
	<c:url value="/guardarAnuncio" var="action"/>
 	<form:form method="post" action="${action}" commandName="anuncio">
 
		fecha desde<br />
		<form:input path="fechaDesde"/><br /><br />
 
		fecha hasta<br />
		<form:input path="fechaHasta"/><br /><br />

 		hora desde<br />
		<form:input path="horaDesde"/><br /><br />
 
		hora hasta<br />
		<form:input path="horaHasta"/><br /><br />

		<div class="demo">
		
			<label for="from">From</label>
			<input type="text" id="from" name="from"/>
			<label for="to">to</label>
			<input type="text" id="to" name="to"/>
		
		</div>
 
		<input type="submit" value="Submit">
 
	</form:form>
</body>
</html>