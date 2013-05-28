<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE HTML>
<html lang="pt-BR">
	<jsp:include page="../head.jsp" ></jsp:include>
    <body>		
		<jsp:include page="../header.jsp" ></jsp:include>
		
		<div id="wrapper" class="container">
			
			<jsp:include page="../menu.jsp" ></jsp:include>
			
			<section  class="homepage-slider" id="home-slider">
				<div class="flexslider">
					<ul class="slides">
						<li>
							<img src="/assets/img/banner-1.jpg" alt="" />
							<div class="intro">
								<p><h1>Essa semana a Cerveja Duff está 50% OFF</h1></p>
								<p><span>Uma cerveja de altíssima qualidade!</span></p>
								<p><span>Compre agora mesmo!</span></p>
							</div>
						</li>
						<li>
							<img src="/assets/img/banner-2.jpg" alt="" />
							<div class="intro">
								<p><h1>Rosquinhas, 12 unidades por R$9,90</h1></p>
								<p><span>Compre antes que o Homer acesse o site.</span></p>
								<p><span>Eu quero!</span></p>
							</div>
						</li>
					</ul>
				</div>
			</section>
			<section class="header_text">
				Os melhores preços de Springfield agora online!<br/>
				Não cobramos frete, promoção do Apu.
			</section>
			<section class="main-content">
				<div class="row">
					<div class="span12">													
					
						<c:import url="${contextpath}/produtos-em-destaque" var="featured"/>
						${featured}

					</div>
				</div>
			</section>
			
			<jsp:include page="../footer.jsp" ></jsp:include>
		</div>
    </body>
</html>