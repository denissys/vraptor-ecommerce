<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page import="br.com.kwikemart.enums.DecisionRoute"%>

<!DOCTYPE HTML>
<html lang="pt-BR">
	<jsp:include page="../head.jsp" ></jsp:include>
    <body>		
		<jsp:include page="../header.jsp" ></jsp:include>
		
		<div id="wrapper" class="container">
			
			<jsp:include page="../menu.jsp" ></jsp:include>

			<h4 class="title">
               	<span class="pull-left"><span class="text"><span class="line">Finalizar <strong>Pedido</strong></span></span></span>
            </h4>

			<jsp:include page="checkoutAuth.jsp" />
			
			<jsp:include page="checkoutOrdered.jsp" />
            
			<jsp:include page="../footer.jsp" ></jsp:include>
			<script type="text/javascript" src="/assets/js/jquery/jquery.form.js"></script>
			<script type="text/javascript" src="/assets/js/jquery/jquery.validate.js"></script>
			<script type="text/javascript" src="/assets/js/jquery/jquery.maskedinput.min.js"></script>
			<script type='text/javascript' src="/assets/js/app/app.register.js"></script>
			<script type="text/javascript" src="/assets/js/app/app.login.js"></script>
			<script type="text/javascript" src="/assets/js/app/app.checkout.js"></script>
		</div>		
    </body>
</html>