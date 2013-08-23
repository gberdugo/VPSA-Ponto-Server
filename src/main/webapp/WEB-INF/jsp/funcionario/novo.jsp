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
    	<link href="/resources/css/geral/bootstrap.min.css" rel="stylesheet">
    	<!-- Main -->
    	<link href="/resources/css/geral/main.css" rel="stylesheet">
    	<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
    	<script src="/resources/js/geral/jquery-1.10.2.min.js"></script>
    	<!-- Include all compiled plugins (below), or include individual files as needed -->
    	<script src="/resources/js/geral/bootstrap.min.js"></script>
    	<!-- jQuery Validation -->
    	<script src="/resources/js/geral/jquery.validate.min.js"></script>
    	
    	<script type="text/javascript">
    		$(document).ready(function() {
    			$("#btnCadastrar").click(function() {
    				$.ajax({ 
    					url: "/funcionario/novo", 
    					type: "POST", 
    					cache: false,	 
    					data:$("#formNovo").serialize(),
    					success: successHandler, 
    					error: errorHandler
    				});
        		});
    			
    			$("#formNovo").validate({
    				rules: {
    					nome: "required",
    					codigoRFID: "required"
    				},
    				messages: {
    					nome: "<spring:message code='funcionario.validacao.nome' javaScriptEscape='true' />",
    					codigoRFID: "<spring:message code='funcionario.validacao.rfid' javaScriptEscape='true' />"
    				}
    			});
    		});
    		
    		function successHandler(data) {
    			if (data.status == '') {
    				alert(strings['funcionario.novo.sucesso']);	
    			}
    		}
    		
    		function errorHandler(data) {
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
					<input id="nome" name="nome" type="text" class="form-control" placeholder="<spring:message code='funcionario.novo.nome' />" autofocus="autofocus" required="required" />
					<input id="codigoRFID" name="codigoRFID" type="text" class="form-control" placeholder="<spring:message code='funcionario.novo.nrocartao' />" required="required" />
					
					<button id="btnCadastrar" class="btn btn-primary" type="button" data-loading-text="<spring:message code='comum.processando' />"><spring:message code='comum.cadastrar' /></button> 
				</form>
			</div>
		</div>
	</body>
</html>
