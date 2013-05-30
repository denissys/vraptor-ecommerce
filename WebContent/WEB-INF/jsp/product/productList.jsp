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
               	<span class="pull-left"><span class="text"><span class="line">Resultado da sua busca por: <strong>${keyword}</strong></span></span></span>
            </h4>
            
            <input type="hidden" id="keywordSearched" value="${keyword}" />
            
			<div class="row">
				<div class="span12">
					<c:choose>
						<c:when test="${products != null}">
							<div id="myCarousel" class="myCarousel carousel slide">
								<div class="carousel-inner">
									<div class="active item">
										<ul class="thumbnails product-list">
											<c:forEach items="${products}" var="product" >
												
												<li class="span3">
													<div class="product-box">
														<span class="sale_tag"></span>
														<p>
															<a href="/produtos/${product.id}">
																<img src="/assets/images/${product.imageFilename}" alt="${product.name}" class="img-box" />
															</a>
														</p>
														<a href="/produtos/${product.id}" class="title">${product.name}</a><br/>
														<p class="price">R$ ${product.price}</p>
														
													</div>
												</li>
											</c:forEach>
										</ul>
									</div>
								</div>							
							</div>
							<a class="btn btn-success btn-large btn-more-products" title="Clique aqui para ver mais produtos." id="enviar">Carregar mais produtos</a><br /><br />
							<div class="end-list hide">Não existem mais produtos para serem listados.</div>
						</c:when>
						<c:otherwise>
							Nenhum produto cadastrado.<br />
							<a href="/produtos/novo" class="btn btn-inverse" title="Clique aqui para cadastrar um novo produto." id="enviar">Cadastre o primeiro produto</a><br />
						</c:otherwise>
					</c:choose>
				</div>
			</div>
			<br />
       
       		<div class="item-template hide">
				<li class="span3">
					<div class="product-box">
						<span class="sale_tag"></span>
						<p>
							<a href="" id="product-template-link">
								<img id="product-template-image" src="" class="img-box" />
							</a>
						</p>
						<a href="" id="product-template-link" class="title product-template-name">${product.name}</a><br/>
						<p class="price product-template-price">R$ ${product.price}</p>
					</div>
				</li>
       		</div>     

			<jsp:include page="../footer.jsp" ></jsp:include>
			<script type="text/javascript" src="/assets/js/app/app.search.js"></script>
		</div>		
    </body>
</html>