<!DOCTYPE html>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page contentType="text/html; charset=UTF-8"%>

<html lang="pt">
  <head>
    <jsp:include page="base/cabecalho.jsp" />
  </head>

  <body>

    <div class="container">
    
	<jsp:include page="base/menu-principal.jsp" />

      <!-- Jumbotron -->
      <div class="jumbotron">
        <h1>Entre!</h1>
        <p class="lead">O VPSA Ponto permite o registro eletrônico dos horários dos representantes cadastrados no sistema, é fácil de usar e rápido de configurar, basta seguir os passos abaixo</p>
        <p><a class="btn btn-lg btn-success" href="#">Autenticar-se com o VPSA</a></p>
      </div>

      <!-- Example row of columns -->
      <div class="row">
        <div class="col-lg-4">
          <h2><i class="icon-exchange"></i> 1. Acesse,</h2>
          <p>Faça o login com o CNPJ usado no VPSA e cadastre cartões para seus colaboradores...</p>
        </div>
        <div class="col-lg-4">
          <h2><i class="icon-calendar-empty"></i> 2. bata o ponto...</h2>
          <p>aproxime o cartão do leitor para registrar a saída/entrada...</p>
       </div>
        <div class="col-lg-4">
          <h2><i class="icon-certificate"></i> 3. ... e pronto!</h2>
          <p>gere relatórios gerenciais de horas trabalhadas, horas extras e devidas em poucos instantes.</p>
        </div>
      </div>

      <jsp:include page="base/rodape.jsp" />

    </div> <!-- /container -->


    <!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
   	<script src="/resources/js/geral/jquery-1.10.2.min.js"></script>
   	<!-- Include all compiled plugins (below), or include individual files as needed -->
   	<script src="/resources/js/geral/bootstrap.min.js"></script>

    <!-- HTML5 shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!--[if lt IE 9]>
      <script src="../../assets/js/html5shiv.js"></script>
      <script src="../../assets/js/respond.min.js"></script>
    <![endif]-->
    
  </body>
</html>