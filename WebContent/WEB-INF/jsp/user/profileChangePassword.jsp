<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page import="br.com.kwikemart.enums.DecisionRoute"%>

<form id="form-change-password" name="form-change-password" method="post" autocomplete="off" >
	E-mail: ${user.email} <br />
	<input type="password" class="input-big" id="password" name="password" maxlength="10" value="" placeholder="Senha Atual" /> <br />
    <input type="password" class="input-big" id="newPassword" name="newPassword" maxlength="10" value="" placeholder="Nova Senha" /> <br />
    <input type="password" class="input-big" id="newPasswordConfirm" name="newPasswordConfirm" maxlength="10" value="" placeholder="Confirmar Nova Senha" /> <br />
   	<button type="submit" class="btn btn-inverse" name="atualizar" title="Clique aqui para atualizar o seu cadastro" id="atualizar">ALTERAR SENHA</button>
</form>