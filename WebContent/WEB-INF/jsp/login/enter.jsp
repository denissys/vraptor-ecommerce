<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page import="br.com.kwikemart.enums.DecisionRoute"%>

<!DOCTYPE HTML>
<html lang="pt-BR">
	<jsp:include page="../head.jsp" ></jsp:include>
    <body>		
		<jsp:include page="../header.jsp" ></jsp:include>
		
		<div id="wrapper" class="container">
			
			<jsp:include page="../menu.jsp" ></jsp:include>

			<form id="form-login" method="post">

				<h4 class="title">
                	<span class="pull-left"><span class="text"><span class="line">Faça o seu <strong>login</strong></span></span></span>
                </h4>
				<div class="register-title">Acesse com o seu e-mail e senha</div>

               	<input type="text" class="input-narrow" id="email" name="email" placeholder="E-mail" /><br />
               	<input type="password" class="input-narrow" id="password" name="password" placeholder="Senha"><br />
               	<input type="hidden" id="decisionRoute" name="decisionRoute" value="<%=DecisionRoute.DEFAULT.toString()%>" />
				<button class="btn btn-inverse" name="enviar" title="Clique aqui para acessar a sua conta." id="enviar">ENTRAR</button><br /><br />

               	<pre><a href="/recuperar-senha" class="link">Esqueci a minha senha</a>    <a href="/cadastro" class="link">Não sou cadastrado</a></pre>
           </form>

			<jsp:include page="../footer.jsp" ></jsp:include>
			<script type="text/javascript" src="/assets/js/jquery/jquery.validate.js"></script>
			<script type="text/javascript" src="/assets/js/app/app.login.js"></script>
		</div>
    </body>
</html>