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
    				height: 'auto',
    				autowidth: true,
    				datatype: function(postdata) {
    					$.ajax({ 
	    					url: "/funcionario/listar", 
	    					type: "POST",
	    					data: postdata,
	    					cache: false,
	    					success: function(response) {
	    						if (response.status == "OK") {
	    							$("#listFuncionario")[0].addJSONData(response.retorno);
	    						}
	    					}
	    				});
    				},
    				colNames: ['<spring:message code="funcionario.lista.table.id"/>',
    				           '<spring:message code="funcionario.lista.table.representante"/>',
    				           '<spring:message code="funcionario.lista.table.nome"/>',
    				           '<spring:message code="funcionario.lista.table.cartao"/>'
    				],
    				colModel: [
    				     		{name: 'id', index: 'id', width: 55, sortable: true, sorttype: 'int', key: true},
    				     		{name: 'idVpsaRepresentante', index: 'idVpsaRepresentante', hidden: true},
    				     		{name: 'nome', index: 'nome', width: 200, sortable: true, editable: true, editrules: {required: true}},
    				     		{name: 'codigoRFID', index: 'codigoRFID', width: 150, sortable: true, editable: true, editrules: {required: true}}
					],
					altRows: true,
					rowNum: 10,
    				rowList: [10,20,30],
    				pager: '#pagerFuncionario',
    				gridview: true,
    				ignoreCase: true,
    				sortname: 'id',
    				viewrecords: true,
    				sortorder: "desc",
    				editurl: '/funcionario/editar'
				});
    			
    			$("#listFuncionario").jqGrid('navGrid','#pagerFuncionario', 
    				{edit: false, add: false, del: true, view: true, search: true},
    				{},
    				{},
    				{
    					onclickSubmit: function(params, postdata) {
    						params.url = '/funcionario/remover/' + postdata;
    					}
    				}
    			).navButtonAdd("#pagerFuncionario", { // custom add button
    				caption: "",  
    				buttonicon: "ui-icon-plus", 
    				onClickButton: function() { 
    					window.location.href = "/funcionario/novo"; 
    				},
    				position: "first",
    				title: $.jgrid.nav.addtitle
    			});
    			
    			$("#listFuncionario").jqGrid('inlineNav','#pagerFuncionario', {
    				edit: true,
    				add: false,
    				cancel: true,
    				editParams: {
    					keys: false,
    					oneditfunc: null,
    					successfunc: function(val) {
    						if (val.responseJSON.status == "OK") {
    							alert(val.responseJSON.mensagem);
    						}
    					}
    				}
    			});
    			
    			$("#listFuncionario").jqGrid('filterToolbar', {
    				stringResult: true, 
    				searchOnEnter: false
    			});
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
