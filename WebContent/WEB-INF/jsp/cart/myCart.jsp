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
               	<span class="pull-left"><span class="text"><span class="line">Meu <strong>Carrinho</strong></span></span></span>
            </h4>


				<div class="row">
					<div class="span9">					
						<table class="table table-striped">
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
							<tbody>
								<c:forEach items="${items}" var="cart" >
									<tr>
										<td><input type="checkbox" value="option1"></td>
										<td><a href="/produtos/${cart.product.id}"><img alt="" src="/assets/images/${cart.product.imageFilename}" style="height: 30px;"></a></td>
										<td>${cart.product.name}</td>
										<td><input type="text" value="${cart.quantity}" class="input-mini"></td>
										<td>R$ ${cart.product.price}</td>
										<td>R$ ${cart.product.price * cart.quantity}</td>
									</tr>
								</c:forEach>
								
								<tr>
									<td colspan="6"><h4>Total da Compra  <div class="label label-success">R$3,600.00</div></h4></td>
								</tr>		  
							</tbody>
						</table>
					</div>
				</div>

			<jsp:include page="../footer.jsp" ></jsp:include>
		</div>		
    </body>
</html>