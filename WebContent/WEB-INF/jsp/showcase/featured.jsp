<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<div class="row">
	<div class="span12">
		<h4 class="title">
			<span class="pull-left"><span class="text"><span class="line">Produtos em <strong>Destaque</strong></span></span></span>
		</h4>
		
		<c:choose>
			<c:when test="${products != null}">
				<div id="myCarousel" class="myCarousel carousel slide">
					<div class="carousel-inner">
						<div class="active item">
							<ul class="thumbnails">
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
											
											<!-- TODO: Implementar forma de adicionar ao carrinho direto da listagem de produtos -->
<%-- 											<input type="hidden" id="productId" value="${product.id}" /> --%>
<!-- 											<label>Quantidade:</label> -->
<%-- 											<input type="text" id="quantity" name="quantity" class="span1" maxlength="2" value="${quantity != null ? quantity : 0}" /><br /> --%>
<!-- 											<button id="add-cart" class="btn btn-success" type="submit">Adicionar ao carrinho</button> -->
										</div>
									</li>
								</c:forEach>
							</ul>
						</div>
					</div>							
				</div>
			</c:when>
			<c:otherwise>
				Acesse mais tarde, estamos sem produtos no momento.
			</c:otherwise>
		</c:choose>
	</div>
</div>
<br />
<script src="/assets/js/jquery-1.7.2.min.js"></script>