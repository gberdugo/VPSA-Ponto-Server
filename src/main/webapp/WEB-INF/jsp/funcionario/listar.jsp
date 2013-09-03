<!DOCTYPE HTML>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page contentType="text/html; charset=UTF-8"%>

<html lang="pt">
	<head>
		<jsp:include page="../base/cabecalho.jsp" />
		
		<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
		<script src="/resources/js/geral/jquery-1.10.2.min.js"></script>
		<!-- Include all compiled plugins (below), or include individual files as needed -->
		<script src="/resources/js/geral/bootstrap.min.js"></script>
		<script src="/resources/js/geral/geral.js"></script>
		
		<script type="text/javascript">
	   		$(document).ready(function() {
  				$.ajax({ 
  					url: "/funcionario/listar", 
  					type: "POST", 
  					cache: false,	 
  					success: function(response) {
  						if (response.status == "OK") {
  							var funcionarios = response.retorno;
  							
  							$.each(funcionarios, function(key, funcionario) {
  								var row = "";
  								row += "<tr>";
  								row += "<td>" + funcionario.id + "</td>";
  								row += "<td>" + funcionario.nome + "</td>";
  								row += "<td>" + funcionario.codigoRFID + "</td>";
  								row += "<td><form action='delete/" + funcionario.id + "' method='post'><button type='submit' class='btn btn-danger btn-mini'><span class='glyphicon glyphicon-remove-circle' /></button></form></td>";
  								row += "<td>" + funcionario.id + "</td>";
  								row += "</tr>";
  								
  								$("#tableFuncionario").append(row);
  							});
  						}
  					}, 
  					error: errorHandler
  				});
	   		});
	   	</script>
	</head>

	<body>
		<div class="container">
			<jsp:include page="../base/menu-principal.jsp" />

			<div class="row row-offcanvas row-offcanvas-right main-list">
				<div class="col-xs-12 col-sm-9">
					<h3 class="panel-title">
						<spring:message code="funcionario.lista.header" />
					</h3>
		<span class="glyphicon glyphicon-volume-off"></span> Te
					<table class="table table-hover">
						<thead>
							<tr>
								<th><spring:message code="funcionario.lista.table.id" /></th>
								<th><spring:message code="funcionario.lista.table.nome" /></th>
								<th><spring:message code="funcionario.lista.table.cartao" /></th>
								<th />
								<th />
							</tr>
						</thead>
						<tbody id="tableFuncionario" />
					</table>
				</div>
	
				<div role="navigation" id="sidebar"
					class="col-xs-6 col-sm-3 sidebar-offcanvas">
					<div class="well sidebar-nav">
						<ul class="nav">
							<li>Opções</li>
							<li class="active"><a href="/funcionario/novo" title="Cadastrar um novo funcionário">Novo</a></li>
							<li>Exportar</li>
							<li><a href="#">PDF</a></li>
							<li><a href="#">CSV</a></li>
						</ul>
					</div>
				</div>
	
			</div>
		</div>
	</body>
</html>
