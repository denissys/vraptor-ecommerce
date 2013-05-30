<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<%@ taglib prefix="c"   uri="http://java.sun.com/jsp/jstl/core"%>

<div id="top-bar" class="container">
	<div class="row">
		<div class="span6">
			<form id="form-search" class="form-search" method="GET" action="/produtos/listagem" >
				<div class="row">
					<div class="span5">
						<input type="text" class="input-block-level search-query" id="keyword" name="keyword" placeholder="Digite aqui o produto que procura..." />
					</div>
					<div class="span1">
						<input type="submit" class="btn btn-info btn-search" value="Buscar" />
					</div>
				</div>
			</form>
		</div>
		<div class="span6">
			<div class="account pull-right">
				<ul class="user-menu">
				<c:choose>
					<c:when test="${sessionScope.loggedUser.user == null}">
						<li><a href="/entrar">Minha Conta</a></li>
						<li><a href="/meu-carrinho">Meu Carrinho</a></li>
						<li>Olá. <a href="/entrar">Faça seu login</a> ou <a href="/cadastro">cadastre-se.</a></li>
					</c:when>
					<c:otherwise>
						<li><a href="/minha-conta">Minha Conta</a></li>
						<li><a href="/meu-carrinho">Meu Carrinho</a></li>
						<li><a href="/logoff">Sair</a></li>
					</c:otherwise>
				</c:choose>
				</ul>
			</div>
		</div>
	</div>
</div>