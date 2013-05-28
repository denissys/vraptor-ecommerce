<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE HTML>
<html lang="pt-BR">
	<jsp:include page="../head.jsp" ></jsp:include>
    <body>		
		<jsp:include page="../header.jsp" ></jsp:include>
		
		<div id="wrapper" class="container">
			
			<jsp:include page="../menu.jsp" ></jsp:include>

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
					<a href="/logoff" class="btn btn-warning" title="Clique aqui navegar deslogado." id="enviar">Sair (Finalizar sessão)</a><br /><br />
				</div>
			</div>

			<jsp:include page="../footer.jsp" ></jsp:include>
		</div>		
    </body>
</html>