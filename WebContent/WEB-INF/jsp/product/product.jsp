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
								<form id="form-purchase" class="form-inline">
									<label>Quantidade:</label>
									<input type="text" class="span1" placeholder="1">
									<button class="btn btn-success" type="submit">Adicionar ao carrinho</button>
									<a href="/comprar" class="btn btn-danger" >Comprar</a>
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
		</div>		
    </body>
</html>