<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "spring" uri = "http://www.springframework.org/tags" %>

<%--
<c:forEach items="${lista}" var="anuncio">
<div>${anuncio.fechaDesde}</div>
<div>${anuncio.fechaHasta}</div>
<div>${anuncio.horaDesde}</div>
<div>${anuncio.horaHasta}</div>
<div>${anuncio.direccion1}</div>
<div>${anuncio.direccion2}</div>
</c:forEach>
 --%>

<table id="table-mis-torneos" class="table-mis-torneos">
	<thead>
		<tr>
			<th>Nombre</th>
			<th>Cuándo</th>
			<th>Dónde</th>
			<th>&nbsp;</th>
		</tr>
	</thead>
	
	<c:forEach items="${lista}" var="anuncio">
		<tr id="torneo-9" class="vcard">
			<td class="col-avatar">
				<div class="cancha-item">
					<div class="content">
						<a class="name fn url" href="/torneos/ver/9">Fui a la pelota</a>
						<small>Fútbol 5</small>
						<br>
						Hombres
						<br>
						+18 años.
					</div>
				</div>
			</td>
			<td>
				<span>Inicia: 9-Abr-2011</span>
				<br>
				<span>Termina: 1-Ene-1970</span>
				<br>
				<br>
				<span>$150 por partido por equipo</span>
			</td>
			<td class="col-direccion adr">
				<span class="street-address">Ortíz de Ocampo 3250</span>
				<span class="locality">Capital Federal</span>
				,
				<br>
				<span class="region">Ciudad de Buenos Aires</span>
				.
				<span class="tel">Tel: 15-5924-1284</span>
			</td>				
		</tr>	
	</c:forEach>
	
</table>