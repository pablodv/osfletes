<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<link type="text/css" href="css/ui-lightness/jquery-ui-1.8.16.custom.css" rel="Stylesheet" />	
<link type="text/css" href="css/datepicker_vista/datepicker_vista.css" rel="Stylesheet" />	
<%@ taglib prefix = "spring" uri = "http://www.springframework.org/tags" %>
 
<html>
<head>
	<script type="text/javascript" src="js/jquery-1.6.2.min.js"></script>
	<script type="text/javascript" src="js/jquery-ui-1.8.16.custom.min.js"></script>
	<script type="text/javascript" src="js/datepicker/datepicker.js"></script>
	<!-- 
	<script>
	$(function() {
		var dates = $( "#from, #to" ).datepicker({
			defaultDate: "+1w",
			changeMonth: true,
			numberOfMonths: 3,
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
	 -->
	<script type="text/javascript">
	window.addEvent('load', function() {
		new DatePicker('.demo_ranged', {
			pickerClass: 'datepicker_jqui',
			inputOutputFormat: 'd-m-Y',
			yearPicker: false,
			minDate: { date: '10-03-2009', format: 'd-m-Y' },
			maxDate: { date: '25-06-2009', format: 'd-m-Y' }
		});
	});	
	</script>
</head>
<body>
	<h1>New Car</h1>
	
	<c:url value="/guardarAnuncio" var="action"/>
 	<form:form method="post" action="${action}" commandName="anuncioDTO">

 		hora desde<br />
		<form:input path="horaDesde"/><br /><br />
		<form:errors path="horaDesde" element="div" cssClass="error" ></form:errors>
 
		hora hasta<br />
		<form:input path="horaHasta"/><br /><br />
		<form:errors path="horaHasta" element="div" cssClass="error" ></form:errors>

		direccion desde<br />
		<form:input path="direccion1"/><br /><br />
		<form:errors path="direccion1" element="div" cssClass="error" ></form:errors>

		direccion hasta<br />
		<form:input path="direccion2"/><br /><br />
		<form:errors path="direccion2" element="div" cssClass="error" ></form:errors>

		<div class="demo">
		
			<label for="from">From</label>
			<form:input path="fechaDesde" id="from" name="from"/>
			<form:errors path="fechaDesde" element="div" cssClass="error" ></form:errors>
			
			<label for="to">to</label>
			<form:input path="fechaHasta" id="to" name="to"/>
			<form:errors path="fechaHasta" element="div" cssClass="error" ></form:errors>
			
		</div>
		<br /><br />
		
		 descripcion:
		<form:textarea path="descripcion"/><br /><br />
		<form:errors path="descripcion" element="div" cssClass="error" ></form:errors>

		<input type="submit" value="Submit">
 
	</form:form>
</body>
</html>