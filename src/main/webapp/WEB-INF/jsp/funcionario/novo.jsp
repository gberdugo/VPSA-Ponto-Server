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
    	<!-- jQuery Validation -->
    	<script src="/resources/js/geral/jquery.validate.min.js"></script>
    	<!-- Geral -->
    	<script src="/resources/js/geral/geral.js"></script>
    	
    	<script type="text/javascript">
    		$(document).ready(function() {
    			$("#formNovo").validate({
    				rules: {
    					nome: "required",
    					codigoRFID: "required"
    				},
    				messages: {
    					nome: "<spring:message code='funcionario.validacao.nome' javaScriptEscape='true' />",
    					codigoRFID: "<spring:message code='funcionario.validacao.rfid' javaScriptEscape='true' />"
    				},
					highlight: function(element) {
						$(element).closest('.form-group').removeClass('success').addClass('error');
					},
					success: function(element) {
						element.text('OK!').addClass('valid').closest('.form-group').removeClass('error').addClass('success');
					}
    			});
    			
    			$("#btnCadastrar").click(function() {
    				if ($("#formNovo").valid()) {
	    				$.ajax({ 
	    					url: "/funcionario/novo", 
	    					type: "POST", 
	    					cache: false,	 
	    					data:$("#formNovo").serialize(),
	    					success: successHandler, 
	    					error: errorHandler
	    				});
    				}
        		});
    		});
    	</script>
	</head>

	<body>
		<div class="container">
			<jsp:include page="../base/menu-principal.jsp" />
			
			<form class="form-horizontal" id="formNovo">
				<input id="id" name="id" type="hidden" value="<c:if test='${not empty funcionarioEditado}'>${funcionarioEditado.id}</c:if>" />
				
				<div class="form-group">
					<label class="col-lg-2 control-label" for="nome"><spring:message code='funcionario.novo.nome' /></label>
					<div class="col-lg-10">
						<input type="text" placeholder="<spring:message code='funcionario.novo.nome' />" id="nome" name="nome" class="form-control" autofocus="autofocus" required="required" value="<c:if test='${not empty funcionarioEditado}'>${funcionarioEditado.nome}</c:if>" />
					</div>
				</div>
				
				<div class="form-group">
					<label class="col-lg-2 control-label" for="nome"><spring:message code='funcionario.novo.nrocartao' /></label>
					<div class="col-lg-10">
						<input id="codigoRFID" name="codigoRFID" type="text" class="form-control" placeholder="<spring:message code='funcionario.novo.nrocartao' />" required="required" value="<c:if test='${not empty funcionarioEditado}'>${funcionarioEditado.codigoRFID}</c:if>" />
					</div>
				</div>
				
				<div class="form-group">
					<div class="col-lg-offset-2 col-lg-10">
						<button id="btnCadastrar" class="btn btn-default" type="button" data-loading-text="<spring:message code='comum.processando' />"><spring:message code='comum.cadastrar' /></button>
					</div>
				</div>
			</form>
		</div>
	</body>
</html>
