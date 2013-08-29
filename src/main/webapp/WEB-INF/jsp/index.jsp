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
	   	
	   	<script type="text/javascript">
    		$(document).ready(function() {
    			$("#btnCadastrarFuncionario").click(function() {
    				window.location.href = "/funcionario/novo";
        		});
    			
    			$("#btnListarFuncionario").click(function() {
    				window.location.href = "/funcionario/listar";
        		});
    		});
    	</script>
	</head>

	<body>
		<button id="btnCadastrarFuncionario" class="btn btn-primary" type="button"><spring:message code='menu.novo.funcionario' /></button>
		<button id="btnListarFuncionario" class="btn btn-primary" type="button"><spring:message code='menu.listar.funcionario' /></button>
		<button id="btnSimulate" class="btn btn-primary" type="button">Simular Entrada</button>
	</body>
</html>
