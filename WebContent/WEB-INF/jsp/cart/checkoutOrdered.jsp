<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn"  uri="http://java.sun.com/jsp/jstl/functions" %>

<c:if test="${sessionScope.loggedUser.user != null && fn:length(sessionScope.cart.items) > 0}">
    <div class="row ordered">
    	<div class="span12">
           	<h4><span class="pull-left"><span class="text"><span class="line">Olá ${sessionScope.loggedUser.user.firstName}, informe os dados para a entrega do seu pedido.</span></span></span></h4>
           	<br /><br />
        </div>
          	
		<div class="span8">
			<form id="form-address" method="post">
               	<input type="text" class="input-large" id="street" name="street" placeholder="Endereço" /><br />
               	<input type="text" class="input-small" id="streetNumber" name="streetNumber" placeholder="Número" /><br />
               	<input type="text" class="input-medium" id="complement" name="complement" placeholder="Complemento" /><br />
               	<br />
				<button class="btn btn-success btn-large" name="finalizar" id="finalizar">ENVIAR PEDIDO</button><br /><br />
           </form>
		</div>

	</div>
	
	<div class="row finish hide">
    	<div class="span12">
           	<h4><span class="pull-left"><span class="text"><span class="line">Obrigado ${sessionScope.loggedUser.user.firstName}, o seu pedido foi enviado com sucesso.</span></span></span></h4><br />
           	<h4><span class="pull-left"><span class="text"><span class="line">Anote o número do seu pedido: <strong id="ordered-number"></strong>.</span></span></span></h4>
           	<br /><br />
        </div>
    </div>
</c:if>