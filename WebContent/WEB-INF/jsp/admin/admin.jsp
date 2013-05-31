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
               	<span class="pull-left"><span class="text"><span class="line">Área <strong>restrita</strong></span></span></span>
            </h4>
            
			<a href="/produtos/admin" class="btn btn-inverse" title="Clique aqui para acessar a área de administração de produtos." id="produtos">Produtos</a><br /><br />
			
			<a href="/pedidos/admin" class="btn btn-inverse" title="Clique aqui para acessar a lista de pedidos dos clientes." id="pedidos">Pedidos</a><br /><br />

			<jsp:include page="../footer.jsp" ></jsp:include>
		</div>		
    </body>
</html>