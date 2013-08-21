<!DOCTYPE HTML>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page contentType="text/html; charset=UTF-8"%>

<html>
	<head>
	    <meta charset="utf-8">
	    <title>VPSA Ponto</title>
	     <meta name="viewport" content="width=device-width, initial-scale=1.0">
    	<!-- Bootstrap -->
    	<link href="/resources/css/bootstrap.min.css" rel="stylesheet">
    	<!-- Main -->
    	<link href="/resources/css/main.css" rel="stylesheet">
    	<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
    	<script src="/resources/js/geral/jquery-1.10.2.min.js"></script>
    	<!-- Include all compiled plugins (below), or include individual files as needed -->
    	<script src="/resources/js/geral/bootstrap.min.js"></script>
    	
    	<script type="text/javascript">
    		$(document).ready(function() {
    			$("#btnCadastrar").click(function() {
    				$.ajax({ 
    					url: "/funcionario/novo", 
    					type: "POST", 
    					cache: false,	 
    					data:$("#formNovo").serialize(),
    					success: novoResult, 
    					error: function(e) {
    						alert('Error: ' + e);
    					}
    				});
        		});
    		});
    		
    		function novoResult(data) {
    			alert(data);
    		}
    	</script>
	</head>

	<body>
		<div class="panel panel-primary">
			<div class="panel-heading">
				<h3 class="panel-title"><spring:message code="funcionario.novo.header"/></h3>
			</div>
			<div class="panel-body">
				<form action="" class="form" id="formNovo">
					<input name="nome" type="text" class="form-control" placeholder="<spring:message code='funcionario.novo.nome' />" autofocus="autofocus" />
					<input name="codigoRFID" type="text" class="form-control" placeholder="<spring:message code='funcionario.novo.nrocartao' />" />
					
					<button id="btnCadastrar" class="btn btn-primary" type="button" data-loading-text="<spring:message code='comum.processando' />"><spring:message code='comum.cadastrar' /></button> 
				</form>
			</div>
		</div>
	</body>
</html>
