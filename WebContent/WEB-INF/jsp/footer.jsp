<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<section id="footer-bar">
	<div class="row">
		<div class="span7">
			<h4>Navegação</h4>
			<ul class="nav">
				<li><a href="/">Home</a></li>
				
				<c:choose>
					<c:when test="${sessionScope.loggedUser.user == null}">
						<li><a href="/entrar">Entrar</a></li>
					</c:when>
					<c:otherwise>
						<li><a href="/minha-conta">Minha conta</a></li>
					</c:otherwise>
				</c:choose>
			</ul>					
		</div>

		<div class="span5">
			<p class="logo"><a href="/"><img src="/assets/img/logo-red.png" class="site_logo" /></a></p>
			<p>Os melhores preços de Springfield!</p>
		</div>					
	</div>	
</section>
<section id="copyright">
	<span>Copyright 2013 @ <strong>Kiwk E-Mart</strong>.</span>
</section>

<!-- scripts -->
<script src="/assets/js/jquery-1.7.2.min.js"></script>
<script src="/assets/js/bootstrap.min.js"></script>				
<script src="/assets/js/superfish.js"></script>	
<!--[if lt IE 9]>			
	<script src="http://html5shim.googlecode.com/svn/trunk/html5.js"></script>
	<script src="/assets/js/respond.min.js"></script>
<![endif]-->
<script src="/assets/js/common.js"></script>
<script src="/assets/js/jquery.flexslider-min.js"></script>
<script type="text/javascript">
	$(function() {
		$(document).ready(function() {
			$('.flexslider').flexslider({
				animation: "fade",
				slideshowSpeed: 8000,
				animationSpeed: 2000,
				controlNav: false,
				directionNav: true,
				controlsContainer: ".flex-container" // the container that holds the flexslider
			});
		});
	});
</script>