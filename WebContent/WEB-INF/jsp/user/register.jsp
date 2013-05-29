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

			<h4 class="title">
               	<span class="pull-left"><span class="text"><span class="line">Cadastre-se no <strong>Kwik E-Mart</strong></span></span></span>
            </h4>
            <div class="register-title">Todos os campos são obrigatórios</div>

           	<form id="form-register" name="form-register" method="post" autocomplete="off" >
           		<input type="text" class="input-big" id="newEmail" name="newEmail" class="tooltip_link" maxlength="40" value="${user.email}" placeholder="E-mail" /> <br />
                <input type="text" class="input-big" id="emailConfirm" name="emailConfirm" maxlength="40" placeholder="Confirmar E-mail" /> <br />
                <input type="text" class="input-big" id="firstName" name="firstName" maxlength="40" value="${user.firstName}" placeholder="Primeiro Nome" /> <br />
                <input type="text" class="input-big" id="lastName" name="lastName" maxlength="40" value="${user.lastName}" placeholder="Sobrenome" /> <br />
                <input type="text" class="input-big" id="cpf" name="cpf" class="tooltip_link" maxlength="20" value="${user.document}" placeholder="CPF" /> <br />
                <input type="password" class="input-big" id="newPassword" name="newPassword" maxlength="10" value="" placeholder="Senha" /> <br />
                <input type="password" class="input-big" id="passwordConfirm" name="passwordConfirm" maxlength="10" value="" placeholder="Confirmar Senha" /> <br />
                <input type="hidden" id="decisionRoute" name="decisionRoute" value="<%=DecisionRoute.DEFAULT.toString()%>" />
               	<button type="submit" class="btn btn-inverse" name="enviar" title="Clique aqui para concluir o seu cadastro" id="enviar">CADASTRE-SE</button>
            </form>

			<jsp:include page="../footer.jsp" ></jsp:include>
	
			<script type="text/javascript" src="/assets/js/jquery/jquery.form.js"></script>
			<script type="text/javascript" src="/assets/js/jquery/jquery.validate.js"></script>
			<script type="text/javascript" src="/assets/js/jquery/jquery.maskedinput.min.js"></script>
			<script type='text/javascript' src="/assets/js/app/app.register.js"></script>
		</div>		
    </body>
</html>