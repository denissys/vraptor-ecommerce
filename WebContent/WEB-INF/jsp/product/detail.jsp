<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE HTML>
<html lang="pt-BR">
	<jsp:include page="../head.jsp" ></jsp:include>
    <body>		
		<jsp:include page="../header.jsp" ></jsp:include>
		
		<div id="wrapper" class="container">
			
			<jsp:include page="../menu.jsp" ></jsp:include>

			<c:choose>
				<c:when test="${product != null}">

				<div class="row">						
					<div class="span9">
						<div class="row">
							<div class="span8">
								<h4><strong>${product.name}</strong></h4>
							</div>
							<div class="span3">
								<a href="/assets/images/${product.imageFilename}" class="thumbnail" data-fancybox-group="group1" title="${product.name}">
									<img alt="" src="/assets/images/${product.imageFilename}">
								</a>												
							</div>
							<div class="span3">
<!-- 								<address> -->
<!-- 									<strong>Disponível:</strong> <span>X</span><br>								 -->
<!-- 								</address>									 -->
								<h4><strong>Preço: R$ ${product.price}</strong></h4>
							</div>
							<div class="span6">
								<form id="form-add" name="form-add" action="POST">
									<input type="hidden" id="productId" value="${product.id}" />
									<label>Quantidade:</label>
									<input type="text" id="quantity" name="quantity" class="span1" maxlength="2" value="${quantity}" /><br />
									<button id="add-cart" class="btn btn-success" type="submit">Adicionar ao carrinho</button>
									<a href="/meu-carrinho" class="btn btn-danger" >Ir para o seu carrinho</a>
								</form>
							</div>							
						</div>
					</div>
				</div>

				</c:when>
				<c:otherwise>
					Desculpe, o produto não foi encontrado.
				</c:otherwise>
			</c:choose>

			<jsp:include page="../footer.jsp" ></jsp:include>
			<script type="text/javascript" src="/assets/js/jquery/jquery.form.js"></script>
			<script type="text/javascript" src="/assets/js/jquery/jquery.validate.js"></script>
			<script type="text/javascript" src="/assets/js/app/app.cart.js"></script>
		</div>		
    </body>
</html>