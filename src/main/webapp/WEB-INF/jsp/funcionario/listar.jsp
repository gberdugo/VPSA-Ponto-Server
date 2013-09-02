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

</head>

<body>
	<div class="container">

		<jsp:include page="../base/menu-principal.jsp" />

		<div class="row row-offcanvas row-offcanvas-right main-list">
			<div class="col-xs-12 col-sm-9">
				<h3 class="panel-title">
					<spring:message code="funcionario.lista.header" />
				</h3>

				<table class="table table-hover">
					<thead>
						<tr>
							<th>#</th>
							<th>First Name</th>
							<th>Last Name</th>
							<th>Username</th>
						</tr>
					</thead>
					<tbody>
						<tr>
							<td>1</td>
							<td>Mark</td>
							<td>Otto</td>
							<td>@mdo</td>
						</tr>
						<tr>
							<td>2</td>
							<td>Jacob</td>
							<td>Thornton</td>
							<td>@fat</td>
						</tr>
						<tr>
							<td>3</td>
							<td colspan="2">Larry the Bird</td>
							<td>@twitter</td>
						</tr>
					</tbody>
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
