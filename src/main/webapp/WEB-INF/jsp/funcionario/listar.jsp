<!DOCTYPE HTML>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page contentType="text/html; charset=UTF-8"%>

<html lang="pt">
	<head>
	    <meta charset="utf-8">
	    <title>VPSA Ponto</title>
	    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    	<!-- Bootstrap -->
    	<link href="/resources/css/geral/bootstrap.min.css" rel="stylesheet">
    	<!-- Main -->
    	<link href="/resources/css/geral/main.css" rel="stylesheet">
    	<link rel="stylesheet" type="text/css" media="screen" href="/resources/css/geral/jquery-ui-1.10.3.custom.min.css" />
		<link rel="stylesheet" type="text/css" media="screen" href="/resources/css/geral/ui.jqgrid.css" />
    	<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
    	<script src="/resources/js/geral/jquery-1.10.2.min.js"></script>
    	<!-- Include all compiled plugins (below), or include individual files as needed -->
    	<script src="/resources/js/geral/bootstrap.min.js"></script>
    	<!-- Geral -->
    	<script src="/resources/js/geral/geral.js"></script>
    	<script src="/resources/js/geral/i18n/grid.locale-pt-br.js" type="text/javascript"></script>
		<script src="/resources/js/geral/jquery.jqGrid.min.js" type="text/javascript"></script>
 
    	<script type="text/javascript">
    		$(document).ready(function() {
    			$("#listFuncionario").jqGrid({
    				jsonReader : {
    				      root:"retorno",
    				},
    				height: 'auto',
    				autowidth: true,
    				datatype: function() {
    					$.ajax({ 
	    					url: "/funcionario/listar", 
	    					type: "POST",
	    					cache: false,
	    					success: function(response) {
	    						if (response.status == "OK") {
	    							var thegrid = $("#listFuncionario")[0];
	    			                thegrid.addJSONData(response.retorno);
	    						}
	    					}
	    				});
    				},
    				colNames: ['<spring:message code="funcionario.lista.table.id"/>',
    				           '<spring:message code="funcionario.lista.table.nome"/>',
    				           '<spring:message code="funcionario.lista.table.cartao"/>'
    				],
    				colModel: [
    				     		{name:'id',index:'id', width:55},
    				     		{name:'nome',index:'nome', width:200},
    				     		{name:'codigoRFID',index:'codigoRFID', width:150}
					],
					rowNum: 10,
    				rowList: [10,20,30],
    				pager: '#pagerFuncionario',
    				sortname: 'id',
    				viewrecords: true,
    				sortorder: "desc",
    				sortable: true,
    				caption: ""
				});
    			
    			$("#listFuncionario").jqGrid('navGrid','#pagerFuncionario',{edit:true,add:false,del:true});
    		});
    	</script>
	</head>

	<body>
		<div class="panel panel-primary">
			<div class="panel-heading">
				<h3 class="panel-title"><spring:message code="funcionario.lista.header"/></h3>
			</div>
			<div class="panel-body">
				<table id="listFuncionario">
				</table>
				<div id="pagerFuncionario">
				</div>
			</div>
		</div>
	</body>
</html>
