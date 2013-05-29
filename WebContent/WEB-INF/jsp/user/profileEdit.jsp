<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page import="br.com.kwikemart.enums.DecisionRoute"%>

<form id="form-update" name="form-update" method="post" autocomplete="off" >
	E-mail: ${user.email} <br />
    <input type="text" class="input-big" id="firstName" name="firstName" maxlength="40" value="${user.firstName}" placeholder="Primeiro Nome" /> <br />
    <input type="text" class="input-big" id="lastName" name="lastName" maxlength="40" value="${user.lastName}" placeholder="Sobrenome" /> <br />
    <input type="text" class="input-big" id="cpf" name="cpf" class="tooltip_link" maxlength="20" value="${user.document}" placeholder="CPF" /> <br />
    <input type="hidden" id="decisionRoute" name="decisionRoute" value="<%=DecisionRoute.DEFAULT.toString()%>" />
   	<button type="submit" class="btn btn-inverse" name="atualizar" title="Clique aqui para atualizar o seu cadastro" id="atualizar">ATUALIZAR</button>
</form>