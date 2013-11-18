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
    			 $(".form_datetime").datetimepicker({
    				 format: "dd/mm/yyyy - hh:ii:ss",
    				 autoclose: true,
    				 todayHighlight: true
    			 });
    			 
    			$("#formSimular").validate({
    				rules: {
    					funcionario: "required",
    					dataHora: "required"
    				},
    				messages: {
    					funcionario: "<spring:message code='entrada.validacao.funcionario' javaScriptEscape='true' />",
    					dataHora: "<spring:message code='entrada.validacao.horario' javaScriptEscape='true' />"
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
    			
    			$("#btnCadastrar").click(function() {
    				if ($("#formSimular").valid()) {
	    				$.ajax({ 
	    					url: "/registro/simular", 
	    					type: "POST", 
	    					cache: false,	 
	    					data:$("#formSimular").serialize(),
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
					<form class="form-horizontal" id="formSimular">
						<div class="form-group">
							<label class="col-lg-2 control-label" for="funcionario.id"><spring:message code='comum.funcionario' />:</label>
							<div class="col-lg-10">
								<select class="form-control" id="funcionario.id" required="required" name="funcionario.id">
									<option value="">Selecione</option>
									<c:forEach items="${funcionarios}" var="funcionario">
										<option id="${funcionario.id}" value="${funcionario.id}">${funcionario.nome}</option>
									</c:forEach>
								</select>
							</div>
						</div>
						
						<div class="form-group">
							<label class="col-lg-2 control-label" for="dataHora"><spring:message code='entrada.simular.horario' />:</label>
							<div class="col-lg-10">
								<div class="input-append date form_datetime">
									<input id="dataHora" name="dataHora" type="text" readonly class="form-control" required="required">
									<span class="add-on">
										<i class="icon-remove"></i>
									</span>
									<span class="add-on">
										 <i class="icon-calendar"></i>
									</span>
								</div>
							</div>
						</div>
						
						<div class="form-group">
							<div class="col-lg-offset-2 col-lg-10">
								<button id="btnCadastrar" class="btn btn-default" type="button" data-loading-text="<spring:message code='comum.processando' />"><spring:message code='comum.cadastrar' /></button>
							</div>
						</div>
					</form>
				</div>
			</div>
			
			<jsp:include page="../base/rodape.jsp" />
		</div> <!-- /container -->
	</body>
</html>
