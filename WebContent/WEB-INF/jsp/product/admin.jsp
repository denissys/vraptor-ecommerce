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
               	<span class="pull-left"><span class="text"><span class="line">Administrar <strong>Produtos</strong></span></span></span>
            </h4>
            
            <div class="row">
            	<div class="span1">
            		<a href="/produtos/novo" class="btn btn-inverse" title="Clique aqui para cadastrar um novo produto." id="enviar">Novo</a><br />
            	</div>
            	<div class="span3">
		            <a href="/produtos/listagem-admin" class="btn btn-inverse" title="Clique aqui para visualizar os produtos cadastrados." id="enviar">Produtos Cadastrados</a><br /><br />
		        </div>
            </div>

			<jsp:include page="../footer.jsp" ></jsp:include>
		</div>		
    </body>
</html>