<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

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
			<li class="dropdown"><a href="#" class="dropdown-toggle" data-toggle="dropdown"><i class="icon-user"></i> gberdugo <b class="caret"></b></a>
				<ul class="dropdown-menu">
					<li><a href="/funcionario/listar" title="Funcionários">Funcionários</a></li>
					<li><a href="#">Relatórios</a></li>
					<li><a href="/registro/simular">Simular Entrada</a></li>
					<li class="divider"></li>
					<li class="dropdown-header">OPÇÕES</li>
					<li><a href="#">Sair</a></li>
				</ul>
			</li>
		</ul>
	</div>
	<!--/.nav-collapse -->
</div>