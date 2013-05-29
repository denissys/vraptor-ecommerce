<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page import="br.com.kwikemart.enums.DecisionRoute"%>

<c:if test="${sessionScope.loggedUser.user == null}">
    <div class="row">
    	<div class="span12">
           	<h4><span class="pull-left"><span class="text"><span class="line">Falta pouco para finalizar a sua compra, faça o seu login ou cadastre-se.</span></span></span></h4>
           	<br /><br />
        </div>
          	
		<div class="span5">
			<form id="form-login" method="post">
				<div class="register-title">Acesse com o seu e-mail e senha</div>
               	<input type="text" class="input-narrow" id="email" name="email" placeholder="E-mail" /><br />
               	<input type="password" class="input-narrow" id="password" name="password" placeholder="Senha"><br />
               	<input type="hidden" id="decisionRoute" name="decisionRoute" value="<%=DecisionRoute.CHECKOUT.toString()%>" />
				<button class="btn btn-inverse" name="enviar" title="Clique aqui para acessar a sua conta." id="enviar">ENTRAR</button><br /><br />
           </form>
		</div>
		            
		<div class="span5">
			<div class="register-title">Se ainda não possui login, cadastre-se</div>
           	<form id="form-register" name="form-register" method="post" autocomplete="off" >
           		<input type="text" class="input-big" id="newEmail" name="newEmail" class="tooltip_link" maxlength="40" value="${user.email}" placeholder="E-mail" /> <br />
                <input type="text" class="input-big" id="emailConfirm" name="emailConfirm" maxlength="40" placeholder="Confirmar E-mail" /> <br />
                <input type="text" class="input-big" id="firstName" name="firstName" maxlength="40" value="${user.firstName}" placeholder="Primeiro Nome" /> <br />
                <input type="text" class="input-big" id="lastName" name="lastName" maxlength="40" value="${user.lastName}" placeholder="Sobrenome" /> <br />
                <input type="text" class="input-big" id="cpf" name="cpf" class="tooltip_link" maxlength="20" value="${user.document}" placeholder="CPF" /> <br />
                <input type="password" class="input-big" id="newPassword" name="newPassword" maxlength="10" value="" placeholder="Senha" /> <br />
                <input type="password" class="input-big" id="passwordConfirm" name="passwordConfirm" maxlength="10" value="" placeholder="Confirmar Senha" /> <br />
                <input type="hidden" id="decisionRoute" name="decisionRoute" value="<%=DecisionRoute.CHECKOUT.toString()%>" />
               	<button type="submit" class="btn btn-inverse" name="enviar" title="Clique aqui para concluir o seu cadastro" id="enviar">CADASTRE-SE</button>
            </form>
		</div>
	</div>
</c:if>