<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE HTML>
<html lang="pt-BR">
	<jsp:include page="../head.jsp" ></jsp:include>
    <body>		
		<jsp:include page="../header.jsp" ></jsp:include>
		<link href="/assets/js/uploadify/uploadify.css" rel="stylesheet" >
		
		<div id="wrapper" class="container">
			
			<jsp:include page="../menu.jsp" ></jsp:include>

			<h4 class="title">
               	<span class="pull-left"><span class="text"><span class="line">Novo <strong>Produto</strong></span></span></span>
            </h4>

			<form id="form-register" name="form-register" method="post" autocomplete="off">
			
				<div class="row">
					<div class="span3">
						<input type="hidden" id="productId" value="${product.id}" />
						<input type="hidden" id="imageFilename" value="${product.imageFilename}" />
						<input type="hidden" id="event" value="EDIT" />
						
						<label>Nome:</label> <input type="text" class="input-big" id="name" name="name" maxlength="150" placeholder="Nome do Produto" value="${product.name}" /> <br />
						<label>Descrição:</label> <input type="text" class="input-big" id="description" name="description" maxlength="150" placeholder="Descrição" value="${product.description}" /> <br />
						<label>Preço:</label> <input type="text" class="input-big" id="price" name="price" placeholder="Preço (R$)" value="${product.price}" /> <br />
		
						<div id="register-action">
							<input type="file" name="file_upload" id="file_upload" />
							<div class="upload-message hide" >O arquivo <strong class="uploaded-filename"></strong> foi processado com sucesso!</div><br/>
							
							<button type="submit" class="btn btn-inverse" name="enviar" title="Atualizar dados do produto." id="enviar">Atualizar</button>
						</div>
					</div>
					<div class="span5">
						<label><strong>Imagem atual</strong></label>
						<img src="/assets/images/${product.imageFilename}" />
					</div>
				</div>
			</form>
			<div id="next-step" class="hide">
				<div class="label label-success">Produto atualizado com sucesso!</div><br /><br />
			</div>
			
			<jsp:include page="../footer.jsp" ></jsp:include>
			<script type="text/javascript" src="/assets/js/uploadify/jquery.uploadify.js"></script>
			<script type="text/javascript" src="/assets/js/jquery/jquery.form.js"></script>
			<script type="text/javascript" src="/assets/js/jquery/jquery.validate.js"></script>
			<script type="text/javascript" src="/assets/js/jquery/jquery.price_format.1.5.js"></script>
			<script type="text/javascript" src="/assets/js/app/app.product-admin.js"></script>

		</div>		
    </body>
</html>