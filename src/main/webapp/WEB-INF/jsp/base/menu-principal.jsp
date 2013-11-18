<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>

<!-- Static navbar -->
<div class="navbar navbar-default">
	<div class="navbar-header">
		<button type="button" class="navbar-toggle" data-toggle="collapse"
			data-target=".navbar-collapse">
			<span class="icon-bar"></span> <span class="icon-bar"></span> <span
				class="icon-bar"></span>
		</button>
		<a class="navbar-brand" href="/" title="Página Inicial">VPSA Ponto</a>
	</div>
	<div class="navbar-collapse collapse">
		<!--
		<ul class="nav navbar-nav">
			<li><a href="#">Contato</a></li>
		</ul>
		-->
		
		<ul class="nav navbar-nav navbar-right">
			<!-- <li class="dropdown"><a href="#" class="dropdown-toggle" data-toggle="dropdown"><i class="icon-user"></i> gberdugo <b class="caret"></b></a> -->
			<li class="dropdown"><a href="#" class="dropdown-toggle" data-toggle="dropdown">Usuário não logado<b class="caret"></b></a>
				<ul class="dropdown-menu">
					<li><a href="/funcionario/listar" title='<spring:message code="menu.funcionarios" />'><spring:message code="menu.funcionarios" /></a></li>
					<li><a href="/relatorio/gerar" title='<spring:message code="menu.relatorios" />'><spring:message code="menu.relatorios" /></a></li>
					<li><a href="/registro/simular">Simular Entrada</a></li>
					<li class="divider"></li>
					<li class="dropdown-header"><spring:message code="menu.opcoes.upper" /></li>
					<li><a href="#"><spring:message code="menu.sair" /></a></li>
				</ul>
			</li>
		</ul>
	</div>
	<!--/.nav-collapse -->
</div>