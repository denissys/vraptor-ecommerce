<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

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
				<input type="text" class="input-big" id="name" name="name" maxlength="150" placeholder="Nome do Produto" /> <br />
				<input type="text" class="input-big" id="description" name="description" maxlength="150" placeholder="Descrição" /> <br />
				<input type="text" class="input-big" id="price" name="price" placeholder="Preço (R$)" /> <br />

				<div id="register-action">
					<input type="file" name="file_upload" id="file_upload" />
					<div class="upload-message hide" >O arquivo <strong class="uploaded-filename"></strong> foi processado com sucesso!</div><br/>
					
					<button type="submit" class="btn btn-inverse" name="enviar" title="Incluir novo produto." id="enviar">Cadastrar</button>
				</div>
			</form>
			<div id="next-step" class="hide">
				<div class="label label-success">Produto cadastrado com sucesso!</div><br /><br />
				<a href="/produtos/novo" class="btn btn-inverse" title="Incluir novo produto." id="enviar">Cadastrar outro produto</a>
			</div>
			
			<jsp:include page="../footer.jsp" ></jsp:include>
			<script type="text/javascript" src="/assets/js/uploadify/jquery.uploadify.js"></script>
			<script type="text/javascript" src="/assets/js/jquery/jquery.form.js"></script>
			<script type="text/javascript" src="/assets/js/jquery/jquery-ui.js"></script>
			<script type="text/javascript" src="/assets/js/jquery/jquery.validate.js"></script>
			<script type="text/javascript" src="/assets/js/jquery/jquery.price_format.1.5.js"></script>
			<script type="text/javascript" src="/assets/js/app/app.product-register.js"></script>

		</div>		
    </body>
</html>