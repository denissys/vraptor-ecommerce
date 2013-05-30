<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<%@ taglib prefix="c"   uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn"  uri="http://java.sun.com/jsp/jstl/functions" %>

<!DOCTYPE HTML>
<html lang="pt-BR">
	<jsp:include page="../head.jsp" ></jsp:include>
    <body>		
		<jsp:include page="../header.jsp" ></jsp:include>
		
		<div id="wrapper" class="container">
			
			<jsp:include page="../menu.jsp" ></jsp:include>

			<h4 class="title">
               	<span class="pull-left"><span class="text"><span class="line">Meu <strong>Carrinho</strong></span></span></span>
            </h4>

				<div class="row">
					<div class="span11">					
						<table class="table table-striped">
							<c:if test="${fn:length(items) gt 0}" >
								<thead>
									<tr>
										<th>Remover</th>
										<th>Imagem</th>
										<th>Nome do Produto</th>
										<th>Quantidade</th>
										<th>Preço Unitário</th>
										<th>Total</th>
									</tr>
								</thead>
							</c:if>
							<tbody>
								<c:set var="total" scope="session" value="0"/>
							
								<c:forEach items="${items}" var="cart" >
									<tr class="product-item" id="item-${product.id}">
										<td>
											<button id="remove-cart" class="btn" type="button" data-id="${cart.product.id}">Remover</button>
										</td>
										<td><a href="/produtos/${cart.product.id}"><img alt="" src="/assets/images/${cart.product.imageFilename}" style="height: 30px;"></a></td>
										<td>${cart.product.name}</td>
										<td><input type="text" value="${cart.quantity}" class="input-mini" readonly="readonly"></td>
										<td>R$ ${cart.product.price}</td>
										<td>R$ <fmt:formatNumber value="${cart.product.price * cart.quantity}" type="currency" /></td>
									</tr>
									
									<c:set var="total" value="${total + (cart.product.price * cart.quantity)}"></c:set>
									
								</c:forEach>
								
								<tr>
									<td colspan="4"><h4>Total da Compra  <div class="label label-success total">R$ <fmt:formatNumber value="${total}" type="currency"/></div></h4></td>
									<c:if test="${fn:length(items) gt 0}" >
										<td>
											<button id="clear-cart" class="btn btn-large" type="button" >Limpar</button>
										</td>
										<td>
											<button id="buy-cart" class="btn btn-danger btn-large" type="button" >Comprar</button>
										</td>
									</c:if>
								</tr>		  
							</tbody>
						</table>
					</div>
				</div>
			
			<jsp:include page="../footer.jsp" ></jsp:include>
			<script type="text/javascript" src="/assets/js/app/app.cart.js"></script>
		</div>		
    </body>
</html>