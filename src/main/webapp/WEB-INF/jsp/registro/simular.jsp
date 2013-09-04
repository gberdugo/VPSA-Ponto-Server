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

			<div class="row row-offcanvas row-offcanvas-right main-list">
				<div class="col-xs-12 col-sm-9">
					<h3 class="panel-title">
						<spring:message code="entrada.simular.header" />
					</h3>
					<form class="form-horizontal" id="formNovo">
						<div class="form-group">
							<label class="col-lg-2 control-label" for="comboFuncionario"><spring:message code='entrada.simular.funcionario' />:</label>
							<div class="col-lg-10">
								<select class="form-control" id="comboFuncionario">
									<option id="0" value="0">Selecione</option>
									<c:forEach items="${funcionarios}" var="funcionario">
										<option id="${funcionario.id}" value="${funcionario.id}">${funcionario.nome}</option>
									</c:forEach>
								</select>
							</div>
						</div>
					</form>
				</div>
			</div>
			
			<jsp:include page="../base/rodape.jsp" />
		</div> <!-- /container -->
	</body>
</html>
