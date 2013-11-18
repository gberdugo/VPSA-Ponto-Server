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
    	<!-- DateTimePicker -->
    	<script src="/resources/js/geral/bootstrap-datetimepicker.min.js"></script>
		
		<script type="text/javascript">
			$(document).ready(function() {
				$("#formGerar").validate({
					rules: {
						idFuncionario: "required",
						periodo: "required",
						tipo: "required",
						data: "required"
					},
					messages: {
						idFuncionario: "<spring:message code='registro.validacao.funcionario' javaScriptEscape='true' />",
						periodo: "<spring:message code='registro.validacao.periodo' javaScriptEscape='true' />",
						tipo: "<spring:message code='registro.validacao.formato' javaScriptEscape='true' />",
						data: "<spring:message code='registro.validacao.tipo' javaScriptEscape='true' />"
					},
					highlight: function(element) {
						$(element).closest('.form-group').removeClass('success').addClass('error');
					},
					success: function(element) {
						element.text('OK!').addClass('valid').closest('.form-group').removeClass('error').addClass('success');
					},
					errorPlacement: function(error, element) {
						error.appendTo(element.parent("div"));
					}
				});
				
				$("#btnGerar").click(function() {
    				if ($("#formGerar").valid()) {
	    				$.ajax({ 
	    					url: "/relatorio/gerar", 
	    					type: "POST", 
	    					cache: false,	 
	    					data: $("#formGerar").serialize(),
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
						<spring:message code="registro.busca.header" />
					</h3>
					<form class="form-horizontal" id="formGerar">
						<div class="form-group">
							<label class="col-lg-2 control-label" for="idFuncionario"><spring:message code='comum.funcionario' />:</label>
							<div class="col-lg-10">
								<select class="form-control" id="idFuncionario" name="idFuncionario" required="required">
									<option value="">Selecione</option>
									<c:forEach items="${funcionarios}" var="funcionario">
										<option id="${funcionario.id}" value="${funcionario.id}">${funcionario.nome}</option>
									</c:forEach>
								</select>
							</div>
						</div>
						
						<div class="form-group">
							<label class="col-lg-2 control-label" for="periodo"><spring:message code='registro.busca.periodo' />:</label>
							<div class="col-lg-10">
								<select class="form-control" id="periodo" name="periodo" required="required">
									<option value="">Selecione</option>
									<option value="<spring:message code='comum.janeiro' />"><spring:message code='comum.janeiro' /></option>
									<option value="<spring:message code='comum.fevereiro' />"><spring:message code='comum.fevereiro' /></option>
									<option value="<spring:message code='comum.marco' />"><spring:message code='comum.marco' /></option>
									<option value="<spring:message code='comum.abril' />"><spring:message code='comum.abril' /></option>
									<option value="<spring:message code='comum.maio' />"><spring:message code='comum.maio' /></option>
									<option value="<spring:message code='comum.junho' />"><spring:message code='comum.junho' /></option>
									<option value="<spring:message code='comum.julho' />"><spring:message code='comum.julho' /></option>
									<option value="<spring:message code='comum.agosto' />"><spring:message code='comum.agosto' /></option>
									<option value="<spring:message code='comum.setembro' />"><spring:message code='comum.setembro' /></option>
									<option value="<spring:message code='comum.outubro' />"><spring:message code='comum.outubro' /></option>
									<option value="<spring:message code='comum.novembro' />"><spring:message code='comum.novembro' /></option>
									<option value="<spring:message code='comum.dezembro' />"><spring:message code='comum.dezembro' /></option>
								</select>
							</div>
						</div>
						
						<div class="form-group">
							<div class="col-lg-offset-2 col-lg-10">
								<input type="radio" id="tipo" name="tipo" required="required" value="<spring:message code='menu.pdf' />" />
								<spring:message code='menu.pdf' />
								<input type="radio" id="tipo" name="tipo" value="<spring:message code='menu.xls' />" />
								<spring:message code='menu.xls' />
							</div>
						</div>
						
						<div class="form-group">
							<div class="col-lg-offset-2 col-lg-10">
								<input type="radio" id="data" name="data" required="required" value="<spring:message code='comum.analitico.enum' />" />
								<spring:message code='comum.analitico' />
								<input type="radio" id="data" name="data" value="<spring:message code='comum.sintetico.enum' />" />
								<spring:message code='comum.sintetico' />
							</div>
						</div>
						
						<div class="form-group">
							<div class="col-lg-offset-2 col-lg-10">
								<button id="btnGerar" class="btn btn-default" type="button" data-loading-text="<spring:message code='comum.processando' />"><spring:message code='comum.gerar' /></button>
							</div>
						</div>
					</form>
				</div>
			</div>
			
			<jsp:include page="../base/rodape.jsp" />
		</div> <!-- /container -->
	</body>
</html>
