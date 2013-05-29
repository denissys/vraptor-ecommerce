<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE HTML>
<html lang="pt-BR">
	<jsp:include page="../head.jsp" />
    <body>		
		<jsp:include page="../header.jsp" />
		
		<div id="wrapper" class="container">
			
			<jsp:include page="../menu.jsp" />

			<h4 class="title">
               	<span class="pull-left"><span class="text"><span class="line">Seja bem-vindo, <strong>${sessionScope.loggedUser.user.firstName}</strong></span></span></span>
            </h4>

			<div class="row">
				<c:if test="${sessionScope.loggedUser.user.role == 'ADMIN'}">
					<div class="span3">
						<a href="/admin" class="btn btn-inverse" title="Clique aqui para acessar a área restrita do Administrador." id="enviar">Administração do Sistema</a><br />
					</div>
				</c:if>
				<div class="span3">	
					<button type="submit" class="btn btn-inverse btn-update" name="atualizar-perfil" title="Clique aqui para editar o seu perfil." id="atualiz-perfil">Editar meu Perfil</button><br /><br />
				</div>
				<div class="span3">	
					<button type="submit" class="btn btn-inverse btn-change-passowrd" name="alterar-senha" title="Clique aqui para alterar a sua senha." id="alterar-senha">Alteração de Senha</button><br /><br />
				</div>
				<div class="span3">	
					<a href="/logoff" class="btn btn-warning btn-update" title="Clique aqui navegar deslogado." id="enviar">Sair (Finalizar sessão)</a><br /><br />
				</div>
			</div>
			<div class="edit hide">		
				<jsp:include page="profileEdit.jsp" />
			</div>
			
			<div class="change-password hide">		
				<jsp:include page="profileChangePassword.jsp" />
			</div>

			<jsp:include page="../footer.jsp" />
			<script type="text/javascript" src="/assets/js/jquery/jquery.form.js"></script>
			<script type="text/javascript" src="/assets/js/jquery/jquery.validate.js"></script>
			<script type="text/javascript" src="/assets/js/jquery/jquery.maskedinput.min.js"></script>
			<script type='text/javascript' src="/assets/js/app/app.profile.js"></script>
			
		</div>		
    </body>
</html>