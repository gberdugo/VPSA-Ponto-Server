<!DOCTYPE HTML>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page contentType="text/html; charset=UTF-8"%>

<html lang="pt">
	<head>
		<jsp:include page="../base/cabecalho.jsp" />
		
		<!-- TableSorter -->
		<link rel="stylesheet" href="/resources/css/geral/theme.bootstrap.css">
		
		<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
		<script src="/resources/js/geral/jquery-1.10.2.min.js"></script>
		<!-- Include all compiled plugins (below), or include individual files as needed -->
		<script src="/resources/js/geral/bootstrap.min.js"></script>
		<script src="/resources/js/geral/jquery.tablesorter.min.js"></script>
		<script src="/resources/js/geral/jquery.tablesorter.widgets.js"></script>
		<!-- Geral -->
		<script src="/resources/js/geral/geral.js"></script>
		
		<script type="text/javascript">
	   		$(document).ready(function() {
  				buscar();
	   		});
	   		
	   		function buscar() {
	   			$.ajax({ 
  					url: "/funcionario/listar", 
  					type: "POST", 
  					cache: false,	 
  					success: function(response) {
  						if (response.status == "OK") {
  							$("#tableFuncionario").html("");
  							var funcionarios = response.retorno;
  							
  							$.each(funcionarios, function(key, funcionario) {
  								var row = "";
  								row += "<tr>";
  								row += "<td>" + funcionario.id + "</td>";
  								row += "<td>" + funcionario.nome + "</td>";
  								row += "<td>" + funcionario.codigoRFID + "</td>";
  								row += "<td><span class='icon-edit' onclick='editar(" + funcionario.id + ")' /></td>";
  								row += "<td><span class='icon-remove' onclick='remover(" + funcionario.id + ")' /></td>";
  								row += "</tr>";
  								
  								$("#tableFuncionario").append(row);
  							});
  						}
  						initTable();
  					}, 
  					error: errorHandler
  				});
	   		}
	   		
	   		function initTable() {
				$.extend($.tablesorter.themes.bootstrap, {
					table      : 'table table-bordered',
					header     : 'bootstrap-header', // give the header a gradient background
					footerRow  : '',
					footerCells: '',
					icons      : '', // add "icon-white" to make them white; this icon class is added to the <i> in the header
					sortNone   : 'bootstrap-icon-unsorted',
					sortAsc    : 'icon-chevron-up',
					sortDesc   : 'icon-chevron-down',
					active     : '', // applied when column is sorted
					hover      : '', // use custom css here - bootstrap class may not override it
					filterRow  : '', // filter row class
					even       : '', // odd row zebra striping
					odd        : ''  // even row zebra striping
				});

				$("table").tablesorter({
					theme : "bootstrap",
					widthFixed: true,
					headerTemplate : '{content} {icon}',
					widgets : [ "uitheme", "filter", "zebra" ],
					widgetOptions : {
						zebra : ["even", "odd"],
						filter_reset : ".reset"
					}
				}).tablesorterPager({
					container: $(".pager"),
					cssGoto  : ".pagenum",
					removeRows: false,
					output: '{startRow} - {endRow} / {filteredRows} ({totalRows})'
				});
	   		}
	   		
	   		function remover(id) {
	   			$.ajax({ 
  					url: "/funcionario/remover/" + id, 
  					type: "POST",
  					cache: false,
  					success: buscar,
  					error: errorHandler
  				});
	   		}
	   		
	   		function editar(id) {
	   			alert(id);
	   		}
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
					<table class="tablesorter">
						<thead>
							<tr>
								<th><spring:message code="funcionario.lista.table.id" /></th>
								<th><spring:message code="funcionario.lista.table.nome" /></th>
								<th><spring:message code="funcionario.lista.table.cartao" /></th>
								<th class="filter-false sorter-false" />
								<th class="filter-false sorter-false" />
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
			
			<jsp:include page="../base/rodape.jsp" />
			
		</div> <!-- /container -->
		
	</body>
</html>
